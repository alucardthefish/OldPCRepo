/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectometodosnumericos;

/**
 *
 * @author Usuario
 */

import java.io.*;
import java.util.StringTokenizer;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import Jama.Matrix;
import Jama.SingularValueDecomposition;

public class Control {
    
    	private int alto,ancho = 0;
        private int numImagenesEntrenamiento;
	private File f;
	private FileWriter fw;
	private BufferedWriter bw;
	private PrintWriter pw;
	private double[][] imagenM; 
	private Matrix matriz0;
	private Matrix matriz1;
	private Matrix matriz2;
	private Matrix matriz3;
	private Matrix matriz4;
	private Matrix matriz5;
	private Matrix matriz6;
	private Matrix matriz7;
	private Matrix matriz8;
	private Matrix matriz9;
	private double[] valores;
	
	
	public Control(int numImgEntreno)
	{
            imagenM = new double[784][1];
            valores = new double[10];
            numImagenesEntrenamiento = numImgEntreno;
            matriz0= new Matrix(784, numImgEntreno);
            matriz1= new Matrix(784, numImgEntreno);
            matriz2= new Matrix(784, numImgEntreno);
            matriz3= new Matrix(784, numImgEntreno);
            matriz4= new Matrix(784, numImgEntreno);
            matriz5= new Matrix(784, numImgEntreno);
            matriz6= new Matrix(784, numImgEntreno);
            matriz7= new Matrix(784, numImgEntreno);
            matriz8= new Matrix(784, numImgEntreno);
            matriz9= new Matrix(784, numImgEntreno);
			
			
	}
	
	
	
	
	public Matrix llenarMatriz( int arch)
	{
		  String cadena;
		  File archivo = null;
                  FileReader f = null;
                  BufferedReader b = null;
                  
		  Matrix matriz = new Matrix(784, numImagenesEntrenamiento);
		try {
			
			archivo = new File("C:/Documents and Settings/Administrador/Escritorio/Proyecto_metodos/"+arch+".txt");
			f = new FileReader(archivo);
			b = new BufferedReader(f);
			cadena = b.readLine();
			StringTokenizer token = new StringTokenizer(cadena);
			String datoString;
			
		      
		    	  
		    	   for (int r = 0; r<numImagenesEntrenamiento;r++)
			          {
			        	  for (int w = 0; w<784;w++)
			        	  {
			        		  
			        		      
			        		  datoString = token.nextToken();
			        		  matriz.set(w,r, Double.parseDouble(datoString));
			        		  
			        		  //System.out.print( matriz0.get(w, r));
			    		      
			        	  }
			        	  
			        	  //System.out.println();
			          }
		          
		       
		     
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 return matriz;
	      
	}
	
	
	
	public void llenarMatrices()
	{
		matriz0= llenarMatriz( 0);
		matriz1= llenarMatriz( 1);
		matriz2= llenarMatriz( 2);
		matriz3= llenarMatriz( 3);
		matriz4= llenarMatriz( 4);
		matriz5= llenarMatriz( 5);
		matriz6= llenarMatriz( 6);
		matriz7= llenarMatriz( 7);
		matriz8= llenarMatriz( 8);
		matriz9= llenarMatriz( 9);
	}
	
	public Matrix svd(Matrix matriz)
	{
		SingularValueDecomposition svd = matriz.svd();
		return svd.getU();
		
		
	}
	
	public void comparacion()
	{
		Matrix identidad = new Matrix(784,784).identity(784, 784);
		Matrix arreglo = new Matrix(imagenM);
		valores[0] = identidad.minus(svd(matriz0).times(svd(matriz0).transpose())).times(arreglo).norm2();
		valores[1] = identidad.minus(svd(matriz1).times(svd(matriz1).transpose())).times(arreglo).norm2();
		valores[2] = identidad.minus(svd(matriz2).times(svd(matriz2).transpose())).times(arreglo).norm2();
		valores[3] = identidad.minus(svd(matriz3).times(svd(matriz3).transpose())).times(arreglo).norm2();
		valores[4] = identidad.minus(svd(matriz4).times(svd(matriz4).transpose())).times(arreglo).norm2();
		valores[5] = identidad.minus(svd(matriz5).times(svd(matriz5).transpose())).times(arreglo).norm2();
		valores[6] = identidad.minus(svd(matriz6).times(svd(matriz6).transpose())).times(arreglo).norm2();
		valores[7] = identidad.minus(svd(matriz7).times(svd(matriz7).transpose())).times(arreglo).norm2();
		valores[8] = identidad.minus(svd(matriz8).times(svd(matriz8).transpose())).times(arreglo).norm2();
		valores[9] = identidad.minus(svd(matriz9).times(svd(matriz9).transpose())).times(arreglo).norm2();
		
	}
	
	

	public void convertirImagen(String ruta)
	{
		
		try {
			
			InputStream archivo;
			archivo = new FileInputStream(ruta);
			ImageInputStream imagen = ImageIO.createImageInputStream(archivo);
			BufferedImage imagenB = ImageIO.read(imagen);
			int count = 0;
		
			
			for(int w = 0; w< 28;w++)
			{
				for (int r = 0; r<28;r++)
				{
					int num = imagenB.getRGB(r,w);
					
					Color color = new Color(num);
					int numf = color.getGreen();
					
					if(numf >= 255)
					{
						imagenM[count][0] = 0.0;
						//System.out.print(imagenM[count][0]);
						
					}
					else if(numf<255)
					{
						imagenM[count][0] = 1.0;
						//System.out.print(imagenM[count][0]);

						
					}
					count++;
				}
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	public void matrizDeimagen(int numi,int numc)
	{
		
		
		try {
			
			InputStream archivo;
			archivo = new FileInputStream("C:/Documents and Settings/Administrador/Escritorio/Proyecto_metodos/test/"+numc+"/"+numi+".png");
			ImageInputStream imagen = ImageIO.createImageInputStream(archivo);
			BufferedImage imagenB = ImageIO.read(imagen);
			
		
		
			for(int w = 0; w< 28;w++)
			{
				for (int r = 0; r<28;r++)
				{
					int num = imagenB.getRGB(r, w);
					
					Color color = new Color(num);
					int numf = color.getGreen();
					
					if(numf >= 255)
					{
						pw.write(0+" ");
						
					}
					else if(numf<255)
					{
						pw.write(1+" ");

						
					}
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
	public double[] getValores() {
		return valores;
	}




	public void setValores(double[] valores) {
		this.valores = valores;
	}
	
	
	public void llenarBase()
	
	{
		try
		{
			int count =0;
			
				
		for(int j = 0 ; j<10; j++)
			{ count = 0;
				
				f = new File("C:/Documents and Settings/Administrador/Escritorio/Proyecto_metodos/"+j+".txt");
				fw = new FileWriter(f);
				bw = new BufferedWriter(fw);
				pw = new PrintWriter(bw);
				
				
				
				for (int i = 1; i<= numImagenesEntrenamiento;i++ )
				{
					matrizDeimagen(i,j);
					
					
				}
				
				
				
				try {
					bw.close();
					pw.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}
		
		
		catch(Exception e)
		{
			System.out.print("error file not found ");

		}
		
		
		
		
	
		
		//C:/Users/user/Desktop/numeros/test
		
	}
        
        
        public int reconocer(){
            
            //Capturamos los valores de los vectores residuales por minimos cuadrados
            comparacion();
            
            int menor = -1;
            double valorResidualMenor = 1000000;
            
            for(int i=0; i<10; i++){
                double valorResidual = getValores()[i];
                valorResidual = ( (double)( (int) (valorResidual *1000000)) ) /1000000;
                if(valorResidualMenor > valorResidual){
                    valorResidualMenor = valorResidual;
                    menor = i;
                }
            }            
            
            return menor;
        }
    
}
