
package productoconsumidor;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;


public class Clientes implements Runnable{
    Control c;
    Barbero barbero;
    DefaultListModel ListaEspera;
    JLabel EstadoBarbero;
    int posInList;
    
    public Clientes(Control c, Barbero b, DefaultListModel ListaEspera, JLabel EstadoBarbero, int numCliente){
        this.ListaEspera = ListaEspera;
        Log("Bienvenido, nuevo proceso");
        barbero = b;
        this.c = c;
        this.EstadoBarbero = EstadoBarbero;
        posInList = numCliente;
        
        c.clientesEspera++;
        ListaEspera.addElement("Cliente No "+numCliente);
        Log("Hay "+ c.getCuantosClientes() + " clientes esperando");
    }
    
    @Override
    public void run() {
        
        if(barbero.duerme){
            despertar();
        }
        
        while(true){
            if(Thread.currentThread().isAlive()){
                if(!c.SillaBarbero){
                    c.cortarPelo(this.posInList);
                    break;
                }
            }
        }
        
    }
    
    public void despertar(){
        
        Log("Barbero ON");
        EstadoBarbero.setText("Barbero ON");
        synchronized(barbero){
            barbero.notify();
        }
    }
    
    public void Log(String mensaje){
        System.out.println(mensaje);
    }
    
}
