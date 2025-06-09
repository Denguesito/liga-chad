package com.tpi.ligachad.servicios.gestion;

import com.tpi.ligachad.dominio.*;

public class GestionPartidosService {

    public void registrarGol(Partido partido, Jugador jugador) {
        if (!partido.estaFinalizado()) {
            partido.registrarGol(jugador);
            System.out.println("⚽ Gol registrado para " + jugador.getNombre());
        } else {
            System.out.println("⚠️ El partido ya está finalizado.");
        }
    }

    public void finalizarPartido(Partido partido) {
        partido.finalizarPartido();
        System.out.println("✅ Partido finalizado.");
    }

    public void registrarPartidoEnLiga(Liga liga, Partido partido) {
        liga.registrarPartido(partido);
        System.out.println("✅ Partido agregado a la liga.");
    }
}
