/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pms.frames;

import com.pms.daoimpl.OrderDAOImpl;
import com.pms.daoimpl.OrderDetailDAOImpl;
import com.pms.models.OrderDetailsModel;
import com.pms.models.OrderModel;
import com.pms.models.RecieptModel;
import java.awt.Dimension;
import java.text.DecimalFormat;
import java.util.List;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Rehan Ali Azeemi
 */
public class ViewOrders extends javax.swing.JFrame {

    /**
     * Creates new form ViewOrders
     */
    public ViewOrders() {
        initComponents();
        fillViewOrderTable();
        this.setLocationRelativeTo(null);
    }
    
    private void fillViewOrderTable(){
        List<OrderModel> list = new OrderDAOImpl().getAllOrders();
        
        
        
        String[] colNames = {"ID","Customer","Order No","Amount Paid","Date-Time","Commision","Commision Type","Discount","Created By","Created Date","Modified By","Modified Date"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            };
        
        
        
        for(OrderModel order:list){
            
            Object[] row = {order.getOrderId(),order.getCustomer().getName(),order.getOrderNo(),order.getAmountPaid(),order.getTime(),order.getCommision(),order.getCommisionType().getCommisionType(),order.getDiscount(),order.getCreatedBy().getName(),order.getCreatedDate(),order.getModifiedBy().getName(),order.getModifiedDate()};
            
            dtm.addRow(row);
        }
        
        viewOrderTable.setModel(dtm);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        viewOrderDetail = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        orderNo = new javax.swing.JLabel();
        customer = new javax.swing.JLabel();
        dateTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        grandTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        viewOrderDetailTable = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        remaining = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        discount = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        amountPaid = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        comission = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        viewOrderTable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("Order No");

        jLabel3.setText("Customer");

        jLabel4.setText("Date/Time");

        orderNo.setText("jLabel5");

        customer.setText("jLabel6");

        dateTime.setText("jLabel7");

        jLabel8.setText("Grand Total");

        grandTotal.setText("jLabel9");

        viewOrderDetailTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(viewOrderDetailTable);

        jLabel5.setText("Remaining");

        remaining.setText("jLabel6");

        jLabel6.setText("Discount %");

        discount.setText("jLabel7");

        jLabel9.setText("Amount Paid");

        amountPaid.setText("jLabel10");

        jLabel11.setText("Comission %");

        comission.setText("sfsgs");

        javax.swing.GroupLayout viewOrderDetailLayout = new javax.swing.GroupLayout(viewOrderDetail.getContentPane());
        viewOrderDetail.getContentPane().setLayout(viewOrderDetailLayout);
        viewOrderDetailLayout.setHorizontalGroup(
            viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewOrderDetailLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(viewOrderDetailLayout.createSequentialGroup()
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(27, 27, 27)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(grandTotal)
                            .addComponent(orderNo)
                            .addComponent(dateTime)
                            .addComponent(customer))
                        .addGap(140, 140, 140)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addGap(65, 65, 65)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comission)
                            .addComponent(amountPaid)
                            .addComponent(discount)
                            .addComponent(remaining))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        viewOrderDetailLayout.setVerticalGroup(
            viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(viewOrderDetailLayout.createSequentialGroup()
                .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewOrderDetailLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(orderNo)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, viewOrderDetailLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(discount))))
                .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(viewOrderDetailLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel4))
                    .addGroup(viewOrderDetailLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(customer)
                            .addComponent(jLabel9)
                            .addComponent(amountPaid))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(dateTime)
                            .addComponent(jLabel11)
                            .addComponent(comission))))
                .addGap(13, 13, 13)
                .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(grandTotal)
                    .addComponent(jLabel8)
                    .addGroup(viewOrderDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel5)
                        .addComponent(remaining, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Search");

        search.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });
        search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchKeyReleased(evt);
            }
        });

        viewOrderTable.setModel(new javax.swing.table.DefaultTableModel(
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
        viewOrderTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                viewOrderTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(viewOrderTable);

        jButton1.setText("Back");
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
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(1119, 1119, 1119)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchKeyReleased
        String txt = search.getText().toString();
        TableRowSorter trs = new TableRowSorter(viewOrderTable.getModel());
        viewOrderTable.setRowSorter(trs);
        trs.setRowFilter(RowFilter.regexFilter("(?i)"+txt));
    }//GEN-LAST:event_searchKeyReleased

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchActionPerformed

    private void viewOrderTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_viewOrderTableMouseClicked
        if(evt.getClickCount() == 2){
            viewOrderDetail.setVisible(true);
            
            viewOrderDetail.setSize(new Dimension(600,500));
            viewOrderDetail.setLocationRelativeTo(null);
            orderNo.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 2)));
            customer.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 1)));
            dateTime.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 4)));
            fillDataIntoViewOrderDetailTable();
            grandTotal.setText(setGrandTotal());
            amountPaid.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 3)));
            comission.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 5)));
            discount.setText(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 7)));
            Integer months = new OrderDetailDAOImpl().getCommisionMonths((Integer) viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 0));
            getRemainingBalance(String.valueOf(viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 6)),months);
        }
    }//GEN-LAST:event_viewOrderTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
this.dispose();
       new HomeFrame1().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void getRemainingBalance(String commisionType,Integer months){
        
        double discountValue = (double) viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 7);
        double amountPaidValue = (double) viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 3);
        double comissionValue = (double) viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 5);
        
        if(commisionType.equals("monthly")){
            months += 1;
            double totalAmount = Double.parseDouble(String.valueOf(setGrandTotal()));
            double remainingBalance = totalAmount - (totalAmount * (discountValue/100.0));
            remainingBalance = remainingBalance - amountPaidValue;
            remainingBalance = (remainingBalance * (months*(comissionValue/100.0))) + remainingBalance;
            remaining.setText(String.valueOf(remainingBalance));
        }
        else if(commisionType.equals("quarter months")){
            if(months == 0){
		months += 1;
            }

            while(true){
		if(months%3 == 0){
			break;
		}
		months++;
            }
		
		int i = 1;
		int interval = 0;
		
		while(i<=months){
			++interval;
			i+=3;
		}
                
            double totalAmount = Double.parseDouble(String.valueOf(setGrandTotal()));
            double remainingBalance = totalAmount - (totalAmount * (discountValue/100.0));
            remainingBalance = remainingBalance - amountPaidValue;
            remainingBalance = (remainingBalance * (interval*(comissionValue/100.0))) + remainingBalance;
            remaining.setText(String.valueOf(remainingBalance));
        }
        else if(commisionType.equals("six months")){
            if(months == 0){
		months += 1;
            }

            while(true){
		if(months%6 == 0){
			break;
		}
		months++;
            }
		
		int i = 1;
		int interval = 0;
		
		while(i<=months){
			++interval;
			i+=6;
		}
                
            double totalAmount = Double.parseDouble(String.valueOf(setGrandTotal()));
            double remainingBalance = totalAmount - (totalAmount * (discountValue/100.0));
            remainingBalance = remainingBalance - amountPaidValue;
            remainingBalance = (remainingBalance * (interval*(comissionValue/100.0))) + remainingBalance;
            remaining.setText(String.valueOf(remainingBalance));
        }
        else if(commisionType.equals("yearly")){
            if(months == 0){
		months += 1;
            }

            while(true){
		if(months%12 == 0){
			break;
		}
		months++;
            }
		
		int i = 1;
		int interval = 0;
		
		while(i<=months){
			++interval;
			i+=12;
		}
                
            double totalAmount = Double.parseDouble(String.valueOf(setGrandTotal()));
            double remainingBalance = totalAmount - (totalAmount * (discountValue/100.0));
            remainingBalance = remainingBalance - amountPaidValue;
            remainingBalance = (remainingBalance * (interval*(comissionValue/100.0))) + remainingBalance;
            remaining.setText(String.valueOf(remainingBalance));
        }
        
       
        
    }
    
    private String setGrandTotal(){

        double sum = 0.0;
        
        
        for(int i=0; i<viewOrderDetailTable.getRowCount(); i++){
            sum += Double.parseDouble(String.valueOf( viewOrderDetailTable.getValueAt(i, 3))) * Double.parseDouble(String.valueOf( viewOrderDetailTable.getValueAt(i, 4)));
        }
        
        return ((new DecimalFormat("##.##").format(sum)));
    }
    
    private void fillDataIntoViewOrderDetailTable(){
        List<OrderDetailsModel> list = new OrderDetailDAOImpl().getOrderDetailsWithId((Integer) viewOrderTable.getValueAt(viewOrderTable.getSelectedRow(), 0));
        
        String[] colNames = {"ID","Order Id","Product Name","Price","Quantity"};
        DefaultTableModel dtm = new DefaultTableModel(colNames,0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; //To change body of generated methods, choose Tools | Templates.
            }
            };
        
        
        
        for(OrderDetailsModel order:list){
            
            Object[] row = {order.getDetialId(),order.getOrderModel().getOrderId(),order.getProductModel().getProductName(),order.getProductModel().getPrice(),order.getQuantity()};
            
            
            dtm.addRow(row);
        }
        
        viewOrderDetailTable.setModel(dtm);
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
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amountPaid;
    private javax.swing.JLabel comission;
    private javax.swing.JLabel customer;
    private javax.swing.JLabel dateTime;
    private javax.swing.JLabel discount;
    private javax.swing.JLabel grandTotal;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel orderNo;
    private javax.swing.JLabel remaining;
    private javax.swing.JTextField search;
    private javax.swing.JFrame viewOrderDetail;
    private javax.swing.JTable viewOrderDetailTable;
    private javax.swing.JTable viewOrderTable;
    // End of variables declaration//GEN-END:variables
}