
import javax.swing.*;

public class ProgramaDos
{
	static int var = 1;

	public static void main(String[] args)
	{
		int miArray[] = new int[] {1,2,4,8,16};
		ProgramaDos miObjeto = new ProgramaDos();
		ProgramaDos miObjeto2 = new ProgramaDos();
		//int resultado = miObjeto.getPosicion(8, miArray);

		JOptionPane.showMessageDialog(null, ""+miObjeto.var+" "+miObjeto2.var);

		miObjeto2.var = 9;

		JOptionPane.showMessageDialog(null, ""+miObjeto.var+" "+miObjeto2.var);

		System.exit(0);
	}

	// Obtengo la posición de "num" en el array "arrayNums"
	int getPosicion (int num, int[] arrayNums)
	{
		for (int i=0; i!=arrayNums.length; i++)
			if (arrayNums[i]==num)
				return i;
		return -1;
	}
}
