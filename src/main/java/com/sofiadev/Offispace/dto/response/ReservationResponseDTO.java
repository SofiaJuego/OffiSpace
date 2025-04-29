package com.sofiadev.Offispace.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponseDTO {
    private Long id;
    private String spaceName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Long spaceId;
    private String status;

}
