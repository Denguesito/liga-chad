package com.tpi.ligachad.menu.reportes;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.reportes.*;
import com.tpi.ligachad.utils.LectorConsola;

import java.util.Optional;

public class MenuReportes {
    private final Liga liga;
    private final ReporteLigaService reporteLiga = new ReporteLigaService();
    private final ReporteEquipoService reporteEquipo = new ReporteEquipoService();

    public MenuReportes(Liga liga) {
        this.liga = liga;
    }

    public void reporteGeneralLiga() {
        reporteLiga.generarReporte(liga);
    }

    public void reportePorEquipo() {
        String nombre = LectorConsola.leerTexto("Nombre del equipo: ");
        Optional<Equipo> equipo = liga.buscarEquipoPorNombre(nombre);
        if (equipo.isPresent()) {
            reporteEquipo.generarReporte(equipo.get());
        } else {
            System.out.println("⚠️ Equipo no encontrado.");
        }
    }
}