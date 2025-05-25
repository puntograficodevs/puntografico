package com.puntografico.pm.domain;

import com.puntografico.pm.enums.PapelFotografico;
import com.puntografico.pm.enums.TipoObra;
import com.puntografico.pm.enums.TipoPortabanner;
import com.puntografico.pm.enums.TipoLona;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grafica")
@Getter @Setter
public class Grafica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    private boolean esBlueback;

    @Enumerated(EnumType.STRING)
    private TipoObra tipoObra;

    @Enumerated(EnumType.STRING)
    private PapelFotografico papelFotografico;

    @Enumerated(EnumType.STRING)
    private TipoLona tipoLona;

    private String medidasLonas;

    private String medidaOtros;

    private boolean tieneBolsillos;

    private boolean tieneOjales;

    private boolean tieneDemasiaCartel;

    @Enumerated(EnumType.STRING)
    private TipoPortabanner tipoPortabanner;

    private String plasticoCorrugadoMedidas;

    private boolean tienePlasticoCorrugadoOjales;

    private int plasticoCorrugadoCantOjales;

    private double precioColocacion;

    private String otros;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;
}
