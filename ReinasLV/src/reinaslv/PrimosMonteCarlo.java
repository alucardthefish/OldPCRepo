/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reinaslv;

import java.util.Scanner;
import java.lang.*;
import java.math.*;

/**
 *
 * @author Administrador
 */
public class PrimosMonteCarlo
{  
  
  /**
   * Intenta averiguar si un numero es primo por el metodo de Miller-Rabin
   * @param n Numero
   * @param t Factor Seguridad cantidad de iteraciones comprobando el numero
   * @return Booleano indicando si es primo
   */
public static boolean primoMR(int n, int t)
  {
    boolean compuesto = true;
    int m=n-1; int s=0;
    int r,a,b;
    while ((m % 2) == 0)
    {
      s=s+1; m=m/2;   // s = veces que 2 divide a n-1
    }
    r=m;
    int i=1;
    while (compuesto && (i<t))
    {
      a=(int) Math.floor(2+(Math.random()* (n-2))); //a= aleatorio 2..n-2
      if (PrimosMonteCarlo.mcd(a,n)!=1)
      {
        i=t; //acabamos -> es compuesto
      }
      else
      {
        b=(int) PrimosMonteCarlo.expRapida(a,r,n);       // b = a^r mod n
        if ((b!=1) && (b!=-1) )
        {
          for (int j=0; j<=s-1; j++)
          {
            b=(int) PrimosMonteCarlo.expRapida(b,2,n);   // b = b^2 mod n
          }
        }
        compuesto = (b!=1) && (b!=-1);             // sigue sin ser primo
      }
      i++;
    }
    return !compuesto;
  }
  
  
  /**
   * Halla el maximo comun divisor de dos numeros
   */
  public static double mcd(double x,double y )
  {
    double a,b;
    a = x;
    b = y;
    if ((a<1) || (b<0))
      return 1;
    else {
    while( a != b )
    {
      if( a < b )
      {
        b = b - a;
      } else {
        a = a - b;
      }
    }
    return(a);
    }
  }
  
  
  /**
   * Realiza la operacion: num^b mod n  de forma eficiente
   */
  public static double expRapida(double num,double b,double n)
  {
    double z, x, resul;
    z = b;
    x = num;
    resul = 1;

    while (z>0)
    {
      if ((z%2)== 1)
      {
        resul = (resul*x) % n;
        z--;
      }else
      {
        x = (x*x) % n;
        z = java.lang.Math.floor(z/2);
      }
    }
    return resul;
  }
    
  /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
        Scanner console = new Scanner(System.in);
        
        int numeroPrimo;
        int factSeguridad;
        
        System.out.print ("Ingresa el numero a verificar si es un primo: ");
        if ( args.length < 1 )
        {
            numeroPrimo = console.nextInt();
        }
        else
        { 
            numeroPrimo = Integer.parseInt(args[0]);
            System.out.println(numeroPrimo);
        }
        
        System.out.print ("Ingresa el numero de repeticiones: ");
        if ( args.length < 1 )
        {
            factSeguridad = console.nextInt();
        }
        else
        { 
            factSeguridad = Integer.parseInt(args[0]);
            System.out.println(factSeguridad);
        }
        
        //if(primoMR(numeroPrimo))
        if(primoMR(numeroPrimo,factSeguridad))
        {
            System.out.println("Muy posiblemente el numero: "+numeroPrimo+" es primo");
        }
        else
        {
            System.out.println("Muy posiblemente el numero: "+numeroPrimo+" no es primo");
        }
        
    }
}
