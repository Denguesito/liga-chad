package com.tpi.ligachad.dominio;

public class Titular extends Jugador {
    private int minutosJugados;

    public Titular(String nombre, int edad, boolean transferible) {
        super(nombre, edad, transferible);
        this.minutosJugados = 0;
    }

    public void agregarMinutos(int minutos) {
        this.minutosJugados += minutos;
    }

    public int getMinutosJugados() {
        return minutosJugados;
    }

    @Override
    public boolean esTitular() {
        return true;
    }

    @Override
    public double calcularEficiencia() {
        return minutosJugados == 0 ? 0 : (double) cantidadGoles / minutosJugados;
    }

    @Override
    public String toString() {
        return super.toString() + " (Titular, Minutos: " + minutosJugados + ")";
    }
}