package com.co.udea.grafos;

/**
 *
 * @author HOME
 */
public class Matriz {

    protected int filas;
    protected int columnas;
    protected Object[][] m;

    public Matriz(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
        m = new Object[filas][columnas];
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public Object[][] getM() {
        return m;
    }

    public void setM(Object[][] m) {
        this.m = m;
    }

    public int[] calcularGrados() {
        int suma = 0;
        int valor;
        int[] grados = new int[filas - 1];
        for (int i = 1; i < filas; i++) {
            for (int j = 1; j < columnas; j++) {
                valor = (int) this.m[i][j];
                suma += valor;
            }
            grados[i - 1] = suma;
            suma = 0;
        }
        return grados;
    }

    public String esRegular() {
        int[] grados = calcularGrados();
        int ref = grados[0];
        for (int i = 1; i < grados.length; i++) {
            if (ref != grados[i]) {
                return "El grafo no es regular";
            }
        }
        return "El grafo es regular";

    }

    public String esEuleriano() {
        int[] grados = calcularGrados();
        for (int i : grados) {
            if (i % 2 != 0) {
                return "El grafo no es Euleriano";
            }
        }
        return "El grafo es Euleriano";

    }
    //Imprimir la matriz en consola
    @Override
    public String toString() {
        String matriz = "";
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz = matriz + m[i][j] + "\t";
            }
            matriz = matriz + "\n";
        }
        return matriz;
    }
}
