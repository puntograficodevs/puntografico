package com.puntografico.pm.domain;

import com.puntografico.pm.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "tarjeta")
@Getter @Setter
public class Tarjeta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoColor tipoColor;

    @Enumerated(EnumType.STRING)
    private TipoFaz tipoFaz;

    @Enumerated(EnumType.STRING)
    private TipoTarjeta tipoTarjeta;

    @Enumerated(EnumType.STRING)
    private TamanioTarjeta tamanioTarjeta;

    private String tamanioPersonalizado;

    @Enumerated(EnumType.STRING)
    private TipoLaminado tipoLaminado;

    @Enumerated(EnumType.STRING)
    private CantidadEstandar cantidadEstandar;

    private int cantidadOtro;
}
