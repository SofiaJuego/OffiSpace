package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Favorite;
import com.sofiadev.Offispace.model.Space;
import com.sofiadev.Offispace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FavoritesRepository extends JpaRepository<Favorite, Long> {

    boolean existsByUserAndSpace(User user, Space space);

    //Buscar favoritos por usuario
    List<Favorite> findByUser(User user);

    //Buscar si un espacio ya esta marcado como favorito por un usuario
    Optional<Favorite> findByUserAndSpace(User user, Space space);

}
