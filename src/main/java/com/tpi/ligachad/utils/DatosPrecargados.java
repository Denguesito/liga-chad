package com.tpi.ligachad.utils;

import com.tpi.ligachad.dominio.*;

public class DatosPrecargados {
    public static void cargarEquiposYJugadores(Liga liga) {
        Equipo union = new Equipo("Union");
        union.agregarJugador(new Titular("Juan Pérez", 25, true));
        union.agregarJugador(new Titular("Pedro Gómez", 28, false));
        union.agregarJugador(new Titular("Lucas Fernández", 22, true));
        union.agregarJugador(new Titular("Matías López", 30, true));
        union.agregarJugador(new Titular("Santiago Ruiz", 27, false));
        union.agregarJugador(new Suplente("Diego Castro", 21, true));
        union.agregarJugador(new Suplente("Emiliano Torres", 23, false));
        union.agregarJugador(new Suplente("Gonzalo Díaz", 24, true));
        liga.agregarEquipo(union);

        Equipo forEver = new Equipo("For Ever");
        forEver.agregarJugador(new Titular("Nicolás Sosa", 26, true));
        forEver.agregarJugador(new Titular("Ezequiel Romero", 29, false));
        forEver.agregarJugador(new Titular("Martín Benítez", 24, true));
        forEver.agregarJugador(new Titular("Franco Acosta", 31, true));
        forEver.agregarJugador(new Titular("Agustín Silva", 28, false));
        forEver.agregarJugador(new Suplente("Ramiro Vera", 22, true));
        forEver.agregarJugador(new Suplente("Tomás Aguirre", 20, false));
        forEver.agregarJugador(new Suplente("Facundo Ríos", 23, true));
        liga.agregarEquipo(forEver);

        Equipo sarmiento = new Equipo("Sarmiento");
        sarmiento.agregarJugador(new Titular("Bruno Méndez", 27, true));
        sarmiento.agregarJugador(new Titular("Leandro Ortiz", 25, false));
        sarmiento.agregarJugador(new Titular("Iván Cabrera", 23, true));
        sarmiento.agregarJugador(new Titular("Joaquín Molina", 29, true));
        sarmiento.agregarJugador(new Titular("Emiliano Godoy", 26, false));
        sarmiento.agregarJugador(new Suplente("Franco López", 22, true));
        sarmiento.agregarJugador(new Suplente("Matías Ríos", 24, false));
        sarmiento.agregarJugador(new Suplente("Santiago Castro", 21, true));
        liga.agregarEquipo(sarmiento);

        Equipo sacachispas = new Equipo("Sacachispas");
        sacachispas.agregarJugador(new Titular("Martín Torres", 28, true));
        sacachispas.agregarJugador(new Titular("Agustín Ramírez", 27, false));
        sacachispas.agregarJugador(new Titular("Pedro Sosa", 24, true));
        sacachispas.agregarJugador(new Titular("Lucas Benítez", 26, true));
        sacachispas.agregarJugador(new Titular("Juan Fernández", 25, false));
        sacachispas.agregarJugador(new Suplente("Diego Gómez", 23, true));
        sacachispas.agregarJugador(new Suplente("Nicolás Acosta", 22, false));
        sacachispas.agregarJugador(new Suplente("Ezequiel López", 21, true));
        liga.agregarEquipo(sacachispas);
    }
}
