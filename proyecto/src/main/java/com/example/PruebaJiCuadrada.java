package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class PruebaJiCuadrada {
    static int n = -1;
    static double deltaIntervalos = 0;
    static double limiteInferior = 0;
    static double limiteSuperior = 0;
    static int observados = 0;
    static double esperados = 0;
    static double sumatoria = 0;
    static double sumatoriaParcial = 0;
    static double sumatoriaTotal = 0;
    static int cantidadDeObservados = 0;

    public PruebaJiCuadrada() {

    }

    // el metodo recibe la lista de valores
    public static void inicio(ArrayList<Double> listaDeValores) {
        // reiniciar valores para un nuevo calculo
        n = -1;
        deltaIntervalos = 0;
        limiteInferior = 0;
        limiteSuperior = 0;
        observados = 0;
        esperados = 0;
        sumatoriaParcial = 0;
        sumatoriaTotal = 0;

        // pedir intervalos
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingrese el numero de intervalos k");
        double intervalos = leer.nextDouble();

        // calcular esperados
        esperados = listaDeValores.size() / intervalos;

        // iniciar calculo con la lista de valores y los intervalos
        calcular(listaDeValores, intervalos);

        // cuando se acabe de calcular, pedir Xi de comparacion, y dar la conclusion
        System.out.println("La sumatoria es: " + sumatoriaTotal);
        System.out.println("Ingrese valor Xi de comparacion:");
        double xi = leer.nextDouble();

        if (sumatoria < xi) {
            System.out.println(
                    "Conclusion:");
            System.out.println(
                    "NO hay pruebas suficientes para determinar que los datos NO fueron generados aleatoriamente");
        }

    }

    public static void calcular(ArrayList<Double> listaDeValores, double intervalos) {
        n++;

        // lo que le vamos a sumar al limite inferior
        deltaIntervalos = 1 / intervalos;

        limiteInferior = n * deltaIntervalos;
        limiteSuperior = (n + 1) * deltaIntervalos;

        // para cada par de limite inferior y limite superior, reiniciamos los
        // observados
        observados = 0;

        // calcular los observados en los limies actuales
        calcularObservados(listaDeValores, limiteInferior, limiteSuperior);

        // ya que se calculen los observados, obtener la sumatoriaParcial de la
        // iteracion actual
        sumatoriaParcial = ((observados - esperados) * (observados - esperados)) / esperados;

        // esta es la sumatoria total, con la que concluimos
        sumatoriaTotal = sumatoriaTotal + sumatoriaParcial;

        // imprimir con formato el renglon calculado
        System.out.printf("%,15f%,15f%,15d%,15f%,15f%,15f%n", limiteInferior, limiteSuperior, observados, esperados,
                observados - esperados, sumatoriaParcial);

        // el metodo recursivo se detiene si hemos llegado al final de los intervalos
        if (n == intervalos - 1) {
            return;
        }
        // si no hemos lleegado al final de los intervalos, seguimos calculando
        calcular(listaDeValores, intervalos);
    }

    //metodo que recibe la lista de valores y los limites, y busca los observados dentro de los limites
    public static void calcularObservados(ArrayList<Double> listaDeValores, double limiteInferior,
            double limiteSuperior) {

        // iterar por toda la lista, y checar si el valor en la iteracion se encuentra
        // dentro de los limites
        for (int i = 0; i < listaDeValores.size(); i++) {
            if (listaDeValores.get(i) >= limiteInferior && listaDeValores.get(i) < limiteSuperior) {
                // se suma 1 a los observados parciales, y a la cantidad de observados totales
                observados++;
                cantidadDeObservados++;
            }
        }

    }

}
