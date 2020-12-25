/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.view;

import fpt.edu.lab.dao.BillDao;
import fpt.edu.lab.dao.BillDetailsDao;
import fpt.edu.lab.dao.StockDao;
import fpt.edu.lab.dao.StockDetailsDao;
import fpt.edu.lab.model.Bill;
import fpt.edu.lab.model.BillDetails;
import fpt.edu.lab.model.Product;
import fpt.edu.lab.model.Stock;
import fpt.edu.lab.model.StockDetails;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hi
 */
public class ReportingJPanel extends javax.swing.JPanel {

    int billIdSelected = -1;
    int stockIdSelected = -1;
    ResourceBundle bundle;
    DefaultTableModel billTableModel;
    DefaultTableModel stockTableModel;
    ArrayList<Bill> listBills;
    ArrayList<Stock> listStocks;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");

    /**
     * Creates new form ReportingJPanel
     *
     * @param bundle
     */
    public ReportingJPanel(ResourceBundle bundle) {
        initComponents();
        this.bundle = bundle;
        billTableModel = (DefaultTableModel) jtbBill.getModel();
        stockTableModel = (DefaultTableModel) jtbStock.getModel();
        addColumnBillTable();
        addColumnStockTable();
        //lấy ra tháng hiện tại để load lên table
        LocalDateTime currentDate = LocalDateTime.now();
        int currentMonth = currentDate.getMonthValue();
        jcbMonthStock.setSelectedItem(String.valueOf(currentMonth));
        jcbMonthBill.setSelectedItem(String.valueOf(currentMonth));
        listBills = BillDao.getAllBillByMonth(currentMonth);
        listStocks = StockDao.getAllStockByMonth(currentMonth);
        loadToBillTable(listBills);
        loadToStockTable(listStocks);
        setUpUILanguage();
    }

    public void setUpUILanguage() {
        jPanel1.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnCheckBill")));
        jPanel2.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnCheckStock")));
        jlbCheckBill.setText(bundle.getString("jlbCheckBillByMonth"));
        jbtnViewBill.setText(bundle.getString("jbtnView"));
        jbtnViewStock.setText(bundle.getString("jbtnView"));
        jlbCheckMonth.setText(bundle.getString("jlbCheckStockByMonth"));
        jbtnViewBillDetails.setText(bundle.getString("jlbViewDetails"));
        jbtnViewStockDetails.setText(bundle.getString("jlbViewDetails"));
    }

    public void addColumnBillTable() {
        billTableModel.addColumn(bundle.getString("BillID"));
        billTableModel.addColumn(bundle.getString("Sellername"));
        billTableModel.addColumn(bundle.getString("Date"));
        billTableModel.addColumn(bundle.getString("TotalPrice"));
    }

    public void addColumnStockTable() {
        stockTableModel.addColumn(bundle.getString("StockID"));
        stockTableModel.addColumn(bundle.getString("Staffname"));
        stockTableModel.addColumn(bundle.getString("Date"));
        stockTableModel.addColumn(bundle.getString("jlbType"));
    }

    public void loadToBillTable(ArrayList<Bill> listBills) {
        while (billTableModel.getRowCount() > 0) {
            billTableModel.removeRow(0);
        }
        double totalPrice = 0;
        for (Bill bill : listBills) {
            billTableModel.addRow(new Object[]{
                bill.getBill_id(), bill.getSellername(), bill.getOrder_date(), bill.getTotal_price()
            });
            //cộng tổng price
            totalPrice += bill.getTotal_price();
        }
        jlbTotalPrice.setText(bundle.getString("jlbTotalBillPrice") + ": " + totalPrice);
    }

    public void loadToStockTable(ArrayList<Stock> listStocks) {
        while (stockTableModel.getRowCount() > 0) {
            stockTableModel.removeRow(0);
        }
        for (Stock stock : listStocks) {
            stockTableModel.addRow(new Object[]{
                stock.getStockId(), stock.getStaffName(), stock.getDate(), stock.getTypeStock()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbCheckBill = new javax.swing.JLabel();
        jcbMonthBill = new javax.swing.JComboBox<>();
        jbtnViewBill = new javax.swing.JButton();
        jlbTotalPrice = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbBill = new javax.swing.JTable();
        jbtnViewBillDetails = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jlbCheckMonth = new javax.swing.JLabel();
        jcbMonthStock = new javax.swing.JComboBox<>();
        jbtnViewStock = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbStock = new javax.swing.JTable();
        jbtnViewStockDetails = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Check Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jlbCheckBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbCheckBill.setText("Check Bill By Month");

        jcbMonthBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbMonthBill.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jbtnViewBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewBill.setText("View");
        jbtnViewBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewBillActionPerformed(evt);
            }
        });

        jlbTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbTotalPrice.setText("Total Price:");

        jtbBill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbBill.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbBillMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbBill);

        jbtnViewBillDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewBillDetails.setText("View Details");
        jbtnViewBillDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewBillDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlbCheckBill)
                        .addGap(18, 18, 18)
                        .addComponent(jcbMonthBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbtnViewBill)
                        .addGap(30, 30, 30)
                        .addComponent(jlbTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnViewBillDetails)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCheckBill)
                    .addComponent(jbtnViewBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMonthBill, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbTotalPrice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnViewBillDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Check Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jlbCheckMonth.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbCheckMonth.setText("Check Stock By Month");

        jcbMonthStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbMonthStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));

        jbtnViewStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewStock.setText("View");
        jbtnViewStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewStockActionPerformed(evt);
            }
        });

        jtbStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbStockMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jtbStock);

        jbtnViewStockDetails.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnViewStockDetails.setText("View Details");
        jbtnViewStockDetails.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnViewStockDetailsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbCheckMonth)
                        .addGap(18, 18, 18)
                        .addComponent(jcbMonthStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jbtnViewStock)
                        .addGap(0, 638, Short.MAX_VALUE))
                    .addComponent(jScrollPane2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jbtnViewStockDetails)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbCheckMonth)
                    .addComponent(jbtnViewStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbMonthStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jbtnViewStockDetails, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnViewBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewBillActionPerformed
        String monthStr = jcbMonthBill.getSelectedItem().toString();
        int month = Integer.parseInt(monthStr);
        listBills = BillDao.getAllBillByMonth(month);
        loadToBillTable(listBills);
    }//GEN-LAST:event_jbtnViewBillActionPerformed

    private void jtbBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBillMouseClicked
        billIdSelected = Integer.parseInt(billTableModel.getValueAt(jtbBill.getSelectedRow(), 0).toString());

    }//GEN-LAST:event_jtbBillMouseClicked

    private void jbtnViewBillDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewBillDetailsActionPerformed
        if (billIdSelected == -1) {
            JOptionPane.showMessageDialog(this, bundle.getString("joChooseBillInTable"));
            return;
        }
        ArrayList<BillDetails> listBillDetailses = BillDetailsDao.getBillDetails(billIdSelected);
        ViewBillDetailsJPanel viewBillDetails = new ViewBillDetailsJPanel(listBillDetailses,bundle);
        viewBillDetails.setLocationRelativeTo(this);
        viewBillDetails.setVisible(true);
    }//GEN-LAST:event_jbtnViewBillDetailsActionPerformed

    private void jbtnViewStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewStockActionPerformed
        int monthSelect = Integer.parseInt(jcbMonthStock.getSelectedItem().toString());
        listStocks = StockDao.getAllStockByMonth(monthSelect);
        loadToStockTable(listStocks);
    }//GEN-LAST:event_jbtnViewStockActionPerformed

    private void jtbStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStockMouseClicked
        stockIdSelected = Integer.parseInt(stockTableModel.getValueAt(jtbStock.getSelectedRow(), 0).toString());
    }//GEN-LAST:event_jtbStockMouseClicked

    private void jbtnViewStockDetailsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnViewStockDetailsActionPerformed
        if (stockIdSelected == -1) {
            JOptionPane.showMessageDialog(this, bundle.getString("joChooseBillInTable"));
            return;
        }
        ArrayList<StockDetails> listStockDetailses = StockDetailsDao.getStockDetails(stockIdSelected);
        ViewStockDetailsJPanel viewStockDetails = new ViewStockDetailsJPanel(listStockDetailses, bundle);
        viewStockDetails.setLocationRelativeTo(this);
        viewStockDetails.setVisible(true);
    }//GEN-LAST:event_jbtnViewStockDetailsActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtnViewBill;
    private javax.swing.JButton jbtnViewBillDetails;
    private javax.swing.JButton jbtnViewStock;
    private javax.swing.JButton jbtnViewStockDetails;
    private javax.swing.JComboBox<String> jcbMonthBill;
    private javax.swing.JComboBox<String> jcbMonthStock;
    private javax.swing.JLabel jlbCheckBill;
    private javax.swing.JLabel jlbCheckMonth;
    private javax.swing.JLabel jlbTotalPrice;
    private javax.swing.JTable jtbBill;
    private javax.swing.JTable jtbStock;
    // End of variables declaration//GEN-END:variables
}