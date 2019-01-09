import java.io.*;
import java.sql.*;
public class pgsql_jdbc {
	static Connection db;
	public static void main(java.lang.String[] args) throws IOException {
		String consulta;
		ResultSet rs;
		String valido = "";
		boolean returnexec = false;
		Statement stmt;
		boolean error_loading_driver=false;
                try {			
			Class.forName("org.postgresql.Driver");
                    } catch (ClassNotFoundException cnfe) {
                            error_loading_driver=true;
                        }		
		if (!error_loading_driver) {	
			boolean connected=false;
			try {
 				System.out.println ("Conectando a la base de datos!");
				/* Obtenemos una conexión a la base de datos */	
				db = DriverManager.getConnection("jdbc:postgresql:Ejemplo","sergio","thefish"); 				
				connected=true;
                            } catch (SQLException se) {	
                                    System.out.println ("No se ha podido conectar a la base.");
                                }
			if (connected)	{
				System.out.println ("Ya se ha conectado a la base de datos");
				try {
					stmt = db.createStatement();
					consulta = "SELECT nombre FROM usuarios WHERE codigo == 0731354;";

                                        BufferedReader br;
                                        br  = new BufferedReader(new InputStreamReader(System.in)); 
                                        consulta = br.readLine(); 

                                        rs = stmt.executeQuery(consulta);
					while( rs.next() ) {
					      valido = rs.getString(2);
					      System.out.println (valido);
                                        } 
					rs.close();
					/* Cerramos la conexión a la base de datos */
					db.close();
					System.out.println ("Base de datos cerrada");
				    } catch (SQLException se) {
						System.out.println ("No se ha podido cerrar la base.");
					}
			}
		} else  { 
                            System.out.println ("No se ha podido encontrar el driver JDBC para PostGreSQL.");
                        }
	}
}