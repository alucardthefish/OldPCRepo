/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;
import logica.Matriz;
import logica.*;
import java.util.*;
/**
 *
 * @author mizesa
 */
public class AlgoritmoGuiado {
    
    private int[][] entrada;
    private int[][] respuesta;
    private int[][] copia;
    private int numCeldasNegras;
    private int filas;
    private int columnas;
    private int [][] celdasNegras;
    private int index=0;
    
    public AlgoritmoGuiado(int[][] entrada, int numCeldasNegras, int filas, int columnas){
        
        this.entrada=entrada;
        this.copia=entrada;
        this.numCeldasNegras=numCeldasNegras;
        this.filas=filas;
        this.columnas=columnas;
        this.celdasNegras=new int [numCeldasNegras][4];
    }
    //metodo q me crea la matriz de celdas negras
    public void crearMatrizCeldas (){
        int x=0;
        for (int i=0; i<=filas; i++){
            for (int j=0; j<=columnas; j++){
                if(entrada[i][j]>2){
                celdasNegras[x][0]=entrada[i][j];
                celdasNegras[x][1]=i;
                celdasNegras[x][2]=j;
                 celdasNegras[x][3]=0;
                x++;
                }
            
            }
        
        }
    
    
    }
    //metodo que me excluye filas y columnas
      public void excluirFilas(int fila, int columna) {
       int temfila=fila+1;
       int temColumna=columna-1;
        while(entrada[fila][temColumna]==0){
        copia[fila][temColumna]=8;
        temColumna--;
        }
        temColumna=columna+1;
        while (entrada[fila][temColumna]==0){
        copia[fila][temColumna]=8;
        temColumna++;
        }
        

        while (entrada[temfila][columna]==0){
        copia[temfila][columna]=8;
        temfila++;
        }
        temfila=fila-1;
        while (entrada[temfila][columna]==0){
        copia[temfila][columna]=8;
        temfila--;
        }
       
    }
      
       public boolean correctitud(int fila, int columna) {
       int temfila=fila+1;
       int temColumna=columna-1;
           boolean correcto=true;
        while(correcto && entrada[fila][temColumna]<2 && temColumna!=0){
        if(entrada[fila][temColumna]==1){correcto=false;}
        temColumna--;
        }
         temColumna=columna+1;
        while(correcto && entrada[fila][temColumna]<2 && temColumna!=0){
        if(entrada[fila][temColumna]==1){correcto=false;}
        temColumna++;
        }
        
        while(correcto && entrada[temfila][columna]<2 && temfila!=0){
        if(entrada[temfila][columna]==1){correcto=false;}
        temfila++;
        }
        temfila=fila-1;
        while(correcto && entrada[temfila][columna]<2 && temfila!=0){
        if(entrada[temfila][columna]==1){correcto=false;}
        temfila--;
        }
        return correcto;
    }
      //metodo para dar el numero de combinaciones posibles
    public int numeroCombinaciones(int celda, int fila, int columna){
    int numcombinaciones=0;
    int celdasBlancas=0;
    if(copia[fila][columna-1]==0){celdasBlancas++;}
    if(copia[fila][columna+1]==0){celdasBlancas++;}
    if(copia[fila-1][columna]==0){celdasBlancas++;}
    if(copia[fila+1][columna]==0){celdasBlancas++;}
    
    if(celda==4){numcombinaciones=celdasBlancas;}
    if(celda==5){numcombinaciones=celdasBlancas*celdasBlancas-1/2;}
    if(celda==6){numcombinaciones=celdasBlancas*celdasBlancas-1*celdasBlancas-2/6;}
 
    return numcombinaciones;
    }
    
    
    
    public void Asignarbombillo(int celda, int fila, int columna) {
       
        if(celda==7){
        if((entrada[fila][columna-1]==0) || (entrada[fila][columna-1]==1)){
        entrada[fila][columna-1]=1;
        copia[fila][columna-1]=1;
        excluirFilas(fila, columna-1);
        }
        else{//"error en la matriz"
        }
        
        if((entrada[fila][columna+1]==0) || (entrada[fila][columna+1]==1)){
        entrada[fila][columna+1]=1;
        copia[fila][columna+1]=1;
        excluirFilas(fila, columna+1);
        }
        else{//"error en la matriz"
        }
        
        if((entrada[fila-1][columna]==0) || (entrada[fila-1][columna]==1)){
        entrada[fila-1][columna]=1;
        copia[fila-1][columna]=1;
        excluirFilas(fila-1, columna);
        }
        else{//"error en la matriz"}
        }
        if((entrada[fila+1][columna]==0) || (entrada[fila+1][columna]==1)){
        entrada[fila+1][columna]=1;
        copia[fila+1][columna]=1;
        excluirFilas(fila+1, columna);
        }
        else{//"error en la matriz"}
        }
        }
        
    
        
        
        if (celda==3){
        copia[fila][columna-1]=8;
        copia[fila][columna+1]=8;
        copia[fila-1][columna]=8;
        copia[fila+1][columna]=8;
        }
        
        if (celda==6){
        if (numeroCombinaciones(celda,fila,columna)==4){
            if ( celdasNegras[fila][3]!=4){
                 if (correctitud(fila,columna-1)&& celdasNegras[index][3]!=3 ){
                     
                     if (correctitud(fila,columna+1)&& celdasNegras[index][3]!=2 ){

                        if (correctitud(fila-1,columna) && celdasNegras[index][3]!=1 ){
                            entrada[fila][columna-1]=1;
                            copia[fila][columna-1]=1;
                            entrada[fila][columna+1]=1;
                            copia[fila][columna+1]=1;
                            entrada[fila-1][columna]=1;
                            copia[fila-1][columna]=1;
                            celdasNegras[index][3]=1;
                            }else{ if(correctitud(fila+1,columna)){
                                      entrada[fila+1][columna]=1;
                                      copia[fila+1][columna]=1; 
                                      celdasNegras[index][3]=2;
                                       }//modificar la combinacion de la anterior celda
                                }
                        
                        }else{ if(correctitud(fila-1,columna)){
                            
                                  if (correctitud(fila+1,columna)){
                                      entrada[fila-1][columna]=1;
                                      copia[fila-1][columna]=1;
                                      entrada[fila+1][columna]=1;
                                      copia[fila+1][columna]=1;
                                      celdasNegras[index][3]=3;
                                       }//modificar la combinacion de la anterior celda
                             }//modificar la combinacion de la anterior celda  
                            }
                 }else{ if(correctitud(fila,columna+1)){
                            if (correctitud(fila-1,columna)){
                                if (correctitud(fila+1,columna)){
                                      entrada[fila][columna+1]=1;
                                      copia[fila+1][columna+1]=1;
                                      entrada[fila-1][columna]=1;
                                      copia[fila-1][columna]=1;
                                      entrada[fila+1][columna]=1;
                                      copia[fila+1][columna]=1;
                                      celdasNegras[index][3]=4;
                                     }//modificar la combinacion de la anterior celda
                                }//modificar la combinacion de la anterior celda
                           }//modificar la combinacion de la anterior celda
                    }
            }
        }else{//como solo hay una posible combinacion asigno los bombillos y hago correctitud y despues excluyo
        }
               
              
        
            }
        }   
        
        
        
    
    // metodo para ordenar matriz
     public void crearSolucion() {
       
        
         

    }
    
    
}
