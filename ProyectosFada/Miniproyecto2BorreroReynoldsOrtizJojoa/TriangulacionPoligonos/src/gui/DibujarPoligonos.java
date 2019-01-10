package gui;

// Dibujo de pol�gonos.
import java.awt.*;
import javax.swing.*;
import logica.ManejadorDeArchivo;

public class DibujarPoligonos extends JFrame {
   
int []valoresX;
int []valoresY;
int filas;
   // establecer cadena de barra de titulo y dimensiones de la ventana
   public DibujarPoligonos(int [] arrayX, int [] arrayY, int filas)
   {
      super( "Dibujo de poligonos" );

      setSize( 275, 230 );
      setVisible( true );
      this.valoresX = arrayX;
      this.valoresY = arrayY;
      this.filas = filas;

   }

   // dibujar poligonos y polilineas
   public void paint( Graphics g )
   {
      super.paint( g );  // llamar al m�todo paint de la superclase

      g.translate( this.getInsets().left,this.getInsets().top );
       
      Polygon poligono1 = new Polygon( valoresX, valoresY, filas);

      g.drawPolygon( poligono1 );

   } // fin del m�todo paint
} 