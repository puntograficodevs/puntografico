package com.puntografico.pm.domain;

import com.puntografico.pm.enums.TipoArmado;
import com.puntografico.pm.enums.TipoColor;
import com.puntografico.pm.enums.TipoTalonario;
import com.puntografico.pm.enums.TipoTerminacionTalonario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "talonario")
@Getter @Setter
public class Talonario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @Enumerated(EnumType.STRING)
    private TipoColor tipoColor;

    @Enumerated(EnumType.STRING)
    private TipoTalonario tipoTalonario;

    @Enumerated(EnumType.STRING)
    private TipoArmado tipoArmado;

    @Enumerated(EnumType.STRING)
    private TipoTerminacionTalonario tipoTerminacionTalonario;

    private String medida;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
