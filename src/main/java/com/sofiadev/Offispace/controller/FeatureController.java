package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.FavoriteResponseDTO;
import com.sofiadev.Offispace.dto.FeatureRequestDTO;
import com.sofiadev.Offispace.dto.FeatureResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.FeatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/features")
@RequiredArgsConstructor
public class FeatureController {

    private final FeatureService featureService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FeatureResponseDTO> createFeature(
            @RequestBody FeatureRequestDTO request)
    {
        FeatureResponseDTO create = featureService.createFeature(request);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FeatureResponseDTO> updateFeature(
            @PathVariable Long id,
            @RequestBody FeatureRequestDTO request) throws ResourceNotFoundException {
      FeatureResponseDTO update = featureService.updateFeature(id, request);
      return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteFeature(@PathVariable Long id) throws ResourceNotFoundException {
        featureService.deleteFeature(id);
        return ResponseEntity.ok("Se elimino la característica con exito");
    }


    @GetMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<List<FeatureResponseDTO>> getAllFeatures(){
        List<FeatureResponseDTO> features = featureService.getAllFeatures();
        return ResponseEntity.ok(features);
    }


}
