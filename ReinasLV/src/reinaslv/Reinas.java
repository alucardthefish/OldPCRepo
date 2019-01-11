/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reinaslv;

import java.util.Scanner;
import java.util.Random;
import java.io.*;

/**
 *
 * @author Administrador
 */
public class Reinas
{
    static Random generator = new Random();
    static int nTrials = 0;
    
    static int[] reinasLV(int n)
    {
      int[] solution = new int[n];
      boolean fail = true;

      while ( fail )
      {
         boolean[][]blocked = new boolean[n][n];   // Inicialmente todas en false
         int row, col, k, d;

         nTrials++;

         for ( row = 0; row < n; row++ )
         {
            col = generator.nextInt(n);
            for ( k = 0; blocked[row][col] && k < n ; k++ )
            {
               col = (col+1) % n;
            }
            if ( blocked[row][col] ) //Si la posicion esta amenzada por una reina no la agregamos a la solucion y volvemos a ejecutar
            {
               break;
            }
            solution[row] = col;
            for ( k = row; k < n; k++ )
            {
               // Marcando las filas hacia abajo de la reina asignada
               blocked[k][col] = true;
               // Marcando la diagonal descendiente hacia la derecha
               d = k - (row - col);
               if ( d >= 0 && d < n )
               {
                  blocked[k][d] = true;
               }
               // Marcando la diagonal descendiente hacia la izquierda
               d = (row + col) - k;
               if ( d >= 0 && d < n )
               {
                   blocked[k][d] = true;
               }
            } // end for k
         } // end for row
         fail = row < n;
      } // end while fail
      return solution;
    }
    
   // Verifica o rechaza la validez de un tablero de tamaño especificado
   static public boolean valid( int[] board, int size )
   {
      int row, nxt, k;
      // Take advantage of initialization to false
      boolean[] diagChk = new boolean[2*size-1],
                antiChk = new boolean[2*size-1];

//    mark (0, board[0], true);
      diagChk[0-board[0]+size-1] = true;
      antiChk[0+board[0]] = true;

      for ( row = 1; row < size; row++ )
      {
         if ( (diagChk[row-board[row]+size-1]||antiChk[row+board[row]]) )
         {
             return false;
         }
         else
         {
//          mark (row, board[row], true);
            diagChk[row-board[row]+size-1] =
               antiChk[row+board[row]] = true;
         }
      }
      return true;
   }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        
        Scanner console = new Scanner(System.in);
        int[]  solution;
        long   start;
        double elapsed;
        int    nQueens;
        PrintWriter outFile = null;

        System.out.print ("Dimension del tablero o numero de reinas:   ");
        if ( args.length < 1 )
        {
            nQueens = console.nextInt();
        }
        else
        {  nQueens = Integer.parseInt(args[0]);
         System.out.println(nQueens);
        }

      // Tiempo inicial cuando se va hallar la solucion:
        start = System.currentTimeMillis();
        solution = reinasLV(nQueens);
        //Tiempo que tardo para hallar la solucion
        elapsed = System.currentTimeMillis() - start;
        
      //Imprimiendo las posiciones de las reinas de la solucion
        
        System.out.println("Solucion Encontrada:");
        for(int i = 0; i < nQueens; i++)
        {
            System.out.println("Reina en Fila["+i+"] Columna: ["+solution[i]+"]");
        }

        if ( valid(solution, nQueens) )
        {
            System.out.println("Solucion valida encontrada en " + elapsed + " msec.");
        }
        else
        {
         System.out.println("ERROR --- solucion invalida encontrada en " +
            (System.currentTimeMillis() - start) + " msec.");
        }
      System.out.println ("Se necesitaron: "+nTrials + " chequeos hasta encontrar una solucion.");
        
    }
}
