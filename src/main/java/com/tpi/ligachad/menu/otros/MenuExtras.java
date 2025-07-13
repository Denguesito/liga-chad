package com.tpi.ligachad.menu.otros;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.gestion.GestionJugadoresService;
import com.tpi.ligachad.servicios.gestion.impl.GestionJugadoresServiceImpl;
import com.tpi.ligachad.servicios.utilidades.ExportadorCSVService;
import com.tpi.ligachad.servicios.utilidades.impl.ExportadorCSVServiceImpl;
import com.tpi.ligachad.utils.LectorConsola;

import java.util.Comparator;
import java.util.Optional;

public class MenuExtras {
    private final Liga liga;
    private final GestionJugadoresService gestionJugadores = new GestionJugadoresServiceImpl();
    private final ExportadorCSVService exportadorCSV = new ExportadorCSVServiceImpl();

    public MenuExtras(Liga liga) {
        this.liga = liga;
    }

    public void transferirJugador() {
        String origenNombre = LectorConsola.leerTexto("Equipo origen: ");
        String destinoNombre = LectorConsola.leerTexto("Equipo destino: ");

        Optional<Equipo> origen = liga.buscarEquipoPorNombre(origenNombre);
        Optional<Equipo> destino = liga.buscarEquipoPorNombre(destinoNombre);

        if (origen.isEmpty() || destino.isEmpty()) {
            System.out.println("Uno o ambos equipos no existen.");
            return;
        }

        String nombreJugador = LectorConsola.leerTexto("Nombre del jugador a transferir: ");
        gestionJugadores.transferirJugador(origen.get(), destino.get(), nombreJugador);
    }

    public void exportarCSV() {
        String nombre = LectorConsola.leerTexto("Nombre del equipo a exportar: ");
        Optional<Equipo> equipo = liga.buscarEquipoPorNombre(nombre);
        equipo.ifPresentOrElse(
                exportadorCSV::exportarJugadoresDeEquipo,
                () -> System.out.println("Equipo no encontrado.")
        );
    }

    public void listarJugadoresPorEquipo() {
        for (Equipo equipo : liga.getEquipos()) {
            System.out.println("Equipo: " + equipo.getNombre());
            for (Jugador j : equipo.getJugadores()) {
                String tipo = j.esTitular() ? "Titular" : "Suplente";
                System.out.println(" - " + j.getNombre() + " (" + tipo + ")");
            }
        }
    }

    public void rankingEquiposPorGoles() {
        System.out.println("Ranking de Equipos por Goles:");
        liga.getEquipos().stream()
                .sorted(Comparator.comparingInt(this::totalGoles).reversed())
                .forEach(e -> System.out.println(
                        e.getNombre() + " - " + totalGoles(e) + " goles"
                ));
    }

    private int totalGoles(Equipo equipo) {
        return equipo.getJugadores().stream()
                .mapToInt(Jugador::getCantidadGoles)
                .sum();
    }
}