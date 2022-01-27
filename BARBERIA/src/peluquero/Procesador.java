package peluquero;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JProgressBar;

public class Procesador implements Runnable{   
     
   
    DefaultListModel lista_espera;
    JProgressBar barra_carga;
    JTextField estado_barbero;
    JTextField silla_barbero;
    ////////////////////////////
    int num_espacio;
    int ClientesEsperando;
    boolean estado_silla;        
    
    public Procesador(JTextField estado_barbero, DefaultListModel lista, 
    JTextField silla_barbero, JProgressBar barra_progreso,int num)
    {
        lista_espera = lista;
      
        this.estado_barbero = estado_barbero;        
        this.silla_barbero = silla_barbero;
        this.barra_carga = barra_progreso;
        
        num_espacio = num;
        estado_silla = false;
        ClientesEsperando = 0;             
    }
    
    public synchronized void cortarPelo(int cliente_listado){
        
        
        try {estado_silla = true;          ClientesEsperando--;     //INICIA LA ACCION
    
            lista_espera.removeElement("Cliente No."+cliente_listado);
            
            silla_barbero.setText("Cliente No."+cliente_listado);         
            estado_barbero.setText("Trabajar"); 
            
            Random ram = new Random();
            int maximo_ram = ram.nextInt(8000);
            barra_carga.setMaximum(maximo_ram);
            
            for (int temp = 0; temp <= maximo_ram; temp++)
            {
                Thread.sleep(1);
                barra_carga.setValue(temp);
                temp++;
            }      
            
            estado_silla = false;
            silla_barbero.setText("Barbero");
           
       estado_barbero.setText("");
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog
            (null, "El cliente resulta Insatisfecho","Alerta!",
            JOptionPane.WARNING_MESSAGE);
        }
       Negocio b  = new Negocio(); 
      b.f(cliente_listado); 
  
    }
     
    
    public int ClientesRestantes()
    {
        return ClientesEsperando;        
    }
    @Override
    public void run() {
      
      
        //MANTENER VIVO EL PROCESO
        while(true){}
    }
}
