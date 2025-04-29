package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.request.FeatureRequestDTO;
import com.sofiadev.Offispace.dto.response.FeatureResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;

import java.util.List;

public interface FeatureService {

    FeatureResponseDTO createFeature(FeatureRequestDTO request);

    FeatureResponseDTO updateFeature(Long id, FeatureRequestDTO request) throws ResourceNotFoundException;

    void deleteFeature(Long id) throws ResourceNotFoundException;

    List<FeatureResponseDTO> getAllFeatures();

}
