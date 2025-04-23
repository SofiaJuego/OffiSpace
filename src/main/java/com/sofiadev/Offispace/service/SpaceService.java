package com.sofiadev.Offispace.service;

import com.sofiadev.Offispace.dto.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.SpaceResponseDTO;

import java.util.List;

public interface SpaceService {

    List<SpaceResponseDTO> getAllSpace();

    SpaceResponseDTO createSpace(SpaceRequestDTO request);

}
