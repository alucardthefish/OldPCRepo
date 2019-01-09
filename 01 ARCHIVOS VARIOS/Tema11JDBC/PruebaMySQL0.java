
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PruebaMySQL0{
    
 private JTextArea area;
 private JScrollPane scroll;
    
 public PruebaMySQL0(){
    
  area = new JTextArea(10,30);
  scroll = new JScrollPane(area);
  
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
    
    Statement s = conexion.createStatement();
    ResultSet rs = s.executeQuery ("select * from mascotas");
            
    while (rs.next()){
      area.append((String)rs.getObject(1));
      area.append("\t" + (String)rs.getObject(2));
      area.append("\t" + (String)rs.getObject(3));
      area.append("\t" + (String)rs.getObject(4));
      area.append("\t" + (Date)rs.getObject(5));
      area.append("\t" + (Date)rs.getObject(6));
   
      area.append("\n");
    }
            
    conexion.close();
 }catch (Exception e){
    e.printStackTrace();
 }

  JOptionPane.showMessageDialog(null, scroll);
}
    
 public static void main(String[] args){
    new PruebaMySQL0();
 }
    
}
