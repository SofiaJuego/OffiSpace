package com.sofiadev.Offispace.controller;

import com.sofiadev.Offispace.dto.SpaceRequestDTO;
import com.sofiadev.Offispace.dto.SpaceResponseDTO;
import com.sofiadev.Offispace.exception.ResourceNotFoundException;
import com.sofiadev.Offispace.service.SpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spaces")
@RequiredArgsConstructor
public class SpaceController {

    private SpaceService spaceService;

    @Autowired
    public SpaceController(SpaceService spaceService) {
        this.spaceService = spaceService;
    }

    @GetMapping
    public ResponseEntity<List<SpaceResponseDTO>> getAllSpace(){
        List<SpaceResponseDTO> spaces = spaceService.getAllSpace();
        return ResponseEntity.ok(spaces);
    }

    @PostMapping
    public ResponseEntity<SpaceResponseDTO> createSpace(@RequestBody SpaceRequestDTO request){
        SpaceResponseDTO createSpace = spaceService.createSpace(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(createSpace);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SpaceResponseDTO> getSpaceById(@PathVariable Long id){
        return ResponseEntity.ok(spaceService.getSpaceById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SpaceResponseDTO> updateSpace (@PathVariable Long id, @RequestBody SpaceRequestDTO request){
        SpaceResponseDTO update = spaceService.updateSpace(id, request);
        return ResponseEntity.ok(update);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSpace(@PathVariable Long id) throws ResourceNotFoundException {
        spaceService.deleteSpace(id);
        return ResponseEntity.noContent().build();
    }


}
