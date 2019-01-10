import javax.swing.JOptionPane;

public class CapaEntrada
{
	public static void main(String args[])
	{
		String mensaje = new String("QuE operaciOn desea ejecutar?.");
		
		String opciones [] = {"Sumar","Restar","Terminar"};
		
		String salida = new String (""); 
		String opcion = new String ("");
		
		double d_alfa,d_beta;
		 d_alfa=d_beta=0.0;
		
		while (true)
		{
				do{
				   
					opcion=(String)JOptionPane.showInputDialog(null,///null por ahora
            				"QuE operaciOn desea realizar",///mensaje
					"Menu Desplegable",///tiUlo
					JOptionPane.QUESTION_MESSAGE, ///icono en el mensaje
					null,///null por ahora
					opciones,///opciones que componen el menu
					opciones[0]);///opciOn inicial
					
				  ///opcion serA null si el usuario pulsa un botOn diferente de aceptar
				}while(opcion==null);	
				
		
			if (opcion.equals("Terminar"))
			{
				System.out.println('S');
				System.exit(0);
			}
			else
			{
				if (opcion.equals("Sumar")) {salida="+ ";}
				else {salida="- ";}
				
				d_alfa=Double.parseDouble(
					JOptionPane.showInputDialog(null,"Dame el primer nUmero"));
					
				d_beta=Double.parseDouble(
					JOptionPane.showInputDialog(null,"Dame el segundo nUmero"));					
					
				salida+=d_alfa+" "+d_beta;	
				System.out.println(salida);	
			}//else
			
		}//while			
		
	}//main	
	
}//capaJava