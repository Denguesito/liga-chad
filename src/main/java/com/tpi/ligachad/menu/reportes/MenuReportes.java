package com.tpi.ligachad.menu.reportes;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.reportes.ReporteLigaService;
import com.tpi.ligachad.servicios.reportes.ReporteEquipoService;
import com.tpi.ligachad.servicios.reportes.impl.ReporteLigaServiceImpl;
import com.tpi.ligachad.servicios.reportes.impl.ReporteEquipoServiceImpl;
import com.tpi.ligachad.utils.LectorConsola;

import java.util.Optional;

public class MenuReportes {
    private final Liga liga;
    private final ReporteLigaService reporteLiga = new ReporteLigaServiceImpl();
    private final ReporteEquipoService reporteEquipo = new ReporteEquipoServiceImpl();

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
            System.out.println("Equipo no encontrado.");
        }
    }
}