package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoColor;
import com.puntografico.pm.enums.TipoPapeleria;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "papeleria")
@Getter @Setter
public class Papeleria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoColor tipoColor;

    @Enumerated(EnumType.STRING)
    private TipoPapeleria tipoPapeleria;

    private String detalleOtro;

    private String medida;
}
