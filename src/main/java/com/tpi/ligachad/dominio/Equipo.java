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

    public void agregarJugador(Jugador jugador) {
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
