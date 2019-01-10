import java.io.*;
import javax.swing.*;



public class CapaSalida
{
   	
 


 public void inter() throws IOException
   {
      BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
      String cadena = new String("");
      JTextArea area=new JTextArea(5,5);
      JScrollPane scroll= new JScrollPane(area);
 
 			cadena  = input.readLine();
      while(cadena.equals("EXIT")==false)
			{
				area.append(""+cadena+"\n");
				JOptionPane.showMessageDialog(null,scroll);
				cadena  = input.readLine();
			}
			System.exit(0);
    }
	




 public final static void main( String args[] )throws IOException
 
{

CapaSalida llama=new CapaSalida();
llama.inter();

}





}//class


