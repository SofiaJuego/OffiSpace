package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.request.FeatureRequestDTO;
import com.sofiadev.Offispace.dto.response.FeatureResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.FeatureService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
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

    @Operation(summary = "Creo una característica")
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FeatureResponseDTO> createFeature(
            @RequestBody @Valid FeatureRequestDTO request)
    {
        FeatureResponseDTO create = featureService.createFeature(request);
        return new ResponseEntity<>(create, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizo una característica existente")
    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<FeatureResponseDTO> updateFeature(
            @PathVariable Long id,
            @RequestBody @Valid
            FeatureRequestDTO request) throws ResourceNotFoundException {
      FeatureResponseDTO update = featureService.updateFeature(id, request);
      return ResponseEntity.ok(update);
    }
    @Operation(summary = "Elimino característica por ID")
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteFeature(@PathVariable Long id) throws ResourceNotFoundException {
        featureService.deleteFeature(id);
        return ResponseEntity.ok("Se elimino la característica con exito");
    }

    @Operation(summary = "Obtengo todas las característica")
    @GetMapping
    public ResponseEntity<List<FeatureResponseDTO>> getAllFeatures(){
        List<FeatureResponseDTO> features = featureService.getAllFeatures();
        return ResponseEntity.ok(features);
    }


}
