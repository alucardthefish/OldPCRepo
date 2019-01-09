
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClienteBaja extends JFrame
{
	private JTextArea areaTexto;
	private JTextField areaInterac;
	private String mensaje = "";

	public ClienteBaja()
	{
                super("Cliente");

		Container container = getContentPane();

		areaInterac = new JTextField();
		Manejador manejador = new Manejador();
		areaInterac.addActionListener(manejador);

		areaTexto = new JTextArea();
		
		JScrollPane scroll = new JScrollPane(areaTexto);
		scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());   // esta linea de codigo se supone que es lo que me haria bajar el scroll, segun lo averiguado, pero no me funciona


		container.add(areaInterac, BorderLayout.NORTH);
		container.add(scroll, BorderLayout.CENTER);

		setVisible(true);
		setSize(300,700);

	}

	private class Manejador implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			verMensajes(areaInterac.getText());
			areaInterac.setText("");
		}
	}

	public void verMensajes(final String mens)
	{
		areaTexto.append("\n"+mens);
	}

	public static void main(String args[])
	{
		Cliente cliente = new Cliente();
		cliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}