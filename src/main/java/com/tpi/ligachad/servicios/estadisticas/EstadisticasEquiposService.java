package com.tpi.ligachad.servicios.estadisticas;

import com.tpi.ligachad.dominio.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EstadisticasEquiposService {

    public double calcularPromedioGoles(Equipo equipo) {
        List<Jugador> jugadores = equipo.getJugadores();
        if (jugadores.isEmpty()) return 0;

        int totalGoles = jugadores.stream().mapToInt(Jugador::getCantidadGoles).sum();
        return (double) totalGoles / jugadores.size();
    }

    public List<Jugador> jugadoresSinGoles(Equipo equipo) {
        return equipo.getJugadores().stream()
            .filter(j -> j.getCantidadGoles() == 0)
            .toList();
    }

    public Optional<Suplente> suplenteMasUtilizado(Equipo equipo) {
        return equipo.getSuplentes().stream()
            .map(j -> (Suplente) j)
            .max(Comparator.comparingInt(Suplente::getPartidosDesdeBanco));
    }
}
