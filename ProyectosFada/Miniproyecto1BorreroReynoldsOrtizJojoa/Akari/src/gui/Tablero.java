/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;

import java.awt.GridLayout;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

/**
 *
 * @author sergio
 */
public class Tablero
{

    public int fila, columna;
    public int [][] matrizIluminadas;

    public JLabel etiquetaBlanca;
    public JLabel etiquetaNegra;
    public JLabel etiquetaBombilla;
    public JLabel etiquetaIluminada;
    public JLabel etiquetaCelda0;
    public JLabel etiquetaCelda1;
    public JLabel etiquetaCelda2;
    public JLabel etiquetaCelda3;
    public JLabel etiquetaCelda4;

    public URL url;


    public Tablero(int[][] matrizSolucion, int fila, int columna)
    {
        this.matrizIluminadas = matrizSolucion;
        this.fila = fila;
        this.columna = columna;
    }

    public void asignarLabelCeldaBlanca()
   {
       String path = "../imagenes/celdaBlanca.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaBlanca = new JLabel();
       etiquetaBlanca.setIcon(icono);
   }

   public void asignarLabelCeldaNegra()
   {
       String path = "../imagenes/celdaNegra.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaNegra = new JLabel();
       etiquetaNegra.setIcon(icono);
   }

   public void asignarLabelCeldaBombilla()
   {
       String path = "../imagenes/celdaBombilla.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaBombilla = new JLabel();
       etiquetaBombilla.setIcon(icono);
   }
   public void asignarLabelCeldaIluminada()
   {
       String path = "../imagenes/celdaIluminada.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaIluminada = new JLabel();
       etiquetaIluminada.setIcon(icono);
   }

   public void asignarLabelCelda0()
   {
       String path = "../imagenes/celda0.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaCelda0 = new JLabel();
       etiquetaCelda0.setIcon(icono);
   }

   public void asignarLabelCelda1()
   {
       String path = "../imagenes/celda1.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaCelda1 = new JLabel();
       etiquetaCelda1.setIcon(icono);
   }

   public void asignarLabelCelda2()
   {
       String path = "../imagenes/celda2.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaCelda2 = new JLabel();
       etiquetaCelda2.setIcon(icono);
   }

   public void asignarLabelCelda3()
   {
       String path = "../imagenes/celda3.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaCelda3 = new JLabel();
       etiquetaCelda3.setIcon(icono);
   }

   public void asignarLabelCelda4()
   {
       String path = "../imagenes/celda4.png";
       url = this.getClass().getResource(path);
       ImageIcon icono = new ImageIcon(url);

       etiquetaCelda4 = new JLabel();
       etiquetaCelda4.setIcon(icono);
   }

    //Entradas: una matriz solucion, numero de filas y columnas
    //Retorna: una Matriz que representa el tablero iluminado
    public int[][] iluminarTablero()
    {
        
        

        //Creando matriz con celdas iluminadas representadas por 8's
        for(int i=0; i<fila; i++)
        {
            for(int j=0; j<columna; j++)
            {
                int iActualSur = i+1;
                int jActualOriente = j+1;
                int iActualNorte = i-1;
                int jActualOccidente = j-1;

//                System.out.println("entro if de si hay bombilla");

                if(matrizIluminadas[i][j] == 1)
                {
                    while(iActualSur < fila && (matrizIluminadas[iActualSur][j] == 0 || matrizIluminadas[iActualSur][j] == 8))
                    {
                        matrizIluminadas[iActualSur][j] = 8;
                        iActualSur++;
                    }
                    while(jActualOriente < columna && (matrizIluminadas[i][jActualOriente] == 0 || matrizIluminadas[i][jActualOriente] == 8))
                    {
                        matrizIluminadas[i][jActualOriente] = 8;
                        jActualOriente++;
                    }
                    while(iActualNorte > 0 && (matrizIluminadas[iActualNorte][j] == 0 || matrizIluminadas[iActualNorte][j] == 8))
                    {
                        matrizIluminadas[iActualNorte][j] = 8;
                        iActualNorte--;
                    }
                    while(jActualOccidente > 0 && (matrizIluminadas[i][jActualOccidente] == 0 || matrizIluminadas[i][jActualOccidente] == 8))
                    {
                        matrizIluminadas[i][jActualOccidente] = 8;
                        jActualOccidente--;
                    }

                }


            }
        }

        return matrizIluminadas;

    }

    public JFrame pintarTablero(int [][] matrix)
    {
        
        matrix = matrizIluminadas;
        JFrame v = new JFrame();
        v.getContentPane().setLayout(new GridLayout(fila,columna));

        //pintando el tablero
        for(int i=0; i < fila; i++)
        {
            for(int j=0; j < columna; j++)
            {
                if(matrizIluminadas[i][j] == 0)
                {
                    asignarLabelCeldaBlanca();
                    v.getContentPane().add(etiquetaBlanca);
                }
                else if(matrizIluminadas[i][j] == 1)
                {
                    asignarLabelCeldaBombilla();
                    v.getContentPane().add(etiquetaBombilla);
                }
                else if(matrizIluminadas[i][j] == 2)
                {
                    asignarLabelCeldaNegra();
                    v.getContentPane().add(etiquetaNegra);
                }
                else if(matrizIluminadas[i][j] == 3)
                {
                    asignarLabelCelda0();
                    v.getContentPane().add(etiquetaCelda0);
                }
                else if(matrizIluminadas[i][j] == 4)
                {
                    asignarLabelCelda1();
                    v.getContentPane().add(etiquetaCelda1);
                }
                else if(matrizIluminadas[i][j] == 5)
                {
                    asignarLabelCelda2();
                    v.getContentPane().add(etiquetaCelda2);
                }
                else if(matrizIluminadas[i][j] == 6)
                {
                    asignarLabelCelda3();
                    v.getContentPane().add(etiquetaCelda3);
                }
                else if(matrizIluminadas[i][j] == 7)
                {
                    asignarLabelCelda4();
                    v.getContentPane().add(etiquetaCelda4);
                }
                else if(matrizIluminadas[i][j] == 8)
                {
                    asignarLabelCeldaIluminada();
                    v.getContentPane().add(etiquetaIluminada);
                }
             }
        }
        
        v.pack();
        v.setVisible(true);

        return v;
    }





}
