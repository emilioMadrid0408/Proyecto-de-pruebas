package com.example;

import java.util.*;
import java.nio.channels.Pipe.SourceChannel;

public class GeneradorProductoMedio {

    static int n = -1;
    static List<Integer> listaDeSemillas = new ArrayList<>();

    public GeneradorProductoMedio() {

    }

    public static void inicio() {

        System.out.println("Ingrese una semilla 1:");
        Scanner leer = new Scanner(System.in);
        int semilla = leer.nextInt();

        System.out.println("Ingrese una semilla 2:");
        int semilla2 = leer.nextInt();

        int cifras = 0;
        int semillaAux = semilla;

        while (semillaAux != 0) {

            semillaAux = semillaAux / 10;
            cifras++;

        }

        System.out.println("n" + "      " + "R(n)" + "R(n + 1)      " + "          " + "R(n)2" +
                "   " + "M.R(n)2" + "    Val 1" + "    Val 2");

        calcular(semilla, semilla2, cifras);
    }

    public static void calcular(int semilla1, int semilla2, int cifras) {
        n++;
        int producto = semilla1 * semilla2;
        String prodStr = String.valueOf(producto);

        // sacar el número sin extremos
        String semillaSinExtremos;
        if (prodStr.length() > cifras - 1) {
            semillaSinExtremos = prodStr.substring(1, prodStr.length() - 1);
        } else {
            // si no tiene suficientes dígitos para quitar extremos, degenera
            semillaSinExtremos = "";
        }

        // quitar ceros a la izquierda
        if (!semillaSinExtremos.isEmpty()) {
            semillaSinExtremos = semillaSinExtremos.replaceFirst("^0+", "");
            if (semillaSinExtremos.isEmpty())
                semillaSinExtremos = "0";
        }

        int valor1 = 0, valor2 = 0;

        if (!semillaSinExtremos.isEmpty()) {
            if (semillaSinExtremos.length() < cifras) {
                // caso especial: menos dígitos que la semilla original
                valor1 = Integer.parseInt(semillaSinExtremos);
                valor2 = 0;
            } else {
                // caso normal
                valor1 = Integer.parseInt(semillaSinExtremos.substring(0, cifras));

                if (semillaSinExtremos.length() >= cifras + 1) {
                    valor2 = Integer.parseInt(semillaSinExtremos.substring(1, cifras + 1));
                }
            }
        }


        System.out.println(n + "  " + semilla1 + "  " + semilla2 + "  " + producto
                + "  " + (semillaSinExtremos.isEmpty() ? "0" : semillaSinExtremos)
                + "  " + valor1 + "  " + valor2);

        // condiciones de degeneración:
        if (semillaSinExtremos.isEmpty())
            return;

        // recursión
        calcular(semilla2, valor1, cifras);
    }

}
