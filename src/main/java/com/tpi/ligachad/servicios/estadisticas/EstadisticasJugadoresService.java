package com.tpi.ligachad.servicios.estadisticas;

import com.tpi.ligachad.dominio.*;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class EstadisticasJugadoresService {

    public Optional<Jugador> obtenerJugadorMasEficiente(List<Jugador> jugadores) {
        return jugadores.stream()
            .filter(j -> j.calcularEficiencia() > 0)
            .max(Comparator.comparingDouble(Jugador::calcularEficiencia));
    }

    public Optional<Titular> titularConMasMinutos(List<Jugador> jugadores) {
        return jugadores.stream()
            .filter(j -> j instanceof Titular)
            .map(j -> (Titular) j)
            .max(Comparator.comparingInt(Titular::getMinutosJugados));
    }

    public List<Suplente> suplentesQueNuncaIngresaron(List<Jugador> jugadores) {
        return jugadores.stream()
            .filter(j -> j instanceof Suplente)
            .map(j -> (Suplente) j)
            .filter(s -> !s.haIngresado())
            .toList();
    }
}

