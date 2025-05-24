package com.puntografico.pm.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "categoria_producto")
@Getter @Setter
public class CategoriaProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_categoria_producto;

    private String nombre;
}
