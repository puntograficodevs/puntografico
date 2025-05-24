package com.puntografico.pm.domain;

import com.puntografico.pm.enums.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "folleto")
@Getter @Setter
public class Folleto {

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
    private TipoFolleto tipoFolleto;

    @Enumerated(EnumType.STRING)
    private TamanioFolleto tamanioFolleto;

    private String tamanioPersonalizado;

    @Enumerated(EnumType.STRING)
    private CantidadEstandar cantidadEstandar;

    private String cantidadOtro;
}
