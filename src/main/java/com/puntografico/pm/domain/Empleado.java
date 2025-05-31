package com.puntografico.pm.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "empleado")
@Getter @Setter
public class Empleado {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String username;

    private String password;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_rol")
    private Rol rol;
}
