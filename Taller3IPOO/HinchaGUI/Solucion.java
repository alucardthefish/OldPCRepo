public class Solucion
{
  //se arma el mensaje
	public String armarMensaje(String nombre, int edad, String equipo)
	{
		String resultado = new String ("");
		resultado= "Me llamo "+nombre+", tengo "+edad+" a�os. ";
		resultado+= "\nSoy hincha del "+equipo;
		return resultado;
	}
}