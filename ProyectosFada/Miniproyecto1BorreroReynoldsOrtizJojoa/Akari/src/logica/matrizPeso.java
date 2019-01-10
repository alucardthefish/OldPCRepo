/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author root
 */
public class matrizPeso {
    private int matriz[][];
    private int entrada[][];
//    private int pesos[];

    public matrizPeso(int[][] entrada){
        this.entrada=entrada;
//        this.pesos=pesos;

    }

    public int[][] calcularMatriz(){
        final int fila=entrada.length;
        Matriz m= new Matriz(fila,fila);
        matriz=m.getMatriz();
        
        for(int i=0;i<fila-1;i++){
            for(int j=0;j<entrada[i].length;j++){
               if(entrada[i][j]==1){
                    for(int ix=i+1;ix<fila;ix++){
                        if(entrada[ix][j]==1){
//                            matriz[i][ix]=pesos[j];
//                            matriz[ix][i]=pesos[j];
                        }
                    }
               }
            }
        }
        
        return matriz;
    }
}
