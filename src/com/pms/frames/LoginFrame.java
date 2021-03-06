/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.frames;


import com.pms.daoimpl.UserDAOImpl;
import com.pms.models.UserModel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;


/**
 *
 * @author farhan baloch
 */
public class LoginFrame extends javax.swing.JFrame {
    public static UserModel userModel;
     /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        this.setBackground(new Color(0,0,0,0));
this.setSize(491, 371);
        this.setLocationRelativeTo(null);
       
         int i=1;
         i+=2;
         System.out.println(i);
    }
    
        
    public static boolean checkStringValidity(String str){
        Pattern pattern = Pattern.compile("[a-zA-Z ]*");
 
      
      Matcher matcher = pattern.matcher(str);
        if(matcher.matches()){
            return true;
        }
        
        return false;
    }
    
    public static boolean checkDecimalValidity(String str){
        
        if(str.matches("[0-9]{1,13}(\\.[0-9]*)?")){
            return true;
        }
        
        return false;
    }
    
    public static boolean checkIntegerValidity(String str){
        
        if(str.matches("[+-]?[0-9]{1,10}")){
            return true;
        }
        
        return false;
    }
    
    public static boolean checkAlphaNumericValidity(String str){
        
        if(str.matches("^(?=.*[A-Z])(?=.*[0-9])[A-Z0-9]+$")){
            return true;
        }
        
        return false;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        passField = new javax.swing.JPasswordField();
        userField = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setUndecorated(true);
        getContentPane().setLayout(null);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setOpaque(false);
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("X");
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel5);
        jLabel5.setBounds(430, 20, 50, 40);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(140, 198, 62));
        jLabel4.setText("Login Form");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(180, 0, 150, 80);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel2);
        jLabel2.setBounds(380, 140, 30, 50);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel3.add(jLabel3);
        jLabel3.setBounds(380, 220, 30, 50);

        passField.setBackground(new java.awt.Color(250, 250, 250));
        passField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        passField.setForeground(new java.awt.Color(102, 102, 102));
        passField.setText("PASSWORD");
        passField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        passField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                passFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                passFieldFocusLost(evt);
            }
        });
        passField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passFieldKeyPressed(evt);
            }
        });
        jPanel3.add(passField);
        passField.setBounds(90, 220, 320, 50);

        userField.setBackground(new java.awt.Color(250, 250, 250));
        userField.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        userField.setForeground(new java.awt.Color(102, 102, 102));
        userField.setText("USERNAME");
        userField.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        userField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                userFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                userFieldFocusLost(evt);
            }
        });
        userField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userFieldKeyPressed(evt);
            }
        });
        jPanel3.add(userField);
        userField.setBounds(90, 140, 320, 50);

        jLabel7.setBackground(new java.awt.Color(140, 198, 62));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Login");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setOpaque(true);
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel7);
        jLabel7.setBounds(180, 310, 140, 50);

        jLabel8.setBackground(new java.awt.Color(11, 18, 29));
        jLabel8.setOpaque(true);
        jPanel3.add(jLabel8);
        jLabel8.setBounds(-2, -6, 500, 90);

        jLabel1.setBackground(new java.awt.Color(235, 235, 235));
        jLabel1.setOpaque(true);
        jPanel3.add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 380);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 490, 370);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void userFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userFieldKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_userFieldKeyPressed

    private void passFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passFieldKeyPressed
        // TODO add your handling code here:
         if(evt.getKeyCode()==KeyEvent.VK_ENTER){
           login();
       }
    }//GEN-LAST:event_passFieldKeyPressed

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
            // TODO add your handling code here:
            login();
    }//GEN-LAST:event_jLabel7MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void userFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFieldFocusGained
        // TODO add your handling code here:
        if(userField.getText().equals("USERNAME")){
        userField.setText("");
        }
    }//GEN-LAST:event_userFieldFocusGained

    private void userFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_userFieldFocusLost
        // TODO add your handling code here:
        if(userField.getText().isEmpty()){
            userField.setText("USERNAME");
        }
    }//GEN-LAST:event_userFieldFocusLost

    private void passFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFieldFocusGained
        // TODO add your handling code here:
        if(passField.getText().equals("PASSWORD")){
        passField.setEchoChar(new JPasswordField().getEchoChar());
       passField.setText(""); 
        }
    }//GEN-LAST:event_passFieldFocusGained

    private void passFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_passFieldFocusLost
        // TODO add your handling code here:
        if(passField.getText().isEmpty()){
            passField.setText("PASSWORD");
            passField.setEchoChar(new JPasswordField().getEchoChar());
        }
    }//GEN-LAST:event_passFieldFocusLost
    private void login(){
        if(userField.getText().equals("") || passField.getText().equals("")){
            JOptionPane.showMessageDialog(this, "Fields are empty");
        }else{
            userModel = new UserDAOImpl().checkLogin(userField.getText(), passField.getText());
               
            if(userModel != null){
                
                new MainFrame().setVisible(true);
                this.dispose();
            }
            else{
               JOptionPane.showMessageDialog(null, "You Entered a Wrong Password");
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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField passField;
    private javax.swing.JTextField userField;
    // End of variables declaration//GEN-END:variables
}
