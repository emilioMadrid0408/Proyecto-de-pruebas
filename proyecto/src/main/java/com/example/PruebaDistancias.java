package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PruebaDistancias {
    static int n = 0;
    static int pertenece;
    static int i = 0;
    static List<Integer> listaDeHuecos = new ArrayList<>();
    static List<Integer> listaDeCantidadHuecos = new ArrayList<>();
    static int cantidadDeHuecos = 0;

    public PruebaDistancias() {

    }

    public static void inicio(ArrayList<Double> listaDeValores) {
        n = 0;
        pertenece = 0;
        i = 0;
        Scanner leer = new Scanner(System.in);

        System.out.println("Ingrese alpha:");
        double alpha = leer.nextDouble();

        System.out.println("Ingrese theta:");
        double theta = leer.nextDouble();

        System.out.println("n" + "      " + "Ui" + "     " + "pertenece" + "      " + "i");
        calcular(listaDeValores, alpha, theta);
        listaDeHuecos.forEach(System.out::println);
    }

    public static void calcular(ArrayList<Double> listaDeValores, double alpha, double theta) {
        i = 0; // contador del hueco
        pertenece = 0; // indicador de pertenencia

        // recorrer por toda la lista de valores
        for (int n = 0; n < listaDeValores.size(); n++) {
            // asignar a la variable pertenece, el resultado del metodo pertenece
            pertenece = pertenece(n, listaDeValores, alpha, theta);

            // si pertenece = 1, entonces i valdra 0
            if (pertenece == 1) {
                if (!listaDeHuecos.contains(i)) {
                    listaDeHuecos.add(i);
                }

                i = 0;
                System.out.println((n + 1) + "      " + listaDeValores.get(n) + "     " + pertenece + "      " + i);
            } else {
                i++;
                System.out.println((n + 1) + "      " + listaDeValores.get(n) + "      " + pertenece + "      " + i);
            }

        }
        if (!listaDeHuecos.contains(i)) {
            listaDeHuecos.add(i);
        }

    }

    public static int pertenece(int indice, ArrayList<Double> listaDeValores, double limiteInferior,
            double limiteSuperior) {
        double valor = listaDeValores.get(indice);
        if (valor > limiteInferior && valor < limiteSuperior) {
            return 1;
        } else {
            return 0;
        }
    }

}
