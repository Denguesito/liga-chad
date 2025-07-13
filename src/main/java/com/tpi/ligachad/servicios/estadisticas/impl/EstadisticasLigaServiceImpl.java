package com.tpi.ligachad.servicios.estadisticas.impl;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.estadisticas.EstadisticasLigaService;
import java.util.Comparator;
import java.util.Optional;

public class EstadisticasLigaServiceImpl implements EstadisticasLigaService {
    public int calcularTotalGoles(Liga liga) {
        return liga.getPartidos().stream()
            .mapToInt(p -> p.getGolesLocal() + p.getGolesVisitante())
            .sum();
    }

    public double calcularPromedioGolesPorPartido(Liga liga) {
        if (liga.getPartidos().isEmpty()) return 0;
        return (double) calcularTotalGoles(liga) / liga.getPartidos().size();
    }

    public Optional<Jugador> obtenerGoleadorDeLaLiga(Liga liga) {
        return liga.getEquipos().stream()
            .flatMap(e -> e.getJugadores().stream())
            .max(Comparator.comparingInt(Jugador::getCantidadGoles));
    }

    public Optional<Equipo> equipoMasGoleador(Liga liga) {
        return liga.getEquipos().stream()
            .max(Comparator.comparingInt(e ->
                e.getJugadores().stream().mapToInt(Jugador::getCantidadGoles).sum()
            ));
    }
}
