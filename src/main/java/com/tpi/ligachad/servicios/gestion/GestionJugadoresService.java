package com.tpi.ligachad.servicios.gestion;

import com.tpi.ligachad.dominio.Equipo;

public interface GestionJugadoresService {
    void transferirJugador(Equipo origen, Equipo destino, String nombreJugador);
}
