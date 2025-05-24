package com.puntografico.pm.domain;

import javax.persistence.*;

@Entity
@Table(name = "otro_producto")
public class OtroProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private String trabajoARealizar;
}
