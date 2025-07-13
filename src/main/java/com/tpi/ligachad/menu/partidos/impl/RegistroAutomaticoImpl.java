package com.tpi.ligachad.menu.partidos.impl;

import com.tpi.ligachad.dominio.Partido;
import com.tpi.ligachad.dominio.Jugador;
import com.tpi.ligachad.servicios.gestion.impl.GestionPartidosServiceImpl;
import com.tpi.ligachad.menu.partidos.MenuPartidos;
import com.tpi.ligachad.menu.partidos.RegistroPartidoStrategy;
import java.util.*;

public class RegistroAutomaticoImpl implements RegistroPartidoStrategy {
    private final GestionPartidosServiceImpl gestionPartidos = new GestionPartidosServiceImpl();
    private final MenuPartidos menuPartidos;

    public RegistroAutomaticoImpl(MenuPartidos menuPartidos) {
        this.menuPartidos = menuPartidos;
    }

    @Override
    public void registrar(Partido partido) {
        Random rand = new Random();
        int totalGoles = rand.nextInt(6);
        List<Jugador> posibles = new ArrayList<>();
        posibles.addAll(partido.getEquipoLocal().getJugadores());
        posibles.addAll(partido.getEquipoVisitante().getJugadores());
        Collections.shuffle(posibles, rand);
        for (int i = 0; i < totalGoles; i++) {
            Jugador goleador = posibles.get(i % posibles.size());
            gestionPartidos.registrarGol(partido, goleador);
        }
        try {
            menuPartidos.getClass().getMethod("asignarMinutosEIngresos", com.tpi.ligachad.dominio.Equipo.class, int.class)
                .invoke(menuPartidos, partido.getEquipoLocal(), 40);
            menuPartidos.getClass().getMethod("asignarMinutosEIngresos", com.tpi.ligachad.dominio.Equipo.class, int.class)
                .invoke(menuPartidos, partido.getEquipoVisitante(), 40);
        } catch (Exception e) {}
        System.out.println("✅ Partido simulado con " + totalGoles + " goles asignados aleatoriamente.");
        try {
            menuPartidos.getClass().getMethod("mostrarResultadoYGanador", partido.getClass())
                .invoke(menuPartidos, partido);
        } catch (Exception e) {}
    }
}
