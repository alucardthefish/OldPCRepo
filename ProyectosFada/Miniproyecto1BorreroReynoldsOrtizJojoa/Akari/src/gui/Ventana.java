package gui;
import logica.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import algoritmos.Algoritmos;
import algoritmos.AlgoritmoIngenuo;
import algoritmos.AlgoritmoGuiado;
import algoritmos.AlgoritmoIngenuo;
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
    private javax.swing.JMenuItem itmMnuAcercade;
    private javax.swing.JMenuItem itmMnuAyuda;
    private javax.swing.JMenuItem itmMnuIngenua;
    private javax.swing.JMenuItem itmMnuOptima;
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
    private Tablero tablero;//Instancia de la clase tablero que permite graficar 
    private int[][] matrizEntrada;
    AlgoritmoIngenuo objAlIngenuo= new AlgoritmoIngenuo();
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
        itmMnuSalir = new javax.swing.JMenuItem();
        mnuHerramientas = new javax.swing.JMenu();
        itmMnuReset = new javax.swing.JMenuItem();
        itmMnuIngenua = new javax.swing.JMenuItem();
        itmMnuOptima = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        itmMnuAcercade = new javax.swing.JMenuItem();
        itmMnuAyuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("::Akari::");
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

	itmMnuIngenua.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, java.awt.event.InputEvent.SHIFT_MASK));
	itmMnuIngenua.setText("Ingenua");
	itmMnuIngenua.addActionListener(this);
	itmMnuIngenua.setEnabled(false);
	mnuHerramientas.add(itmMnuIngenua);

	itmMnuOptima.setAccelerator( KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
	itmMnuOptima.setText("Optima");
	itmMnuOptima.addActionListener(this);
	itmMnuOptima.setEnabled(false);
	mnuHerramientas.add(itmMnuOptima);

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
        
        pRespuesta.jButton1.addActionListener(this);
	
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
		itmMnuIngenua.setEnabled(estado);
		itmMnuOptima.setEnabled(estado);
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
		if(e.getSource()==itmMnuIngenua){
			//System.out.println("\n\nAlgoritmo Ingenuo");
                        TiempoEjecucion t = new TiempoEjecucion();//tiempo
                        t.iniciar();//tiempo
                        AlgoritmoIngenuo algoritmo= new AlgoritmoIngenuo(lectorDArchivos.getMatrizFinal(),lectorDArchivos.getTotalNegrasNumero(),lectorDArchivos.getFilas(),lectorDArchivos.getColumnas());
                        this.objAlIngenuo= algoritmo;
                        System.out.println("entro");
                        objAlIngenuo.crearSolucion();
                        System.out.println("salio");
                        pRespuesta.jTextField1.setText(""+objAlIngenuo.totalCombinaciones);
                        pRespuesta.jTextField2.setText(""+objAlIngenuo.combinacionesCorrectas);
                        matrizEntrada=objAlIngenuo.entrada;
                        
 //                       tablero = new Tablero(lectorDArchivos.getMatrizFinal(),lectorDArchivos.getFilas(),lectorDArchivos.getColumnas());
//                        AlgoritmoIngenuo objAlIngenuo= new AlgoritmoIngenuo(matrizPeso,2,5,4);

//                        int[][] ma = objAlIngenuo.crearSolucion();
//                        for(int i=0;i<ma.length;i++){
//                                for(int j=0;j<ma[0].length;j++)
//                                System.out.print(ma[i][j]+" ");
//                            System.out.println();
//                        }

//                        final int[][] matrizSalida= new matrizAdyacencia().transformar(matrizEntrada,objAlIngenuo.getSolucion());
                        t.terminar();
                        System.out.println("Tiempo total: "+t.getTiempo());
//                        lectorDArchivos=new ManejadorDeArchivo(chooser.getSelectedFile());
//						lectorDArchivos.crearMatrizDesdeArchivo();
						habilitarHerramientas(true);
                }
                if(e.getSource()==pRespuesta.jButton1){
                    objAlIngenuo.imprimirSolucion(Integer.parseInt(pRespuesta.jTextField3.getText()));
                     
			tablero = new Tablero(matrizEntrada,lectorDArchivos.getFilas(),lectorDArchivos.getColumnas());
                        int[][] entradaTablero = tablero.iluminarTablero();
                        JFrame intFrameTexto = new JFrame();
                        intFrameTexto = tablero.pintarTablero(entradaTablero);
		}
		if(e.getSource()==itmMnuOptima){
//                    Algoritmos objAlOptimo = new AlgoritmoOptimo(matrizEntrada,lectorDArchivos.objEnrrutamientoMulticast.getCostos(),lectorDArchivos.objEnrrutamientoMulticast.getObjetivos());
                    TiempoEjecucion t = new TiempoEjecucion();//tiempo
                    t.iniciar();//tiempo
//                    objAlOptimo.crearSolucion();
//                    int[][] matrizSa=objAlOptimo.getSolucion();

//                    final int[][] matrizSalida = m.transformar(matrizEntrada, matrizSa);
                    t.terminar();
                    System.out.println("Tiempo total: "+t.getTiempo());
		}

		if(e.getSource()==itmMnuAbrir){
			JFileChooser chooser = new JFileChooser("./entrada");
			int returnVal = chooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				 lectorDArchivos=new ManejadorDeArchivo(chooser.getSelectedFile());
						lectorDArchivos.crearMatrizDesdeArchivo();
                                                lectorDArchivos.leerArchivoEntrada(chooser.getSelectedFile().getPath());
                                                tablero = new Tablero(lectorDArchivos.getMatrizFinal(),lectorDArchivos.getFilas(),lectorDArchivos.getColumnas());
                                                int[][] entradaTablero = tablero.iluminarTablero();
                                                JFrame intFrameTexto = new JFrame();
                                                intFrameTexto = tablero.pintarTablero(entradaTablero);
					txtRutaArchivo.setText(chooser.getSelectedFile().getPath());
						habilitarHerramientas(true);
                                              lblAyuda.setText("<html><ul>Ayuda<li>Ejecuta un algoritmo</li><li>Ingenuo:May+F5</li><li>Optima:F5</li></ul></html>");
			}
		}
	}
}
