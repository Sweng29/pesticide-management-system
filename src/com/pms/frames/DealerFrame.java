/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.frames;

import com.pms.daoimpl.CompanyDAOImpl;
import com.pms.daoimpl.CustomerDAOImpl;
import com.pms.daoimpl.DealerDaoImpl;
import com.pms.daoimpl.UserDAOImpl;
import com.pms.models.CompanyModel;
import com.pms.models.CustomerModel;
import com.pms.models.DealerModel;
import java.sql.Timestamp;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Asif Ali
 */
public class DealerFrame extends javax.swing.JFrame {

    /**
     * Creates new form CustomerFrame
     */
    public DealerFrame() {
        initComponents();
        fillCustomerTable();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Update = new javax.swing.JDialog();
        jcustomerField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jcontactfield = new javax.swing.JFormattedTextField();
        Delete = new javax.swing.JPopupMenu();
        DeleteRow = new javax.swing.JMenuItem();
        Add = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jcustomerfield = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jcustomercontactfield = new javax.swing.JFormattedTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DealerTable = new javax.swing.JTable();
        addbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        customersearch = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        Update.setBounds(new java.awt.Rectangle(0, 0, 350, 300));

        jLabel3.setText("CustomerName");

        jLabel4.setText("Contact");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Update");

        jButton2.setText("Confirm");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        try {
            jcontactfield.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+92###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout UpdateLayout = new javax.swing.GroupLayout(Update.getContentPane());
        Update.getContentPane().setLayout(UpdateLayout);
        UpdateLayout.setHorizontalGroup(
            UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateLayout.createSequentialGroup()
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcustomerField, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(jcontactfield)))
                    .addGroup(UpdateLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jButton2)
                        .addGap(27, 27, 27)
                        .addComponent(jButton3)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        UpdateLayout.setVerticalGroup(
            UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(UpdateLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(38, 38, 38)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jcustomerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jcontactfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(UpdateLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(104, Short.MAX_VALUE))
        );

        DeleteRow.setText("DeleteRow");
        DeleteRow.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteRowActionPerformed(evt);
            }
        });
        Delete.add(DeleteRow);

        Add.setBounds(new java.awt.Rectangle(0, 0, 352, 300));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Add Dealer");

        jLabel7.setText("Name");

        jLabel8.setText("Contact");

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Cancel");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        try {
            jcustomercontactfield.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("+92###-#######")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout AddLayout = new javax.swing.GroupLayout(Add.getContentPane());
        Add.getContentPane().setLayout(AddLayout);
        AddLayout.setHorizontalGroup(
            AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddLayout.createSequentialGroup()
                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AddLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(jLabel6))
                    .addGroup(AddLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcustomerfield, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE)
                            .addComponent(jcustomercontactfield)))
                    .addGroup(AddLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton5)))
                .addContainerGap(101, Short.MAX_VALUE))
        );
        AddLayout.setVerticalGroup(
            AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AddLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jcustomerfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcustomercontactfield, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(AddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton5))
                .addGap(58, 58, 58))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        DealerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        DealerTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DealerTableMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                DealerTableMouseReleased(evt);
            }
        });
        jScrollPane1.setViewportView(DealerTable);

        addbtn.setText("Add Dealer");
        addbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbtnActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Dealer Panel");

        jLabel2.setText("Dealer Name");

        customersearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customersearchKeyReleased(evt);
            }
        });

        jButton6.setText("Back");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton6)
                        .addGap(231, 231, 231)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(customersearch, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(customersearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(addbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DealerTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DealerTableMouseClicked
       System.out.println(evt.getClickCount());
        if(evt.getClickCount()==2){
            Update.setLocationRelativeTo(DealerTable);
            jcustomerField.setText(DealerTable.getValueAt(DealerTable.getSelectedRow(), 1).toString());
            jcontactfield.setText(DealerTable.getValueAt(DealerTable.getSelectedRow(), 2).toString());
        Update.setVisible(true);
        }
    }//GEN-LAST:event_DealerTableMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       Update.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void customersearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customersearchKeyReleased
String customerName = customersearch.getText();
        TableRowSorter tableRowSorter = new TableRowSorter(DealerTable.getModel());
        DealerTable.setRowSorter(tableRowSorter);
        tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+customerName));
    }//GEN-LAST:event_customersearchKeyReleased

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
  if(jcustomerField.getText().equals("")||jcontactfield.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Any Field Should Not Be Empty");
        }else{
      if(checkValidityForUpdate()){
        DealerModel dealerModel = new DealerModel();
        Integer customerId = Integer.parseInt(DealerTable.getValueAt(DealerTable.getSelectedRow(),0).toString());
       dealerModel.setCustomerId(customerId);
       String customerName = jcustomerField.getText();
       dealerModel.setDealerName(customerName);
       String contact = jcontactfield.getText();
       dealerModel.setContact(contact);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        dealerModel.setModifiedBy(LoginFrame.userModel);
        dealerModel.setModifiedDate(timestamp);
        DealerDaoImpl dealerDaoImpl = new DealerDaoImpl();
        int row = dealerDaoImpl .updateDealer(dealerModel);
        if(row>0){
            JOptionPane.showMessageDialog(rootPane, "Updated");
            fillCustomerTable();
            Update.dispose();
        }else{
         JOptionPane.showMessageDialog(rootPane, "NotUpdated");
        }
      }
  }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void DeleteRowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteRowActionPerformed
       DealerModel dealerModel = new DealerModel();
        Integer customerId = Integer.parseInt(DealerTable.getValueAt(DealerTable.getSelectedRow(),0).toString());
      dealerModel.setCustomerId(customerId);
      dealerModel.setActive(false);
 DealerDaoImpl dealerDaoImpl = new DealerDaoImpl();
        int row = dealerDaoImpl.deleteDealer(dealerModel);
        if(row>0){
            JOptionPane.showMessageDialog(rootPane, "Deleted");
            fillCustomerTable();
            
        }else{
         JOptionPane.showMessageDialog(rootPane, "NotDeleted");
        }
      
    }//GEN-LAST:event_DeleteRowActionPerformed

    private void DealerTableMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DealerTableMouseReleased
        if(evt.isPopupTrigger()){
        Delete.show(DealerTable,evt.getX(),evt.getY());
        }
    }//GEN-LAST:event_DealerTableMouseReleased

    private void addbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbtnActionPerformed
        Add.setLocationRelativeTo(DealerTable);
        Add.setVisible(true);
       
    }//GEN-LAST:event_addbtnActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Add.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
  if(jcustomerfield.getText().equals("")||jcustomercontactfield.getText().equals("")){
        JOptionPane.showMessageDialog(rootPane, "Any Field Should Not Be Empty");
        }else{  
if(checkValidityForInsert()){
        String customerName = jcustomerfield.getText();
        String contact = jcustomercontactfield.getText();
        
        DealerModel dealerModel = new DealerModel();
        dealerModel.setDealerName(customerName);
        dealerModel.setContact(contact);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
      dealerModel.setCreatedBy(LoginFrame.userModel);
        dealerModel.setCreatedDate(timestamp);
        dealerModel.setModifiedBy(LoginFrame.userModel);
        dealerModel.setModifiedDate(timestamp);
        dealerModel.setActive(true);
        DealerDaoImpl dealerDaoImpl = new DealerDaoImpl();
        int row = dealerDaoImpl.addDealer(dealerModel);
        if(row>0){
        JOptionPane.showMessageDialog(rootPane, "Data Inserted");
        fillCustomerTable();
        Add.dispose();
        }
        else{
            JOptionPane.showMessageDialog(rootPane, "Not Inserted");
        }
            }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

       new HomeFrame1().setVisible(true); 
       this.dispose();
              // TODO add your handling code here:
// TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

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
            java.util.logging.Logger.getLogger(DealerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DealerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DealerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DealerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DealerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog Add;
    private javax.swing.JTable DealerTable;
    private javax.swing.JPopupMenu Delete;
    private javax.swing.JMenuItem DeleteRow;
    private javax.swing.JDialog Update;
    private javax.swing.JButton addbtn;
    private javax.swing.JTextField customersearch;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JFormattedTextField jcontactfield;
    private javax.swing.JTextField jcustomerField;
    private javax.swing.JFormattedTextField jcustomercontactfield;
    private javax.swing.JTextField jcustomerfield;
    // End of variables declaration//GEN-END:variables

    private void fillCustomerTable() {
        DefaultTableModel defaultTableModel = new DefaultTableModel(){
         @Override
         public boolean isCellEditable(int row, int column) {
             return false; //To change body of generated methods, choose Tools | Templates.
         }    
     };
        defaultTableModel.addColumn("Id");
        defaultTableModel.addColumn("DealerName");
        defaultTableModel.addColumn("Contact");
        defaultTableModel.addColumn("CreatedBy");
        defaultTableModel.addColumn("CreatedDate");
        defaultTableModel.addColumn("ModifiedBy");
        defaultTableModel.addColumn("ModifiedDate");
        
        DealerDaoImpl dealerDaoImpl = new DealerDaoImpl();
List<DealerModel> dealer = dealerDaoImpl.getDealerDetails();

for(DealerModel list:dealer){

    Object []items = {list.getCustomerId(),list.getDealerName(),list.getContact(),list.getCreatedBy().getName(),list.getCreatedDate(),list.getModifiedBy().getName(),list.getModifiedDate()};

    defaultTableModel.addRow(items);
}
    DealerTable.setModel(defaultTableModel);

    }
     private boolean checkValidityForUpdate(){
        if(!LoginFrame.checkStringValidity(jcustomerField.getText())){
            JOptionPane.showMessageDialog(this, "Name Field Contains only Alphabet letters");
            return false;
        }
        
        if(jcontactfield.getText().trim().length() != 14){
            JOptionPane.showMessageDialog(this, "Invalid Contact");
            return false;
        }
        return true;
    }
    
    private boolean checkValidityForInsert(){
        if(!LoginFrame.checkStringValidity(jcustomerfield.getText())){
            JOptionPane.showMessageDialog(this, "Name Field Contains only Alphabet letters");
            return false;
        }
        
        if(jcustomercontactfield.getText().trim().length() != 14){
            JOptionPane.showMessageDialog(this, "Invalid Contact");
            return false;
        }
        return true;
    }
    
}
