/**
 * Probabilistic generation of ONE solution to the N-queens problem.
 *
 * Author:  Timothy Rolfe
 */
import java.io.*;
import java.util.Scanner;

public class QueenLasVegas
{
   static java.util.Random generator = new java.util.Random();

   static final boolean VERBOSE  = false;
   static final boolean LONG_RUN = false;

   // Single copy for ALL recursive function calls
   static boolean[] diagChk = null, antiChk = null;

// Quick-and-dirty exception handling --- ship them back to OpSys
   static public void main ( String[] args ) throws Exception
   {
      int   nPasses,
            pass = 0,
            k;
      int   size;
      int[] board;
      long  start;
      String lineIn = "i.in";

      if ( args.length > 0 )
         lineIn = args[0];
      File f = new File (lineIn);
      FileReader fis = new FileReader(f);
      Scanner inp = new Scanner (fis);

      nPasses = inp.nextInt();

      for ( pass = 1; pass <= nPasses; pass++ )
      {
         size = inp.nextInt();

         board = new int[size];

      /* Initial permutation generated. */
         for (k = 0; k < size; k++)
            board[k] = k;

         while ( !build( board, size ) )
            ;

         printBoard(board, size);
      }
   }

// Las Vegas algorithm to build a POSSIBLY valid board for the
// N-queens problem:  random permutation, and then validation
// or NOT (hence the boolean value returned --- true only if
// the board discovered is a valid solution).
   static public boolean build( int[] board, int size )
   {
      int row, nxt, k;
      // Take advantage of initialization to false
      boolean[] diagChk = new boolean[2*size-1],
                antiChk = new boolean[2*size-1];

      shuffleArray ( board, size );

//    mark (0, board[0], true);
      diagChk[0-board[0]+size-1] = true;
      antiChk[0+board[0]] = true;

      for ( row = 1; row < size; row++ )
      {
         nxt = row + 1;
      // If the current row is invalid, try swapping with succeeding
      // rows until there is a valid one --- or NONE work.
         while ( (diagChk[row-board[row]+size-1] || antiChk[row+board[row]]) )
         {
            if (nxt == size)
               return false;      // Failed to find a good replacement
            if ( VERBOSE )
               System.out.println("Swap " + row + " and " + nxt);
            swap ( board, row, nxt++ );
         }
//       mark (row, board[row], true);
         diagChk[row-board[row]+size-1] = true;
         antiChk[row+board[row]] = true;
         if ( VERBOSE )
            System.out.println ("Good down to " + row);
      }
      return true;
   }

// Verify (or reject) the validity of the board of indicated
// size.
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
         if ( (diagChk[row-board[row]+size-1] || antiChk[row+board[row]]) )
            return false;
         else
//          mark (row, board[row], true);
            diagChk[row-board[row]+size-1] = antiChk[row+board[row]] = true;
      return true;
   }

// Show the state of the board --- simplest possible format.
// Keep track of line remaining and break as needed.
   static void printBoard ( int[] board, int size )
   {
      int remaining = 65;

      System.out.println(size);
      for ( int k = 0; k < size; k++ )
      {  String out = " " + board[k];

         if ( out.length() > remaining )
         {
            System.out.print ("\n" + out);
            remaining = 65;
         }
         else
            System.out.print (out);
         remaining -= out.length();
      }
      System.out.println();
   }

   static void swap ( int[] x, int p, int q )
   {  int temp = x[p];  x[p] = x[q];  x[q] = temp;  }

/**
 * Shuffle the entire array, using the class scope generator
 *
 * See Rolfe, Timothy.  "Algorithm Alley:  Randomized Shuffling",
 * Dr. Dobb’s Journal, Vol. 25, No. 1 (January 2000), pp. 113-14.
 */
   static void shuffleArray ( int [] x, int lim )
   {  while ( lim > 1 )
      {  int item;
         int save = x[lim-1];
         item = generator.nextInt(lim);
         x[--lim] = x[item];                // Note predecrement on lim
         x[item] = save;
      } // end while
   } // end shuffleArray()
}
