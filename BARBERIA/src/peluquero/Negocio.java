package peluquero;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.Border;

public final class Negocio extends javax.swing.JFrame {
  public boolean n5 = true;
  
  public void leerr()
  {
  try {
            leer();        // TODO add your handling code here:
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
  
  public void leer() throws FileNotFoundException, IOException
{
    String leer = "";
    String temporal = "";
FileReader f = new FileReader("C:\\Users\\Ronal\\Desktop\\fichero.txt");
BufferedReader b = new BufferedReader(f);
while(true)
            {        
       if ((temporal = b.readLine()) != null)
       {
                leer = leer+temporal+"\n";
       }   
           else
       {
            break;
               }
       
       
   
               }
area.setText(leer);
b.close();

}
  public String escribirr(int m)
  {
      escribir(m);
      return null;
  
  }
   public String escribir(int m)
        {
       System.out.println("\n");
       try
        {
               
       javax.swing.JFileChooser k; //  ventanita de texto
        k = new javax.swing.JFileChooser();
        k.showSaveDialog(k); // metodo para abrir la ventana grafica 
        String obt2; // guardar en la variable obt  la ruta del archivo completa
        obt2 = k.getSelectedFile().getAbsolutePath();
     File f2 = new File(obt2);
       FileWriter fr = new FileWriter(f2, true);
            BufferedWriter br = new BufferedWriter(fr);
            PrintWriter pw = new PrintWriter(br);
       
           int s = m;   
  
            br.write(s);
          
            pw.close();
            br.close();
        }
        catch(Exception e)
        {
            
        }
       System.out.println("\nescritura exitosa \n");
        return null;
           // TODO add your handling code here:
    }                       
  
     public class MiRunnable implements Runnable
{
    private boolean terminar = false;
    public void setTerminar (boolean terminar)
    {
        this.terminar=terminar;
    }
    public void run ()
    {
         while (!terminar){         }
    }
}
     public void parar()
     {
          n5 = false;
         bton_inicio.setEnabled(true);    
    bton_terminar.setEnabled(false);
    estado_barbero.setText("dormido");
     }
     public void iniciar()
     {
 
       n5 = true;
         bton_inicio.setEnabled(false);    
    bton_terminar.setEnabled(true);
     }
    public void Fondo(){
    setLocationRelativeTo(null);
        setResizable(false);
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon Fondo = new ImageIcon(this.getClass().getResource("/Imagenes/fondo.jpg"));
        JLabel Menu = new JLabel();
        Menu.setIcon(Fondo);
        getLayeredPane().add(Menu, JLayeredPane.FRAME_CONTENT_LAYER);
        Menu.setBounds(0,0,Fondo.getIconWidth(),Fondo.getIconHeight());
    }
   
    public void Extras(){
    bton_inicio.setEnabled(true);
    bton_terminar.setEnabled(false);
    silla_barbero.setEditable(false);
    estado_barbero.setEditable(false);
    
    barra_carga.setStringPainted(true);    
    barra_carga.setForeground(Color.RED);
    barra_carga.setBackground(Color.red);
    }
    public void Forzar(){
    bton_inicio.setEnabled(false);    
    bton_terminar.setEnabled(true);
    }
    
    public Negocio() {
        initComponents();
        Fondo();Extras();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lista_espera = new javax.swing.JList();
        label3 = new javax.swing.JLabel();
        label4 = new javax.swing.JLabel();
        barra_carga = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        label1 = new javax.swing.JLabel();
        num_lugares = new javax.swing.JTextField();
        bton_inicio = new javax.swing.JButton();
        bton_terminar = new javax.swing.JButton();
        silla_barbero = new javax.swing.JTextField();
        estado_barbero = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        area = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        lista_espera.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Clientes Esperando"));
        lista_espera.setModel(model);
        jScrollPane1.setViewportView(lista_espera);

        label3.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setText("ESTADO BARBERO");

        label4.setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setText("SILLA PRINCIPAL");

        barra_carga.setForeground(new java.awt.Color(255, 51, 51));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        label1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setText("NUMERO LUGARES");

        bton_inicio.setText("INICIAR");
        bton_inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_inicioActionPerformed(evt);
            }
        });

        bton_terminar.setText("TERMINAR");
        bton_terminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bton_terminarActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(label1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(bton_inicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 83, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(bton_terminar)
                        .add(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .add(jPanel1Layout.createSequentialGroup()
                .add(49, 49, 49)
                .add(num_lugares, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 95, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(label1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(num_lugares, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(bton_inicio)
                    .add(bton_terminar))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton1.setText("EXIT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        area.setColumns(20);
        area.setRows(5);
        jScrollPane2.setViewportView(area);

        jButton2.setText("historial");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .addContainerGap()
                                .add(silla_barbero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(label4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 146, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(21, 21, 21)
                        .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(54, 54, 54)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(barra_carga, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 307, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 260, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(37, 37, 37)
                                .add(jButton2)))))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(label3)
                        .add(estado_barbero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 141, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(jButton1)
                        .add(35, 35, 35)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 226, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(label3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(estado_barbero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jButton1)
                            .add(jButton2)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(23, 23, 23)
                                .add(label4)
                                .add(18, 18, 18)
                                .add(silla_barbero, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .add(18, 18, 18)
                        .add(barra_carga, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 34, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(18, 18, 18)
                        .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 121, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void bton_inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_inicioActionPerformed
  /*    try {
          //OBTENER NUMERO DE LUGARES
          borrarar();
      } catch (IOException ex) {
          Logger.getLogger(Negocio.class.getName()).log(Level.SEVERE, null, ex);
      }*/
        final int n_lugares  = Integer.parseInt(num_lugares.getText());
        //IR A FUNCION PROCESAR
        final Procesador proces = new Procesador(estado_barbero, model,silla_barbero, barra_carga,n_lugares);
        //IR FUNCION BARBERO
        final Barbero barbero = new Barbero(proces, estado_barbero, silla_barbero, barra_carga);
        //INICIAR HILOS
        
        new Thread(barbero).start();
        new Thread(proces).start();
        new Thread().start();
        iniciar();
        new Thread(new Runnable()
        {
            @Override            
            public void run(){
                try 
                {
                    int total_clientes=0;
                    Random ram = new Random();
                   while(n5 == true)
                    {
                        Thread.sleep(ram.nextInt(5000));
                        if(proces.ClientesEsperando < n_lugares)
                        {
                            Cliente iniciar = new Cliente(proces, barbero, model,estado_barbero, ++total_clientes);
                            Thread hilo = new Thread(iniciar);
                            hilo.start();
                        }
                        
                    }
            
                } catch (Exception Exe) {
                    JOptionPane.showMessageDialog(null, "El Local No se Abrio","Advertencia",JOptionPane.WARNING_MESSAGE);
                }
         
            }
        }
        ).start();
    
    }//GEN-LAST:event_bton_inicioActionPerformed
 public int f(int clientes)
     {
          Stack < String > pila = new Stack < String > ();
        
        //apila 3 elementos
        String k = "";
        String k2 = "";
        k2 = k2 + pila.push("\n" +clientes) + "\n";
        JOptionPane.showMessageDialog(this, k2);
        area.setText(k2);
         return 0;
     }
    private void bton_terminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bton_terminarActionPerformed
  
    parar();

    
    }//GEN-LAST:event_bton_terminarActionPerformed
public String borrarar() throws IOException
{

BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\Ronal\\Desktop\\fichero.txt"));
bw.write("");
return null;
}

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
     System.exit(0);    // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
leerr();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Negocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Negocio().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area;
    private javax.swing.JProgressBar barra_carga;
    private javax.swing.JButton bton_inicio;
    private javax.swing.JButton bton_terminar;
    private javax.swing.JTextField estado_barbero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel label1;
    private javax.swing.JLabel label3;
    private javax.swing.JLabel label4;
    private javax.swing.JList lista_espera;
    private DefaultListModel model = new DefaultListModel();
    private javax.swing.JTextField num_lugares;
    private javax.swing.JTextField silla_barbero;
    // End of variables declaration//GEN-END:variables
}
