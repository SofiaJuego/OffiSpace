package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.request.ReviewRequestDTO;
import com.sofiadev.Offispace.dto.response.ReviewResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;

import java.util.List;

public interface ReviewService {

    ReviewResponseDTO createReview(ReviewRequestDTO reviewRequestDTO) throws ResourceNotFoundException;

    List<ReviewResponseDTO> getAllReviews();

    List<ReviewResponseDTO> getReviewBySpaceById(Long spaceId);

    ReviewResponseDTO getReviewById(Long id) throws ResourceNotFoundException;

    ReviewResponseDTO updateReview(Long id, ReviewRequestDTO reviewRequestDTO, String userEmail) throws ResourceNotFoundException;

    void deleteReview(Long id, String userEmail) throws ResourceNotFoundException;

}
