package com.sofiadev.Offispace.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FeatureRequestDTO {
    @Schema(description = "Nombre de la característica", example = "Estacionamiento")
    @NotNull(message = "Tienes que agregarle un nombre")
    private String name;

    @Schema(description = "Icono de la característica", example = "icon.png")
    @NotNull(message = "Tienes que agregarle un icono")
    private String icon;
}
