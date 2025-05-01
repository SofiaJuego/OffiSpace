package com.sofiadev.Offispace.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Category;
import com.sofiadev.Offispace.repository.CategoryRepository;
import com.sofiadev.Offispace.service.CategoryService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@ActiveProfiles("test")
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    private Long savedCategoryId;

    @BeforeEach
    void setup(){
        categoryRepository.deleteAll();
        savedCategoryId = createCategory("Oficina privadas", "Hermosa sala para trabajar tranquilo").getId();
    }

    private Category createCategory(String name, String description){
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setImage("https://link-a-la-galeria.com");
        return categoryRepository.save(category);
    }

    @Test
    void getCategoryByIdNotFound() throws Exception {
        mockMvc.perform(get("/categories/{id}", 100L)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }


    @Test
    void createCategory() throws Exception {
        String json = """
              {
              "name": "Sala de eventos",
              "description":"Espacio ideal para eventos empresariales",
              "image": "https://link-a-la-galeria.com"
              }
              
              """;

        mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("Sala de eventos"))
                .andExpect(jsonPath("$.description").value("Espacio ideal para eventos empresariales"))
                .andExpect(jsonPath("$.image").value("https://link-a-la-galeria.com"));

    }

    @Test
    void getAllCategories() throws Exception {
        categoryRepository.deleteAll();

        createCategory("Oficina privadas", "Hermosa sala para trabajar tranquilo");
        createCategory("Salas privada", "Hermosa sala para reuniones");

        mockMvc.perform(get("/categories")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[*].name", containsInAnyOrder("Oficina privadas", "Salas privada")))
                .andExpect(jsonPath("$[*].description", containsInAnyOrder("Hermosa sala para trabajar tranquilo", "Hermosa sala para reuniones")))
                .andExpect(jsonPath("$[*].image", everyItem(is("https://link-a-la-galeria.com"))));
    }


    @Test
    void getCategoryById() throws Exception {

        mockMvc.perform(get("/categories/{id}" , savedCategoryId)
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name").value("Oficina privadas"))
                        .andExpect(jsonPath("$.description").value("Hermosa sala para trabajar tranquilo"))
                        .andExpect(jsonPath("$.image").value("https://link-a-la-galeria.com"));
    }

    @Test
    void updateCategory() throws Exception {
        Category category = createCategory("Temporal", "A modificar");

        Category updateCategory = new Category();
        updateCategory.setName("Oficina renovadas");
        updateCategory.setDescription("oficina renovada, pleno centro");
        updateCategory.setImage("https://link-a-la-galeria.com");

        mockMvc.perform(put("/categories/{id}", category.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updateCategory)))
                        .andExpect(status().isOk())
                        .andExpect(jsonPath("$.name").value("Oficina renovadas"))
                        .andExpect(jsonPath("$.description").value("oficina renovada, pleno centro"))
                        .andExpect(jsonPath("$.image").value("https://link-a-la-galeria.com"));

    }

    @Test
    void deleteCategory() throws Exception {
        Category category = createCategory("Temporal", "Categoria para eliminar");

        mockMvc.perform(delete("/categories/{id}", category.getId()))
                .andExpect(status().isOk())
                .andExpect(content().string("Se elimino la categoria con id: " + category.getId()));

        Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            categoryService.getCategoryById(category.getId());
        });
    }
}