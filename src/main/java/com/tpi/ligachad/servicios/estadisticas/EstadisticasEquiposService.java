package com.tpi.ligachad.servicios.estadisticas;

import com.tpi.ligachad.dominio.Equipo;
import com.tpi.ligachad.dominio.Jugador;
import com.tpi.ligachad.dominio.Suplente;
import java.util.List;
import java.util.Optional;

public interface EstadisticasEquiposService {
    double calcularPromedioGoles(Equipo equipo);
    List<Jugador> jugadoresSinGoles(Equipo equipo);
    Optional<Suplente> suplenteMasUtilizado(Equipo equipo);
}
