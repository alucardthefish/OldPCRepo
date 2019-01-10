import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//UsaSolucionGUI es una ventana (JFrame)  y es una implementación de ActionListener
public class UsaSolucionGUI extends JFrame 
implements ActionListener
{
	//los objetos auxiliares
	private int edad;
	private String nombre;
	private String equipo;
	
	//el objeto de la clase base
	private Solucion objSolucion;
	
	//los que  "SIEMPRE" van
	private Container contenedor;
	private FlowLayout miFlow;
	
	///los relativos al problema y a la interfaz especifica  
	private JLabel etqNombre, etqEdad, etqEquipo;
	private JTextField tefNombre, tefEdad, tefEquipo, tefMensaje;
	private JButton botMensaje;
	private JPanel panCentral, panInferior;
	private String mensaje;
	
	//constructor
	public UsaSolucionGUI()
	{
		//el título
		super("HinchaGUI");		
		//la operación que cierra la ventana
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//el objeto de la capa lógica (que provee la solución)
		objSolucion =new Solucion();
		
		//inicialización de las variables auxiliares
		edad=0;
		nombre=new String("");
		equipo= new String("");
		
		//las líneas de "rigor"
		contenedor=getContentPane();
		miFlow = new FlowLayout();
		contenedor.setLayout(miFlow);
		
		//los páneles asociados a las grillas
		panCentral = new JPanel(new GridLayout(3,2));
		panInferior = new JPanel(new GridLayout(2,1));
		
		//la creación de los elementos de la GUI
		etqNombre = new JLabel("Nombre");
		etqEdad= new JLabel("Edad");
		etqEquipo=new JLabel("Equipo");
		
		tefNombre=new JTextField(12);
		tefEdad =new JTextField(12);
		tefEquipo=new JTextField(12);
		tefMensaje=new JTextField(50);
		
      botMensaje= new JButton("Mensaje");
		
		//determinar qué objetos desencadenarán acciones (agregarlos a la escucha)
		botMensaje.addActionListener(this);
		
		//acomodar los objetos en los páneles
		panCentral.add(etqNombre);
		panCentral.add(tefNombre);
		
		panCentral.add(etqEdad);
		panCentral.add(tefEdad);
		
		panCentral.add(etqEquipo);
		panCentral.add(tefEquipo);
		
		panInferior.add(botMensaje);
		panInferior.add(tefMensaje);
		
		contenedor.add(panCentral);
		contenedor.add(panInferior);
		
		//ajustar el tamaño y hacer visible
		pack();
		setVisible(true);
	}
	
	public void limpiarCampos()
	{
	   //borra lo que que esté escrito en los campos de texto
		tefNombre.setText("");
		tefEdad.setText("");
		tefEquipo.setText("");
		tefMensaje.setText("");
	}


	public boolean capturarDatosUsuario( )
	{
	   //bloque try catch ("intente"  y "capture") 
		try//intente
		{						
			nombre=tefNombre.getText( );
			edad=Integer.parseInt(tefEdad.getText( ));
			equipo=tefEquipo.getText( );
			
			//si el nombre o el equipo están vacios se lanza una exception
			if (nombre.equals("") || equipo.equals(""))
			{
				throw new Exception("Los campos requeridos están vacios.");
			}
		}
		catch(Exception error)//capture
		{
			JOptionPane.showMessageDialog(this,
				"Por favor ingrese los datos correctamente.\n"+error.toString(),
				"Error",JOptionPane.ERROR_MESSAGE);	
			limpiarCampos();	
			return false;
		}
		return true;
	}
	
	//metodo declarado en ActionListener
	public void actionPerformed(ActionEvent evento)
	{
	   //si no hay datos retorne
		if (capturarDatosUsuario()==false)
		{
			return;
		}
		//determinar que el evento esté asociado a un botón particular
		if (evento.getSource()==botMensaje)
		{
		  //se envía petición al objeto de la capa lógica y se almacena
		  //el resultado 
			mensaje= objSolucion.armarMensaje(nombre,edad,equipo);
			tefMensaje.setText(mensaje);
			JOptionPane.showMessageDialog(this, mensaje);			
			limpiarCampos();
		}
		 
	}
	
	public static void main (String args[])
	{
	   //tan pronto se intancia la GUI esta queda lista para
		//trabajar
		UsaSolucionGUI aplicacion=new UsaSolucionGUI();
	}
}