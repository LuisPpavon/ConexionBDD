/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.intsuperior.vista;

import com.mysql.jdbc.PreparedStatement;
import ec.edu.intsuperior.controlador.Conexion;
import static ec.edu.intsuperior.controlador.Conexion.conexion;
import ec.edu.intsuperior.controlador.Controlador;
import java.sql.Connection;
import javax.swing.JOptionPane;

/**
 *
 * @author Santiago
 */
public class LoginDocente extends javax.swing.JPanel {

    /**
     * Creates new form LoginDocente
     */
    Controlador controlador;
    public LoginDocente(Controlador controlador) {
        initComponents();
        this.controlador=controlador;
        //setSize(400, 400);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txtPass = new javax.swing.JPasswordField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txtLogin = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        cbxTipoUser = new javax.swing.JComboBox<>();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("LOGIN DOCENTE");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(153, 22, 226, 23));

        jLabel2.setText("ID:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 78, 29));

        jLabel3.setText("Password:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(104, 128, 78, 29));
        add(txtId, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 185, -1));

        jButton1.setText("Conexion");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(218, 190, -1, -1));
        add(txtPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 132, 185, -1));

        jButton2.setText("Ingresar Datos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, -1, -1));

        jButton3.setText("Consultar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 190, -1, -1));
        add(txtLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 92, 185, -1));

        jLabel4.setText("Login:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 88, 78, 29));

        jButton4.setText("Abrir Formulario Docente");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 180, -1, -1));

        cbxTipoUser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Docente ", "Estudiante" }));
        add(cbxTipoUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 70, 140, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        controlador.conectar();
        


        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
 Conexion c = new Conexion();

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       Connection cn;
        try {
            cn=conexion();
            java.sql.PreparedStatement ps;
            ps=cn.prepareStatement("INSERT INTO usuario(idUser,user,passw)values(?,?,?)");
            ps.setInt(1,Integer.parseInt(txtId.getText()));
            ps.setString(2,txtLogin.getText());
            ps.setString(3,txtPass.getText());
            if(ps.executeUpdate()==1){
            System.out.println("datos ingresados");
        }else{
                System.out.println("error");
            }
        } catch (Exception e) {
        }
        
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       
        c.consultarUsuarios();

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if(cbxTipoUser.getSelectedItem().toString().trim().equals("Docente")){
            controlador.mostrarFrmDocente();
        }else{
            JOptionPane.showMessageDialog(null,"user no hallado");
        }
        

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxTipoUser;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPass;
    // End of variables declaration//GEN-END:variables
}
