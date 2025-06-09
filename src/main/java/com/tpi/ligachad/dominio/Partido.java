package com.tpi.ligachad.dominio;

import java.util.HashMap;
import java.util.Map;

public class Partido {
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private int golesLocal;
    private int golesVisitante;
    private boolean finalizado;
    private Map<Jugador, Integer> golesPorJugador;

    public Partido(Equipo local, Equipo visitante) {
        this.equipoLocal = local;
        this.equipoVisitante = visitante;
        this.golesLocal = 0;
        this.golesVisitante = 0;
        this.finalizado = false;
        this.golesPorJugador = new HashMap<>();
    }

    public void registrarGol(Jugador jugador) {
        if (finalizado) return;

        golesPorJugador.put(jugador, golesPorJugador.getOrDefault(jugador, 0) + 1);
        jugador.incrementarGoles(1);
        jugador.jugarPartido();

        if (equipoLocal.getJugadores().contains(jugador)) {
            golesLocal++;
        } else if (equipoVisitante.getJugadores().contains(jugador)) {
            golesVisitante++;
        }
    }

    public void finalizarPartido() {
        finalizado = true;
    }

    public boolean estaFinalizado() {
        return finalizado;
    }

    public int getGolesLocal() {
        return golesLocal;
    }

    public int getGolesVisitante() {
        return golesVisitante;
    }

    public Map<Jugador, Integer> getGoleadores() {
        return golesPorJugador;
    }

    public Equipo getEquipoLocal() {
        return equipoLocal;
    }

    public Equipo getEquipoVisitante() {
        return equipoVisitante;
    }
}
