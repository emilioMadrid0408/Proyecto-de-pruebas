package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GeneradorMultiplicativo {
    static int n = -1;
    static int longitudDelPeriodo = 0;

    public GeneradorMultiplicativo() {

    }

    public static void inicio() {
        n = -1;
        longitudDelPeriodo = 0;
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese una semilla:");
        int semilla = leer.nextInt();
        System.out.println("Ingrese un modulo:");
        int modulo = leer.nextInt();
        System.out.println("n           X(n)           a*X(n)           a*X(n) mod m           ");
        calcula(semilla, semilla, modulo);
        System.out.println("La longitud del periodo es de: " + longitudDelPeriodo);

    }

    public static void calcula(int a, int semilla, int modulo) {
        n++;
        longitudDelPeriodo++;
        int aXn = semilla * a;
        int aXnmodm = aXn % modulo;

        System.out.printf("%1d%15d%15d%15d%n", n, semilla, aXn, aXnmodm);
        semilla = aXnmodm;
        //condicion de degeneracion
        if (semilla == a) {
            return;
        }
        calcula(a, semilla, modulo);
    }
}
