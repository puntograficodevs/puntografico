package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoMate;
import com.puntografico.pm.enums.TipoOtraSublimacion;
import com.puntografico.pm.enums.TipoTaza;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sublimacion")
@Getter @Setter
public class Sublimacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoTaza tipoTaza;

    @Enumerated(EnumType.STRING)
    private TipoMate tipoMate;

    @Enumerated(EnumType.STRING)
    private TipoOtraSublimacion tipoOtraSublimacion;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
