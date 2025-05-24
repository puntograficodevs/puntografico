package com.puntografico.pm.domain;

import com.puntografico.pm.enums.EstadoOrden;
import com.puntografico.pm.enums.EstadoPago;
import com.puntografico.pm.enums.MedioPago;
import lombok.Getter;
import lombok.Setter;

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

    private LocalDate fechaPedido;

    private LocalDate fechaMuestra;

    private LocalDate fechaEntrega;

    private String horaEntrega;

    private int cantidad;

    private double total;

    private double abonado;

    private double resta;

    private String enlaceArchivo;

    private String detalle;

    @Enumerated(EnumType.STRING)
    private MedioPago medioPago;

    @Enumerated(EnumType.STRING)
    private EstadoPago estadoPago;

    @Enumerated(EnumType.STRING)
    private EstadoOrden estadoOrden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_categoria_producto")
    private CategoriaProducto categoriaProducto;
}
