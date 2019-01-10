package algoritmos;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ell
 */

import logica.Matriz;
import logica.*;
import java.util.*;
import java.lang.Math.*;
/**
 *
 * @author mizesa
 */
public class AlgoritmoIngenuo {
    
    public int[][] entrada;
    private int[][] respuesta;
    private int[][] copia;
    private int numCeldasNegras;
    private int filas;
    private int columnas;
    private int [][] celdasNegras;
    private int index=0;
    public int totalCombinaciones;
    public Vector combinacionesCorrectas=new Vector(20);
    public Vector posiblesSoluciones=new Vector();
    
    public AlgoritmoIngenuo(int[][] entrada, int numCeldasNegras, int filas, int columnas){
        
        this.entrada=entrada;
        copia=entrada;
        this.numCeldasNegras=numCeldasNegras;
        this.filas=filas;
        this.columnas=columnas;
        this.celdasNegras=new int [numCeldasNegras][7];
    }
     public AlgoritmoIngenuo(){
        
       
    }
    //metodo q me crea la matriz de celdas negras
    public void crearMatrizCeldas (){
        int x=0;
        for (int i=0; i<filas; i++){
            for (int j=0; j<columnas; j++){
                if(entrada[i][j]>3){
                celdasNegras[x][0]=entrada[i][j];  //celdas
                celdasNegras[x][1]=i;               //filas
                celdasNegras[x][2]=j;              //columnas
                celdasNegras[x][3]=0;               //combinacion
                celdasNegras[x][4]=0;               //index
                celdasNegras[x][5]=0;               //combinacion actual
                celdasNegras[x][6]=0;               //total de combinacion
                x++;
                
                }
            
            }
        
        }
    
    
    }
    

    
     public int numeroCombinaciones(int celda, int fila, int columna){
 
    int numcombinaciones=0;
    int celdasBlancas=0;
    if(columna==0 || copia[fila][columna-1]!=0 ){}
    else celdasBlancas++;
    if(columna==columnas-1 || copia[fila][columna+1]!=0){}
    else celdasBlancas++;
    if(fila==0 || copia[fila-1][columna]!=0){}
    else celdasBlancas++;
    if(fila==filas-1 || copia[fila+1][columna]!=0){}
    else celdasBlancas++;
    if(celda==4){numcombinaciones=celdasBlancas;}
    if(celda==5){numcombinaciones=(celdasBlancas*(celdasBlancas-1))/2;}
    if(celda==6){numcombinaciones=(celdasBlancas*(celdasBlancas-1)*(celdasBlancas-2))/6;}
    if(celda==7){numcombinaciones=1;}

    return numcombinaciones;
    }
     
     public void totalCombinaciones(){
    int totalcombinaciones=1;
   
    for (int i=0; i<numCeldasNegras; i++){
    totalcombinaciones=celdasNegras[i][6]*totalcombinaciones;
    
    }
 
     this.totalCombinaciones=totalcombinaciones;
    }
      public void index(){
    int index=1;
  
    for (int i=0; i<numCeldasNegras; i++){
        for (int j=i+1; j<numCeldasNegras; j++){
            index=celdasNegras[j][6]*index;
            
            }
        
    celdasNegras[i][4]=index; 
//    System.out.println(celdasNegras[i][4]);
    index=1;
    }
   
    }
     
       private void celda(int fila, int columna ) {

     
           if (columna!=0){
               if(copia[fila][columna-1]==0) {copia[fila][columna-1]=8;}}
              
           if (columna<columnas-1){
               if(copia[fila][columna+1]==0) {copia[fila][columna+1]=8;}}
                    
           if(fila!=0){
              if(copia[fila-1][columna]==0) {copia[fila-1][columna]=8; }}
                             
           if (fila<filas-1){
              if(copia[fila+1][columna]==0) {copia[fila+1][columna]=8; }}
                                
                           
      }
       
           
     public void excluirCeldas(){
    
  
    for (int i=0; i<filas; i++){
        for (int j=0; j<columnas; j++){
            if(copia[i][j]==3){celda(i,j);}
                                
            
            }
    }
    
  }
        
      public void excluirCeldasNum(){
    
  
    for (int i=0; i<numCeldasNegras; i++){
       
            celda(celdasNegras[i][1],celdasNegras[i][2]);
                                
            
            
    }
    
  }     
    
     private void celda1(int combinacion,int fila, int columna, int posx) {

      switch (combinacion){
          case 1: if (columna!=0){
                                if(copia[fila][columna-1]<2) {copia[fila][columna-1]=1; celdasNegras[posx][5]=1-celdasNegras[posx][3];}
                                else{combinacion++;celda1(combinacion,fila,columna, posx);}}
                  else{combinacion++;celda1(combinacion,fila,columna, posx);}
              break;
          case 2: if (columna<columnas-1){
                                        if(copia[fila][columna+1]<2) {copia[fila][columna+1]=1; celdasNegras[posx][5]=2-celdasNegras[posx][3];}
                                        else{combinacion++;celda1(combinacion,fila,columna, posx);}}
                  else{combinacion++;celda1(combinacion,fila,columna,posx);}
              break;
          case 3:if (fila!=0){
                             if(copia[fila-1][columna]<2) {copia[fila-1][columna]=1; celdasNegras[posx][5]=3-celdasNegras[posx][3];}
                             else{combinacion++;celda1(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda1(combinacion,fila,columna,posx);}
              break;
          case 4:if (fila<filas-1){
                                if(copia[fila+1][columna]<2) {copia[fila+1][columna]=1; celdasNegras[posx][5]=4-celdasNegras[posx][3];}
                                else{combinacion++;celda1(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda1(combinacion,fila,columna,posx);}
              break;
                           
      }
        
    } 
     
     private void celda2(int combinacion,int fila, int columna, int posx) {

      switch (combinacion){
          case 1: if (columna!=0){ 
                                  if (columna<columnas-1){
                                                         if(copia[fila][columna-1]<2 && copia[fila][columna+1]<2) {copia[fila][columna-1]=1;copia[fila][columna+1]=1; celdasNegras[posx][5]=1-celdasNegras[posx][3];}
                                                           else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                                  else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                    else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;
          case 2: if (columna!=0){ 
                                 if (fila!=0){
                                             if(copia[fila][columna-1]<2 && copia[fila-1][columna]<2) {copia[fila][columna-1]=1;copia[fila-1][columna]=1; celdasNegras[posx][5]=2-celdasNegras[posx][3];}
                                             else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                                 else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                   else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;
          case 3:if (columna!=0){
                                if (fila<filas-1){
                                                  if(copia[fila][columna-1]<2 && copia[fila+1][columna]<2) {copia[fila][columna-1]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=3-celdasNegras[posx][3];}
                                                  else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                                else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;
          case 4:if (fila!=0){
                             if (columna<columnas-1){
                                                    if(copia[fila][columna+1]<2 && copia[fila-1][columna]<2) {copia[fila][columna+1]=1;copia[fila-1][columna]=1;celdasNegras[posx][5]=4-celdasNegras[posx][3];}
                                                    else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                             else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;
          case 5:if (fila<filas-1){
                                if (columna<columnas-1){
                                                        if(copia[fila][columna+1]<2 && copia[fila+1][columna]<2) {copia[fila][columna+1]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=5-celdasNegras[posx][3];}
                                                        else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                                else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;
          case 6:if (fila!=0){ 
                             if (fila<filas-1){
                                               if(copia[fila-1][columna]<2 && copia[fila+1][columna]<2) {copia[fila-1][columna]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=6-celdasNegras[posx][3];}
                                               else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                             else{combinacion++;celda2(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda2(combinacion,fila,columna, posx);}
              break;    
                           
      }    
        
    } 
     private void celda3(int combinacion,int fila, int columna, int posx) {

         switch (combinacion){
         case 1: if (columna!=0){ 
                                if (columna<columnas-1){
                                                        if(fila !=0){ 
                                                                    if(copia[fila][columna-1]<2 && copia[fila][columna+1]<2 && copia[fila-1][columna]<2) {copia[fila][columna-1]=1;copia[fila][columna+1]=1;copia[fila-1][columna]=1;celdasNegras[posx][5]=1-celdasNegras[posx][3];}
                                                                    else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                                        else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda3(combinacion,fila,columna, posx);}
              break;
          case 2: if (columna!=0){ 
                                 if (columna<columnas-1){
                                                        if(fila<filas-1){ 
                                                                        if(copia[fila][columna-1]<2 && copia[fila][columna+1]<2 && copia[fila+1][columna]<2) {copia[fila][columna-1]=1;copia[fila][columna+1]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=2-celdasNegras[posx][3];}
                                                                        else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                                        else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                 else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                   else{combinacion++;celda3(combinacion,fila,columna, posx);}
              break;
          case 3:if (columna!=0){ 
                                if (fila !=0){
                                             if(fila<filas-1){ 
                                                              if(copia[fila][columna-1]<2 && copia[fila-1][columna]<2 && copia[fila+1][columna]<2) {copia[fila][columna-1]=1;copia[fila-1][columna]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=3-celdasNegras[posx][3];}
                                                              else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                             else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda3(combinacion,fila,columna, posx);}
              break;
          case 4:if (columna<columnas-1){ 
                                        if (fila!=0){
                                                    if(fila<filas-1){ 
                                                                    if(copia[fila][columna+1]<2 && copia[fila-1][columna]<2 && copia[fila+1][columna]<2) {copia[fila][columna+1]=1;copia[fila-1][columna]=1;copia[fila+1][columna]=1;celdasNegras[posx][5]=4-celdasNegras[posx][3];}
                                                                    else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                                    else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                                        else{combinacion++;celda3(combinacion,fila,columna, posx);}}
                 else{combinacion++;celda3(combinacion,fila,columna, posx);}
              break;
         
         }
    } 
     private void celda4(int combinacion,int fila, int columna) {

        if (columna!=0){ if (fila!=0){if(columna<columnas-1) {if(fila<filas-1){ if(copia[fila][columna-1]==0 && copia[fila][columna+1]==0 && copia[fila-1][columna]==0 && copia[fila+1][columna]==0) {copia[fila][columna-1]=1;copia[fila][columna+1]=1;copia[fila-1][columna]=1;copia[fila+1][columna]=1;}}}}}
         
    } 
     
     public boolean correctitudAdyacentes() {
          boolean correcto=true;
          int norte,sur,este,oeste;
          int j=0;
          int contador=0;
          while(j<numCeldasNegras && correcto)
       {
             if(celdasNegras[j][2]-1 == -1 || copia[celdasNegras[j][1]][celdasNegras[j][2]-1]!=1)
                 este=0;
             else {contador++; if(correcto==true){correcto=correctitud(celdasNegras[j][1],celdasNegras[j][2]-1);}}
              if(celdasNegras[j][2]+1 == columnas || copia[celdasNegras[j][1]][celdasNegras[j][2]+1]!=1)
                 oeste=0;
             else {contador++; if(correcto==true){correcto=correctitud(celdasNegras[j][1],celdasNegras[j][2]+1);}}
               if(celdasNegras[j][1]-1 == -1 || copia[celdasNegras[j][1]-1][celdasNegras[j][2]]!=1)
                 oeste=0;
             else {contador++; if(correcto==true){correcto=correctitud(celdasNegras[j][1]-1,celdasNegras[j][2]);}}
                if(celdasNegras[j][1]+1 == filas || copia[celdasNegras[j][1]+1][celdasNegras[j][2]]!=1)
                 oeste=0;
             else {contador++; if(correcto==true){correcto=correctitud(celdasNegras[j][1]+1,celdasNegras[j][2]);}}
            
            if (celdasNegras[j][0]!=contador+3){correcto=false;}
            else contador=0;
            j++;
        }
          
          return correcto;
    }
     
     public boolean correctitud(int fila, int columna) {
       int temfila=fila+1;
       int temColumna=columna-1;
           boolean correcto=true;
        while(correcto && temColumna>=0 && copia[fila][temColumna]<2){
        if(copia[fila][temColumna]==1){correcto=false;}
        temColumna--;
        }
         temColumna=columna+1;
        while(correcto && temColumna<columnas && copia[fila][temColumna]<2 ){
        if(copia[fila][temColumna]==1){correcto=false;}
        temColumna++;
        }
        
        while(correcto && temfila<filas && copia[temfila][columna]<2 ){
        if(copia[temfila][columna]==1){correcto=false;}
        temfila++;
        }
        temfila=fila-1;
        while(correcto && temfila>=0 && copia[temfila][columna]<2 ){
        if(copia[temfila][columna]==1){correcto=false;}
        temfila--;
        }
        return correcto;
    }
     public boolean asignarbombilloCeldaExcluyente(int fila, int columna){
     
     int temfila=fila+1;
       int temColumna=columna-1;
       boolean correcto=false;
       boolean condicionParada=true;
         
        while( condicionParada && temColumna>=0  ){
        if(copia[fila][temColumna]>0 && copia[fila][temColumna]<8 ){condicionParada=false;}
        else{
        if (copia[fila][temColumna]==0){copia[fila][temColumna]=1; iluminar(fila, temColumna); return true;}
        }
        temColumna--;
        }
        condicionParada=true;
         temColumna=columna+1;
        while(condicionParada && temColumna<columnas ){
       if(copia[fila][temColumna]>0 && copia[fila][temColumna]<8 ){condicionParada=false;}
        else{
        if (copia[fila][temColumna]==0){copia[fila][temColumna]=1; iluminar(fila, temColumna); return true;}
        }
        temColumna++;
        }
       condicionParada=true;
        while( condicionParada && temfila<filas ){
       if(copia[temfila][columna]>0 && copia[temfila][columna]<8 ){condicionParada=false;}
        else{
        if (copia[temfila][columna]==0){copia[temfila][columna]=1; iluminar(temfila, columna); return true;}
        }
        temfila++;
        }
        condicionParada=true;
        temfila=fila-1;
        while(condicionParada &&  temfila>=0 ){
        if(copia[temfila][columna]>0 && copia[temfila][columna]<8 ){condicionParada=false;}
        else{
        if (copia[temfila][columna]==0){copia[temfila][columna]=1; iluminar(temfila, columna); return true;}
        }
        temfila--;
        }
      
     return correcto;
     }
     
     public boolean iluminarCeldasBlancas() {
              boolean correcto=true;
   for (int i=0; i<filas; i++){
        for (int j=0; j<columnas; j++){
            if(copia[i][j]==8){if(asignarbombilloCeldaExcluyente(i,j)==false){return false;}
                                else{correcto=true;}}
                                
            
            }
    }
    
        return correcto;
    }
     
     
//     opcional iluminar celdas en 8
      public void iluminar(int fila, int columna) {
       int temfila=fila+1;
       int temColumna=columna-1;
       boolean correcto=true;
         
        while( correcto && temColumna>=0  ){
        if(copia[fila][temColumna]>1 && copia[fila][temColumna]<8 ){correcto=false;}
        else{
        if (copia[fila][temColumna]!=1){copia[fila][temColumna]=9;}
        }
        temColumna--;
        }
        correcto=true;
         temColumna=columna+1;
        while(correcto && temColumna<columnas ){
       if(copia[fila][temColumna]>1 && copia[fila][temColumna]<8 ){correcto=false;}
        else{
        if (copia[fila][temColumna]!=1){copia[fila][temColumna]=9;}
        }
        temColumna++;
        }
        correcto=true;
        while( correcto && temfila<filas ){
        if(copia[temfila][columna]>1 && copia[temfila][columna]<8 ){correcto=false;}
        else{
        if (copia[temfila][columna]!=1){copia[temfila][columna]=9;}
        }
        temfila++;
        }
        correcto=true;
        temfila=fila-1;
        while(correcto &&  temfila>=0 ){
        if(copia[temfila][columna]>1 && copia[temfila][columna]<8 ){correcto=false;}
        else{
        if (copia[temfila][columna]!=1){copia[temfila][columna]=9;}
        }
        temfila--;
        }
        
    }
      
               
     public void iluminarCeldas(){
    
  
    for (int i=0; i<filas; i++){
        for (int j=0; j<columnas; j++){
            if(copia[i][j]==1){iluminar(i,j);}
                                
            
            }
    }
    
  }  
    
      

    private void asignarCombinacion() {
        
       for (int j=0; j<numCeldasNegras; j++){
             if (celdasNegras[j][0]==4){ celda1(celdasNegras[j][3]+celdasNegras[j][5],celdasNegras[j][1], celdasNegras[j][2],j);}
             if (celdasNegras[j][0]==5){ celda2(celdasNegras[j][3]+celdasNegras[j][5],celdasNegras[j][1], celdasNegras[j][2],j);}
             if (celdasNegras[j][0]==6){ celda3(celdasNegras[j][3]+celdasNegras[j][5],celdasNegras[j][1], celdasNegras[j][2],j);}
             if (celdasNegras[j][0]==7){ celda4(celdasNegras[j][3],celdasNegras[j][1], celdasNegras[j][2]);}
             }
  }
              
        
    
    
    
    
      public void crearcombinaciones() {
      double combinacion=0;
       
      for (int i=0; i<totalCombinaciones; i++){
           for (int j=0; j<numCeldasNegras; j++){
               combinacion=i/celdasNegras[j][4];
               if (Math.floor(combinacion)+1>celdasNegras[j][6]){
                combinacion=((int)Math.floor(combinacion)+1)%celdasNegras[j][6];
                if(combinacion==1){celdasNegras[j][5]=0;}
                if(combinacion==0){combinacion=celdasNegras[j][6];celdasNegras[j][3]=(int)combinacion;}
                else {celdasNegras[j][3]=(int)combinacion;}
               }
              else {celdasNegras[j][3]=(int)Math.floor(combinacion)+1; } 
               
            }
          
           asignarCombinacion();
           if(correctitudAdyacentes()){ iluminarCeldas();excluirCeldasNum(); 
                                        if (iluminarCeldasBlancas()==true){combinacionesCorrectas.addElement(i+1);  System.out.println(i+1);}}
      
             for (int x=0; x<filas; x++){
                  for (int y=0; y<columnas; y++){
                      posiblesSoluciones.addElement(copia[x][y]);
                      
                  }
           }
//           this.copia=entrada;
                      for (int x=0; x<filas; x++){
                  for (int y=0; y<columnas; y++){
                      if (copia[x][y]==1)copia[x][y]=0;
                      if (copia[x][y]==9)copia[x][y]=0;
                      if (copia[x][y]==8)copia[x][y]=0;
                  }
           }
        excluirCeldas();
          
    }   
         
   
    }
      
      public void imprimirSolucion(int numSolucion){
        int contador=(numSolucion*(filas*columnas))-(filas*columnas);
         for (int i=0; i<filas; i++){
             for (int j=0; j<columnas; j++){
            if(posiblesSoluciones.elementAt(contador)==0){entrada[i][j]=1;}
            else {if(posiblesSoluciones.elementAt(contador)==8 || posiblesSoluciones.elementAt(contador)==9){entrada[i][j]=0;}
            else{entrada[i][j]=(int)posiblesSoluciones.elementAt(contador);}}
                                
            contador++;
            }
    }
//      for (int x=(numSolucion*(filas*columnas))-(filas*columnas); x<=(numSolucion*(filas*columnas))-1; x++){
//          
//          if (contador==columnas){System.out.println();contador=0;}
//             System.out.print(posiblesSoluciones.elementAt(x));   
//             contador++;
//           }
       
  }
  public void crearSolucion(){
      
  crearMatrizCeldas ();
  excluirCeldas();
  for (int j=0; j<numCeldasNegras; j++){
      celdasNegras[j][6]=numeroCombinaciones(celdasNegras[j][0], celdasNegras[j][1], celdasNegras[j][2]);
      Matriz s = new Matriz();
        this.respuesta = s.getMatriz();
  }
   
  totalCombinaciones();
 
  index();
  crearcombinaciones();
//imprimirSolucion(14879);
  
  }   
    
    }

