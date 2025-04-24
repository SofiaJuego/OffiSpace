package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.SpaceResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.model.Space;

import java.util.List;

public interface SpaceService {

    List<SpaceResponseDTO> getAllSpace();

    SpaceResponseDTO createSpace(SpaceRequestDTO request);

    SpaceResponseDTO getSpaceById(Long id);

    SpaceResponseDTO updateSpace(Long id,SpaceRequestDTO spaceRequestDTO);

    void deleteSpace(Long id) throws ResourceNotFoundException;



}
