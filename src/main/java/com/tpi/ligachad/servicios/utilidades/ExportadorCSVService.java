package com.tpi.ligachad.servicios.utilidades;

import com.tpi.ligachad.dominio.Equipo;
import com.tpi.ligachad.dominio.Jugador;
import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExportadorCSVService {

    private static final String[] CABECERA = {
        "Es titular (SI/NO)", "Nombre", "Edad", "Cantidad de goles"
    };

    public void exportarJugadoresDeEquipo(Equipo equipo) {
        String nombreArchivo = equipo.getNombre().replaceAll(" ", "_") + ".csv";
        String rutaDirectorio = "src/main/java/com/tpi/ligachad/csv";
        File carpeta = new File(rutaDirectorio);

        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        String rutaCompleta = rutaDirectorio + File.separator + nombreArchivo;

        try (CSVWriter writer = new CSVWriter(new FileWriter(rutaCompleta))) {
            writer.writeNext(CABECERA);

            List<Jugador> jugadores = equipo.getJugadores();
            for (Jugador j : jugadores) {
                String esTitular = j.esTitular() ? "SI" : "NO";
                String[] fila = {
                    esTitular,
                    j.getNombre(),
                    String.valueOf(j.getEdad()),
                    String.valueOf(j.getCantidadGoles())
                };
                writer.writeNext(fila);
            }

            System.out.println("✅ Archivo CSV exportado correctamente en: " + rutaCompleta);
        } catch (IOException e) {
            System.out.println("❌ Error al exportar el archivo CSV: " + e.getMessage());
        }
    }
}
