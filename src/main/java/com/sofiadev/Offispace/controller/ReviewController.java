package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.request.ReviewRequestDTO;
import com.sofiadev.Offispace.dto.response.ReviewResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Operation(summary = "Obtengo la lista de reseñas que realice")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña encontrada con exito"),
            @ApiResponse(responseCode = "404", description = "Reseña no encontrada")})
    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @Operation(summary = "Obtengo la reseña que deje en un espacio")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Reseña encontrada con exito"),
            @ApiResponse(responseCode = "404", description = "Reseña no encontrada")})
    @GetMapping("/space/{spaceId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsBySpace(@PathVariable Long spaceId){
        return ResponseEntity.ok(reviewService.getReviewBySpaceById(spaceId));
    }

    @Operation(summary = "Creo una reseña")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Se creo la reseña con exito"),
            @ApiResponse(responseCode = "400", description = "Datos de entrada invalidos")})
    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody @Valid ReviewRequestDTO reviewRequestDTO) throws ResourceNotFoundException {
        ReviewResponseDTO createReview = reviewService.createReview(reviewRequestDTO);
        return new ResponseEntity<>(createReview, HttpStatus.CREATED);
    }
    @Operation(summary = "Actualizo una reseña")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id,
            @RequestBody @Valid ReviewRequestDTO reviewRequestDTO,
            Authentication authentication) throws ResourceNotFoundException
    {
        String userEmail = authentication.getName();
        ReviewResponseDTO updateReview = reviewService.updateReview(id, reviewRequestDTO, userEmail);
        return ResponseEntity.ok(updateReview);
    }
    @Operation(summary = "Elimino una reseña")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteReview(@PathVariable Long id, Authentication authentication) throws ResourceNotFoundException {
        String userEmail = authentication.getName();
        reviewService.deleteReview(id, userEmail);
        return ResponseEntity.ok("Se elimino la reseña");
    }

}
