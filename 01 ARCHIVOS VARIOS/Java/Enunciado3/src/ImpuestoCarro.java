import java.awt.Graphics;
import javax.swing.*;

public class ImpuestoCarro extends JApplet
{
	int impuesto = 200000;
	int impuesto1, impuesto2, impuesto3;
	int estimadoFinal, impuestoFinal;
	
	public void init()
	{
		String fechaCarro;
		String numeCilindro;
		String carroTipo;
		String servicioTipo;
	
		int modeloCarro;
		int cilindraje;
		int tipoCarro;
		int tipoServicio;
	
	
		fechaCarro = JOptionPane.showInputDialog("Digite el modelo del automovil:");
		numeCilindro = JOptionPane.showInputDialog("Introduzca el cilindraje de su automovil:");
	
		modeloCarro = Integer.parseInt(fechaCarro);
		cilindraje = Integer.parseInt(numeCilindro);
	
		carroTipo = JOptionPane.showInputDialog("Introduzca el numero correspondiente a su vehiculo:" +
				"\n 1- Vehiculo" +
				"\n 2- Campero" +
				"\n 3- Camioneta" +
				"\n 4- Bus" +
				"\n 5- Camion");
	
		tipoCarro = Integer.parseInt(carroTipo);
		
	//aqui va codigo de carroTipo
	
		servicioTipo = JOptionPane.showInputDialog("Introduzca el codigo correspondiente al servicio de su vehiculo" +
				"\n 1- Publico" +
				"\n 2- Particular");
	
		tipoServicio = Integer.parseInt(servicioTipo);
	
	
		if(cilindraje>3000)
		{
			int nveces = ((cilindraje-3000)/100);
			impuesto1 = 11000*nveces;
		}
		else
		{
			impuesto1 = 0;
		}
		if(tipoCarro == 2 || tipoCarro == 3)
		{
			impuesto2 = (impuesto*15)/100;
		}
		else
		{
			impuesto2 = 0;
		}
	
		estimadoFinal = (impuesto+impuesto1+impuesto2);
	
		if(modeloCarro == 2006 || modeloCarro == 2007)
		{
			impuesto3 = ((estimadoFinal*15)/100);
		}
	
		impuestoFinal = (impuesto+impuesto1+impuesto2-impuesto3);
		
	}
	
	
	public void paint(Graphics g)
	{
		super.paint( g );
		g.drawString("!! RECIBO DE IMPUESTO VEHICULAR ANUAL ¡¡:" ,25 ,25);
		g.drawString("Impuesto General de Vehiculos: "+ impuesto, 25 , 70);
		g.drawString("Impuesto estimado sobre el cilindraje: "+ impuesto1, 25 , 85);
		g.drawString("Impuesto respecto al tipo de vehiculo: "+ impuesto2, 25, 100);
		g.drawString("Bono de descuento por 15% del impuesto final: "+ impuesto3, 25, 115);
		g.drawString("Valor Total del impuesto vehicular: "+ impuestoFinal, 25 , 160);
		
	}
	
	
	
}
