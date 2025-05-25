package com.puntografico.pm.domain;

import com.puntografico.pm.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "impresion")
@Getter @Setter
public class Impresion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoProducto tipoProducto;

    @Enumerated(EnumType.STRING)
    private TamanioHoja tamanioHoja;

    @Enumerated(EnumType.STRING)
    private TipoColor tipoColor;

    @Enumerated(EnumType.STRING)
    private TipoFaz tipoFaz;

    private boolean tieneAnillado;

    @Enumerated(EnumType.STRING)
    private TipoPapelImpresion tipoPapelImpresion;

    private int gramajeEspecial;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
