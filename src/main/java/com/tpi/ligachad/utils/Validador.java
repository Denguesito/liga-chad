package com.tpi.ligachad.utils;

public class Validador {

    public static boolean esNombreValido(String nombre) {
        return nombre != null && !nombre.trim().isEmpty();
    }

    public static boolean esEdadValida(int edad) {
        return edad > 0 && edad <= 40;
    }

    public static boolean esNumeroValido(int valor) {
        return valor >= 0;
    }
}
