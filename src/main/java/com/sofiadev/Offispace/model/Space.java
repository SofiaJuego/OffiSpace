package com.sofiadev.Offispace.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "space")
public class Space {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String description;

    private String address;

    private String city;

    private String country;

    private BigDecimal price_per_day;

    private Boolean available;

    private String mainImage;

    private String imageGallery;

    private Integer capacity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;




}
