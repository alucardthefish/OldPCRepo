import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class Grid
{
   static Random generator = new Random();
   static int    nTrials = 0;

/**
 * Main program allows for either command-line arguments or user dialog
 * to determine the number of queens and the number of parallel threads
 * to work on the problem.
 */
   public static void main ( String[] args )
   {
      Scanner console = new Scanner(System.in);
      int[]  solution;
      long   start;
      double elapsed;
      int    nQueens;
      PrintWriter outFile = null;

      System.out.print ("Number of queens:   ");
      if ( args.length < 1 )
         nQueens = console.nextInt();
      else
      {  nQueens = Integer.parseInt(args[0]);
         System.out.println(nQueens);
      }

      // Timed computation of ONE solution:

      start = System.currentTimeMillis();
      solution = gridSearch(nQueens);
      //Agregado por mi
      for(int i = 0; i < nQueens; i++)
      {
      	System.out.println("Solucion: "+solution[i]);
      }
      //Fin de agregado por mi
      elapsed = System.currentTimeMillis() - start;

      if ( valid(solution, nQueens) )
         System.out.println("Valid solution found in " +
            elapsed + " msec.");
      else
         System.out.println("ERROR --- invalid solution took " +
            (System.currentTimeMillis() - start) + " msec.");
      System.out.println (nTrials + " passes required.");
   }

   static int[] gridSearch(int n)
   {
      int[] solution = new int[n];
      boolean fail = true;

      while ( fail )
      {
         boolean[][]blocked = new boolean[n][n];   // Initially all false
         int row, col, k, d;

         nTrials++;

         for ( row = 0; row < n; row++ )
         {
            col = generator.nextInt(n);
            for ( k = 0; blocked[row][col] && k < n ; k++ )
               col = (col+1) % n;
            if ( blocked[row][col] )
               break;
            solution[row] = col;
            for ( k = row; k < n; k++ )
            {
               blocked[k][col] = true;
               // row - col
               d = k - (row - col);
               if ( d >= 0 && d < n )
                  blocked[k][d] = true;
               // row + col
               d = (row + col) - k;
               if ( d >= 0 && d < n )
                  blocked[k][d] = true;
            } // end for k
         } // end for row
         fail = row < n;
      } // end while fail
      return solution;
   }

// Verify (or reject) the validity of the board of indicated size.
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
         if ( (diagChk[row-board[row]+size-1]||antiChk[row+board[row]]) )
            return false;
         else
//          mark (row, board[row], true);
            diagChk[row-board[row]+size-1] =
               antiChk[row+board[row]] = true;
      return true;
   }
}