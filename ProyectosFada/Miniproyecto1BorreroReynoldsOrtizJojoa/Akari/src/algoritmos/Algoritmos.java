/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

/**********************************************************************************************
* Interfaz para los algoritmos que puede ser AlgoritmoIngenuo o AlgoritmoOptimo 
**********************************************************************************************/
/**
 *
 * @author jhoreyse
 */
public interface Algoritmos {  
        /**
	*Crea la ejecucion 
	*/
        public abstract void crearSolucion();
        /**
        *Retorna una matriz con la solucion despues de computado con el algoritmo
        *@return Matriz con las solucion
        */
        public abstract int[][] getSolucion();
    
}
