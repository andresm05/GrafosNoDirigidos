package com.co.udea.grafos;

/**
 *
 * @author HOME
 */
public class MatrizAdyacencia extends Matriz {

    public static final String TIPO = "Ady";

    /*Agrega las leyendas a la matriz*/
    public MatrizAdyacencia(int n) {
        super(n, n);
        m[0][0] = TIPO;
        for (int j = 1; j < n; j++) {
            m[0][j] = "V" + j;
        }
        for (int i = 1; i < n; i++) {
            m[i][0] = "V" + i;
        }
    }
    
        public String esCompleto(int lados){
        int n = filas-1;
        int aristas = (n*(n-1))/2;
        if(aristas==lados-1){
            return "El grafo es completo";
        }
        return "El grafo no es completo";
    }


}
