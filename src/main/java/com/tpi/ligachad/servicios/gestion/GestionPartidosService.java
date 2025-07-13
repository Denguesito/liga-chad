package com.tpi.ligachad.servicios.gestion;

import com.tpi.ligachad.dominio.Liga;
import com.tpi.ligachad.dominio.Partido;
import com.tpi.ligachad.dominio.Jugador;

public interface GestionPartidosService {
    void registrarGol(Partido partido, Jugador jugador);
    void finalizarPartido(Partido partido);
    void registrarPartidoEnLiga(Liga liga, Partido partido);
}
