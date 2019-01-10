package logica;
import java.io.*;
import java.util.*;
/**
**********************************************************************************************<br/>
 * Crea un vector de arreglos de enteros
 * Crea y lee archivos
 * Imprime matrices y las convierte a String
* @author jhoreyse
**********************************************************************************************
*/
public class ManejadorDeArchivo {
	private File archivo;
	private FileInputStream fis = null;
	private BufferedInputStream bis = null;
	private DataInputStream dis = null;
	private String lectura="";
        private Vector vectorTablero = new Vector();

        Vector vectorDimension = new Vector();
        Vector matrizVector = new Vector();
        int fila, columna, totalNegrasNumero;
        int[][] matrizFinal;

	/**
	*Contruye un nuevo lector de archivos sin archivo
	*/
	public ManejadorDeArchivo(){
	}
	/**
	*Contruye un nuevo lector de archivos
	*@param archivo archivo leido
	*/
	public ManejadorDeArchivo(File archivo) {
		this.archivo=archivo; 	
//		System.out.println("Cargo el archivo:"+archivo.getName());
	}
	/**
	*Establece el archivo 
	*@param archivo archivo leido
	*/
	public void setArchivo(File archivo) {
		this.archivo=archivo;   	
	}
	/**
	*Retorna el Archivo que se leyo
	@return Archivo Leido
	*/
	public File getArchivo(){
		return this.archivo;
	}	
	/**
	*Guarda un archivo en una direccion
	*@param salidaUrl direccion donde guarda el archivo
	*@param contenido contenido del archivo a guardar
	*@throws IOException problemas a leer
	*/
	public static void saveArchivo(String salidaUrl,String salida){
		try{
			FileWriter fstream = new FileWriter(salidaUrl);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(salida);
			out.close();
		}catch (IOException e){
			System.err.println("Error Write Output: " + e.getMessage());
		}
	}

        //-----------------------------------COMIENZA---------------------------------------------------
        //-------------------------------leerArchivoEntrada---------------------------------------------
        //-----------------------------------COMIENZA---------------------------------------------------

        public void leerArchivoEntrada(String archivo)
        {
            String linea="";

            try
            {
                RandomAccessFile file = new RandomAccessFile(archivo, "r");
                linea = file.readLine();

//-----------------------------------------Dimensiones[fila][columna]-----------------------------------------
                StringTokenizer st0 = new StringTokenizer(linea, "\\s");

                String dimension = st0.nextToken();

                StringTokenizer st0_1 = new StringTokenizer(dimension);

                while(st0_1.hasMoreTokens())
                {
                    String capt = (String)(st0_1.nextToken());
                    vectorDimension.add(capt);
                }

                fila = Integer.parseInt((String)(vectorDimension.elementAt(0)));
                columna = Integer.parseInt((String)(vectorDimension.elementAt(1)));
                

//-----------------------------------------Leyendo El Tablero-------------------------------------------------

                linea = file.readLine();

                while(linea != null)
                {
                    StringTokenizer st3 = new StringTokenizer(linea, " ");

                    while(st3.hasMoreTokens())
                    {
                        String captador = (String)(st3.nextToken());
                        matrizVector.add(captador);
                    }
                    linea = file.readLine();
                }

                //probando lo que hay en matrizVector
//                System.out.println("esto es lo que hay en matrizVector");
//                for(int i = 0; i<fila*columna; i++)
//                {
//                    System.out.println(matrizVector.elementAt(i));
//                }

                matrizFinal = new int[fila][columna];
//                System.out.println("inicializo la matrizFinal");

                int contador = 0;

                for(int i=0; i < fila; i++)
                {
                    for(int j=0; j < columna; j++)
                    {
                        int localTmp = Integer.parseInt((String)(matrizVector.elementAt(contador)));
                        matrizFinal[i][j] = localTmp;
                        contador++;
                    }
                }


                //dibujar para verla
                System.out.println("Dibujando matriz final \n");
                for(int i=0; i < fila; i++)
                {
                    for(int j=0; j < columna; j++)
                    {
                        System.out.print(matrizFinal[i][j]+" ");
                        contador++;
                    }
                    System.out.println();
                }

                totalNegrasNumero = 0;
                System.out.println("Contando negras con numero");
                for(int i=0; i < fila; i++)
                {
                    for(int j=0; j < columna; j++)
                    {
                        if(matrizFinal[i][j] > 3)
                        {
                            totalNegrasNumero++;
                        }
                    }
                }
                //System.out.println("Total de celdas negras con numero en el tablero = "+totalNegrasNumero);

            }
            catch(IOException e)
            {
                System.out.println("Error al leer el archivo");
            }


//	leerArchivoEntrada("C:/Users/sergio/Desktop/FADA2012/Akari/Akari/entrada/TableroEjemplo.txt");
    }


        //--------------------------------------FIN-----------------------------------------------------
        //-------------------------------leerArchivoEntrada---------------------------------------------
        //--------------------------------------FIN-----------------------------------------------------


	/**
	*Corazon de clase aqui el LectorDeArchivos crea la matriz 
	*@throws IOException problemas a leer
	*/
	public void crearMatrizDesdeArchivo(){
		//System.out.println("En crearMatrizDesdeArchivo()");
		try {
			lectura+="Archivo : "+archivo.getName()+"\n";
			fis = new FileInputStream(archivo);
			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);
			while (dis.available() != 0) {
				String strDatos=dis.readLine();
				lectura+=strDatos+"\n";
				StringTokenizer tokens=new StringTokenizer(strDatos, " ");
				int nDatos=tokens.countTokens();
				int[] datos=new int[nDatos];
				int i=0;
				while(tokens.hasMoreTokens()){
					String str=tokens.nextToken();
					datos[i]=Integer.valueOf(str).intValue();
					i++;
				}
		}
                
		fis.close();
		bis.close();
		dis.close();
		}catch(IOException ioe){
			System.err.println("Error Read Input: " + ioe.getMessage());
		}
	}
         /**
         * Convierte una matriz a una cadena
         * @param entrada matriz que usted desea imprimir en la consola
         */
        public static String toString(int [][] entrada){
            String salida="";
           for(int i =0;i<entrada.length;i++){
                for(int j=0;j<entrada[i].length;j++){
                    salida+=entrada[i][j]+" ";
                }
                salida+="\n";
           }
            return salida;
        }
        /**
         * Pinta una matriz
         * @param entrada matriz que usted desea imprimir en la consola
         */
        public static void printMatrix(int [][] entrada){
           for(int i =0;i<entrada.length;i++){
                for(int j=0;j<entrada[i].length;j++){
                    System.out.print(entrada[i][j]+" ");
                }
                System.out.print("\n");
            }
        }
        /**
         *Retorna la matriz como una cadena
         * @return archivo leido
         */
    public String toString(){
		return lectura+"\n #####FIN DEL ARCHIVO#####";
    }
    
    public int[][]  getMatrizFinal(){
		return matrizFinal;
	}
    
    public int getFilas(){
		return fila;
	}
    
    public int getColumnas(){
		return columna;
	}
    
    public int getTotalNegrasNumero(){
		return totalNegrasNumero;
	}
}
