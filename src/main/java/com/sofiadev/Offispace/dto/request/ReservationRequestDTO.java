package com.sofiadev.Offispace.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequestDTO {
    private Long spaceId;

    @Schema(description = "Fecha de ingreso en el espacio", example = "2025-04-29")
    @NotNull(message = "Tienes que agregar una fecha")
    private LocalDate startDate;

    @Schema(description = "Fecha final del alquiler del espacio", example = "2025-05-01")
    @NotNull(message = "Tienes que agregar una fecha")
    private LocalDate endDate;

}
