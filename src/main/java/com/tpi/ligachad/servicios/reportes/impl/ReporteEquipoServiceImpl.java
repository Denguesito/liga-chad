package com.tpi.ligachad.servicios.reportes.impl;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.estadisticas.impl.EstadisticasEquiposServiceImpl;
import com.tpi.ligachad.servicios.estadisticas.impl.EstadisticasJugadoresServiceImpl;
import com.tpi.ligachad.servicios.reportes.ReporteEquipoService;
import java.util.Optional;

public class ReporteEquipoServiceImpl implements ReporteEquipoService {

    private EstadisticasEquiposServiceImpl estadisticas = new EstadisticasEquiposServiceImpl();
    private EstadisticasJugadoresServiceImpl estadisticasJugadores = new EstadisticasJugadoresServiceImpl();

    public void generarReporte(Equipo equipo) {
        System.out.println("\nReporte del Equipo: " + equipo.getNombre());

        
        double promedioGoles = estadisticas.calcularPromedioGoles(equipo);
        System.out.printf("Promedio de goles por jugador: %.2f\n", promedioGoles);

        
        System.out.println("Jugadores sin goles:");
        estadisticas.jugadoresSinGoles(equipo).forEach(j -> System.out.println("- " + j.getNombre()));

        
        System.out.println("Jugadores con goles:");
        equipo.getJugadores().stream()
            .filter(j -> j.getCantidadGoles() > 0)
            .forEach(j -> System.out.println("- " + j.getNombre() + ": " + j.getCantidadGoles() + " gol(es)"));

        
        Optional<Titular> titularMasMinutos = estadisticasJugadores.titularConMasMinutos(equipo.getJugadores());
        titularMasMinutos.ifPresent(t ->
            System.out.println("Titular con más minutos: " + t.getNombre() + " (" + t.getMinutosJugados() + " minutos)")
        );

        
        Optional<Suplente> suplenteMasUtilizado = estadisticas.suplenteMasUtilizado(equipo);
        suplenteMasUtilizado.ifPresent(s ->
            System.out.println("Suplente más utilizado: " + s.getNombre() + " (" + s.getPartidosDesdeBanco() + " ingresos)")
        );
    }
}
