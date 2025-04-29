package com.sofiadev.Offispace.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.math.BigDecimal;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceRequestDTO {

    @Schema(description = "Nombre del espacio (entre 3 y 50 caracteres)", example = "Sala de reuniones")
    @NotNull(message = "El nombre del espacio no puede estar vacio")
    @Size(min = 3, max = 50, message = "El nombre del espacio debe tener entre 3 y 50 caracteres")
    private String name;

    @Schema(description = "Descripción detallada del espacio", example = "Sala moderna equipada con sillas y escritorios.")
    @NotNull(message = "La descripción del espacio no puede estar vacia")
    private String description;

    @Schema(description = "Direccion completa del espacio", example = "Corrientes 800")
    @NotNull(message = "Necesitas agregar una dirección")
    private String address;

    @Schema(description = "Ciudad donde se encuentra el espacio", example = "Buenos Aires")
    @NotNull(message = "Necesitas agregar una ciudad")
    private String city;

    @Schema(description = "Pais donde se encuentra el espacio", example = "Argentina")
    @NotNull(message = "Necesitas agregar un pais")
    private String country;

    @Schema(description = "Precio por dia del espacio", example = "20.000")
    @Min(value = 1, message = "El precio por dia debe ser mayor que 0.")
    private BigDecimal pricePerDay;

    @Schema(description = "Disponibilidad del espacio", example = "Disponible")
    @NotNull(message = "Debes indicar si está disponible")
    private Boolean available;

    @Schema(description = "URL de la imagen principal del espacio", example = "imagenprincipal.png")
    @NotBlank(message = "Debes proporcionar una imagen principal")
    private String mainImage;

    @Schema(description = "URL de varias imagenes del espacio", example = "galeriaoficina.png")
    @Size(min = 5, message = "La galería debe contener al menos 5 caracteres si se proporciona")
    private String imageGallery;

    @Schema(description = "Capacidad total de personas del espacio", example = "10")
    @NotNull(message = "Tiene que agregar la capacidad del espacio")
    @Min(value = 1, message = "La capacidad debe ser al menos 1.")
    private Integer capacity;

    private Long userId;

    @Schema(description = "Categoria del espacio", example = "Oficinas privadas")
    @NotNull(message = "Tienes que agregar una categoria")
    private Long categoryId;

    @Schema(description = "Característica del espacio", example = "Wi-Fi")
    @NotNull(message = "Tienes que agregar al menos una característica")
    private List<Long> featureIds;
}
