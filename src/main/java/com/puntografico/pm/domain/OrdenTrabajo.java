package com.puntografico.pm.domain;

import com.puntografico.pm.enums.EstadoOrden;
import com.puntografico.pm.enums.EstadoPago;
import com.puntografico.pm.enums.MedioPago;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "orden_trabajo")
@Getter @Setter
public class OrdenTrabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado")
    private Empleado empleado;

    private String clienteNombre;

    private String clienteTelefono;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaPedido;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaMuestra;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fechaEntrega;

    private String horaEntrega;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estadoOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_papeleria")
    private Papeleria papeleria;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etiqueta_sticker")
    private EtiquetaSticker etiquetaSticker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_folleto")
    private Folleto folleto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_grafica")
    private Grafica grafica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_impresion")
    private Impresion impresion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_otro_producto")
    private OtroProducto otroProducto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sello")
    private Sello sello;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sublimacion")
    private Sublimacion sublimacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_talonario")
    private Talonario talonario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tarjeta")
    private Tarjeta tarjeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vinilo")
    private Vinilo vinilo;
}
