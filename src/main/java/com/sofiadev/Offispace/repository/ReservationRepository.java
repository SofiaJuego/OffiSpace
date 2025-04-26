package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Reservation;
import com.sofiadev.Offispace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);

}
