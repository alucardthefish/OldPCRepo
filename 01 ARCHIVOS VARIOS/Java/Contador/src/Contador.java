
//  
//  Contador.java
//  Copyright (c) 1996, Agustin Froufe
//  Todos los derechos reservados.
//  
//  No se asume ninguna  responsabilidad por el  uso o  alteracion  de este
//  software.  Este software se proporciona COMO ES, sin garantia de ningun
//  tipo de su funcionamiento y en ningun caso sera el autor responsable de
//  daños o perjuicios que se deriven del mal uso del software,  aun cuando
//  este haya sido notificado de la posibilidad de dicho daño.
// 
//   Compilador: javac 1.0
//        Autor: Agustin Froufe
//     Creacion: 14-Sep-1996  16:33:10
// 
//--------------------------------------------------------------------------
//  Esta informacion no es necesariamente definitiva y est  sujeta a cambios
//  que pueden ser incorporados en cualquier momento, sin avisar.
//--------------------------------------------------------------------------

import java.awt.*;
import java.applet.Applet;

// Esta clase implementa un contador gráfico, tipo cuentakilómetros de
// coche. Admite que se le pasen tres parámetros desde la llamada al
// applet en la página html que lo incorpore, son:
//    DIGITOS              Número de dígitos del contador
//    INTERVALO            Tiempo a transcurrir entre cada incremento
//    VALOR_INICIAL        Cifra inicial desde la que empieza a contar
// Utiliza un fichero que contiene las imágenes de los dígitos y 
// de ahí va extrayendo cada una de las figuras para componer el
// número que tenga que representar en pantalla
//
public class Contador extends Applet implements Runnable {
    Thread thread = null;
    MediaTracker tracker = null;
    Image numeros;
    int numero_ancho = 15; // Pixels de ancho de cada uno de los numeros
    int numero_alto = 20;  // Pixels de alto de cada uno de los numeros
    int digitos;
    int intervalo;
    String valor;
    int estado = 0;

    public void init() {
        String parametro;

        // Creamos un objeto mediatracker para soportar el contador	
        tracker = new MediaTracker( this );

        try {
            // Cargamos la imagen que contiene los numeros que vamos a
            // presentar en el contador
            numeros = getImage( getCodeBase(),"numeros.gif" );
            tracker.addImage( numeros,0 );

            // Numero de digitos de que consta el contador
            parametro = getParameter( "DIGITOS" );
            digitos = Integer.parseInt( parametro );

            // Intervalo entre cada actualizacion del contador
            parametro = getParameter( "INTERVALO" );
            intervalo = Integer.parseInt ( parametro );

            // Valor del contador cuando lo arrancamos
            valor = getParameter( "VALOR_INICIAL" );
            if( valor == null )
                valor = String.valueOf( 
                    (long)( Math.random() * 
                    (long)( Math.pow( 10,digitos ) ) ) );
        } catch( Exception e ) {
            return;
            }

        // Ponemos el applet al tamaño más adecuado
        resize( ( digitos * numero_ancho ),numero_alto );

        // Creamos y arrancamos el thread que va a controla al
        // contador
        thread = new Thread( this );
        thread.start();
        }
	   

    public void stop() {
        if( thread != null )
            {
            thread.stop();
            thread = null;
            }
        }
	   

    // Método principal del thread, donde se llama a la función de
    // pintado, que es donde se componen las imágenes de los números
    // para reflejar la cifra por donde anda el contador
    public void run() {
        // Una vez que se ha cargado la imagen de los número, seguimos
        tracker.checkAll( true );

        // repitamos y nos dormimos el intervalo de tiempo que se haya
        // indicado
        for( ;; )
            {
            repaint();

            try {
                Thread.sleep( intervalo );
            } catch( InterruptedException e ) {
                ;
                }
            }
        }


    // Cuando se pulsa el ratón, se para el contador y cuando se 
    // vuelva a pulsar, seguirá contando
    public boolean mouseDown( Event e,int x,int y ) {
        if( thread != null )
            {
            thread.stop();
            thread = null;
            }
        else
            {
            thread = new Thread( this );
            thread.start();
            }
        return true;
        }
    

    // Controlamos algunas teclas, para poder manipular el contador
    public boolean keyDown( Event e,int key ) {
        switch( key )
            {
            case '+':		// Va más rápido
                intervalo -= 100;
                if( intervalo < 10 )
                    intervalo = 10;
                break;

            case '-':		// Va más lento
                intervalo += 100;
                break;

            case '0':           // Lo reseteamos
                valor = String.valueOf( 0 );
                estado = 0;
                break;

            default:
                valor = String.valueOf(
                    (long)( Math.random() * (long)( Math.pow( 10,digitos ) ) ) );
                estado = 0;
                break;
            }
	
        return true;
        }

    
    // Aquí no borramos la pantalla, sólo pintamos encima
    public void update( Graphics g ) {
        paint( g );
        }


    // Pintamos el número
    public void paint( Graphics g ) {
        int i;
        int digit;
        boolean scroll;
	
        if( tracker.checkAll() == false )
            {
            g.setColor( Color.black );
            g.fillRect( 0,0,(digitos * numero_ancho),numero_alto );
            return;
            }

        int zeros = digitos - valor.length();
        for( i=0; i < zeros; i++ )
            {
            Graphics gc = g.create( i * numero_ancho,0,
                numero_ancho,numero_alto );
            gc.drawImage( numeros,0,0,this );
            gc.dispose();
            }

        scroll = true;
	
        for( i=valor.length() - 1; i >= 0;i-- )
            {
            digit = valor.charAt( i ) - '0';
	    
            Graphics gc = g.create( (zeros+i) * numero_ancho,0,
                numero_ancho,numero_alto );

            // Tenemos en cuenta cuando se va a cambiar de un número
            // a otro para ir mostrando la mitad del anterior y la primera
            // mitad del siguiente para dar la sensación de movimiento del
            // display del contador
            if( scroll )
                {
                switch( estado )
                    {
                    case 0:
                        if( digit == 0 )
                            gc.drawImage( numeros,0,
                               -( (9 * numero_alto) + numero_alto / 2 ),this );
                        gc.drawImage( numeros,0,
                           -( (digit * numero_alto) - numero_alto / 2 ),this );
                        break;

                    case 1:
                        gc.drawImage( numeros,0,
                           -(digit * numero_alto),this );
                        break;

                    case 2:
                        gc.drawImage( numeros,0,
                           -( (digit * numero_alto) + numero_alto / 2 ),this );
                        if( digit == 9 )
                            gc.drawImage( numeros,0,
                               -( (0 * numero_alto) - numero_alto / 2 ),this );
                        break;
                    }
                }
            else
                gc.drawImage( numeros,0,-(digit * numero_alto),this );
	    
            gc.dispose();

            if( digit != 9 )
                scroll = false;
            }

        if( estado >= 2 )
            {
            estado = 0;
            long l = Long.parseLong( valor );
            l++;
            valor = String.valueOf( l );
            }
        estado++;
        }
    }

//---------------------------------------- Final del fichero Contador.java

