package com.co.udea.grafos;

/**
 *
 * @author HOME
 */
public class matrizIncidencia extends Matriz {

    public static final String TIPO = "Inc";
    public static final String CAR = "dfghjklmnpqrtwxyzabcsuvieo";

    /*Agrega las leyendas a la matriz*/
    public matrizIncidencia(int filas, int columnas) {
        super(filas, columnas);
        m[0][0] = TIPO;
        for (int j = 1; j < columnas; j++) {
            m[0][j] = CAR.substring(j - 1, j);
        }
        for (int i = 1; i < filas; i++) {
            m[i][0] = "V" + i;
        }
    }

    void completarUsandoAdy(Matriz matrizAdy) {
        /*k r´presenta las columnas en la matriz de inc. cada vez que se encuentre un 1
        su valor incrementará una unidad (siguiente columna)*/
        int k = 1;
        Object valor;
        /*Cada vez que se encuentre un 1 en la matriz de ady, toma la fila y la columna
        ej: mady[1][2]=1, significa que V1 y V2 están unidos por un lado*/
        for (int i = 1; i < matrizAdy.filas; i++) {
            for (int j = 1; j <= i; j++) {
                valor = matrizAdy.m[i][j];
                if (valor.equals(1)) {
                    this.m[i][k] = valor;
                    this.m[j][k] = valor;
                    /*Continuar en la siguiente columna*/
                    k++;
                }
            }
        }
        //Llenar el resto de los campos de la matriz de inc con 0
        for (int i = 1; i < this.filas; i++) {
            for (int j = 1; j < this.columnas; j++) {
                if (this.m[i][j]==null) {
                    this.m[i][j] = 0;
                }
            }
        }
    }
    
    public String esCompleto(){
        int n = filas-1;
        int aristas = (n*(n-1))/2;
        if(aristas==columnas-1){
            return "El grafo es completo";
        }
        return "El grafo no es completo";
    }

}
