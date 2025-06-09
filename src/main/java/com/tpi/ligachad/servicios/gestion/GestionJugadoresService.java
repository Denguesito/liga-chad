package com.tpi.ligachad.servicios.gestion;

import com.tpi.ligachad.dominio.*;
import java.util.Optional;

public class GestionJugadoresService {

    public void transferirJugador(Equipo origen, Equipo destino, String nombreJugador) {
        Optional<Jugador> jugadorOpt = origen.buscarJugadorPorNombre(nombreJugador);

        if (jugadorOpt.isPresent()) {
            Jugador jugador = jugadorOpt.get();
            if (jugador.isTransferible()) {
                origen.quitarJugador(jugador);
                // Al transferir, el jugador pasa a ser transferible en el nuevo equipo
                jugador.setTransferible(true);
                destino.agregarJugador(jugador);
                System.out.println("✅ Jugador transferido exitosamente.");
            } else {
                System.out.println("⚠️ El jugador no es transferible.");
            }
        } else {
            System.out.println("⚠️ Jugador no encontrado en el equipo origen.");
        }
    }
}

