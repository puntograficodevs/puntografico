package com.puntografico.pm.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "etiqueta_sticker")
@Getter @Setter
public class EtiquetaSticker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private boolean sonEtiquetasColgantes;

    private boolean sonCierraBolsas;

    private boolean sonCircularesTroqueladas;

    private boolean sonAccesorios;

    private boolean tienePromocion;

    private boolean esPlanchaSoloImpresa;

    private boolean esPlanchaTroquelada;

    private boolean sonTroqueladosConForma;

    private String otros;

    private String medida;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
