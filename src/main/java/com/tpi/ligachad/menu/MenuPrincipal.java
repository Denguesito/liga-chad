package com.tpi.ligachad.menu;

import com.tpi.ligachad.dominio.Liga;
import com.tpi.ligachad.menu.equipos.MenuEquipos;
import com.tpi.ligachad.menu.partidos.MenuPartidos;
import com.tpi.ligachad.menu.reportes.MenuReportes;
import com.tpi.ligachad.menu.otros.MenuExtras;
import com.tpi.ligachad.utils.LectorConsola;

public class MenuPrincipal {

    private final MenuEquipos menuEquipos;
    private final MenuPartidos menuPartidos;
    private final MenuReportes menuReportes;
    private final MenuExtras menuExtras;

    public MenuPrincipal(Liga liga) {
        this.menuEquipos = new MenuEquipos(liga);
        this.menuPartidos = new MenuPartidos(liga);
        this.menuReportes = new MenuReportes(liga);
        this.menuExtras = new MenuExtras(liga);
    }

    public void mostrar() {
        boolean salir = false;

        while (!salir) {
            System.out.println("\nMENU PRINCIPAL - LIGA CHAD");
            System.out.println("1. Crear equipo");
            System.out.println("2. Agregar jugadores a un equipo");
            System.out.println("3. Listar todos los jugadores y su tipo");
            System.out.println("4. Registrar partido");
            System.out.println("5. Reporte general de la liga");
            System.out.println("6. Reporte por equipo");
            System.out.println("7. Mostrar ranking de equipos por goles");
            System.out.println("8. Transferir jugador");
            System.out.println("9. Exportar jugadores a CSV");
            System.out.println("0. Salir");

            int opcion = LectorConsola.leerEntero("Elegí una opción: ");

            switch (opcion) {
                case 1 -> menuEquipos.crearEquipo();
                case 2 -> menuEquipos.agregarJugadores();
                case 3 -> menuExtras.listarJugadoresPorEquipo();
                case 4 -> menuPartidos.registrarPartido();
                case 5 -> menuReportes.reporteGeneralLiga();
                case 6 -> menuReportes.reportePorEquipo();
                case 7 -> menuExtras.rankingEquiposPorGoles();
                case 8 -> menuExtras.transferirJugador();
                case 9 -> menuExtras.exportarCSV();
                case 0 -> {
                    System.out.println("Gracias por usar la Liga Chad!");
                    salir = true;
                }
                default -> System.out.println("Opción inválida.");
            }

            if (!salir) LectorConsola.esperarEnter();
        }
    }
}
