package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.FavoriteRequestDTO;
import com.sofiadev.Offispace.dto.FavoriteResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.FavoriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favorites")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;


    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<FavoriteResponseDTO> addFavorite(
            @RequestBody FavoriteRequestDTO requestDTO,
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException {
       String userEmail = userDetails.getUsername();
       FavoriteResponseDTO response = favoriteService.addFavorite(requestDTO, userEmail);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @DeleteMapping("/{spaceId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> removeFavorite(
            @PathVariable Long spaceId,
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException {
        String userEmail =userDetails.getUsername();
        favoriteService.removeFavorite(spaceId, userEmail);
        return ResponseEntity.ok("Se elimino el espacio de favoritos");
    }

    @GetMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<List<FavoriteResponseDTO>> getUserFavorites(
            @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException {
        String userEmail =userDetails.getUsername();
        List<FavoriteResponseDTO> favorites = favoriteService.getFavorites(userEmail);
        return ResponseEntity.ok(favorites);
    }



}
