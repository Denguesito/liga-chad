package com.tpi.ligachad;

import com.tpi.ligachad.dominio.Liga;
import com.tpi.ligachad.menu.MenuPrincipal;
import com.tpi.ligachad.repository.LigaRepository;

public class App {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   Bienvenido a la LIGA CHAD");
        System.out.println("====================================\n");

        LigaRepository repo = new LigaRepository();
        Liga liga = new Liga();
        repo.getEquipos().forEach(liga::agregarEquipo);
        MenuPrincipal menu = new MenuPrincipal(liga);
        menu.mostrar();

        System.out.println("\nGracias por utilizar la Liga Chad. Hasta la próxima.");
    }
}
