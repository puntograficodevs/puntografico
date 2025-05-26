package com.puntografico.pm.service;

import com.puntografico.pm.domain.OrdenTrabajo;
import com.puntografico.pm.domain.Papeleria;
import com.puntografico.pm.enums.EstadoOrden;
import com.puntografico.pm.enums.EstadoPago;
import com.puntografico.pm.repository.OrdenTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrdenTrabajoService {

    @Autowired
    private OrdenTrabajoRepository ordenTrabajoRepository;

    @Autowired
    private PapeleriaService papeleriaService;

    public List<OrdenTrabajo> buscarPorIdClienteNombreOClienteTelefono(String tipo, String valor) {
        List<OrdenTrabajo> ordenes;

        if (tipo.equalsIgnoreCase("ID")) {
            try {
                Long id = Long.parseLong(valor);
                Optional<OrdenTrabajo> ordenOpcional = ordenTrabajoRepository.findById(id);
                ordenes = ordenOpcional.map(List::of).orElseGet(List::of);
            } catch (NumberFormatException e) {
                return List.of();
            }
        } else if (tipo.equalsIgnoreCase("NOMBRE")) {
            String nombreNormalizado = normalizar(valor);
            ordenes = ordenTrabajoRepository.findAllByClienteNombre(nombreNormalizado);
        } else if (tipo.equalsIgnoreCase("TELEFONO")) {
            ordenes = ordenTrabajoRepository.findAllByClienteTelefono(valor);
        } else {
            ordenes = List.of();
        }

        return ordenes;
    }
    public OrdenTrabajo guardar(OrdenTrabajo ordenTrabajo) {
        String nombre = ordenTrabajo.getClienteNombre();
        ordenTrabajo.setClienteNombre(normalizar(nombre));
        agregarFechaPedidoEstadoPagoYEstadoOrden(ordenTrabajo);
        return ordenTrabajoRepository.save(ordenTrabajo);
    }

    private String normalizar(String texto) {
        if (texto == null || texto.isBlank()) return "";
        // Quitar tildes y pasar a lowercase
        String sinTildes = Normalizer.normalize(texto, Normalizer.Form.NFD)
                .replaceAll("\\p{InCombiningDiacriticalMarks}+", "")
                .toLowerCase();

        // Capitalizar primera letra de cada palabra
        String[] palabras = sinTildes.split("\\s+");
        StringBuilder resultado = new StringBuilder();
        for (String palabra : palabras) {
            if (palabra.isEmpty()) continue;
            resultado.append(Character.toUpperCase(palabra.charAt(0)))
                    .append(palabra.substring(1))
                    .append(" ");
        }
        return resultado.toString().trim();
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
