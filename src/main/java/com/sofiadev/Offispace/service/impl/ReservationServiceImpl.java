package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.dto.request.ReservationRequestDTO;
import com.sofiadev.Offispace.dto.response.ReservationResponseDTO;
import com.sofiadev.Offispace.exception.AccessDeniedException;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Reservation;
import com.sofiadev.Offispace.model.Space;
import com.sofiadev.Offispace.model.User;
import com.sofiadev.Offispace.model.enums.ReservationStatus;
import com.sofiadev.Offispace.repository.ReservationRepository;
import com.sofiadev.Offispace.repository.SpaceRepository;
import com.sofiadev.Offispace.repository.UserRepository;
import com.sofiadev.Offispace.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final SpaceRepository spaceRepository;
    private final UserRepository userRepository;

    @Override
    public ReservationResponseDTO createReservation(ReservationRequestDTO request, String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        Space space = getSpaceById(request.getSpaceId());

        Reservation reservation = Reservation.builder()
                .user(user)
                .space(space)
                .startTime(request.getStartDate())
                .endTime(request.getEndDate())
                .status((ReservationStatus.PENDING))
                .build();

        Reservation save = reservationRepository.save(reservation);
        return mapToDTO(save);
    }

    @Override
    public List<ReservationResponseDTO> getUserReservation(String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        List<Reservation> reservations = reservationRepository.findByUser(user);

        return reservations.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void cancelReservation(Long reservationId, String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ResourceNotFoundException("Reserva no encontrada"));

        if (!reservation.getUser().getId().equals(user.getId())){
            throw new AccessDeniedException("No tienes permiso para cancelar esta reserva");
        }

        reservationRepository.delete(reservation);
    }

    private User getUserByEmail(String email) throws ResourceNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    private Space getSpaceById(Long spaceId) throws ResourceNotFoundException {
        return spaceRepository.findById(spaceId)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

    }

    private ReservationResponseDTO mapToDTO(Reservation reservation) {
        return ReservationResponseDTO.builder()
                .id(reservation.getId())
                .spaceName(reservation.getSpace().getName())
                .spaceId(reservation.getSpace().getId())
                .startDate(reservation.getStartTime())
                .endDate(reservation.getEndTime())
                .status(reservation.getStatus().name())
                .build();
    }

}
