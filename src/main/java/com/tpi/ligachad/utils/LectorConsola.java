package com.tpi.ligachad.utils;

import java.util.Scanner;

public class LectorConsola {

    private static final Scanner scanner = new Scanner(System.in);

    public static String leerTexto(String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().trim();
    }

    public static int leerEntero(String mensaje) {
        while (true) {
            try {
                System.out.print(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingresá un número válido.");
            }
        }
    }

    public static boolean leerBooleano(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (SI/NO): ");
            String input = scanner.nextLine().trim().toUpperCase();
            if (input.equals("SI")) return true;
            if (input.equals("NO")) return false;
            System.out.println("Ingreso inválido. Escribí 'SI' o 'NO'.");
        }
    }

    public static void esperarEnter() {
        System.out.println("\nPresione ENTER para continuar...");
        scanner.nextLine();
    }
}
