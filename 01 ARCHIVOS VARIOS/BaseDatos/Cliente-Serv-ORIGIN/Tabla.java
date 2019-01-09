// Tabla.java

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;


public class Tabla extends JFrame
{

	DefaultTableModel tablilla;
	JTable table;
	String dias[] = {"Lunes","Martes","Miercoles","Jueves","Viernes","Sabado","Domingo"};

	public Tabla()
	{
		Container contenedor = getContentPane();
		contenedor.setLayout(new FlowLayout());

		tablilla = new DefaultTableModel();
		
		for(int i = 0; i<dias.length; i++)
		{
			tablilla.addColumn(dias[i]);
		}

		for(int i = 0; i < 6; i++) {

			JButton rows[] = new JButton[7];
			tablilla.addRow(rows);

		}

		table = new JTable(tablilla);
		table.setPreferredScrollableViewportSize(new Dimension(500, 96));
		table.setSelectionMode(0);

		contenedor.add(table);
		setVisible(true);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String args[])
	{
		Tabla tabla = new Tabla();
	}




}