package com.tpi.ligachad.servicios.gestion;

import com.tpi.ligachad.dominio.Equipo;
import com.tpi.ligachad.dominio.Jugador;
import com.tpi.ligachad.dominio.Liga;

public interface GestionEquiposService {
    void crearEquipo(Liga liga, String nombre);
    void agregarJugadorAEquipo(Equipo equipo, Jugador jugador);
}
