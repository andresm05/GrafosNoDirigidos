package com.co.udea.grafos;

import java.util.Scanner;

/**
 *
 * @author HOME
 */
public class Principal {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String res;
        int valor;
        int vertices;
        int lados = 0;

        try {
            System.out.println("¿Cuántos vértices tiene el grafo?");
            vertices = sc.nextInt();
            sc.nextLine();
            vertices++;
            MatrizAdyacencia matrizAd = new MatrizAdyacencia(vertices);

            for (int j = 1; j < matrizAd.getColumnas(); j++) {
                for (int i = 1; i <= j; i++) {
                    if (j == i) {
                        matrizAd.m[i][j] = 0;
                    } else {
                        System.out.println("¿V" + j + " tiene adyacencia con V" + i + "?" + "\n"
                                + "Responda 1 para SI, 0 para NO");
                        res = sc.nextLine();
                        while (!res.equals("1") && !res.equals("0")) {
                            System.out.println("Ingrese un valor válido");
                            System.out.println("¿V" + j + " tiene adyacencia con V" + i + "?" + "\n"
                                    + "Responda 1 para SI, 0 para NO");
                            res = sc.nextLine();
                        }
                        if (res.equals("1")) {
                            lados++;
                        }
                        valor = Integer.parseInt(res);
                        matrizAd.m[j][i] = valor;
                        matrizAd.m[i][j] = matrizAd.m[j][i];
                    }
                }
            }
            lados++;
            matrizIncidencia matrizInc = new matrizIncidencia(vertices, lados);
            matrizInc.completarUsandoAdy(matrizAd);

            System.out.println(matrizAd);
            System.out.println(matrizInc);
            System.out.println(matrizInc.esRegular());
            System.out.println(matrizInc.esCompleto());
            System.out.println(matrizInc.esEuleriano());

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
