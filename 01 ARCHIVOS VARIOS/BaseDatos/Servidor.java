
import java.net.*;
import java.io.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Servidor extends JFrame
{
	private ServerSocket SocketServidor;
	private ObjectOutputStream salida;
	private ObjectInputStream entrada;
	private Socket conexion;
	private JTextArea areaMensajes;
	private JTextField areaEnvio;
	private JScrollPane scroller;

	public Servidor()
	{
		super("Servidor");

		Container contenedor = getContentPane();

		areaEnvio = new JTextField();
		ManejaEvento manejador = new ManejaEvento();
		areaEnvio.addActionListener(manejador);
		areaMensajes = new JTextArea();
		System.out.println("El servidor escucha por el puerto 1234");
		
		scroller = new JScrollPane(areaMensajes);
		scroller.getVerticalScrollBar().setValue(scroller.getVerticalScrollBar().getMaximum());

		contenedor.add(areaEnvio, BorderLayout.NORTH);
		contenedor.add(scroller, BorderLayout.CENTER);

		setVisible(true);
		setSize(300,700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void ejecutarServidor() 
	{
		try
		{
			SocketServidor = new ServerSocket(1234,10);
			while(true)
			{
				try 
				{
					esperarConexion();  // Paso 2: esperar una conexion.
					obtenerFlujos();    // Paso 3: establecer flujos de entrada y salida.
					procesarConexion(); // Paso 4: procesar la conexion.
				}
		// procesar excepcion EOFException cuando el cliente cierre la conexion 
				catch ( EOFException excepcionEOF )
				{
					System.err.println("El servidor termino la conexion");
				}
				finally
				{
					cerrarConexion();   // Paso 5: cerrar la conexion.             
				}
			}
		} 
		catch ( IOException excepcion )
		{
			excepcion.printStackTrace();
		}
	}

	private void esperarConexion() throws IOException
	{
		implementarMensaje( "Esperando una conexion\n" );
		conexion = SocketServidor.accept(); 
	}

	private void obtenerFlujos() throws IOException
	{
		salida = new ObjectOutputStream( conexion.getOutputStream() );// establecer flujo de salida para los objetos
		salida.flush(); // vaciar bufer de salida para enviar informacion de encabezado
		entrada = new ObjectInputStream( conexion.getInputStream() );// establecer flujo de entrada para los objetos
		implementarMensaje( "\nSe han establecido los flujos de E/S\n" );
	}

	private void enviarDatos( String mensaje )
	{
		try
		{
			salida.writeObject( "SERVIDOR>>> " + mensaje );
			salida.flush();
			implementarMensaje("\nSERVIDOR>>> "+mensaje);
		}
		catch ( IOException excepcionES )
		{
		implementarMensaje( "\nError al escribir objeto" );
		}
	}

	private void procesarConexion() throws IOException
	{
		String mensaje="Conexion exitosa";
		enviarDatos(mensaje);	 
		do
		{ // procesar los mensajes enviados por el cliente
		
			// leer el mensaje y mostrarlo en pantalla
			try
			{
				mensaje = (String)entrada.readObject();
				implementarMensaje( "\n" + mensaje );
			}
			catch ( ClassNotFoundException excepcionClaseNoEncontrada )
			{
				implementarMensaje( "\nSe recibio un tipo de objeto desconocido" );
			}
		}
		while( !mensaje.equals( "CLIENTE>>> exit" ) );
	}

	private void cerrarConexion()
	{
		implementarMensaje( "\nCerrando conexion" );
		try
		{
			salida.close();
			entrada.close();
			conexion.close();
		}
		catch( IOException excepcionES )
		{
			excepcionES.printStackTrace();
		}
	}

	private void implementarMensaje(String msg)
	{
		areaMensajes.append(msg);
	}


	private class ManejaEvento implements ActionListener
	{
		public void actionPerformed(ActionEvent evento)
		{
			enviarDatos(areaEnvio.getText());
			areaEnvio.setText("");
		}
	}

	public static void main(String[] args)
	{
		Servidor server = new Servidor();
// 		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.ejecutarServidor();
	}

}

