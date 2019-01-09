import java.io.*;
import java.sql.*;
public class mysql_dbc {
	static Connection db;
	public static void main(java.lang.String[] args) throws IOException {
		String consulta;
		ResultSet rs;
		String valido = "";
		boolean returnexec = false;
		Statement stmt;
		boolean error_loading_driver=false;
		try {			
			Class.forName("com.mysql.jdbc.Driver");
                    }catch (ClassNotFoundException cnfe){
                            error_loading_driver=true;
                        }		
		if (!error_loading_driver) {	
			boolean connected=false;
			try {
 				System.out.println ("Conectando a la base de datos!");
				/* Obtenemos una conexión a la base de datos */
				
				db = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", ""); 				
				connected=true;
                            } catch (SQLException se) {	
                                    System.out.println ("No se ha podido conectar a la base.");
                                }
			if (connected) {
				System.out.println ("Ya se ha conectado a la base de datos");
				try {
					stmt = db.createStatement();
					consulta = "SELECT * FROM usuarios";
                                        //INSERT INTO usuarios (login, pass, nombre) VALUES ('luz', '567', 'Luz Estela')
                                        //System.out.println("Digite el SQL: ");
                                        //BufferedReader br;
                                        //br  = new BufferedReader(new InputStreamReader(System.in)); 
                                        //consulta = br.readLine(); 
                                        rs = stmt.executeQuery(consulta);
                                        //stmt.executeUpdate(consulta);
					while( rs.next() ) {
                                             valido = rs.getString(1);
                                             System.out.println (valido);
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
                            System.out.println ("No se ha podido encontrar el driver JDBC para MySql.");
                        }
	}
}