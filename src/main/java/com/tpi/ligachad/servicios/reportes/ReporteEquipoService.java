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


        equipo.getJugadores().stream()
            .filter(j -> j.getCantidadGoles() > 0)
            .forEach(j -> System.out.println("- " + j.getNombre() + ": " + j.getCantidadGoles() + " gol(es)"));


        equipo.getTitulares().forEach(j -> {
            Titular t = (Titular) j;
            System.out.println("- " + t.getNombre() + ": " + t.getMinutosJugados() + " minutos");
        });


        equipo.getSuplentes().forEach(j -> {
            Suplente s = (Suplente) j;
            System.out.println("- " + s.getNombre() + ": " + s.getPartidosDesdeBanco() + " ingresos");
        });


        List<Jugador> sinGoles = estadisticas.jugadoresSinGoles(equipo);
        sinGoles.forEach(j -> System.out.println("- " + j.getNombre()));


        com.tpi.ligachad.servicios.estadisticas.EstadisticasJugadoresService estadJugadores = new com.tpi.ligachad.servicios.estadisticas.EstadisticasJugadoresService();
        Optional<Titular> titularMasMinutos = estadJugadores.titularConMasMinutos(equipo.getJugadores());
        titularMasMinutos.ifPresent(t ->
            System.out.println("Titular con más minutos: " + t.getNombre() + " (" + t.getMinutosJugados() + " minutos)")
        );


        Optional<Suplente> suplenteMasUtilizado = estadisticas.suplenteMasUtilizado(equipo);
        suplenteMasUtilizado.ifPresent(s ->
            System.out.println("Suplente más utilizado: " + s.getNombre() + " (" + s.getPartidosDesdeBanco() + " ingresos)")
        );


        Optional<Suplente> suplenteNoUsado = equipo.getSuplentes().stream()
            .map(j -> (Suplente) j)
            .filter(s -> !s.haIngresado())
            .findFirst();
        suplenteNoUsado.ifPresent(s ->
            System.out.println("Suplente no usado: " + s.getNombre())
        );
    }
}
