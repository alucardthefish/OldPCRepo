/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.Vector;


/**
 *
 * @author Administrador
 */
public class triangulacionDinamica {
    
    public int[][] poligono;
    private double [][] costosTriangulacion;
    private int[][] copia;
    private int numNodos;
     Vector solucionOptima=new Vector();
     private double [][]matrizSolucion;
 
  
    public triangulacionDinamica(int[][] poligono, int numNodos){
        
        this.poligono=poligono;
        copia=new int [numNodos-1][numNodos];
        this.numNodos=numNodos;
       costosTriangulacion=new double [numNodos-1][numNodos];
       matrizSolucion=new double [numNodos-3][2];
        
    }
    
    
    public void costoMinimo(){
    double minimo=1000000;
    int indicek=0;
    int nodotemp=0;
    int nodo2Temp=0;
        
         for (int i=2; i<=numNodos; i++){
            for (int j=0; j<numNodos; j++){
                if(i>=2 && i<4){costosTriangulacion[i][j]=0;}
                else{
               for(int k=1; k<=i-2; k++) {
                   if (j+k>numNodos-1){nodotemp=(j+k)-numNodos;}
                   else{nodotemp=j+k;}
                   if(j+(i-1)>numNodos-1){nodo2Temp=(j+(i-1))-numNodos;}
                   else{nodo2Temp=j+(i-1);}
                   //if(j==0 && i==6 && k==5){System.out.println(costosTriangulacion[(k+1)-2][j]+" "+costosTriangulacion[(i-k)-2][nodotemp]+"  "+longitudCuerda(poligono[j][0],poligono[j][1],poligono[nodotemp][0],poligono[nodotemp][1],j,nodotemp)+"  "+longitudCuerda(poligono[nodotemp][0],poligono[nodotemp][1],poligono[nodo2Temp][0],poligono[nodo2Temp][1],nodotemp,nodo2Temp));}
                   //System.out.println(costosTriangulacion[k+1][j]+costosTriangulacion[i-k][nodotemp]+longitudCuerda(poligono[j][0],poligono[j][1],poligono[nodotemp][0],poligono[nodotemp][1],j,nodotemp)+longitudCuerda(poligono[nodotemp][0],poligono[nodotemp][1],poligono[nodo2Temp][0],poligono[nodo2Temp][1],nodotemp,nodo2Temp)+" ");
                   if(costosTriangulacion[(k+1)-2][j]+costosTriangulacion[(i-k)-2][nodotemp]+longitudCuerda(poligono[j][0],poligono[j][1],poligono[nodotemp][0],poligono[nodotemp][1],j,nodotemp)+longitudCuerda(poligono[nodotemp][0],poligono[nodotemp][1],poligono[nodo2Temp][0],poligono[nodo2Temp][1],nodotemp,nodo2Temp)<minimo){
                   if(costosTriangulacion[(k+1)-2][j]+costosTriangulacion[(i-k)-2][nodotemp]+longitudCuerda(poligono[j][0],poligono[j][1],poligono[nodotemp][0],poligono[nodotemp][1],j,nodotemp)+longitudCuerda(poligono[nodotemp][0],poligono[nodotemp][1],poligono[nodo2Temp][0],poligono[nodo2Temp][1],nodotemp,nodo2Temp)!=0){
                   minimo=costosTriangulacion[(k+1)-2][j]+costosTriangulacion[(i-k)-2][nodotemp]+longitudCuerda(poligono[j][0],poligono[j][1],poligono[nodotemp][0],poligono[nodotemp][1],j,nodotemp)+longitudCuerda(poligono[nodotemp][0],poligono[nodotemp][1],poligono[nodo2Temp][0],poligono[nodo2Temp][1],nodotemp,nodo2Temp);
                   indicek=k;
                   }
                   }
                   }
               if(i==numNodos && j>0){}
               else{
               costosTriangulacion[i-2][j]=minimo;
               copia[i-2][j]=indicek;
             
              
                }
               minimo=1000000;
                }
                  // System.out.print(costosTriangulacion[i-2][j]+" ");
                }
            //System.out.println(" ");
            }
        
        
       //System.out.print(copia[5][0]+" ");
    
    } 
    
    public double longitudCuerda(int x1, int y1, int x2, int y2, int nodo1, int nodo2){
    double longitud=0.0;
    
   if (nodo1==0 || nodo1==numNodos-1){if(nodo2==nodo1+1 || nodo2==nodo1-1 || nodo2==0 || nodo2==numNodos-1 ){return 0.0;}}
  if(nodo1-1==nodo2 || nodo1+1==nodo2){return 0.0;}
    longitud=Math.sqrt(Math.pow((x2-x1),2)+Math.pow((y2-y1),2));
   
  // System.out.println(longitud);
    return longitud;
    } 
    
    public double costoTriangulacionMinima(){
    
    return costosTriangulacion[numNodos-2][0];
    }
    
    public void añadirCuerdas(int verticeInicial, int numVertices, int indiceK){
   
        int indiceTemp=0;
        int indiceTemp1=0;
        if (verticeInicial+indiceK>numNodos-1){indiceTemp=(verticeInicial+indiceK)-numNodos;}
                   else{indiceTemp=verticeInicial+indiceK;}
        
        if(verticeInicial+(numVertices-1)>numNodos-1){indiceTemp1=(verticeInicial+(numVertices-1))-numNodos;}
                   else{indiceTemp1=verticeInicial+(numVertices-1);}
        
        
        if(longitudCuerda(poligono[verticeInicial][0],poligono[verticeInicial][1],poligono[indiceTemp][0],poligono[indiceTemp][1],verticeInicial,indiceTemp)!=0){
          solucionOptima.addElement(verticeInicial); 
          solucionOptima.addElement(indiceTemp);
       
        
        }
        
        if(longitudCuerda(poligono[indiceTemp][0],poligono[indiceTemp][1],poligono[indiceTemp1][0],poligono[indiceTemp1][1],indiceTemp,indiceTemp1)!=0){
          solucionOptima.addElement(indiceTemp); 
          solucionOptima.addElement(indiceTemp1);
        
    
        }
    
    
    }
    
    
    public boolean crearSolucionOptima(int verticeInicial, int numVertices){
    int indiceK=0; 
    boolean condicion=true;
    indiceK=copia[numVertices-2][verticeInicial];
    int indiceTemp=0;
    int indiceS=numVertices;
    if (verticeInicial+indiceK>numNodos-1){indiceTemp=(verticeInicial+indiceK)-numNodos;}
                   else{indiceTemp=verticeInicial+indiceK;}
        
        
    añadirCuerdas( verticeInicial, numVertices, indiceK);
  
     if(costosTriangulacion[(indiceK+1)-2][verticeInicial]==0 && costosTriangulacion[(indiceS-indiceK)-2][indiceTemp]==0) {  
        return   condicion;
    }
    
    if(costosTriangulacion[(indiceK+1)-2][verticeInicial]!=0){
    //añadirCuerdas(verticeInicial, indiceK+1, copia[(indiceK+1)-2][verticeInicial]);
    crearSolucionOptima(verticeInicial, indiceK+1);
     
    
    }
     
    if(costosTriangulacion[(indiceS-indiceK)-2][indiceTemp]!=0){
   // añadirCuerdas(indiceTemp, (indiceS-indiceK), indiceK);
     crearSolucionOptima(indiceTemp, indiceS-indiceK);
     
    }
  
    
   return   condicion; 
    
}
    public double [][]solucionOptima(){
        int contador=0;
  
     for(int i=0; i < numNodos-3; i++)
                {
                    for(int j=0; j < 2; j++)
                    {
                        int localTmp = (Integer)(solucionOptima.elementAt(contador));
                        matrizSolucion[i][j] = localTmp;
                        contador++;
                    }
                }

    return matrizSolucion;
    }

}