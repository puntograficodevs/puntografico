package com.puntografico.pm.service;

import com.puntografico.pm.domain.OrdenTrabajo;
import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.enums.EstadoOrden;
import com.puntografico.pm.enums.EstadoPago;
import com.puntografico.pm.repository.OrdenTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class OrdenTrabajoService {

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    private PapeleriaService papeleriaService;

    public OrdenTrabajo guardar(OrdenTrabajo ordenTrabajo) {
        agregarFechaPedidoEstadoPagoYEstadoOrden(ordenTrabajo);
        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    private void agregarFechaPedidoEstadoPagoYEstadoOrden(OrdenTrabajo ordenTrabajo) {
        asignarFechaActualComoFechaPedido(ordenTrabajo);
        asignarEstadoPagoSegunImporteRestante(ordenTrabajo);
        asignarEstadoTomadoComoEstadoOrden(ordenTrabajo);
    }

    private void asignarFechaActualComoFechaPedido(OrdenTrabajo ordenTrabajo) {
        LocalDate fechaActual = LocalDate.now();
        ordenTrabajo.setFechaPedido(fechaActual);
    }

    private void asignarEstadoPagoSegunImporteRestante(OrdenTrabajo ordenTrabajo) {
        double total = traerTotalDelProducto(ordenTrabajo);
        double abonado = traerAbonadoDelProducto(ordenTrabajo);
        double resta = total - abonado;

        if (Math.abs(resta - total) < 0.01) {
            ordenTrabajo.setEstadoPago(EstadoPago.SIN_PAGAR);
        } else if (Math.abs(resta) < 0.01) {
            ordenTrabajo.setEstadoPago(EstadoPago.PAGADO);
        } else {
            ordenTrabajo.setEstadoPago(EstadoPago.SEÑADO);
        }
    }

    private double traerTotalDelProducto(OrdenTrabajo ordenTrabajo) {
        double total;

        if (ordenTrabajo.getPapeleria() != null) {
            Papeleria papeleria = papeleriaService.buscarPorId(ordenTrabajo.getPapeleria().getId());
            total = papeleria.getTotal();
        } else {
            total = 10.00;
        }

        return total;
    }

    private double traerAbonadoDelProducto(OrdenTrabajo ordenTrabajo) {
        double abonado;

        if (ordenTrabajo.getPapeleria() != null) {
            Papeleria papeleria = papeleriaService.buscarPorId(ordenTrabajo.getPapeleria().getId());
            abonado = papeleria.getAbonado();
        } else {
            abonado = 10.00;
        }

        return abonado;
    }

    private void asignarEstadoTomadoComoEstadoOrden(OrdenTrabajo ordenTrabajo) {
        ordenTrabajo.setEstadoOrden(EstadoOrden.TOMADO);
    }
}
