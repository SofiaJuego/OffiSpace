package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.ReservationRequestDTO;
import com.sofiadev.Offispace.dto.ReservationResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;

import java.util.List;

public interface ReservationService {
    ReservationResponseDTO createReservation(ReservationRequestDTO request, String userEmail) throws ResourceNotFoundException;

    List<ReservationResponseDTO> getUserReservation(String userEmail) throws ResourceNotFoundException;

    void cancelReservation(Long reservationId, String userEmail) throws ResourceNotFoundException;

}
