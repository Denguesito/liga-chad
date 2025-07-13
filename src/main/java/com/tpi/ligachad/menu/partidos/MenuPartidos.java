package com.tpi.ligachad.menu.partidos;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.gestion.GestionPartidosService;
import com.tpi.ligachad.servicios.gestion.impl.GestionPartidosServiceImpl;
import com.tpi.ligachad.utils.LectorConsola;

import com.tpi.ligachad.menu.partidos.impl.RegistroManualImpl;
import com.tpi.ligachad.menu.partidos.impl.RegistroAutomaticoImpl;

import java.util.*;

public class MenuPartidos {
    private final Liga liga;
    private final GestionPartidosService gestionPartidos = new GestionPartidosServiceImpl();

    public MenuPartidos(Liga liga) {
        this.liga = liga;
    }

    public void registrarPartido() {
        String local = LectorConsola.leerTexto("Nombre del equipo local: ");
        String visitante = LectorConsola.leerTexto("Nombre del equipo visitante: ");

        Optional<Equipo> equipoLocal = liga.buscarEquipoPorNombre(local);
        Optional<Equipo> equipoVisitante = liga.buscarEquipoPorNombre(visitante);

        if (equipoLocal.isEmpty() || equipoVisitante.isEmpty()) {
            System.out.println("Uno o ambos equipos no existen.");
            return;
        }

        System.out.println("1. Registrar goles manualmente");
        System.out.println("2. Simular partido automáticamente");
        int opcion = LectorConsola.leerEntero("Elegí el modo de registro: ");

        Partido partido = new Partido(equipoLocal.get(), equipoVisitante.get());

        RegistroPartidoStrategy registroStrategy;
        if (opcion == 1) {
            registroStrategy = new RegistroManualImpl(this);
        } else {
            registroStrategy = new RegistroAutomaticoImpl(this);
        }
        registroStrategy.registrar(partido);

        gestionPartidos.finalizarPartido(partido);
        gestionPartidos.registrarPartidoEnLiga(liga, partido);
    }

    public void mostrarJugadoresDisponibles(Partido partido) {
        System.out.println("Jugadores disponibles para el registro:");
        partido.getEquipoLocal().getJugadores().forEach(j -> System.out.println("- " + j.getNombre() + " (Local)"));
        partido.getEquipoVisitante().getJugadores().forEach(j -> System.out.println("- " + j.getNombre() + " (Visitante)"));
    }

    public void mostrarResultadoYGanador(Partido partido) {
        int golesLocal = partido.getGolesLocal();
        int golesVisitante = partido.getGolesVisitante();
        String nombreLocal = partido.getEquipoLocal().getNombre();
        String nombreVisitante = partido.getEquipoVisitante().getNombre();
        System.out.println("Resultado final: " + nombreLocal + " " + golesLocal + " - " + golesVisitante + " " + nombreVisitante);
        if (golesLocal > golesVisitante) {
            System.out.println("Ganador: " + nombreLocal);
        } else if (golesVisitante > golesLocal) {
            System.out.println("Ganador: " + nombreVisitante);
        } else {
            System.out.println("Empate");
        }
    }

    public void asignarMinutosEIngresos(Equipo equipo, int minutosPorPartido) {
        equipo.getTitulares().forEach(j -> {
            Titular t = (Titular) j;
            t.agregarMinutos(minutosPorPartido);
        });
        List<Jugador> suplentes = equipo.getSuplentes();
        if (!suplentes.isEmpty()) {
            Suplente s = (Suplente) suplentes.get(new Random().nextInt(suplentes.size()));
            s.marcarIngreso();
        }
    }
}