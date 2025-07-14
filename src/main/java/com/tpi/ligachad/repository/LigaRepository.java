package com.tpi.ligachad.repository;

import com.tpi.ligachad.dominio.*;
import java.util.ArrayList;
import java.util.List;

public class LigaRepository {
    private final List<Equipo> equipos = new ArrayList<>();

    public LigaRepository() {
        precargarEquiposYJugadores();
    }

    private void precargarEquiposYJugadores() {
        Equipo union = new Equipo("Union");
        union.agregarJugador(new Titular("Juan Perez", 25, true));
        union.agregarJugador(new Titular("Pedro Gomez", 28, false));
        union.agregarJugador(new Titular("Lucas Fernandez", 22, true));
        union.agregarJugador(new Titular("Matias Lopez", 30, true));
        union.agregarJugador(new Titular("Santiago Ruiz", 27, false));
        union.agregarJugador(new Suplente("Diego Castro", 21, true));
        union.agregarJugador(new Suplente("Emiliano Torres", 23, false));
        union.agregarJugador(new Suplente("Gonzalo Diaz", 24, true));
        equipos.add(union);

        Equipo forEver = new Equipo("For Ever");
        forEver.agregarJugador(new Titular("Nicolas Sosa", 26, true));
        forEver.agregarJugador(new Titular("Ezequiel Romero", 29, false));
        forEver.agregarJugador(new Titular("Martin Benitez", 24, true));
        forEver.agregarJugador(new Titular("Franco Acosta", 31, true));
        forEver.agregarJugador(new Titular("Agustin Silva", 28, false));
        forEver.agregarJugador(new Suplente("Ramiro Vera", 22, true));
        forEver.agregarJugador(new Suplente("Tomas Aguirre", 20, false));
        forEver.agregarJugador(new Suplente("Facundo Rios", 23, true));
        equipos.add(forEver);

        Equipo sarmiento = new Equipo("Sarmiento");
        sarmiento.agregarJugador(new Titular("Bruno Mendez", 27, true));
        sarmiento.agregarJugador(new Titular("Leandro Ortiz", 25, false));
        sarmiento.agregarJugador(new Titular("Ivan Cabrera", 23, true));
        sarmiento.agregarJugador(new Titular("Joaquin Molina", 29, true));
        sarmiento.agregarJugador(new Titular("Emiliano Godoy", 26, false));
        sarmiento.agregarJugador(new Suplente("Franco Lopez", 22, true));
        sarmiento.agregarJugador(new Suplente("Matias Rios", 24, false));
        sarmiento.agregarJugador(new Suplente("Santiago Castro", 21, true));
        equipos.add(sarmiento);

        Equipo sacachispas = new Equipo("Sacachispas");
        sacachispas.agregarJugador(new Titular("Martin Torres", 28, true));
        sacachispas.agregarJugador(new Titular("Agustin Ramirez", 27, false));
        sacachispas.agregarJugador(new Titular("Pedro Sosa", 24, true));
        sacachispas.agregarJugador(new Titular("Lucas Benitez", 26, true));
        sacachispas.agregarJugador(new Titular("Juan Fernandez", 25, false));
        sacachispas.agregarJugador(new Suplente("Diego Gomez", 23, true));
        sacachispas.agregarJugador(new Suplente("Nicolas Acosta", 22, false));
        sacachispas.agregarJugador(new Suplente("Ezequiel Lopez", 21, true));
        equipos.add(sacachispas);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }
}
