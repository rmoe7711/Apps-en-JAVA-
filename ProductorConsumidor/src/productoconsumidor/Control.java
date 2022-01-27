
package productoconsumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JProgressBar;


public class Control implements Runnable{
    
    int nS;
    
    
    boolean SillaBarbero;
    
        int clientesEspera;
    
    JLabel EstadoBarbero;
    
    DefaultListModel listModel;
    
    JLabel EstadoSilla;
    
    JProgressBar progreso;
    
    
    Control(int num, JLabel EstadoBarbero, DefaultListModel defaultList, JLabel EstadoSilla, JProgressBar progreso){
        nS = num;
        SillaBarbero = false;
        clientesEspera = 0;
        this.EstadoBarbero = EstadoBarbero;
        listModel = defaultList;
        this.EstadoSilla = EstadoSilla;
        this.progreso = progreso;
    }
    
    public synchronized void cortarPelo(int posInList){
        try {
            SillaBarbero = true;
            
            clientesEspera--;
            listModel.removeElement("Cliente No "+posInList);
            
            EstadoSilla.setText("ocupado por "+posInList+" ");
           
            Log("Barbero cortando el pelo...");
            EstadoBarbero.setText("Barbero cortando el pelo...");
            
            Random r = new Random();
            int i = 0;
            int max = r.nextInt(6500);
            progreso.setMaximum(max);
            while(i<max){
                Thread.sleep(1);
                progreso.setValue(i);
                i++;
            }
            
            Log("Servido");
            Log("Clientes esperando: "+clientesEspera);
            SillaBarbero = false;
            EstadoSilla.setText("desocupado");
        } catch (InterruptedException ex) {
            Logger.getLogger(Barbero.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int getCuantosClientes(){
        return clientesEspera;
    }

    @Override
    public void run() {
        while(true){
            
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
