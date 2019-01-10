/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

import java.util.ArrayList;

/**
 *
 * @author jhoreyse
 */
public class Matriz {
    private int[][] matriz;
    private static int filas,columnas;
    private int celdasNegras;

    public Matriz(int filas, int columnas){
        Matriz.filas=filas;
        Matriz.columnas=columnas;
        matriz=new int[filas][columnas];
        inicializarMatriz();
    }

    public Matriz(){
    }
    
    public int[][] Matriz(int filas){
         int[][] salida = new int[filas][filas];

        //inicializar salida
        for(int i=0;i<filas;i++)
            for(int j=0;j<filas;j++)
                salida[i][j]=0;

         return salida;
    }

    private void inicializarMatriz(){
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas;j++){
                if(i==j)
                    matriz[i][j]=0;
                else
                matriz[i][j]=50000;//modifique
            }
        }
    }

    public int[][] getMatriz(){
        return matriz;
    }
    
    public int getFilas(){
        return filas;
    }
    
    public int getColumnas(){
        return columnas;
    }
    
    public int getNumeroCeldasNegras(){
        return celdasNegras;
    }

    public int[][] combinar(ArrayList<int[][]> entrada){
        filas = entrada.get(0).length;
        int columnas = entrada.get(0)[0].length;
        int[][] salida = new int[filas][columnas];

        for(int i=0;i<entrada.size();i++){
            for(int x=0;x<filas;x++){
                for(int y=0;y<columnas;y++){
                    if(salida[x][y]!=1)
                        salida[x][y]=entrada.get(i)[x][y];
                }
            }
        }

        return salida;

    }

    public static int[][] multiplicar(int [][] a, int [][] b){
        if(a[0].length==b.length){
            int[][] salida = new int[a.length][b[0].length];

            //inicializacion de la matriz salida a ceros
            for(int i=0;i<salida.length;i++)
                for(int j=0;j<salida[0].length;j++)
                    salida[i][j]=0;
            
            //algoritmo multiplicar
            for(int i=0;i<a.length;i++){
                for(int j=0;j<a[0].length;j++){
                    for(int u=0;u<b[0].length;u++)
                    salida[i][u]+=a[i][j]*b[j][u];
                }
            }

            return salida;
        }

        else
            return null;

    }

    public static int[][] comparar(int [][]a,int [][]b){
        int[][] salida=new int[a.length][a[0].length];

        for(int i=0;i<a.length;i++)
            for(int j=0;j<a[0].length;j++){
                if(a[i][j]==b[i][j])
                    salida[i][j]=1;
                else
                    salida[i][j]=0;
            }

        return salida;
    }
}
