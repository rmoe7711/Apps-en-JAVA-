
package productoconsumidor;

import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Barbero implements Runnable {
    boolean duerme;
    Random rand;
    Control c;
    JLabel EstadoBarbero;
    JLabel EstadoSilla;
    JProgressBar progreso;
            
    public Barbero(Control c, JLabel EstadoBarbero, JLabel EstadoSilla, JProgressBar progreso){
        duerme = false;
        rand = new Random();
        this.c = c;
        this.EstadoBarbero = EstadoBarbero;
        this.EstadoSilla = EstadoSilla;
        this.progreso = progreso;
    }
    
    public void dormir(){
        try{                
            Log("Barbero en espera...");
            EstadoBarbero.setText("barbero en espera..");
            duerme = true;
            c.SillaBarbero = true;
            progreso.setValue(0);
            EstadoSilla.setText("Barbero ocupando lugar..");
            synchronized(this){
                wait();
            }
            Log("Barbero Despierto");
            EstadoBarbero.setText("Barbero Despierto");
            EstadoSilla.setText("Barbero listo para atender");
            duerme = false;
            c.SillaBarbero = false;
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
   public void run() {
        while(true){
            if(!c.SillaBarbero && c.getCuantosClientes()==0 && !duerme){
                dormir();
            }
            Log("Barbero Dormido?: "+duerme);
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
