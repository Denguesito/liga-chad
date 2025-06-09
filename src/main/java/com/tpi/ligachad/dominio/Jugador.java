package com.tpi.ligachad.dominio;

public abstract class Jugador {
    protected String nombre;
    protected int edad;
    protected int cantidadGoles;
    protected int partidosJugados;
    protected boolean transferible;

    public Jugador(String nombre, int edad, boolean transferible) {
        this.nombre = nombre;
        this.edad = edad;
        this.transferible = transferible;
        this.cantidadGoles = 0;
        this.partidosJugados = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getCantidadGoles() {
        return cantidadGoles;
    }

    public boolean isTransferible() {
        return transferible;
    }

    public void setTransferible(boolean transferible) {
        this.transferible = transferible;
    }

    public void incrementarGoles(int cantidad) {
        this.cantidadGoles += cantidad;
    }

    public void jugarPartido() {
        this.partidosJugados++;
    }

    public abstract double calcularEficiencia();

    public abstract boolean esTitular();

    @Override
    public String toString() {
        return nombre + " - Edad: " + edad + ", Goles: " + cantidadGoles + ", Transferible: " + (transferible ? "Sí" : "No");
    }
}