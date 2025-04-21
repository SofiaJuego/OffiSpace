package com.sofiadev.Offispace.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Aseguro que no tenga valores nulos y que sea unico, es decir que no se repita ningun rol
    @Column(nullable = false, unique = true)
    private String user_type;

    @OneToMany(mappedBy = "role")
    private Set<User> users;
}
