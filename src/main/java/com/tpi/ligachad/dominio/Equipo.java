package com.tpi.ligachad.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Equipo {
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo(String nombre) {
        this.nombre = nombre;
        this.jugadores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public boolean puedeAgregarJugador(Jugador jugador) {
        int total = jugadores.size();
        if (total >= 10) return false;
        long titulares = jugadores.stream().filter(Jugador::esTitular).count();
        long suplentes = jugadores.stream().filter(j -> !j.esTitular()).count();
        long transferibles = jugadores.stream().filter(Jugador::isTransferible).count();
        if (jugador.esTitular() && titulares >= 5) return false;
        if (!jugador.esTitular() && suplentes >= 3) return false;
        if (jugador.isTransferible() && transferibles >= 2) return false;
        return true;
    }

    public void agregarJugador(Jugador jugador) {
        if (!puedeAgregarJugador(jugador)) {
            System.out.println("❌ No se puede agregar el jugador. Límite alcanzado (5 titulares, 3 suplentes, 2 transferibles, 10 en total).");
            return;
        }
        jugadores.add(jugador);
    }

    public void quitarJugador(Jugador jugador) {
        jugadores.remove(jugador);
    }

    public Optional<Jugador> buscarJugadorPorNombre(String nombre) {
        return jugadores.stream()
            .filter(j -> j.getNombre().equalsIgnoreCase(nombre))
            .findFirst();
    }

    public List<Jugador> getTitulares() {
        return jugadores.stream().filter(Jugador::esTitular).toList();
    }

    public List<Jugador> getSuplentes() {
        return jugadores.stream().filter(j -> !j.esTitular()).toList();
    }

    @Override
    public String toString() {
        return "Equipo: " + nombre + " (Jugadores: " + jugadores.size() + ")";
    }
}
