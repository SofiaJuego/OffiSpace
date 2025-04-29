package com.sofiadev.Offispace.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewRequestDTO {

    @Schema(description = "Reseña (entre 3 y 200 caracteres)", example = "Me gusto la oficina, ideal para trabajar")
    @Size(min = 3, max = 200, message = "La reseña debe tener entre 3 y 200 caracteres")
    private String content;

    @Schema(description = "Puntuación del espacio", example = "5")
    @NotNull(message = "Tienes que dar al menos una estrella")
    @Min(value = 1, message = "Tiene que dar al menos 1 estrella.")
    private Integer rating;

    private Long userId;

    private Long spaceId;
}
