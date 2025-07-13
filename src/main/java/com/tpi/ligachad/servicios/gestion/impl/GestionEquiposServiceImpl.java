package com.tpi.ligachad.servicios.gestion.impl;

import com.tpi.ligachad.dominio.*;
import com.tpi.ligachad.servicios.gestion.GestionEquiposService;
import java.util.Optional;

public class GestionEquiposServiceImpl implements GestionEquiposService {
    public void crearEquipo(Liga liga, String nombre) {
        Optional<Equipo> existente = liga.buscarEquipoPorNombre(nombre);
        if (existente.isPresent()) {
            System.out.println("El equipo ya existe.");
            return;
        }
        Equipo nuevo = new Equipo(nombre);
        liga.agregarEquipo(nuevo);
        System.out.println("Equipo creado: " + nombre);
    }

    public void agregarJugadorAEquipo(Equipo equipo, Jugador jugador) {
        equipo.agregarJugador(jugador);
    }
}
