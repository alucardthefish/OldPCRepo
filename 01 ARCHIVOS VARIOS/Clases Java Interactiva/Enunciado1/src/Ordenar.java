/* Enunciado1.java */


import java.awt.Graphics;
import javax.swing.*;

public class Ordenar extends JApplet
{
   int a, b, c, d;

   int temporal1, temporal2, temporal3, temporal4, temporal5, temporal6;

  public void init()
  {
	  
	String nume1, nume2, nume3, nume4;
	
	nume1 = JOptionPane.showInputDialog("Ingrese el primer valor:");
	nume2 = JOptionPane.showInputDialog("Ingrese el segundo valor:");
	nume3 = JOptionPane.showInputDialog("Ingrese el tercer valor:");
	nume4 = JOptionPane.showInputDialog("Ingrese el cuarto valor:");
	 
	a = Integer.parseInt(nume1);
	b = Integer.parseInt(nume2);
	c = Integer.parseInt(nume3);
	d = Integer.parseInt(nume4);
	
    if(a>b)
    {
      temporal1=a;
      a=b;
      b=temporal1;
    }
    if(a>c)
    {
    	temporal5=a;
    	a=c;
    	c=temporal5;
    }
    if(a>d)
    {
    	temporal3=a;
    	a=d;
    	d=temporal3;
    }
    if(b>c)
    {
    	temporal4=b;
    	b=c;
    	c=temporal4;
    }
    if(b>d)
    {
    	temporal6=b;
    	b=d;
    	d=temporal6;
    }
    if(c>d)
    {
      temporal2=c;
      c=d;
      d=temporal2;
    }
    
    //Profesor yo lo hice con seis if's, por que con 5 no lo pude hacer.
   
  }

	public void paint(Graphics g)
	{
		super.paint( g );
		g.drawString("Estos son los valores ordenados:",25,40);
		g.drawString("a: "+a,25,70);
		g.drawString("b: "+b,25,100);
		g.drawString("c: "+c,25,130);
		g.drawString("d: "+d,25,160);
	}

}
