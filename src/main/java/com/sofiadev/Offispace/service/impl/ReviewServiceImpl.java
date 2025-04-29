package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.dto.request.ReviewRequestDTO;
import com.sofiadev.Offispace.dto.response.ReviewResponseDTO;
import com.sofiadev.Offispace.exception.AccessDeniedException;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Review;
import com.sofiadev.Offispace.model.Space;
import com.sofiadev.Offispace.model.User;
import com.sofiadev.Offispace.repository.ReviewRepository;
import com.sofiadev.Offispace.repository.SpaceRepository;
import com.sofiadev.Offispace.repository.UserRepository;
import com.sofiadev.Offispace.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final SpaceRepository spaceRepository;


    @Override
    public ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) throws ResourceNotFoundException {
        User user = userRepository.findById(reviewRequestDTO.getUserId())
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        Space space = spaceRepository.findById(reviewRequestDTO.getSpaceId())
                .orElseThrow(() -> new ResourceNotFoundException("Oficina no encontrada"));

        Review review = Review.builder()
                .content(reviewRequestDTO.getContent())
                .rating(reviewRequestDTO.getRating())
                .user(user)
                .space(space)
                .build();

        Review saveReview = reviewRepository.save(review);
        return mapToDTO(saveReview);
    }

    @Override
    public List<ReviewResponseDTO> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewResponseDTO> getReviewBySpaceById(Long id) {
        return reviewRepository.findBySpaceId(id)
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewResponseDTO getReviewById(Long id) throws ResourceNotFoundException {
        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reseña no encontrada"));
        return mapToDTO(review);
    }

    @Override
    public ReviewResponseDTO updateReview(Long id, ReviewRequestDTO reviewRequestDTO, String userEmail) throws ResourceNotFoundException {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la reseña con el id: " + id));

        if (!existingReview.getUser().getEmail().trim()
                .equalsIgnoreCase(userEmail.trim())){
            throw new AccessDeniedException("No tienes permiso para modificar esta reseña");
        }

        existingReview.setContent(reviewRequestDTO.getContent());
        existingReview.setRating(reviewRequestDTO.getRating());

        Review update = reviewRepository.save(existingReview);
        return mapToDTO(update);
    }

    @Override
    public void deleteReview(Long id, String userEmail) throws ResourceNotFoundException {
        Review existingReview = reviewRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontro la reseña con el id: " + id));

        if (!existingReview.getUser().getEmail().equals(userEmail)){
            throw new AccessDeniedException("No tienes permiso para eliminar esta reseña");
        }

        reviewRepository.delete(existingReview);

    }

    private ReviewResponseDTO mapToDTO(Review review) {
        return ReviewResponseDTO.builder()
                .id(review.getId())
                .content(review.getContent())
                .rating(review.getRating())
                .userName(review.getUser() != null ? review.getUser().getName() : null)
                .spaceName(review.getSpace() != null ? review.getSpace().getName() : null)
                .build();
    }
}
