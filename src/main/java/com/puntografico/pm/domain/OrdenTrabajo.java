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

    private boolean esCuentaCorriente;

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
    @JoinColumn(name = "id_sticker")
    private Sticker sticker;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_etiqueta")
    private Etiqueta etiqueta;
}
