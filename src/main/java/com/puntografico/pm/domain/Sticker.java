package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoTroquelado;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sticker")
@Getter @Setter
public class Sticker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean esTroquelado;

    @Enumerated(EnumType.STRING)
    private TipoTroquelado tipoTroquelado;

    private String medida;

    private int cantidad;

    private String archivo;

    private String detalle;

    private double total;

    private double abonado;

    private double resta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;
}
