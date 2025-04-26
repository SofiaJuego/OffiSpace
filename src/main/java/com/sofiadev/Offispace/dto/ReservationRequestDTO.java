package com.sofiadev.Offispace.dto;

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
    private LocalDate startDate;
    private LocalDate endDate;

}
