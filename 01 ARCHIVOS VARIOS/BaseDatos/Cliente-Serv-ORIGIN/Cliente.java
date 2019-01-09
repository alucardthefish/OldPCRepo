
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Cliente extends JFrame
{
	//Socket socket;	
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private Socket cliente;
	private JTextArea areaTexto;
	private JTextField areaInterac;
	private String mensaje = "";
	private JScrollPane scroll;

	public Cliente()
	{
		super("Cliente");

		Container container = getContentPane();

		areaInterac = new JTextField();
		Manejador manejador = new Manejador();
		areaInterac.addActionListener(manejador);

		areaTexto = new JTextArea();
		
		scroll = new JScrollPane(areaTexto);
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());


		container.add(areaInterac, BorderLayout.NORTH);
		container.add(scroll, BorderLayout.CENTER);
// 		container.add(new JScrollPane(areaTexto), BorderLayout.CENTER);

		

		setVisible(true);
		setSize(300,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void verMensajes(final String mens)
	{
		areaTexto.append(mens);
	}

	private void ejecutarCliente()
	{
		
			try
			{
				conectarAServidor();  // Paso 1: crear un socket para realizar la conexion
				obtenerFlujos();      // Paso 2: establecer los flujos de entrada y salida
				procesarConexion();   // Paso 3: procesar la conexion
			}
	// el servidor cerro la conexion
			catch ( EOFException excepcionEOF )
			{
				System.err.println( "El cliente termino la conexion" );
			}
	// procesar los problemas que pueden ocurrir al comunicarse con el servidor
			catch ( IOException excepcionES )
			{
				excepcionES.printStackTrace();
			}
			finally
			{
				cerrarConexion(); // Paso 4: cerrar la conexion
			}
	}

	private void conectarAServidor() throws IOException
	{
		verMensajes("Intentando realizar conexion\n" );
     // crear Socket para realizar la conexion con el servidor
		cliente = new Socket("localhost", 1234 );      
	}

	private void obtenerFlujos() throws IOException
	{
		salida = new ObjectOutputStream( cliente.getOutputStream() );// establecer flujo de salida para los objetos
		salida.flush(); // vaciar bufer de salida para enviar informacion de encabezado
		entrada = new ObjectInputStream( cliente.getInputStream() );      // establecer flujo de entrada para los objetos
		verMensajes( "\nSe establecieron los flujos de E/S\n" );
	}


	private void procesarConexion() throws IOException
	{
		mensaje="Este es el cliente";
		enviarDatos(mensaje);
		do
		{
			try
			{
				mensaje = (String)entrada.readObject();
				verMensajes("\n"+mensaje);
			}
			catch(ClassNotFoundException ioex)
			{
				verMensajes("\nSe recibio un tipo de objeto desconocido");
			}
		}
		while(!mensaje.equals("SERVIDOR>>> exit"));
	} // fin del metodo procesarConexion

	private void cerrarConexion()
	{
		verMensajes( "\nCerrando conexion" );
		try
		{
			salida.close();
			entrada.close();
			cliente.close();
			System.exit(0);
		}
		catch( IOException excepcionES )
		{
			excepcionES.printStackTrace();
		}
	}

	private  void enviarDatos( String mensaje )
	{
   // enviar objeto al servidor
		try
		{
			salida.writeObject( "CLIENTE>>> " + mensaje );
			salida.flush();
			verMensajes("\nCLIENTE>>> "+mensaje);
        //System.out.println( "\nCLIENTE>>> " + mensaje );
		}
    // procesar los problemas que pueden ocurrir al enviar el objeto
		catch ( IOException excepcionES )
		{
			verMensajes( "\nError al escribir el objeto" );
		}
	}

	private class Manejador implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			enviarDatos(areaInterac.getText());
			areaInterac.setText("");
		}
	}

	public static void main(String[] args)
	{
		Cliente cliente = new Cliente();
// 		cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cliente.ejecutarCliente();
	}

}
