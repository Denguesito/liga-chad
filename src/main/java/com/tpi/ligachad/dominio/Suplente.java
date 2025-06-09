package com.tpi.ligachad.dominio;

public class Suplente extends Jugador {
    private int partidosDesdeBanco;
    private boolean haIngresado;

    public Suplente(String nombre, int edad, boolean transferible) {
        super(nombre, edad, transferible);
        this.partidosDesdeBanco = 0;
        this.haIngresado = false;
    }

    public void marcarIngreso() {
        haIngresado = true;
        partidosDesdeBanco++;
    }

    public int getPartidosDesdeBanco() {
        return partidosDesdeBanco;
    }

    public boolean haIngresado() {
        return haIngresado;
    }

    @Override
    public boolean esTitular() {
        return false;
    }

    @Override
    public double calcularEficiencia() {
        return partidosJugados == 0 ? 0 : (double) cantidadGoles / partidosJugados;
    }

    @Override
    public String toString() {
        return super.toString() + " (Suplente, Ingresos: " + partidosDesdeBanco + ")";
    }
}