package peluquero;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class Cliente implements Runnable{
    Procesador proces;
    Barbero barbero;
    DefaultListModel lista_espera;
    JTextField estado_barbero;
    int listados;
    
    public Cliente(Procesador proces, Barbero barber, 
    DefaultListModel lista_espera, JTextField estado_barbero, int lista)
    {
        this.lista_espera = lista_espera;        
        this.proces = proces;
        this.estado_barbero = estado_barbero;
        barbero = barber;
        listados = lista;        
        proces.ClientesEsperando++;
        lista_espera.addElement("Cliente No."+lista);
         
        }
    
    @Override
    public void run() {        
        if(barbero.dormir)
        {
            despertar();
        }        
        while(true)
        {
            if(Thread.currentThread().isAlive())
            {
                if(!proces.estado_silla)
                {
                    proces.cortarPelo(this.listados);
                    
                    break;
                }
            }
        }        
    }    
    public void despertar(){
        
        estado_barbero.setText("despierto");
        synchronized(barbero)
        {
            barbero.notify();
        }
    }    
}
