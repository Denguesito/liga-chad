package com.tpi.ligachad.servicios.reportes;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.estadisticas.EstadisticasEquiposService;

import java.util.List;
import java.util.Optional;

public class ReporteEquipoService {

    private EstadisticasEquiposService estadisticas = new EstadisticasEquiposService();

    public void generarReporte(Equipo equipo) {
        System.out.println("\n📋 Reporte del Equipo: " + equipo.getNombre());

        double promedioGoles = estadisticas.calcularPromedioGoles(equipo);
        System.out.printf("Promedio de goles por jugador: %.2f\n", promedioGoles);

        System.out.println("Jugadores sin goles:");
        List<Jugador> sinGoles = estadisticas.jugadoresSinGoles(equipo);
        sinGoles.forEach(j -> System.out.println("- " + j.getNombre()));

        // Titular con más minutos
        com.tpi.ligachad.servicios.estadisticas.EstadisticasJugadoresService estadJugadores = new com.tpi.ligachad.servicios.estadisticas.EstadisticasJugadoresService();
        Optional<Titular> titularMasMinutos = estadJugadores.titularConMasMinutos(equipo.getJugadores());
        titularMasMinutos.ifPresent(t ->
            System.out.println("Titular con más minutos: " + t.getNombre() + " (" + t.getMinutosJugados() + " minutos)")
        );

        // Suplente más utilizado
        Optional<Suplente> suplenteMasUtilizado = estadisticas.suplenteMasUtilizado(equipo);
        suplenteMasUtilizado.ifPresent(s ->
            System.out.println("Suplente más utilizado: " + s.getNombre() + " (" + s.getPartidosDesdeBanco() + " ingresos)")
        );

        // Mostrar suplente no usado
        Optional<Suplente> suplenteNoUsado = equipo.getSuplentes().stream()
            .map(j -> (Suplente) j)
            .filter(s -> !s.haIngresado())
            .findFirst();
        suplenteNoUsado.ifPresent(s ->
            System.out.println("Suplente no usado: " + s.getNombre())
        );
    }
}
