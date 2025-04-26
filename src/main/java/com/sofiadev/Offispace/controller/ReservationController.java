package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.ReservationRequestDTO;
import com.sofiadev.Offispace.dto.ReservationResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReservationResponseDTO> createReservation(
            @RequestBody ReservationRequestDTO request,
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException
    {
        String userEmail = userDetails.getUsername();
        ReservationResponseDTO reservation = reservationService.createReservation(request, userEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ReservationResponseDTO>> getUserReservations(
       @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException
    {
        String userEmail = userDetails.getUsername();
        List<ReservationResponseDTO> reservations = reservationService.getUserReservation(userEmail);
        return ResponseEntity.ok(reservations);
    }

    @DeleteMapping("/{reservationId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> cancelReservation(
            @PathVariable Long reservationId,
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException {
        String userEmail = userDetails.getUsername();
        reservationService.cancelReservation(reservationId, userEmail);
        return ResponseEntity.ok("Reserva cancelada con exito");
    }



}
