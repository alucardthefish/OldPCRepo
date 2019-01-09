import javax.swing.*;

public class Arreglos 
{
	public static void main(String a[])
	{
		String arreglo[]= new String [10];
		JTextArea area = new JTextArea(10,20);
		JScrollPane scroll = new JScrollPane(area);
		
		for(int i=0;i<=9;i=i+1)
		{
			arreglo[i]=JOptionPane.showInputDialog("Digite un dato para la posicion "+i);
		}
		
		for(int i=0;i<=9;i=i+1)
		{
			area.append(" "+arreglo[i]);
		}
		
		JOptionPane.showMessageDialog(null, scroll);
		System.exit(0);
	}
}
