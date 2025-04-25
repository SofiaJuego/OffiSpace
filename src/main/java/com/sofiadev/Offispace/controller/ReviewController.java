package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.ReviewRequestDTO;
import com.sofiadev.Offispace.dto.ReviewResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.ReviewService;
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

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ReviewResponseDTO>> getAllReviews(){
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/space/{spaceId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<List<ReviewResponseDTO>> getReviewsBySpace(@PathVariable Long spaceId){
        return ResponseEntity.ok(reviewService.getReviewBySpaceById(spaceId));
    }

    @PostMapping
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReviewResponseDTO> createReview(@RequestBody ReviewRequestDTO reviewRequestDTO){
        ReviewResponseDTO createReview = reviewService.createReview(reviewRequestDTO);
        return new ResponseEntity<>(createReview, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<ReviewResponseDTO> updateReview(
            @PathVariable Long id,
            @RequestBody ReviewRequestDTO reviewRequestDTO,
            Authentication authentication) throws ResourceNotFoundException
    {
        String userEmail = authentication.getName();
        ReviewResponseDTO updateReview = reviewService.updateReview(id, reviewRequestDTO, userEmail);
        return ResponseEntity.ok(updateReview);

    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<String> deleteReview(@PathVariable Long id, Authentication authentication) throws ResourceNotFoundException {
        String userEmail = authentication.getName();
        reviewService.deleteReview(id, userEmail);
        return ResponseEntity.ok("Se elimino la reseña");
    }








}
