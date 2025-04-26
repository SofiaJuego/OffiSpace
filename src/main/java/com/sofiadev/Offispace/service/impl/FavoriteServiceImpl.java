package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.dto.FavoriteRequestDTO;
import com.sofiadev.Offispace.dto.FavoriteResponseDTO;
import com.sofiadev.Offispace.exception.ResourceAlreadyExistsException;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Favorite;
import com.sofiadev.Offispace.model.Space;
import com.sofiadev.Offispace.model.User;
import com.sofiadev.Offispace.repository.FavoritesRepository;
import com.sofiadev.Offispace.repository.SpaceRepository;
import com.sofiadev.Offispace.repository.UserRepository;
import com.sofiadev.Offispace.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteServiceImpl implements FavoriteService {

    private final FavoritesRepository favoritesRepository;
    private final UserRepository userRepository;
    private final SpaceRepository spaceRepository;

    @Override
    public FavoriteResponseDTO addFavorite(FavoriteRequestDTO request, String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        Space space = getSpaceById(request.getSpaceId());

        boolean exists = favoritesRepository.existsByUserAndSpace(user, space);

        if (exists){
            throw new ResourceAlreadyExistsException("Este espacio ya está en tus favoritos");
        }

        Favorite favorite = Favorite.builder()
                .user(user)
                .space(space)
                .build();

        Favorite saveFavorite = favoritesRepository.save(favorite);
        return mapToDTO(saveFavorite);

    }

    @Override
    public void removeFavorite(Long spaceId, String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        Space space = getSpaceById(spaceId);

        Favorite favorite = favoritesRepository.findByUserAndSpace(user, space)
                .orElseThrow(() -> new ResourceNotFoundException("Favorito no encontrado"));

        favoritesRepository.delete(favorite);
    }

    @Override
    public List<FavoriteResponseDTO> getFavorites(String userEmail) throws ResourceNotFoundException {
        User user = getUserByEmail(userEmail);
        List<Favorite> favorites = favoritesRepository.findByUser(user);
        return favorites.stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    private FavoriteResponseDTO mapToDTO(Favorite favorite) {
        return FavoriteResponseDTO.builder()
                .id(favorite.getId())
                .spaceId(favorite.getSpace().getId())
                .spaceName(favorite.getSpace().getName())
                .build();
    }

    private User getUserByEmail(String email) throws ResourceNotFoundException {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));
    }

    private Space getSpaceById(Long spaceId) throws ResourceNotFoundException {
        return spaceRepository.findById(spaceId)
                .orElseThrow(() -> new ResourceNotFoundException("Espacio no encontrado"));
    }

}
