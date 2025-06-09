package com.tpi.ligachad.menu.partidos;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.gestion.GestionPartidosService;
import com.tpi.ligachad.utils.LectorConsola;

import java.util.*;

public class MenuPartidos {
    private final Liga liga;
    private final GestionPartidosService gestionPartidos = new GestionPartidosService();

    public MenuPartidos(Liga liga) {
        this.liga = liga;
    }

    public void registrarPartido() {
        String local = LectorConsola.leerTexto("Nombre del equipo local: ");
        String visitante = LectorConsola.leerTexto("Nombre del equipo visitante: ");

        Optional<Equipo> equipoLocal = liga.buscarEquipoPorNombre(local);
        Optional<Equipo> equipoVisitante = liga.buscarEquipoPorNombre(visitante);

        if (equipoLocal.isEmpty() || equipoVisitante.isEmpty()) {
            System.out.println("❌ Uno o ambos equipos no existen.");
            return;
        }

        System.out.println("1. Registrar goles manualmente");
        System.out.println("2. Simular partido automáticamente");
        int opcion = LectorConsola.leerEntero("Elegí el modo de registro: ");

        Partido partido = new Partido(equipoLocal.get(), equipoVisitante.get());

        if (opcion == 1) {
            registrarManual(partido);
        } else {
            registrarAutomatico(partido);
        }

        gestionPartidos.finalizarPartido(partido);
        gestionPartidos.registrarPartidoEnLiga(liga, partido);
    }

    private void registrarManual(Partido partido) {
        while (true) {
            String nombre = LectorConsola.leerTexto("Jugador que anotó gol (ENTER para terminar): ");
            if (nombre.isBlank()) break;

            Optional<Jugador> jugador = partido.getEquipoLocal().buscarJugadorPorNombre(nombre);
            if (jugador.isEmpty()) {
                jugador = partido.getEquipoVisitante().buscarJugadorPorNombre(nombre);
            }

            jugador.ifPresentOrElse(
                    j -> gestionPartidos.registrarGol(partido, j),
                    () -> System.out.println("❌ Jugador no encontrado.")
            );
        }
    }

    private void registrarAutomatico(Partido partido) {
        Random rand = new Random();
        int totalGoles = rand.nextInt(6); // 0 a 5 goles totales
        List<Jugador> posibles = new ArrayList<>();
        posibles.addAll(partido.getEquipoLocal().getJugadores());
        posibles.addAll(partido.getEquipoVisitante().getJugadores());

        for (int i = 0; i < totalGoles; i++) {
            Jugador goleador = posibles.get(rand.nextInt(posibles.size()));
            gestionPartidos.registrarGol(partido, goleador);
        }

        System.out.println("✅ Partido simulado con " + totalGoles + " goles asignados aleatoriamente.");
    }
}