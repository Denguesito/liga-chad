package com.tpi.ligachad.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Liga {
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public Liga() {
        this.equipos = new ArrayList<>();
        this.partidos = new ArrayList<>();
    }

    public void agregarEquipo(Equipo equipo) {
        if (equipos.size() >= 12) {
            System.out.println("Límite de 12 equipos alcanzado.");
            return;
        }
        equipos.add(equipo);
    }

    public Optional<Equipo> buscarEquipoPorNombre(String nombre) {
        return equipos.stream()
            .filter(e -> e.getNombre().equalsIgnoreCase(nombre))
            .findFirst();
    }

    public void registrarPartido(Partido partido) {
        partidos.add(partido);
    }

    public List<Equipo> getEquipos() {
        return equipos;
    }

    public List<Partido> getPartidos() {
        return partidos;
    }
}

