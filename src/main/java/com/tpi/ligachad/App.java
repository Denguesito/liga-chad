package com.tpi.ligachad;

import com.tpi.ligachad.dominio.Liga;
import com.tpi.ligachad.menu.MenuPrincipal;

public class App {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   ¡Bienvenido a la LIGA CHAD! ⚽🔥");
        System.out.println("====================================\n");

        Liga liga = new Liga();
        com.tpi.ligachad.utils.DatosPrecargados.cargarEquiposYJugadores(liga);
        MenuPrincipal menu = new MenuPrincipal(liga);
        menu.mostrar();

        System.out.println("\nGracias por utilizar la Liga Chad. ¡Hasta la próxima! 👋");
    }
}
