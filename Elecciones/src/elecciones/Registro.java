/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecciones;

import CorbaConection.ClientCorbaConection;
import javax.swing.JOptionPane;

/**
 *
 * @author Padilla_Bustamante
 */
public class Registro extends javax.swing.JFrame {

    private String[] args;

    /**
     * Creates new form Resultados
     */
    public Registro() {
        initComponents();
        setSize(638, 500);
        lblWarning1.setVisible(false);
    }

    public Registro(String[] args) {
        this.args = args;
        initComponents();
        setSize(638, 500);
        lblWarning1.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMatricula = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        lblMensaje2 = new javax.swing.JLabel();
        lblWarning1 = new javax.swing.JLabel();
        lblMensaje3 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        btnVerificar = new javax.swing.JButton();
        lblFonfo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elecciones 2018");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMatricula.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMatricula.setText("Matrícula:");
        getContentPane().add(lblMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, 80, 30));

        lblMensaje.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMensaje.setText("Sistema de Elecciones ");
        getContentPane().add(lblMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 310, -1));

        lblMensaje2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblMensaje2.setText("Para los alumnos de la Licenciatura en Informática");
        getContentPane().add(lblMensaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 550, -1));

        lblWarning1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblWarning1.setForeground(new java.awt.Color(255, 0, 0));
        lblWarning1.setText("La matrícula introducida no es válida, o ya votó una vez verifique sus datos.");
        getContentPane().add(lblWarning1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 520, -1));

        lblMensaje3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblMensaje3.setText("Sistema con fines educativos, ajeno a cualquier partido político.");
        getContentPane().add(lblMensaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 520, -1));

        txtMatricula.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(txtMatricula, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 210, 30));

        btnVerificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVerificar.setText("VERIFICAR");
        btnVerificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVerificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 240, 140, 40));

        lblFonfo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/elecciones/resultados.png"))); // NOI18N
        getContentPane().add(lblFonfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVerificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerificarActionPerformed
        ClientCorbaConection ccc = new ClientCorbaConection(this.args);
        System.out.println(this.txtMatricula.getText());
        if (this.txtMatricula.getText().equals("root")) {
            Resultados res = new Resultados(this.args);
            res.show();
        } else {
            if (!this.txtMatricula.getText().isEmpty()) {
                if (ccc.verificarMatricula(this.txtMatricula.getText())) {
                    
                            JOptionPane.showMessageDialog(null, "Bienvenido Fulano");
                    Boleta boleta = new Boleta(this.args, this.txtMatricula.getText());
                    boleta.show();
                    this.lblWarning1.setVisible(false);

                } else {
                    this.lblWarning1.setVisible(true);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar una matrícula");
            }
        }
    }//GEN-LAST:event_btnVerificarActionPerformed

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
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVerificar;
    private javax.swing.JLabel lblFonfo;
    private javax.swing.JLabel lblMatricula;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblMensaje2;
    private javax.swing.JLabel lblMensaje3;
    private javax.swing.JLabel lblWarning1;
    private javax.swing.JTextField txtMatricula;
    // End of variables declaration//GEN-END:variables
}