package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.request.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.response.SpaceResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.SpaceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private final SpaceService spaceService;

    @Operation(summary = "Obtener todos los espacios")
    @GetMapping
    public ResponseEntity<List<SpaceResponseDTO>> getAllSpace(){
        List<SpaceResponseDTO> spaces = spaceService.getAllSpace();
        System.out.println("Entró al endpoint público de /spaces");
        return ResponseEntity.ok(spaces);
    }

    @Operation(summary = "Crear un nuevo espacio")
    @PostMapping
    public ResponseEntity<SpaceResponseDTO> createSpace(@RequestBody @Valid SpaceRequestDTO request) throws ResourceNotFoundException {
        SpaceResponseDTO createSpace = spaceService.createSpace(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createSpace);
    }

    @Operation(summary = "Obtener un espacio por ID")
    @GetMapping("/{id}")
    public ResponseEntity<SpaceResponseDTO> getSpaceById(@PathVariable Long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(spaceService.getSpaceById(id));
    }

    @Operation(summary = "Actualizar un espacio existente")
    @PutMapping("/{id}")
    public ResponseEntity<SpaceResponseDTO> updateSpace (@PathVariable Long id, @RequestBody @Valid SpaceRequestDTO request) throws ResourceNotFoundException {
        SpaceResponseDTO update = spaceService.updateSpace(id, request);
        return ResponseEntity.ok(update);
    }

    @Operation(summary = "Eliminar un espacio por ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpace(@PathVariable Long id) throws ResourceNotFoundException {
        spaceService.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }


}
