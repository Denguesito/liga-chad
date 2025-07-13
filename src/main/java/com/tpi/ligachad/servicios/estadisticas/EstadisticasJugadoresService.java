package com.tpi.ligachad.servicios.estadisticas;

import com.tpi.ligachad.dominio.Jugador;
import com.tpi.ligachad.dominio.Titular;
import com.tpi.ligachad.dominio.Suplente;
import java.util.List;
import java.util.Optional;

public interface EstadisticasJugadoresService {
    Optional<Jugador> obtenerJugadorMasEficiente(List<Jugador> jugadores);
    Optional<Titular> titularConMasMinutos(List<Jugador> jugadores);
    List<Suplente> suplentesQueNuncaIngresaron(List<Jugador> jugadores);
}
