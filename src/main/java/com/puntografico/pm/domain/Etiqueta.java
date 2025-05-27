package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoLaminado;
import com.puntografico.pm.enums.TipoPapelEtiquetas;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "etiqueta")
@Getter @Setter
public class Etiqueta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Enumerated(EnumType.STRING)
    private TipoPapelEtiquetas tipoPapelEtiquetas;

    @Enumerated(EnumType.STRING)
    private TipoLaminado tipoLaminado;

    private boolean conPerforacion;

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
