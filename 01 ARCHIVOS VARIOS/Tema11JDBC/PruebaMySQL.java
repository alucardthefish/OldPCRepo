
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PruebaMySQL{
    
 public PruebaMySQL(){
    
  DefaultTableModel modelo = new DefaultTableModel();
  JTable  tabla = new JTable(modelo);
  JScrollPane scroll = new JScrollPane(tabla);

  modelo.addColumn("nombre");
  modelo.addColumn("propietario");
  modelo.addColumn("especie");
  modelo.addColumn("sexo");
  modelo.addColumn("nacimiento");
  modelo.addColumn("fallecimiento");


  try{ 
    Class.forName("com.mysql.jdbc.Driver").newInstance();
  }catch (ClassNotFoundException cnfe) {
    System.out.println( "No encontró el driver" );
    cnfe.printStackTrace();
    return ;
  }catch(Exception e){
    return;
  }

  Connection conexion=null;      
  
  try
  {          
    conexion = DriverManager.getConnection ("jdbc:mysql://malpelo.univalle.edu.co/oscarbed", "oscarbed","oscarbed");
  }catch (Exception e){
    System.out.println( "No se pudo crear la conexión" );
    e.printStackTrace();
    return;
  }       
      
  try{
    // Se crea un Statement, para realizar la consulta
    Statement s = conexion.createStatement();
            
    // Se realiza la consulta. Los resultados se guardan en el ResultSet rs
    ResultSet rs = s.executeQuery ("select * from mascotas");
            
    // Se recorre el ResultSet, mostrando por pantalla los resultados.
    while (rs.next()){
      System.out.println (rs.getString("nombre"));

      // Se crea un array que será una de las filas de la tabla.
      Object [] fila = new Object[6]; // Hay tres columnas en la tabla

      // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
      for (int i=0;i<6;i++){
        fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.
      }
   
      // Se añade al modelo la fila completa.
      modelo.addRow(fila); 
   }
            
   // Se cierra la conexión con la base de datos.
   conexion.close();
 }catch (Exception e){
    e.printStackTrace();
 }

  JOptionPane.showMessageDialog(null, scroll);
}
    
 public static void main(String[] args){
    new PruebaMySQL();
 }
    
}
