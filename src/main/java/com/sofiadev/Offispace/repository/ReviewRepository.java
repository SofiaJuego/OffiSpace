package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findBySpaceId(Long spaceId);

}
