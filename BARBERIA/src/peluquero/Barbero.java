package peluquero;

import java.util.Random;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Barbero implements Runnable {
    
    
    
    Procesador proces;
    JTextField estado_barbero;
    JTextField estado_silla;
    JProgressBar barra_carga;
    ////////////////////////////////////////
    boolean dormir;
    Random ram;    
            
    public Barbero(Procesador m, JTextField estado_barbero, 
    JTextField estado_silla, JProgressBar barra_progreso)
    {
        dormir = false;
        ram = new Random();
        this.proces = m;
        this.estado_barbero = estado_barbero;
        this.estado_silla = estado_silla;
        this.barra_carga = barra_progreso;
    }
    
    public void descansar(){
        try{
            estado_barbero.setText("Dormir");
            dormir = true;
            proces.estado_silla = true;
            barra_carga.setValue(0);
            estado_silla.setText("Barbero");            
            synchronized(this){wait();}            
            estado_barbero.setText("Despierto");            
            dormir = false;
            proces.estado_silla = false;
            
        } catch (InterruptedException exe) {
            JOptionPane.showMessageDialog
            (null, "El barbero no se siente bien","Atencion!",
            JOptionPane.WARNING_MESSAGE);
        }
    }

    @Override
    public void run() {
        while(true){
            if(!proces.estado_silla)
            {
                descansar();
            }
            if(proces.ClientesRestantes()== 0)
            {
                descansar();
            }
        }
    }    
}
