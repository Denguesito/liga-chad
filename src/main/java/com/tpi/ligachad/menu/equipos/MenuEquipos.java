package com.tpi.ligachad.menu.equipos;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.gestion.GestionEquiposService;
import com.tpi.ligachad.utils.LectorConsola;

import java.util.Optional;

public class MenuEquipos {
    private final Liga liga;
    private final GestionEquiposService gestionEquipos = new GestionEquiposService();

    public MenuEquipos(Liga liga) {
        this.liga = liga;
    }

    public void crearEquipo() {
        String nombre = LectorConsola.leerTexto("Nombre del nuevo equipo: ");
        gestionEquipos.crearEquipo(liga, nombre);
    }

    public void agregarJugadores() {
        String nombreEquipo = LectorConsola.leerTexto("Nombre del equipo al que se agregan jugadores: ");
        Optional<Equipo> equipoOpt = liga.buscarEquipoPorNombre(nombreEquipo);
        if (equipoOpt.isEmpty()) {
            System.out.println("⚠️ Equipo no encontrado.");
            return;
        }

        Equipo equipo = equipoOpt.get();
        boolean seguir = true;

        while (seguir) {
            String nombre = LectorConsola.leerTexto("Nombre del jugador: ");
            int edad = LectorConsola.leerEntero("Edad del jugador: ");
            boolean titular = LectorConsola.leerBooleano("¿Es titular?");
            boolean transferible = LectorConsola.leerBooleano("¿Es transferible?");

            Jugador jugador = titular ? new Titular(nombre, edad, transferible) : new Suplente(nombre, edad, transferible);
            gestionEquipos.agregarJugadorAEquipo(equipo, jugador);

            System.out.println("Jugadores actuales en el equipo " + equipo.getNombre() + ":");
            equipo.getJugadores().forEach(j -> {
                String tipo = j.esTitular() ? "Titular" : "Suplente";
                System.out.println("- " + j.getNombre() + " (" + tipo + ")");
            });

            seguir = LectorConsola.leerBooleano("¿Deseás seguir agregando jugadores?");
        }
    }
}
