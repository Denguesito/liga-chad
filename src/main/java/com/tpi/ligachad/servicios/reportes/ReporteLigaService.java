package com.tpi.ligachad.servicios.reportes;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.estadisticas.EstadisticasLigaService;

import java.util.Optional;

public class ReporteLigaService {

    private EstadisticasLigaService estadisticas = new EstadisticasLigaService();

    public void generarReporte(Liga liga) {
        System.out.println("\n📊 Reporte General de la Liga");

        int totalGoles = estadisticas.calcularTotalGoles(liga);
        double promedio = estadisticas.calcularPromedioGolesPorPartido(liga);

        System.out.println("Total de goles en la liga: " + totalGoles);
        System.out.printf("Promedio de goles por partido: %.2f\n", promedio);

        Optional<Jugador> goleador = estadisticas.obtenerGoleadorDeLaLiga(liga);
        goleador.ifPresent(j -> 
            System.out.println("Goleador de la liga: " + j.getNombre() + " (" + j.getCantidadGoles() + " goles)")
        );

        Optional<Jugador> masEficiente = liga.getEquipos().stream()
            .flatMap(e -> e.getJugadores().stream())
            .filter(j -> j.calcularEficiencia() > 0)
            .max((j1, j2) -> Double.compare(j1.calcularEficiencia(), j2.calcularEficiencia()));

        masEficiente.ifPresent(j ->
            System.out.printf("Jugador más eficiente: %s (%.2f de eficiencia)\n", j.getNombre(), j.calcularEficiencia())
        );

        Optional<Equipo> masGoleador = estadisticas.equipoMasGoleador(liga);
        masGoleador.ifPresent(e -> 
            System.out.println("Equipo con más goles: " + e.getNombre())
        );
    }
}
