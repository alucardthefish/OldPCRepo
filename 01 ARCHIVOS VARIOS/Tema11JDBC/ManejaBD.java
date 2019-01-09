
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ManejaBD{

  Connection conexion;
  DefaultTableModel modelo;
  JTable  tabla;
  JScrollPane scroll;
     
 public ManejaBD(){    
	crearModelo();
 }
 
 public void crearModelo(){
    modelo = new DefaultTableModel();
    tabla = new JTable(modelo);
    scroll = new JScrollPane(tabla);
    modelo.addColumn("nit");
    modelo.addColumn("nombre");
    modelo.addColumn("apellido");
    modelo.addColumn("edad");
    modelo.addColumn("nacimiento");	
 }
 
 public void crearConexion(){
 
  try { 
   Class.forName("org.postgresql.Driver").newInstance();
  }catch (ClassNotFoundException cnfe) {
      System.out.println( "No encontró el controlador" );
  }catch (Exception e) {
      System.out.println( "Error al crear cargar el controlador" );
  }
      
  conexion=null;      
  try{          
    conexion = DriverManager.getConnection ("jdbc:postgresql:BDEmpresa","sergio","thefish");
  }catch (Exception e){
    System.out.println( "No se pudo crear la conexión" );
    return ;
  } 
            
 }
   
  public void consultarBD(String query){
  
  crearModelo();  
  crearConexion();
  
  try{
       
    Statement s = conexion.createStatement();
    ResultSet rs = s.executeQuery(query);
       
    while (rs.next())
    {
      Object[] fila = new Object[5];

      for (int i=0;i<5;i++){
       fila[i] = rs.getObject(i+1); 
      }
      modelo.addRow(fila); 
    }
            
     conexion.close();
  }
  catch (Exception e){
    e.toString();
  }
  JOptionPane.showMessageDialog(null, scroll);
 } 


 public void insertarTuplas(String query){
 
 crearConexion();
 System.out.println(query);
  	
  try{       
    Statement s = conexion.createStatement();
    s.executeUpdate(query);    
  }
  catch (Exception e){
    e.toString();
  }
   cerrarConexion();	
 }
  
 public void cerrarConexion(){ 	
  
   try{       
 	 conexion.close();
   }
   catch (Exception e){
    e.toString();
   }
 }   
   
}
