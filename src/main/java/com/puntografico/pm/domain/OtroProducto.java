package com.puntografico.pm.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "otro_producto")
@Getter @Setter
public class OtroProducto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private String trabajoARealizar;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
