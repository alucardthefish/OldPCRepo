// Fig. 14.10: PruebaContextual.java
// Demostración de los objetos JPopupMenu

package menus.fig14_10;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PruebaContextual extends JFrame {
   private JRadioButtonMenuItem elementos[];
   private final Color valoresColor[] = 
      { Color.BLUE, Color.YELLOW, Color.RED };
   private JPopupMenu menuContextual;

   // configurar GUI
   public PruebaContextual()
   {
      super( "Uso de objetos JPopupMenu" );

      ManejadorEventos manejador = new ManejadorEventos();
      String colores[] = { "Azul", "Amarillo", "Rojo" };

      // establecer menú contextual y sus elementos
      ButtonGroup grupoColores = new ButtonGroup();
      menuContextual = new JPopupMenu();
      elementos = new JRadioButtonMenuItem[ 3 ];

      // construir cada elemento de menú y agregarlo al menú contextual; además
      // permitir el manejo de eventos para cada elemento de menú
      for ( int cuenta = 0; cuenta < elementos.length; cuenta++ ) {
         elementos[ cuenta ] = new JRadioButtonMenuItem( colores[ cuenta ] );
         menuContextual.add( elementos[ cuenta ] );
         grupoColores.add( elementos[ cuenta ] );
         elementos[ cuenta ].addActionListener( manejador );
      }

      getContentPane().setBackground( Color.WHITE );

      // declarar un objeto MouseListener para la ventana que muestra
      // un objeto JPopupMenu cuando ocurre el evento de desencadenamiento del menú contextual
      addMouseListener(

         new MouseAdapter() {  // clase interna anónima

            // manejar evento de oprimir botón del ratón
            public void mousePressed( MouseEvent evento )
            { 
               checkForTriggerEvent( evento ); 
            } 

            // manejar evento de soltar el botón del ratón
            public void mouseReleased( MouseEvent evento )
            { 
               checkForTriggerEvent( evento ); 
            } 

            // determinar si evento debe desencadenar el menú contextual
            private void checkForTriggerEvent( MouseEvent evento )
            {
               if ( evento.isPopupTrigger() ) 
                  menuContextual.show( 
                     evento.getComponent(), evento.getX(), evento.getY() );  
            }

         } // fin de la clase interna anónima

      ); // fin de la llamada a addMouseListener

      setSize( 300, 200 );
      setVisible( true );

   } // fin del constructor de PruebaContextual

   public static void main( String args[] )
   {
      PruebaContextual aplicacion = new PruebaContextual();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // clase interna privada para manejar eventos de elemento de menú
   private class ManejadorEventos implements ActionListener {

      // procesar selecciones de elementos de menú
      public void actionPerformed( ActionEvent evento )
      {
         // determinar cuál elemento de menú fue seleccionado
         for ( int i = 0; i < elementos.length; i++ )
            if ( evento.getSource() == elementos[ i ] ) {
               getContentPane().setBackground( valoresColor[ i ] );
               return;
            }
      }

   } // fin de la clase interna privada ManejadorEventos

} 