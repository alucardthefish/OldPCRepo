/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logica;

/**
 *
 * @author jhoreyse
 */
public class TiempoEjecucion {
    
    private long tIni;
    private long tTotal;

    public TiempoEjecucion(){
        tIni = tTotal = 0;
    }

    public void iniciar(){
        tTotal = 0;
        tIni = System.currentTimeMillis();
    }

    public void terminar(){
        tTotal = System.currentTimeMillis() - tIni;
    }

    public long getTiempo(){
        return tTotal;
    }

}
