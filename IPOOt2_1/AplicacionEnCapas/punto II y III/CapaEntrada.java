import javax.swing.JOptionPane;



public class CapaEntrada

{


		
		private String opciones [] ;
		
		private String salida ; 
		private String opcion ;
		private String mensaje;
		private double primero,segundo;


		

		public  CapaEntrada()
		{
		 primero=segundo=0.0;
		salida = new String (""); 
		opcion = new String ("");
		mensaje = new String("QuE operaciOn desea ejecutar?.");
		opciones = new String [5];
		opciones [0]  = "Sumar";
		opciones [1]  ="Restar";
		opciones [2]  ="Multiplicar";
		opciones [3]  ="Dividir";
		opciones [4]  ="Terminar";
		
		}
		
public   void  ejecutar ()

{
				
		while (true)
		{
				do{
				   
					opcion=(String)JOptionPane.showInputDialog(null,///null por ahora
            				"QuE operación desea realizar",///mensaje
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
				else { if (opcion.equals("Restar")) {salida="- ";}
					else { if (opcion.equals("Multiplicar")) {salida="* ";}
						else {salida="/ ";} } } }
					
				
				primero=Double.parseDouble(
					JOptionPane.showInputDialog(null,"Dame el primer nUmero"));
					
				segundo=Double.parseDouble(
					JOptionPane.showInputDialog(null,"Dame el segundo nUmero"));					
					
				salida+=primero+" "+segundo;	
				System.out.println(salida);	
			}
			
		}			







	public static void main(String args[])
	{
	
	CapaEntrada llam=new CapaEntrada();
	llam.ejecutar();
		
	}//main	
	
}//capaJavacl


