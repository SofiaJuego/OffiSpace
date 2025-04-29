package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.request.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.response.SpaceResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;

import java.util.List;

public interface SpaceService {

    List<SpaceResponseDTO> getAllSpace();

    SpaceResponseDTO createSpace(SpaceRequestDTO request) throws ResourceNotFoundException;

    SpaceResponseDTO getSpaceById(Long id) throws ResourceNotFoundException;

    SpaceResponseDTO updateSpace(Long id,SpaceRequestDTO spaceRequestDTO) throws ResourceNotFoundException;

    void deleteSpace(Long id) throws ResourceNotFoundException;
}
