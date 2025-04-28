package com.sofiadev.Offispace.repository;

import com.sofiadev.Offispace.model.Feature;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FeatureRepository extends JpaRepository<Feature, Long> {
    boolean existsByName(String name);


}
