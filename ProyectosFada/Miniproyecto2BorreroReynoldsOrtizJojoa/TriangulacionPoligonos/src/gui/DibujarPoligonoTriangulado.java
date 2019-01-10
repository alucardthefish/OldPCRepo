package gui;

// Dibujo de pol�gonos.
import java.awt.*;
import javax.swing.*;
import logica.ManejadorDeArchivo;

public class DibujarPoligonoTriangulado extends JFrame {

int []valoresX;
int []valoresY;
int [][]matrizEntrada;
double [][]matrizSolucion;
int filas;
   // establecer cadena de barra de titulo y dimensiones de la ventana
   public DibujarPoligonoTriangulado(int [] arrayX, int [] arrayY, int filas,int [][]matrizEntrada, double [][]matrizSolucion)
   {
      super( "Dibujo de poligonos" );

      setSize( 275, 230 );
      setVisible( true );
      this.valoresX = arrayX;
      this.valoresY = arrayY;
      this.filas = filas;
      this.matrizEntrada=matrizEntrada;
      this.matrizSolucion=matrizSolucion;

   }

   // dibujar poligonos y polilineas
   public void paint( Graphics g )
   {
      super.paint( g );  // llamar al m�todo paint de la superclase

      g.translate( this.getInsets().left,this.getInsets().top );

      Polygon poligono1 = new Polygon( valoresX, valoresY, filas);



      g.drawPolygon( poligono1 );

     for(int i=0; i<filas-3; i++)
     {
     g.drawLine(matrizEntrada[(int)matrizSolucion[i][0]][0],matrizEntrada[(int)matrizSolucion[i][0]][1],matrizEntrada[(int)matrizSolucion[i][1]][0],matrizEntrada[(int)matrizSolucion[i][1]][1]);
     System.out.println("nodos1 "+matrizEntrada[(int)matrizSolucion[i][0]][0]+"   "+matrizEntrada[(int)matrizSolucion[i][1]][0]+"  "+matrizEntrada[(int)matrizSolucion[i][0]][1]+"  "+matrizEntrada[(int)matrizSolucion[i][1]][1]);
     }


   } // fin del m�todo paint
   
      // dibujar poligonos y polilineas
   public  String [][]matrizString()
   {
       String fila="";
      String [][] salida=new String [(filas-3)*2][1];
      int contador=0;
           for(int i =0;i<filas-3;i++){
               for(int x=0;x<2;x++){
                 
                for(int j=0;j<2;j++){
                    fila+=matrizEntrada[(int)matrizSolucion[i][j]][x]+"  ";
                }
                
                salida[ contador][0]=fila;
                fila="";
                contador++;
               }
           }
            return salida;


   } // fin del m�todo paint


}