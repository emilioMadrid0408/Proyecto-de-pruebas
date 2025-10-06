package com.example;

import java.util.*;
import java.nio.channels.Pipe.SourceChannel;

public class GeneradorCuadradoMedio {

    static int n = -1;
    static List<Integer> listaDeSemillas = new ArrayList<>();

    public GeneradorCuadradoMedio() {

    }

    public static void inicio() {

        System.out.println("Ingrese una semilla:");
        Scanner leer = new Scanner(System.in);
        int semilla = leer.nextInt();

        int cifras = 0;
        int semillaAux = semilla;

        while (semillaAux != 0) {

            semillaAux = semillaAux / 10;
            cifras++;

        }

        System.out.println("n" + "      " + "R(n)" + "          " + "R(n)2" +
                "   " + "M.R(n)2" + "    Val 1" + "    Val 2");

        calcular(semilla, cifras);
        n = -1;
    }

    public static void calcular(int semilla, int cifras) {
        n++;

        int semillaCuadrada = semilla * semilla;
        String semillaStr = String.valueOf(semillaCuadrada);

        // obtenemos el número sin extremos
        String semillaSinExtremos = "";
        if (semillaStr.length() > 2) {
            semillaSinExtremos = semillaStr.substring(1, semillaStr.length() - 1);
        } else {
            semillaSinExtremos = semillaStr; // en caso de que sea muy corto
        }

        int valor1 = 0, valor2 = 0;

        if (semillaSinExtremos.length() >= cifras) {
            // tomamos el primer valor (los primeros 'cifras' dígitos)
            valor1 = Integer.parseInt(semillaSinExtremos.substring(0, cifras));

            // si hay suficientes dígitos para un segundo valor
            if (semillaSinExtremos.length() >= cifras + 1) {
                valor2 = Integer.parseInt(semillaSinExtremos.substring(1, cifras + 1));
            }
        }

        System.out.println(n + "      " +
                semilla + "        " +
                semillaCuadrada + "       " +
                semillaSinExtremos + "       " +
                valor1 + "       " +
                valor2);

        // condiciones de degeneración

        // si la semilla se uso anteriormente, degenera
        if (listaDeSemillas.contains(semilla))
            return;

        // si la semilla no se utilizo anteriormente entonces se añade
        listaDeSemillas.add(semilla);

        // si el valor1 actual tiene menos cifras que la primer semilla, degenera
        if (String.valueOf(valor1).length() < cifras)
            return;

        // si no degenero sigue con la recursion
        calcular(valor1, cifras);
    }

}
