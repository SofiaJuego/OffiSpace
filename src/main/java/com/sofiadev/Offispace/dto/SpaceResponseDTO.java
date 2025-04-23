package com.sofiadev.Offispace.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceResponseDTO {

    private Long id;
    private String name;
    private String description;
    private String address;
    private String city;
    private String country;
    private BigDecimal pricePerDay;
    private Boolean available;
    private String mainImage;
    private String imageGallery;
    private Integer capacity;
    private String userName;
    private String categoryName;

}
