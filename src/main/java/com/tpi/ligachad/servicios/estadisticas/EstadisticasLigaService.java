package com.tpi.ligachad.servicios.estadisticas;

import com.tpi.ligachad.dominio.Liga;
import com.tpi.ligachad.dominio.Equipo;
import com.tpi.ligachad.dominio.Jugador;
import java.util.Optional;

public interface EstadisticasLigaService {
    int calcularTotalGoles(Liga liga);
    double calcularPromedioGolesPorPartido(Liga liga);
    Optional<Jugador> obtenerGoleadorDeLaLiga(Liga liga);
    Optional<Equipo> equipoMasGoleador(Liga liga);
}
