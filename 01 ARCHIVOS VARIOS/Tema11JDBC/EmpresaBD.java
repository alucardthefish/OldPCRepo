import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

 public class EmpresaBD extends JFrame implements ActionListener{

   Container contenedor;
   FlowLayout miFlow;
   JLabel LNombre, LApellido, LCodigo, LEdad, LNacimiento, LNIT;
   JTextField TFNombre, TFApellido, TFCodigo, TFEdad, TFNacimiento, TFNIT;
   JButton BAdicionar, BPregunta1;
   JPanel panel1, panel2, tab1, tab2;
   JTabbedPane panelConFichas;
   ManejaBD manejador=new ManejaBD();

   EmpresaBD(){
 
       super(".:: Manejo de empleados ::.");  
       LNombre = new JLabel("Nombre"); 
       LApellido = new JLabel("Apellido"); 
       LCodigo = new JLabel("NIT"); 
       LEdad = new JLabel("Edad"); 
       LNacimiento = new JLabel("Nacimiento"); 
       
       TFNombre = new JTextField(10); 
       TFApellido = new JTextField(10); 
       TFCodigo = new JTextField(10); 
       TFEdad = new JTextField(10); 
       TFNacimiento = new JTextField("aaaa-mm-dd",10); 

       BAdicionar = new JButton(" Ingresar Datos ");
       BAdicionar.addActionListener(this); 

       panel1=new JPanel(new GridLayout(5,2));       
       panel1.add(LCodigo);             
       panel1.add(TFCodigo);                    
       panel1.add(LNombre);             
       panel1.add(TFNombre);             
       panel1.add(LApellido);             
       panel1.add(TFApellido);          
       panel1.add(LEdad);             
       panel1.add(TFEdad);             
       panel1.add(LNacimiento);             
       panel1.add(TFNacimiento); 
       
       tab1 = new JPanel(new FlowLayout());      
       tab1.add(panel1);                          
       tab1.add(BAdicionar); 
              
       panel2=new JPanel(new GridLayout(1,2));              
       LNIT = new JLabel("NIT");
       TFNIT = new JTextField(10);       
       panel2.add(LNIT); 
       panel2.add(TFNIT);        
       BPregunta1 = new JButton(" Consultar BD ");
       BPregunta1.addActionListener(this); 

       tab2 = new JPanel(new FlowLayout());
       tab2.add(panel2);
       tab2.add(BPregunta1);       
       
       panelConFichas = new JTabbedPane();
       panelConFichas.addTab( "Ingreso de datos", null, tab1, "Ingreso de datos" ); 
       panelConFichas.addTab( "Consulta", null, tab2, "Consulta" ); 
       
       contenedor = getContentPane(); 
       miFlow = new FlowLayout();
       contenedor.setLayout(miFlow); 

       contenedor.add(panelConFichas);
              
       manejador.crearConexion();       
       setSize(410,200);
       setVisible( true );

 }
 
 public void actionPerformed(ActionEvent evento){
    
 if (evento.getSource()==BAdicionar){
   manejador.crearConexion();  
   String n=TFNombre.getText();
   String a=TFApellido.getText();
   String c=TFCodigo.getText();
   String e=TFEdad.getText();
   String d=TFNacimiento.getText();
   
   String consulta;
   consulta = "INSERT INTO empleados VALUES(\'"+ c + "\',\'" + n + "\',\'" + a + "\'," + e + ",\'" + d + "\');";       
   System.out.println(consulta);
  
   manejador.insertarTuplas(consulta);

 }
 
  if (evento.getSource()==BPregunta1){
   manejador.crearConexion();
   String consulta;
   consulta = "SELECT * FROM empleados WHERE nit=" + TFNIT.getText();
   System.out.println(consulta);
  
   manejador.consultarBD(consulta);
  
  }
 }
  public static void main(String a[]){ 
      EmpresaBD aplicacion = new EmpresaBD();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
  }
 
 
  
}

