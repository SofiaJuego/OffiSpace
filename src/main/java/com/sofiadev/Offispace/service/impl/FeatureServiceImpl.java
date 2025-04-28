package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.dto.FeatureRequestDTO;
import com.sofiadev.Offispace.dto.FeatureResponseDTO;
import com.sofiadev.Offispace.exception.ResourceAlreadyExistsException;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Feature;
import com.sofiadev.Offispace.repository.FeatureRepository;
import com.sofiadev.Offispace.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    @Override
    public FeatureResponseDTO createFeature(FeatureRequestDTO request) {
        if (featureRepository.existsByName(request.getName())){
            throw new ResourceAlreadyExistsException("Ya existe una característica con ese nombre");
        }

        Feature feature = Feature.builder()
                .name(request.getName())
                .icon(request.getIcon())
                .build();

        Feature saveFeature = featureRepository.save(feature);
        return mapToDTO(saveFeature);

    }


    @Override
    public FeatureResponseDTO updateFeature(Long id, FeatureRequestDTO request) throws ResourceNotFoundException {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Característica no encontrada"));

        feature.setName(request.getName());
        feature.setIcon(request.getIcon());

        Feature update = featureRepository.save(feature);
        return mapToDTO(update);
    }

    @Override
    public void deleteFeature(Long id) throws ResourceNotFoundException {
        Feature feature = featureRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Característica no encontrada"));

        featureRepository.delete(feature);

    }

    @Override
    public List<FeatureResponseDTO> getAllFeatures() {
        return featureRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    private FeatureResponseDTO mapToDTO(Feature feature) {
        return FeatureResponseDTO.builder()
                .id(feature.getId())
                .name(feature.getName())
                .icon(feature.getIcon())
                .build();
    }
}
