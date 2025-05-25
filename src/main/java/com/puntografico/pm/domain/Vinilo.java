package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoCorteVinilo;
import com.puntografico.pm.enums.TipoOtroVinilo;
import com.puntografico.pm.enums.TipoTerminacionVinilo;
import com.puntografico.pm.enums.TipoViniloImpreso;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vinilo")
@Getter @Setter
public class Vinilo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoCorteVinilo tipoCorteVinilo;

    @Enumerated(EnumType.STRING)
    private TipoViniloImpreso tipoViniloImpreso;

    @Enumerated(EnumType.STRING)
    private TipoOtroVinilo tipoOtroVinilo;

    @Enumerated(EnumType.STRING)
    private TipoTerminacionVinilo tipoTerminacionVinilo;

    private String medida;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
