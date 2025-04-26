package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.SpaceResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Space;

import java.util.List;

public interface SpaceService {

    List<SpaceResponseDTO> getAllSpace();

    SpaceResponseDTO createSpace(SpaceRequestDTO request) throws ResourceNotFoundException;

    SpaceResponseDTO getSpaceById(Long id) throws ResourceNotFoundException;

    SpaceResponseDTO updateSpace(Long id,SpaceRequestDTO spaceRequestDTO) throws ResourceNotFoundException;

    void deleteSpace(Long id) throws ResourceNotFoundException;
}
