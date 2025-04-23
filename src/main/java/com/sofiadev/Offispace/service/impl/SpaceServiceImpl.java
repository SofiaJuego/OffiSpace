package com.sofiadev.Offispace.service.impl;

import com.sofiadev.Offispace.dto.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.SpaceResponseDTO;
import com.sofiadev.Offispace.model.Category;
import com.sofiadev.Offispace.model.Space;
import com.sofiadev.Offispace.model.User;
import com.sofiadev.Offispace.repository.CategoryRepository;
import com.sofiadev.Offispace.repository.SpaceRepository;
import com.sofiadev.Offispace.repository.UserRepository;
import com.sofiadev.Offispace.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SpaceServiceImpl implements SpaceService {

    private final SpaceRepository spaceRepository;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    @Autowired
    public SpaceServiceImpl(SpaceRepository spaceRepository, UserRepository userRepository, CategoryRepository categoryRepository) {
        this.spaceRepository = spaceRepository;
        this.userRepository = userRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<SpaceResponseDTO> getAllSpace() {
        return spaceRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());

    }

    private SpaceResponseDTO mapToDTO(Space space){
        return SpaceResponseDTO.builder()
                .id(space.getId())
                .name(space.getName())
                .description(space.getDescription())
                .address(space.getAddress())
                .city(space.getCity())
                .country(space.getCountry())
                .pricePerDay(space.getPricePerDay())
                .available(space.getAvailable())
                .mainImage(space.getMainImage())
                .imageGallery(space.getImageGallery())
                .capacity(space.getCapacity())
                .build();
    }

    @Override
    public SpaceResponseDTO createSpace(SpaceRequestDTO request) {
//        User user = userRepository.findById(request.getUserId())
//                .orElseThrow(() -> new RuntimeException("No se puedo encontrar al usuario"));
//
//        Category category = categoryRepository.findById(request.getCategoryId())
//                .orElseThrow(() -> new RuntimeException("No se encontro la categoria"));

        Space space = Space.builder()
                .name(request.getName())
                .name(request.getName())
                .description(request.getDescription())
                .address(request.getAddress())
                .city(request.getCity())
                .country(request.getCountry())
                .pricePerDay(request.getPricePerDay())
                .available(request.getAvailable())
                .mainImage(request.getMainImage())
                .imageGallery(request.getImageGallery())
                .capacity(request.getCapacity())
//                .user(user)
//                .category(category)
                .build();

        Space saveSpace = spaceRepository.save(space);
        return mapToDTO(saveSpace);

    }
}
