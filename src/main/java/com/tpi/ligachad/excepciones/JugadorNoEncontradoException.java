package com.tpi.ligachad.excepciones;

public class JugadorNoEncontradoException extends RuntimeException {
    public JugadorNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}
