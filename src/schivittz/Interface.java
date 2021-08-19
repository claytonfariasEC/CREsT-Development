/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package schivittz;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Schivittz
 */
public class Interface extends javax.swing.JFrame {

    /**
     * Creates new form Interface
     */
    
    
    public Interface() {
        initComponents();
        this.jTextField1.setText("nand2.txt");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setText("jTextField1");

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton1)
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(201, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         // TODO add your handling code here:

        String arquivo = this.jTextField1.getText();
        System.out.println("");
        System.out.println("Analisando o arquivo " + arquivo);
        System.out.println("");
        LeArquivo l = new LeArquivo();
        try {
            l.Ler(arquivo, 0);
            l.InsereProbEntradas("50");
        } catch (IOException ex) {
            Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        l.mostraTudo();

        Grafo g = new Grafo(l.getListaTransistores(), l.getListaEntradas(), l.getListaNodos(), l.getConfiabilidade());
        
        //g.analiseSOnF();
        g.analiseSOF();


    }//GEN-LAST:event_jButton1ActionPerformed

    static BigDecimal[][] PTM_SOnF;
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
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               // BigDecimal[][] PTM_SOnF;
                if(args.length==0){
                    //System.out.println("passagem por interface gráfica");
                    new Interface().setVisible(true);
                }
                else{
                    //System.out.println("passagem por argumento");
                    String arquivo = args[0] + ".txt";
                    String confiabilidade = args[1];
                    //System.out.println("confiabilidade = "+confiabilidade[1]);
                    //String[] entradas = args[2].split("=");
                    
                    //System.out.println("Prob_entradas = "+ entradas[1]);
                    //String[] prob = entradas[1].split("/");
                    //System.out.println("Prob = "+ Arrays.toString(prob));
                    
                    
                    
                    System.out.println("Analisando o arquivo " + arquivo);
                    LeArquivo l = new LeArquivo();
                    try {
                        l.setConfiabilidade(new BigDecimal(confiabilidade));
                        l.Ler(arquivo, 1);
                        l.InsereProbEntradas("50");
                    } catch (IOException ex) {
                        Logger.getLogger(Interface.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    l.mostraTudo();

                    Grafo g = new Grafo(l.getListaTransistores(), l.getListaEntradas(), l.getListaNodos(), l.getConfiabilidade());
                    
                    PTM_SOnF = new BigDecimal[g.getNumComb()][2];
                    PTM_SOnF = g.analiseSOnF();
                    
                    mostraPTM();
                    //g.analiseSOF();
                }
                
            }
        });
    }
    
    public static void mostraPTM(){
        for(int i=0; i<PTM_SOnF.length;i++){
            System.out.println(PTM_SOnF[i][0] + "\t" + PTM_SOnF[i][1]);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
