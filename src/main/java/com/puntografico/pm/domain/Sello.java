package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoModelo;
import com.puntografico.pm.enums.TipoProducto;
import com.puntografico.pm.enums.TipoProfesional;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "sello")
@Getter @Setter
public class Sello {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoProducto tipoProducto;

    private boolean esProfesional;

    @Enumerated(EnumType.STRING)
    private TipoProfesional tipoProfesional;

    private char dibujo;

    private int tipografia;

    private String textoLineaUno;

    private String textoLineaDos;

    private String textoLineaTres;

    private String textoLineaCuatro;

    @Enumerated(EnumType.STRING)
    private TipoModelo tipoModelo;
}
