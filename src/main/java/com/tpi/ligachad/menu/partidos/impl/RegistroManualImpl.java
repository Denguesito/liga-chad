package com.tpi.ligachad.menu.partidos.impl;

import com.tpi.ligachad.dominio.Partido;
import com.tpi.ligachad.utils.LectorConsola;
import com.tpi.ligachad.servicios.gestion.impl.GestionPartidosServiceImpl;
import com.tpi.ligachad.menu.partidos.MenuPartidos;
import com.tpi.ligachad.menu.partidos.RegistroPartidoStrategy;
import java.util.Optional;

public class RegistroManualImpl implements RegistroPartidoStrategy {
    private final GestionPartidosServiceImpl gestionPartidos = new GestionPartidosServiceImpl();
    private final MenuPartidos menuPartidos;

    public RegistroManualImpl(MenuPartidos menuPartidos) {
        this.menuPartidos = menuPartidos;
    }

    @Override
    public void registrar(Partido partido) {
        try {
            menuPartidos.getClass().getMethod("mostrarJugadoresDisponibles", partido.getClass()).invoke(menuPartidos, partido);
        } catch (Exception e) {}
        while (true) {
            String nombre = LectorConsola.leerTexto("Jugador que anotó gol (ENTER para terminar): ");
            if (nombre.isBlank()) break;

            Optional<com.tpi.ligachad.dominio.Jugador> jugador = partido.getEquipoLocal().buscarJugadorPorNombre(nombre);
            if (jugador.isEmpty()) {
                jugador = partido.getEquipoVisitante().buscarJugadorPorNombre(nombre);
            }

            jugador.ifPresentOrElse(
                    j -> gestionPartidos.registrarGol(partido, j),
                    () -> System.out.println("❌ Jugador no encontrado.")
            );
        }
        try {
            menuPartidos.getClass().getMethod("asignarMinutosEIngresos", com.tpi.ligachad.dominio.Equipo.class, int.class)
                .invoke(menuPartidos, partido.getEquipoLocal(), 40);
            menuPartidos.getClass().getMethod("asignarMinutosEIngresos", com.tpi.ligachad.dominio.Equipo.class, int.class)
                .invoke(menuPartidos, partido.getEquipoVisitante(), 40);
        } catch (Exception e) {}
        try {
            menuPartidos.getClass().getMethod("mostrarResultadoYGanador", partido.getClass())
                .invoke(menuPartidos, partido);
        } catch (Exception e) {}
    }
}
