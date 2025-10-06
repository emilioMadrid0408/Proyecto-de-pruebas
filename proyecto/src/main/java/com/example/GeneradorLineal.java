package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneradorLineal {
    static List<Integer> listaDeSemillas = new ArrayList<>();

    public GeneradorLineal() {

    }

    public static void inicio() {
        listaDeSemillas.clear();
        Scanner leer = new Scanner(System.in);
        int n = -1;
        int semilla;
        int a;
        int c;
        int mod;
        do {
            System.out.println("Ingrese una semilla valida X0 > 0:");
            semilla = leer.nextInt();
        } while (semilla < 0);

        do {
            System.out.println("Ingrese un multiplicador valido a > 0 :");
            a = leer.nextInt();
        } while (a < 0);
        do {
            System.out.println("Ingrese una constante aditiva valida c > 0 :");
            c = leer.nextInt();
        } while (c < 0);

        do {
            System.out.println("Ingrese un modulo valido mod > X0, mod > a y mod > c :");
            mod = leer.nextInt();
        } while (mod < semilla || (mod < a && mod < c));
        System.out.println("n" + "          " + "Xn" + "        " + "aXnc" + "         " + "aXncmod");
        
        calcula(semilla, a, c, mod, n);

    }

    public static void calcula(int semilla, int a, int c, int mod, int n) {
        n++;

        int aXnc = a * semilla + c;
        int aXncmod = aXnc % mod;
        System.out.println(n + "            " + semilla + "         " + aXnc + "            " + aXncmod);

        if (listaDeSemillas.contains(semilla)) {
            return;
        }
        listaDeSemillas.add(semilla);

        calcula(aXncmod, a, c, mod, n);

    }

}
