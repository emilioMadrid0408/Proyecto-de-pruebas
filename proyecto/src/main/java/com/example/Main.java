package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Generador de numeros aleatorios:");
        System.out.println("    1) Cuadrado medio");
        System.out.println("    2) Producto medio");
        System.out.println("    3) Lineal");
        System.out.println("    4111) Multiplicativo");

        System.out.println("Pruebas de bondad de ajuste:");
        System.out.println("    5) Ji Cuadrada");
        System.out.println("    6) Kolmogorov");

        System.out.println("Pruebas de aleatoriedad:");
        System.out.println("    7) Series");
        System.out.println("    8) Distancias");

        System.out.println("Que desea realizar?");

        Scanner leer = new Scanner(System.in);

        int opcion = leer.nextInt();
        String archivo = "";
        switch (opcion) {
            case 1:
                GeneradorCuadradoMedio.inicio();
                break;
            case 2:
                GeneradorProductoMedio.inicio();
                break;
            case 3:
                GeneradorLineal.inicio();
                break;
            case 4:
                GeneradorMultiplicativo.inicio();
                break;
            case 5:
                PruebaJiCuadrada.inicio(cargarArchivo());
                break;
            case 8:
                PruebaDistancias.inicio(cargarArchivo());
                break;

            case 9:

            default:
                break;
        }

    }

    public static ArrayList cargarArchivo() {
        System.out.println("Que archivo desea leer?");

        Scanner leer = new Scanner(System.in);
        int opcion = leer.nextInt();
        String archivo = "";

        switch (opcion) {
            case 1:
                archivo = "proyecto/src/main/resources/datos.csv";
                break;
            case 2:
                archivo = "proyecto/src/main/resources/Pruebas2.csv";
                break;
            case 3:
                archivo = "proyecto/src/main/resources/pruebas3.csv";
                break;
            default:
                break;
        }

        String linea;
        String delimitador = ",";
        ArrayList<Double> listaValores = new ArrayList<>();

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(archivo));
            while ((linea = br.readLine()) != null) {
                String[] tokens = linea.split(delimitador);
                for (String token : tokens) {
                    token = token.trim();
                    if (!token.isEmpty()) {
                        try {
                            double valor = Double.parseDouble(token);
                            listaValores.add(valor);
                        } catch (NumberFormatException e) {
                            // Ignorar valores no numéricos ya que pues hay uno ahi que no es numerico
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return listaValores;
    }

}