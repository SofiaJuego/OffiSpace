package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.FavoriteRequestDTO;
import com.sofiadev.Offispace.dto.FavoriteResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Favorite;
import com.sofiadev.Offispace.model.User;

import java.util.List;

public interface FavoriteService {

    //Marco un espacio como favorito
    FavoriteResponseDTO addFavorite(FavoriteRequestDTO favoriteRequestDTO, String userEmail) throws ResourceNotFoundException;

    //Desmarco un espacio como favorito
    void removeFavorite(Long spaceId, String userEmail) throws ResourceNotFoundException;

    //Obtengo todos los favoritos de un usario
    List<FavoriteResponseDTO> getFavorites(String userEmail) throws ResourceNotFoundException;



}
