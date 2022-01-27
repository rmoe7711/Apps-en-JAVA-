/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package productoconsumidor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Diseño extends javax.swing.JFrame {
    public Diseño() {
        initComponents();
        setTextFieldChanged(numerosillas);
        inicio.setEnabled(false);
        fin.setEnabled(false);
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        progreso = new javax.swing.JProgressBar();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaEspera = new javax.swing.JList();
        waitingLabel = new javax.swing.JLabel();
        stateLabel = new javax.swing.JLabel();
        EstadoBarbero = new javax.swing.JLabel();
        inChairLabel = new javax.swing.JLabel();
        EstadoSilla = new javax.swing.JLabel();
        inicio = new javax.swing.JButton();
        fin = new javax.swing.JButton();
        numerosillas = new javax.swing.JTextField();
        nChairsLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));

        container.setBackground(new java.awt.Color(0, 255, 255));

        ListaEspera.setModel(model);
        ListaEspera.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                ListaEsperaComponentHidden(evt);
            }
        });
        jScrollPane1.setViewportView(ListaEspera);

        waitingLabel.setForeground(new java.awt.Color(204, 0, 204));
        waitingLabel.setText("Casilla Clientes Wait");

        stateLabel.setForeground(new java.awt.Color(153, 0, 153));
        stateLabel.setText("Estado Barbero:");

        EstadoBarbero.setForeground(new java.awt.Color(255, 0, 0));
        EstadoBarbero.setText("...");

        inChairLabel.setForeground(new java.awt.Color(153, 0, 153));
        inChairLabel.setText("Silla:");

        EstadoSilla.setForeground(new java.awt.Color(255, 0, 0));
        EstadoSilla.setText("...");

        inicio.setText("Inicio");
        inicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        fin.setText("Detener");
        fin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout containerLayout = new org.jdesktop.layout.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(containerLayout.createSequentialGroup()
                .addContainerGap()
                .add(inicio, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 12, Short.MAX_VALUE)
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(containerLayout.createSequentialGroup()
                        .add(waitingLabel)
                        .add(146, 207, Short.MAX_VALUE))
                    .add(containerLayout.createSequentialGroup()
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(containerLayout.createSequentialGroup()
                                .add(inChairLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(EstadoSilla))
                            .add(containerLayout.createSequentialGroup()
                                .add(stateLabel)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(EstadoBarbero))
                            .add(containerLayout.createSequentialGroup()
                                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                    .add(progreso, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .add(jScrollPane1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(fin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 106, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 31, Short.MAX_VALUE))))
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, containerLayout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .add(waitingLabel)
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(containerLayout.createSequentialGroup()
                        .add(6, 6, 6)
                        .add(inicio))
                    .add(containerLayout.createSequentialGroup()
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(fin)
                            .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(28, 28, 28)
                .add(progreso, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(stateLabel)
                    .add(EstadoBarbero))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(containerLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(inChairLabel)
                    .add(EstadoSilla))
                .add(51, 51, 51))
        );

        nChairsLabel.setText("Sillas Disponibles");

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(container, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(126, 126, 126)
                        .add(numerosillas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 156, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(171, 171, 171)
                        .add(nChairsLabel)))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(nChairsLabel)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(numerosillas, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(container, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inicioActionPerformed
       
        
        
        try{
            Integer.parseInt(numerosillas.getText());
        }catch(NumberFormatException e){
            JOptionPane.showMessageDialog(this, "Invalid number");
            return;
        }
        
        final int numeroSillas  = Integer.parseInt(numerosillas.getText());
      
       
        final Control c = new Control(numeroSillas, EstadoBarbero, model, EstadoSilla, progreso);
        
        
        final Barbero barbero = new Barbero(c, EstadoBarbero, EstadoSilla, progreso);
        
        List<Clientes> clientes = new ArrayList<Clientes>();
        
        
        
        new Thread(barbero).start();
        new Thread(c).start();
        
       
        inicio.setEnabled(false);
        fin.setEnabled(true);
        
        
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    int numCliente=0;
                    Random r = new Random();
                    while(true){
                        Thread.sleep(r.nextInt(10000));
                        if(c.clientesEspera<numeroSillas){
                            Clientes nuevo = new Clientes(c, barbero, model, EstadoBarbero, ++numCliente);
                            Thread t = new Thread(nuevo);
                            t.start();
                        }else{
                            System.out.println("Entro un cliente, Barberia llena, Cliente se retira");
                        }
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Diseño.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start(); 
    }//GEN-LAST:event_inicioActionPerformed

    private void finActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finActionPerformed
       System.exit(0);
    }//GEN-LAST:event_finActionPerformed

    private void ListaEsperaComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ListaEsperaComponentHidden

    }//GEN-LAST:event_ListaEsperaComponentHidden

    private void setTextFieldChanged(JTextField txt){
        final JTextField t = txt;
        DocumentListener documentListener = new DocumentListener() {

            @Override
            public void insertUpdate(DocumentEvent de) {
                changeEnabled(de);
            }

            @Override
            public void removeUpdate(DocumentEvent de) {
                changeEnabled(de);
            }

            @Override
            public void changedUpdate(DocumentEvent de) {
                changeEnabled(de);
            }
        };
        txt.getDocument().addDocumentListener(documentListener);
    }
    
    private void changeEnabled(DocumentEvent event){
        DocumentEvent.EventType type = event.getType();
 
        if (type.equals(DocumentEvent.EventType.CHANGE)){
 
        }
        else if (type.equals(DocumentEvent.EventType.INSERT)){
            if(numerosillas.getText().length()>0){
                inicio.setEnabled(true);
            }
        }
        else if (type.equals(DocumentEvent.EventType.REMOVE)){
           if(numerosillas.getText().length()==0){
                inicio.setEnabled(false);
            } 
        }
    }
    
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
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Diseño.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Diseño().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel EstadoBarbero;
    private javax.swing.JLabel EstadoSilla;
    private javax.swing.JList ListaEspera;
    private DefaultListModel model = new DefaultListModel();
    private javax.swing.JPanel container;
    private javax.swing.JButton fin;
    private javax.swing.JLabel inChairLabel;
    private javax.swing.JButton inicio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nChairsLabel;
    private javax.swing.JTextField numerosillas;
    private javax.swing.JProgressBar progreso;
    private javax.swing.JLabel stateLabel;
    private javax.swing.JLabel waitingLabel;
    // End of variables declaration//GEN-END:variables
}
