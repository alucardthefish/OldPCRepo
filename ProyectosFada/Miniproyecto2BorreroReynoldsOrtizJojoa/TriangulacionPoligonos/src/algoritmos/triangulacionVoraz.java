/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package algoritmos;

import java.util.Hashtable;

/**
 *
 * @author sergio
 */
public class triangulacionVoraz
{

    public int[][] poligono;
    private double [][] costosTriangulacion;

    public double [][] cuerdasMatriz;

    private int[][] copia;
    private int numNodos;
    Hashtable valorK = new Hashtable();

    public double minimaCuerda = 0.0;



    public triangulacionVoraz(int[][] poligono, int numNodos)
    {
        this.poligono=poligono;
        copia=new int [numNodos-1][numNodos];
        this.numNodos=numNodos;
        costosTriangulacion=new double [numNodos][numNodos];

        cuerdasMatriz = new double [numNodos-3][3];
        for(int i=0; i<numNodos-3; i++)
        {
            for(int j=0; j<3; j++)
            {
                cuerdasMatriz[i][j] = 0.0;
            }
        }
    }




    public double longitudCuerda(int x1, int y1, int x2, int y2, int nodo1, int nodo2)
    {
        double longitud=0.0;

        if(nodo1==0 || nodo1==numNodos-1)
        {
            if(nodo2==nodo1+1 || nodo2==nodo1-1 || nodo2==0 || nodo2==numNodos-1 )
            {
                return 0.0;
            }
        }
        if(nodo1-1==nodo2 || nodo1+1==nodo2)
        {
            return 0.0;
        }

        longitud=Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));

//        System.out.println(longitud);
        return longitud;
    }


    public void llenandoTabla()
    {
        for(int fila = 0; fila < numNodos; fila++)
        {
            for(int columna = 0; columna < numNodos; columna++)
            {
                costosTriangulacion[fila][columna] = longitudCuerda(poligono[fila][0], poligono[fila][1], poligono[columna][0], poligono[columna][1], fila, columna);
            }
        }
    }

    public void almacenArreglo()
    {
        double minimo = 1000000;
        int nodo1 =0;
        int nodo2 =0;

        while(verificarContenido())
        {
            for(int fila = 0; fila < numNodos-2; fila++)
            {
                for(int col = 0; col < numNodos; col++)
                {
                    if(col > fila+1 && costosTriangulacion[fila][col] != 0)
                    {
                        if(costosTriangulacion[fila][col] < minimo)
                        {
                            minimo = costosTriangulacion[fila][col];
                            nodo1 = fila;
                            nodo2 = col;


                        }


                    }
                }
            }
            costosTriangulacion[nodo1][nodo2] = 0;
//            System.out.println("nodo1: "+nodo1+", nodo2: "+nodo2+",minimo: "+minimo);
            agregarCuerda(nodo1, nodo2, minimo);
            minimo = 1000000;
        }

         
    }

    public boolean verificarContenido()
    {
        boolean respuesta = false;

        for(int fila = 0; fila < numNodos-2; fila++)
        {
            for(int columna = 0; columna < numNodos; columna++)
            {

                if(columna > fila+1)
                {
                    
                    if(costosTriangulacion[fila][columna] > 0)
                    {
                        respuesta = true;
                        return respuesta;
                    }
//                  costosTriangulacion[fila][columna];

                }
            }
        }

        return respuesta;
    }

    public void dibujarTabla()
    {
        for(int fila = 0; fila < numNodos; fila++)
        {
            for(int columna = 0; columna < numNodos; columna++)
            {
                System.out.print(costosTriangulacion[fila][columna]+" ");
//                costosTriangulacion[fila][columna];
            }
            System.out.println();
        }
    }

    private void agregarCuerda(int nodo1, int nodo2, double minimo)
    {

        for(int i = 0; i < numNodos-3; i++)
        {
            if(cuerdasMatriz[i][0] == 0 && cuerdasMatriz[i][1] == 0 && cuerdasMatriz[i][2] == 0)
            {
                System.out.println("nodo1: "+nodo1+", nodo2: "+nodo2+",minimo: "+minimo);
                cuerdasMatriz[i][0] = nodo1;
                cuerdasMatriz[i][1] = nodo2;
                cuerdasMatriz[i][2] = minimo;
                i = numNodos-3;
            }
            else
            {
                if(cruzarCuerda(cuerdasMatriz[i][0], cuerdasMatriz[i][1], nodo1, nodo2) == false)
                {
                    i = numNodos-3;
                }
            }
        }
    }

    private boolean cruzarCuerda(double nodo1, double nodo2, int nodoX, int nodoY)
    {
        boolean seCruzanCuerdas;
        int contador = 0;

        if(nodo2 == 0)
        {
            nodo2 = numNodos;
        }

        for(double i = nodo1; i != nodo2-1; i--)
        {
            if(i < 0)
            {
                i = numNodos-1;
            }

            if(i == nodoX)
            {
                contador++;
            }
            if(i == nodoY)
            {
                contador++;
            }

           

        }

        if(contador == 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public double valorSolucion()
    {
        double valor = 0.0;
        for(int filas = 0; filas < numNodos-3; filas++)
        {
            valor = valor+cuerdasMatriz[filas][2];
        }
        return valor;
    }

    public double [][] getMatrizSolucion()
    {
        return cuerdasMatriz;
    }

}
