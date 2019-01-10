package gui;
import logica.*;
import java.awt.event.*;

import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import algoritmos.triangulacionDinamica;
import algoritmos.triangulacionVoraz;
import java.awt.GridLayout;
/**
**********************************************************************************************<br/>
* Interfaz grafiaca de la aplicacion 
* @author jhoreyse
**********************************************************************************************
*/
public class Ventana extends  JFrame implements ActionListener {
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel escritorioPanel;
    private javax.swing.JMenuItem itmMnuAbrir;
    private javax.swing.JMenuItem itmMnuGuardar;
    private javax.swing.JMenuItem itmMnuAcercade;
    private javax.swing.JMenuItem itmMnuAyuda;
    private javax.swing.JMenuItem itmMnuVoraz;
    private javax.swing.JMenuItem itmMnuDinamica;
    private javax.swing.JMenuItem itmMnuReset;
    private javax.swing.JMenuItem itmMnuSalir;
    private javax.swing.JMenuBar jmnuBarra;
    private javax.swing.JLabel lblAyuda;
    private javax.swing.JLabel lblRutaArchivo;
    private javax.swing.JLabel totalDeCombinaciones;
    private javax.swing.JLabel imprimirSolucion;
    private javax.swing.JLabel totalSoluciones;
    private javax.swing.JMenu mnuArchivo;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuHerramientas;
    private javax.swing.JPanel pnlInformacion;
    private javax.swing.JTextField txtRutaArchivo;
    private javax.swing.JTextField txtCalcular;
    private javax.swing.JButton botonCalcular;
    private ManejadorDeArchivo lectorDArchivos;
    private panelRespuesta pRespuesta;
    private DibujarPoligonos poligono;
    private DibujarPoligonoTriangulado poligonoT;
    private int[][] matrizEntrada;
    String [][]archivoGuardar;
    String fila;
    private triangulacionVoraz tVoraz;
    private triangulacionDinamica tDinamica;

    // End of variables declaration//GEN-END:variables
    
    /** Creates new form Ventana */
    public Ventana() {
	initComponents();
    }
    private void initComponents() {
        pRespuesta= new panelRespuesta();
	escritorioPanel = new javax.swing.JPanel();
        pnlInformacion = new javax.swing.JPanel();
        lblRutaArchivo = new javax.swing.JLabel();
        totalDeCombinaciones = new javax.swing.JLabel();
        imprimirSolucion = new javax.swing.JLabel();
        totalSoluciones = new javax.swing.JLabel();
        txtRutaArchivo = new javax.swing.JTextField();
        txtCalcular = new javax.swing.JTextField();
        botonCalcular = new javax.swing.JButton();
        lblAyuda = new javax.swing.JLabel();
        jmnuBarra = new javax.swing.JMenuBar();
        mnuArchivo = new javax.swing.JMenu();
        itmMnuAbrir = new javax.swing.JMenuItem();
        itmMnuGuardar = new javax.swing.JMenuItem();
        itmMnuSalir = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        itmMnuReset = new javax.swing.JMenuItem();
        itmMnuVoraz = new javax.swing.JMenuItem();
        itmMnuDinamica = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        itmMnuAcercade = new javax.swing.JMenuItem();
        itmMnuAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::Triangulación de Poligonos::");
        setResizable(false);

        escritorioPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Panel de resumen de resultados"));
        
        escritorioPanel.setAutoscrolls(true);
        
        escritorioPanel.setLayout(new GridLayout(5,30));
        imprimirSolucion.setText("Solucion");
        totalSoluciones.setText("Total Soluciones:");
        totalDeCombinaciones.setText("Total Combinaciones");
        
        txtCalcular.setText("Ingresar Index combinacion");
        botonCalcular.setText("Calcular");
        

       escritorioPanel.add(imprimirSolucion);
       escritorioPanel.add(totalSoluciones);
       escritorioPanel.add(totalDeCombinaciones);
       
       escritorioPanel.add(txtCalcular);
       escritorioPanel.add(botonCalcular);
//       escritorioPanel.add(totalDeCombinaciones);
              
        pnlInformacion.setBackground(java.awt.Color.white);

        lblRutaArchivo.setText("Ruta del Archivo: ");

        txtRutaArchivo.setEditable(false);
        txtRutaArchivo.setToolTipText("");

       
        lblAyuda.setText("<html><ul>Ayuda<li>Carge un Archivo</li><li>Archivo->Abrir</li><li>Ctrl+O</li></ul></html>");

        javax.swing.GroupLayout pnlInformacionLayout = new javax.swing.GroupLayout(pnlInformacion);
        pnlInformacion.setLayout(pnlInformacionLayout);
        pnlInformacionLayout.setHorizontalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addContainerGap()
                    .addGroup(pnlInformacionLayout.createSequentialGroup()
                       .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblRutaArchivo))
                        .addGroup(pnlInformacionLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                         .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)    
                    .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(lblAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)
                
        ));
        pnlInformacionLayout.setVerticalGroup(
            pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlInformacionLayout.createSequentialGroup()
                .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlInformacionLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(pnlInformacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblRutaArchivo)
                            .addComponent(txtRutaArchivo, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlInformacionLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblAyuda, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                
        ));

	mnuArchivo.setText("Archivo");
	mnuArchivo.setToolTipText("menuArchivo");


	itmMnuAbrir.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
	itmMnuAbrir.setText("Abrir");
	itmMnuAbrir.addActionListener(this);
	mnuArchivo.add(itmMnuAbrir);
        
        itmMnuGuardar.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        itmMnuGuardar.setText("Guardar");
	itmMnuGuardar.addActionListener(this);
	mnuArchivo.add(itmMnuGuardar);
        
	itmMnuSalir.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
	itmMnuSalir.setText("Salir");
	itmMnuSalir.addActionListener(this);
	mnuArchivo.add(itmMnuSalir);

	jmnuBarra.add(mnuArchivo);

	mnuHerramientas.setText("Herramientas");

	itmMnuReset.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
	itmMnuReset.setText("Reset");
	itmMnuReset.addActionListener(this);
	itmMnuReset.setEnabled(false);
	mnuHerramientas.add(itmMnuReset);

	itmMnuVoraz.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.SHIFT_MASK));
	itmMnuVoraz.setText("Voraz");
	itmMnuVoraz.addActionListener(this);
	itmMnuVoraz.setEnabled(false);
	mnuHerramientas.add(itmMnuVoraz);

	itmMnuDinamica.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
	itmMnuDinamica.setText("Dinamico");
	itmMnuDinamica.addActionListener(this);
	itmMnuDinamica.setEnabled(false);
	mnuHerramientas.add(itmMnuDinamica);

	jmnuBarra.add(mnuHerramientas);

	mnuAyuda.setText("Ayuda");

	itmMnuAcercade.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
	itmMnuAcercade.setText("Acerca de");
	itmMnuAcercade.addActionListener(this);
	mnuAyuda.add(itmMnuAcercade);

	itmMnuAyuda.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F1, 0));
	itmMnuAyuda.setText("Ayuda");
	itmMnuAyuda.addActionListener(this);
	mnuAyuda.add(itmMnuAyuda);
	jmnuBarra.add(mnuAyuda);
	setJMenuBar(jmnuBarra);   
	
	 javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                    .addComponent(pnlInformacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlInformacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pRespuesta, javax.swing.GroupLayout.DEFAULT_SIZE, 358, Short.MAX_VALUE)
                .addContainerGap())
        );
	pack();
	setDefaultCloseOperation( WindowConstants.EXIT_ON_CLOSE);
	setVisible(true);
    }//
	public void habilitarHerramientas(boolean estado){
		itmMnuReset.setEnabled(estado);
		itmMnuVoraz.setEnabled(estado);
		itmMnuDinamica.setEnabled(estado);
	}
        
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==itmMnuSalir){
			System.exit(0);
		}
		if(e.getSource()==itmMnuReset){
//			intFrameSalida.setVisible(false);
//			intFrameTexto.setVisible(false);
			habilitarHerramientas(false);
		}
		if(e.getSource()==itmMnuVoraz){
                 
                        tVoraz = new triangulacionVoraz(lectorDArchivos.getMatrizFinal(),lectorDArchivos.getFilas());
			tVoraz.llenandoTabla();
                        tVoraz.almacenArreglo();
                        archivoGuardar=new String[(lectorDArchivos.getFilas()-3)*2][1];
                        pRespuesta.jTextField1.setText(""+tVoraz.valorSolucion());
                        pRespuesta.jTextField2.setText("Voraz");
                       fila=""+(lectorDArchivos.getFilas()-3);
                         fila=fila+" "+tVoraz.valorSolucion()+"  ";
                       poligonoT= new DibujarPoligonoTriangulado(lectorDArchivos.getVectorX(), lectorDArchivos.getVectorY(), lectorDArchivos.getFilas(),lectorDArchivos.getMatrizFinal(),  tVoraz.getMatrizSolucion());
                       archivoGuardar=poligonoT.matrizString();
                        habilitarHerramientas(true);
                }
		if(e.getSource()==itmMnuDinamica){
                    tDinamica = new triangulacionDinamica (lectorDArchivos.getMatrizFinal(),lectorDArchivos.getFilas());
                        tDinamica.costoMinimo();
                        archivoGuardar=new String[(lectorDArchivos.getFilas()-3)*2][1];
                         pRespuesta.jTextField1.setText(""+tDinamica.costoTriangulacionMinima());
                         pRespuesta.jTextField2.setText("Dinamica");
                         tDinamica.crearSolucionOptima(0, lectorDArchivos.getFilas());
                         fila=""+(lectorDArchivos.getFilas()-3);
                         fila=fila+" "+tDinamica.costoTriangulacionMinima();
                         poligonoT= new DibujarPoligonoTriangulado(lectorDArchivos.getVectorX(), lectorDArchivos.getVectorY(), lectorDArchivos.getFilas(),lectorDArchivos.getMatrizFinal(),  tDinamica.solucionOptima());
                          archivoGuardar=poligonoT.matrizString();
                         habilitarHerramientas(true);
		}

        if(e.getSource()==itmMnuGuardar){
			    JFileChooser selectorArchivo= new JFileChooser();
    File primero = new File("MatricesGrafos");
   	selectorArchivo.setCurrentDirectory(primero);		
    PrintStream flujoSalida = null;
      
	int resultado = selectorArchivo.showSaveDialog(this);

	if (resultado == selectorArchivo.APPROVE_OPTION)
	{
	 File nombreArchivo = selectorArchivo.getSelectedFile();
	 
	 try{
       flujoSalida= new PrintStream(new FileOutputStream(nombreArchivo+".txt") );
     } 
     catch (IOException ex){ System.out.println("Error al crear el archivo"); }

     try{
                        
                        flujoSalida.println( fila );
                        
                       for(int i=0; i<archivoGuardar.length; i++){
                        flujoSalida.println(archivoGuardar[i][0]);
                       }
                        flujoSalida.flush();
                        flujoSalida.close();
                       } catch(Exception ej) {System.out.println("Error al escribir en el archivo");}

     JOptionPane.showMessageDialog(this,"El archivo ha sido guardado","",JOptionPane.INFORMATION_MESSAGE);
    }
  }   		
		
        
		if(e.getSource()==itmMnuAbrir){
			JFileChooser chooser = new JFileChooser("./entrada");
			int returnVal = chooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				 lectorDArchivos=new ManejadorDeArchivo(chooser.getSelectedFile());
						lectorDArchivos.crearMatrizDesdeArchivo();
                                                lectorDArchivos.leerArchivoEntrada(chooser.getSelectedFile().getPath());
                                                JFrame intFrameTexto = new JFrame();
                                                poligono = new DibujarPoligonos(lectorDArchivos.getVectorX(), lectorDArchivos.getVectorY(), lectorDArchivos.getFilas());
//                                                intFrameTexto = tablero.pintarTablero(entradaTablero);
					txtRutaArchivo.setText(chooser.getSelectedFile().getPath());
						habilitarHerramientas(true);
                                              lblAyuda.setText("<html><ul>Ayuda<li>Ejecuta un algoritmo</li><li>Voraz:May+F5</li><li>Dinamico:F5</li></ul></html>");
			}
		}
	}
}
