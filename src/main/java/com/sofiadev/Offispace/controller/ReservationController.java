package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.request.ReservationRequestDTO;
import com.sofiadev.Offispace.dto.response.ReservationResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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

    private ReservationService reservationService;

    @Operation(summary = "Realizo una reserva")
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReservationResponseDTO> createReservation(
            @RequestBody @Valid ReservationRequestDTO request,
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException
    {
        String userEmail = userDetails.getUsername();
        ReservationResponseDTO reservation = reservationService.createReservation(request, userEmail);
        return ResponseEntity.status(HttpStatus.CREATED).body(reservation);
    }

    @Operation(summary = "Obtengo mis reservas")
    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<ReservationResponseDTO>> getUserReservations(
       @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException
    {
        String userEmail = userDetails.getUsername();
        List<ReservationResponseDTO> reservations = reservationService.getUserReservation(userEmail);
        return ResponseEntity.ok(reservations);
    }
    @Operation(summary = "Cancelo una reserva")
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
