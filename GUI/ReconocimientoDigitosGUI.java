//GUI Project

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.util.zip.*;
import java.io.*;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ReconocimientoDigitosGUI extends JFrame implements ActionListener {

	private JLabel etiqueta_resultado, imageToAnalize;
	private JTextField numDigitsBDText, fecha, horaT, lugarT;
	private JButton cargarImgBtn, nuevoBtn, bdBtn, ejecutarBtn, guardar, cancelar;
	private JFrame marco;
	private JTextArea resultadosArea;
	private FileNameExtensionFilter filtroImagen;
	private String ruta;
	private String blankImgPath = "C:/Documents and Settings/Administrador/Escritorio/A_blank_flag.png";
	private static final Object[] entrenamientos = new Object[] { 100, 200, 300, 400, 500, 600, 700, 800, 850 };

	//private Control obj;


	public ReconocimientoDigitosGUI() {

		super("Reconocimiento de digitos escritos a mano");

		Container c = getContentPane();
		c.setLayout(new FlowLayout());

		etiqueta_resultado = new JLabel("Resultado: ");

		numDigitsBDText = new JTextField(10);
		numDigitsBDText.setEditable(false);

		fecha = new JTextField(10);
		fecha.setEditable(false);

//-------------------------------Botones------------------------------------------------
		cargarImgBtn = new JButton("Cargar Imagen");
		cargarImgBtn.addActionListener(this);
		cargarImgBtn.setMnemonic('C');
		cargarImgBtn.setToolTipText("Cargar la imagen a reconocer");

		nuevoBtn = new JButton("Nuevo >>");
		nuevoBtn.addActionListener(this);
		nuevoBtn.setMnemonic('N');
		nuevoBtn.setToolTipText("Iniciar un nuevo reconocimiento");

		bdBtn = new JButton("Cargar Entrenamiento");
		bdBtn.addActionListener(this);
		bdBtn.setMnemonic('E');
		bdBtn.setToolTipText("Seleccionar cantidad de imagenes de entrenamiento");

		ejecutarBtn = new JButton("Ejecutar");
		ejecutarBtn.addActionListener(this);
		ejecutarBtn.setMnemonic('R');
		ejecutarBtn.setToolTipText("Inicia el reconocimiento de digito");
//----------------------------Botones--------------------------------------------------
		

		JPanel p1 = new JPanel(new GridLayout(1,1,25,5));
		p1.add(new JLabel("Base de entrenamiento por cada digito:"));
		p1.add(numDigitsBDText);


		JPanel p3 = new JPanel(new BorderLayout());
		p3.add(p1, BorderLayout.WEST);

		JPanel p4 = new JPanel(new GridLayout(1,4,3,3));
		p4.add(bdBtn);
		p4.add(cargarImgBtn);
		p4.add(ejecutarBtn);
		p4.add(nuevoBtn);

		JPanel p5 = new JPanel(new BorderLayout(3,3));
		p5.add(etiqueta_resultado, BorderLayout.WEST);

		JPanel panelVisual = new JPanel(new GridLayout(1, 2, 50, 50));
		
		resultadosArea = new JTextArea(10,10);
		resultadosArea.setText("Resultado: ");
		resultadosArea.setEditable(false);
		Font fuente=new Font("Dialog", Font.BOLD, 10);
        resultadosArea.setFont(fuente);

		imageToAnalize = new JLabel();
		imageToAnalize.setBackground(Color.WHITE);
		//imageToAnalize.setSize(28,28);
		ImageIcon imagen =new ImageIcon(blankImgPath);
		Icon icono = new ImageIcon(imagen.getImage().getScaledInstance(150, 150, Image.SCALE_DEFAULT));
		imageToAnalize.setIcon(icono);

		panelVisual.add(resultadosArea);
		panelVisual.add(imageToAnalize);




		JPanel p6 = new JPanel(new BorderLayout(10,10));
		p6.add(p3, BorderLayout.NORTH);
		p6.add(panelVisual, BorderLayout.CENTER); //meter las dos cosas de visualizacion
		p6.add(p4, BorderLayout.SOUTH);

		JPanel p7 = new JPanel(new BorderLayout(5,5));
		p7.add(p6, BorderLayout.NORTH);
		p7.add(p5, BorderLayout.SOUTH);

		JPanel p8 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p8.add(p7);

		c.add(p8);

		habilitarBtns(1);

		//setSize(550,260);

		pack();
		setResizable(false);
		show();


	}// public calendario

	static { // Obtiene la apariencia de la interfaz del sistema y la muestra en el programa

	    try {

	      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	    }// look and feel

	    catch (Exception e) {}

  	}// catch


	public void actionPerformed(ActionEvent e) {

		//System.out.println("Estamos en actionPerformed");
		if(e.getSource() == bdBtn){
			eventoCargarBD();
		}
		if(e.getSource() == cargarImgBtn){
			eventoCargarImagen();
		}
		if(e.getSource() == ejecutarBtn){
			eventoEjecutar();
		}
		if(e.getSource() == nuevoBtn){
			eventoBotonNuevo();
		}

	}// actionPerformed

	public void eventoCargarBD(){
		System.out.println("Cargando bd");


		Object trainingSetNumObj = JOptionPane.showInputDialog(null,"Ingresa la cantidad de imagenes para entrenamiento", "Cargando Base de Datos", JOptionPane.QUESTION_MESSAGE, null, 
			entrenamientos, entrenamientos[2]);

		int trainingSetNum = (Integer) trainingSetNumObj;


		//obj = new Control(trainingSetNum);
		//obj.llenarBase();
		//obj.llenarMatrices();
		System.out.println("Se cargo una base de datos de "+trainingSetNum+" imagenes por cada digito");
		habilitarBtns(2);


	}

	public void eventoCargarImagen(){
		System.out.println("Se undio el boton cargar imagen");
		JFileChooser explorador = new JFileChooser();
		explorador.setCurrentDirectory(new File("C:/Documents and Settings/Administrador/Escritorio/Proyecto_metodos/test/"));
		
		//Le cambiamos el titulo
        explorador.setDialogTitle("Cargar imagen...");
        
        //Agregamos un filtro de extensiones
        filtroImagen = new FileNameExtensionFilter("JPG, PNG & GIF","jpg","png","gif");
        explorador.setFileFilter(filtroImagen);
        
        //Muestro un dialogo sin pasarle parent con el boton de abrir
        int seleccion = explorador.showDialog(ReconocimientoDigitosGUI.this, "Abrir!");

        //analizamos la respuesta
        switch(seleccion) {
        case JFileChooser.APPROVE_OPTION:
        //seleccionó abrir
            try {
                //Podemos crear un File con lo seleccionado
                File archivo = explorador.getSelectedFile();

                //y guardar una ruta
                ruta = archivo.getPath();
                
                ImageIcon imagen =new ImageIcon(ruta);
                Icon icono = new ImageIcon(imagen.getImage().
                        getScaledInstance(/*imageToAnalize.getWidth()*/150, /*imageToAnalize.getHeight()*/150, Image.SCALE_DEFAULT));
                imageToAnalize.setIcon(icono);

                //obj.convertirImagen(ruta);
                System.out.println("Se cargo la imagen y se transformo en matriz");

                habilitarBtns(3);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        break;

        case JFileChooser.CANCEL_OPTION:
        //dio click en cancelar o cerro la ventana
        break;

        case JFileChooser.ERROR_OPTION:
        //llega aqui si sucede un error
        break;
        }

	}

	public void eventoEjecutar(){
		System.out.println("Ejecutando reconocimiento de digitos");
		//obj.comparacion(); //mejorarlo poniendo la logica en control.
		//Escribir en pantalla de resultados
		habilitarBtns(4);
	}

	public void eventoBotonNuevo(){
		habilitarBtns(1);
		System.out.println("Reiniciando proceso <boton nuevo> oprimido");
	}

	public void habilitarBtns(int step){
		switch(step){
			case 1:
			bdBtn.setEnabled(true);
			cargarImgBtn.setEnabled(false);
			ejecutarBtn.setEnabled(false);
			break;

			case 2:
			bdBtn.setEnabled(false);
			cargarImgBtn.setEnabled(true);
			ejecutarBtn.setEnabled(false);
			break;

			case 3:
			bdBtn.setEnabled(false);
			cargarImgBtn.setEnabled(false);
			ejecutarBtn.setEnabled(true);
			break;

			case 4:
			bdBtn.setEnabled(false);
			cargarImgBtn.setEnabled(false);
			ejecutarBtn.setEnabled(false);
			break;
		}
	}

	public static void main(String args[]) {

		ReconocimientoDigitosGUI gui = new ReconocimientoDigitosGUI();

			gui.addWindowListener(
				new WindowAdapter() {
					public void windowClosing(WindowEvent e) {
						System.exit(0);
					}// windowClosing
				}// WindowAdapter
			);//WindowListener
	}// main

}// class calendario
