/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.view;

import fpt.edu.lab.dao.CategoryDao;
import fpt.edu.lab.dao.ProductDao;
import fpt.edu.lab.model.Category;
import fpt.edu.lab.model.Product;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Hi
 */
public class ProductJPanel extends javax.swing.JPanel {

    DefaultTableModel dtm;
    ArrayList<Product> listProducts;
    ArrayList<Category> categorys;
    ResourceBundle bundle;

    /**
     * Creates new form ProductJPanel
     *
     * @param bundle
     */
    public ProductJPanel(ResourceBundle bundle) {
        initComponents();
        this.bundle = bundle;
        categorys = CategoryDao.getAllCategory();
        dtm = (DefaultTableModel) jtbProductTable.getModel();
        addColumnTable();
        jtaProductDescription.setLineWrap(true);
        jtaProductDescription.setWrapStyleWord(true);
        loadCategoryToCB();
        setUpUILanguage();
        sortFeature();
        setSizeColumn();
        listProducts = ProductDao.getAllProduct();
        loadToTable(listProducts);
    }

    public void setUpUILanguage() {
        jlbProductCode.setText(bundle.getString("ProductCode"));
        jlbProductName.setText(bundle.getString("ProductName"));
        jlbProductPrice.setText(bundle.getString("Price"));
        jlbProductQuantity.setText(bundle.getString("Quantity"));
        jlbListByCategory.setText(bundle.getString("Category"));
        jlbProductCategory.setText(bundle.getString("Category"));
        jlbProductDescription.setText(bundle.getString("Description"));
        jbtnAdd.setText(bundle.getString("jbtnAddNew"));
        jbtnUpdate.setText(bundle.getString("jbtnUpdate"));
        jbtnDelete.setText(bundle.getString("jbtnDelete"));
        jbtnListAll.setText(bundle.getString("jbtnListAll"));
        jbtnListByCategory.setText(bundle.getString("jbtnList"));
        jbtnSearch.setText(bundle.getString("jbtnSearch"));
        jlbSearchProduct.setText(bundle.getString("jlbSearchProduct"));
        jlbListAllProduct.setText(bundle.getString("jlbListAll"));
        jPanel3.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnProductList")));
        jPanel1.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnProduct")));
        jPanel2.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnList&Search")));
    }

    public void sortFeature() {
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(dtm);
        jtbProductTable.setRowSorter(sorter);
    }

    public void addColumnTable() {
        dtm.addColumn(bundle.getString("ProductCode"));
        dtm.addColumn(bundle.getString("ProductName"));
        dtm.addColumn(bundle.getString("Price"));
        dtm.addColumn(bundle.getString("Quantity"));
        dtm.addColumn(bundle.getString("Category"));
        dtm.addColumn(bundle.getString("Description"));
    }

    public void setSizeColumn() {
        TableColumnModel columnModel = jtbProductTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(100);
        columnModel.getColumn(2).setPreferredWidth(30);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(80);
        columnModel.getColumn(5).setPreferredWidth(250);
    }

    public void loadCategoryToCB() {
        DefaultComboBoxModel dcbm1 = (DefaultComboBoxModel) jcbProductCategory.getModel();
        DefaultComboBoxModel dcbm2 = (DefaultComboBoxModel) jcbProductCategorySearch.getModel();
        for (Category cat : categorys) {
            dcbm1.addElement((cat.getCategoryName().trim()));
            dcbm2.addElement((cat.getCategoryName().trim()));
        }
    }

    public void loadToTable(ArrayList<Product> listProducts) {
        while (dtm.getRowCount() > 0) {
            dtm.removeRow(0);
        }
        for (Product p : listProducts) {
            dtm.addRow(new Object[]{
                p.getProduct_code(), p.getProduct_name(),
                p.getPrice(), p.getQuantity(), p.getCategory_name(), p.getDescription()
            });
        }
    }

    public int getCategoryId(String categoryName) {
        int id = -1;
        categorys = CategoryDao.getAllCategory();
        for (int i = 0; i < categorys.size(); i++) {
            if (categorys.get(i).getCategoryName().equalsIgnoreCase(categoryName)) {
                id = categorys.get(i).getCategoryId();
                break;
            }
        }
        return id;
    }

    public int getIndexCategory(String categoryName) {
        int pos = -1;
        for (int i = 0; i < categorys.size(); i++) {
            if (categorys.get(i).getCategoryName().equalsIgnoreCase(categoryName)) {
                return i;
            }
        }
        return pos;
    }

    public boolean checkDuplicateProduct(String productcode) {
        for (Product p : listProducts) {
            if (productcode.equalsIgnoreCase(p.getProduct_code())) {
                return true;
            }
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

        jPanel1 = new javax.swing.JPanel();
        jtfProductCode = new javax.swing.JTextField();
        jtfProductName = new javax.swing.JTextField();
        jtfProductPrice = new javax.swing.JTextField();
        jtfProductQuantity = new javax.swing.JTextField();
        jcpTextAreaDescription = new javax.swing.JScrollPane();
        jtaProductDescription = new javax.swing.JTextArea();
        jlbProductCode = new javax.swing.JLabel();
        jlbProductName = new javax.swing.JLabel();
        jlbProductPrice = new javax.swing.JLabel();
        jlbProductQuantity = new javax.swing.JLabel();
        jlbProductDescription = new javax.swing.JLabel();
        jbtnAdd = new javax.swing.JButton();
        jbtnUpdate = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jlbProductCategory = new javax.swing.JLabel();
        jcbProductCategory = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jlbListByCategory = new javax.swing.JLabel();
        jcbProductCategorySearch = new javax.swing.JComboBox<>();
        jbtnListByCategory = new javax.swing.JButton();
        jbtnListAll = new javax.swing.JButton();
        jlbListAllProduct = new javax.swing.JLabel();
        jlbSearchProduct = new javax.swing.JLabel();
        jtfSearchCode = new javax.swing.JTextField();
        jbtnSearch = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbProductTable = new javax.swing.JTable();

        setMaximumSize(new java.awt.Dimension(930, 640));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtfProductCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfProductPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jtfProductQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jcpTextAreaDescription.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jcpTextAreaDescription.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtaProductDescription.setColumns(20);
        jtaProductDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtaProductDescription.setRows(5);
        jcpTextAreaDescription.setViewportView(jtaProductDescription);

        jlbProductCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductCode.setText("Product Code");

        jlbProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductName.setText("Product Name");

        jlbProductPrice.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductPrice.setText("Product Price");

        jlbProductQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductQuantity.setText("Product Quantity");

        jlbProductDescription.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductDescription.setText("Product Description");

        jbtnAdd.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnAdd.setText("Add New");
        jbtnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddActionPerformed(evt);
            }
        });

        jbtnUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnUpdate.setText("Update");
        jbtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateActionPerformed(evt);
            }
        });

        jbtnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jlbProductCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbProductCategory.setText("Product Category");

        jcbProductCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnUpdate)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(86, 86, 86))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jlbProductCode)
                                    .addComponent(jlbProductName)
                                    .addComponent(jlbProductPrice)
                                    .addComponent(jlbProductQuantity)
                                    .addComponent(jlbProductCategory))
                                .addGap(25, 25, 25))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlbProductDescription)
                                .addGap(14, 14, 14)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jcpTextAreaDescription, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jcbProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfProductPrice, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                            .addComponent(jtfProductName)
                            .addComponent(jtfProductQuantity)
                            .addComponent(jtfProductCode))
                        .addGap(52, 52, 52)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbProductCode))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbProductName))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbProductPrice))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbProductQuantity)
                    .addComponent(jtfProductQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProductCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbProductCategory))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jlbProductDescription))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jcpTextAreaDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List & Search", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jlbListByCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbListByCategory.setText("List By Category:");

        jcbProductCategorySearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbtnListByCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnListByCategory.setText("List");
        jbtnListByCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnListByCategoryActionPerformed(evt);
            }
        });

        jbtnListAll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnListAll.setText("List All");
        jbtnListAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnListAllActionPerformed(evt);
            }
        });

        jlbListAllProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbListAllProduct.setText("List All Product");

        jlbSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbSearchProduct.setText("Search By Product:");

        jtfSearchCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbtnSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSearch.setText("Search");
        jbtnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchActionPerformed(evt);
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
                        .addComponent(jlbListByCategory)
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addComponent(jcbProductCategorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnListByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jlbSearchProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jlbListAllProduct, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jbtnListAll)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(jtfSearchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jbtnSearch)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbListAllProduct)
                    .addComponent(jbtnListAll, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbSearchProduct)
                    .addComponent(jtfSearchCode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbListByCategory)
                    .addComponent(jcbProductCategorySearch, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnListByCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtbProductTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbProductTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jtbProductTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbProductTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbProductTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 853, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 473, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductTableMouseClicked
        jtfProductCode.setText(dtm.getValueAt(jtbProductTable.getSelectedRow(), 0).toString());
        jtfProductName.setText(dtm.getValueAt(jtbProductTable.getSelectedRow(), 1).toString());
        jtfProductPrice.setText(dtm.getValueAt(jtbProductTable.getSelectedRow(), 2).toString());
        jtfProductQuantity.setText(dtm.getValueAt(jtbProductTable.getSelectedRow(), 3).toString());
        jcbProductCategory.setSelectedIndex(getIndexCategory(dtm.getValueAt(jtbProductTable.getSelectedRow(), 4).toString()));
        jtaProductDescription.setText(dtm.getValueAt(jtbProductTable.getSelectedRow(), 5).toString());
    }//GEN-LAST:event_jtbProductTableMouseClicked

    private void jbtnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddActionPerformed
        String productCode = jtfProductCode.getText();
        if (checkDuplicateProduct(productCode)) {
            JOptionPane.showMessageDialog(this, bundle.getString("joCheckProductInList"));
            return;
        }
        String productName = jtfProductName.getText();
        String description = jtaProductDescription.getText();
        //kiểm tra các trường nhập vào có rỗng hay không
        if ("".equals(productCode) || "".equals(productName)) {
            JOptionPane.showMessageDialog(this, bundle.getString("joEmptyInput"));
            return;
        }
        double price;
        //kiểm tra tiền nhập vào có phải là một số hay không
        try {
            price = Double.parseDouble(jtfProductPrice.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputPrice"));
            return;
        }
        int quantity;
        //kiểm tra số lượng nhập vào có phải là một số hay không
        try {
            quantity = Integer.parseInt(jtfProductQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"));
            return;
        }
        String productCategory = jcbProductCategory.getSelectedItem().toString();
        Product product = new Product(productCode, productName, description, price, quantity, productCategory);
        //đưa vào database
        ProductDao.addProduct(product, getCategoryId(productCategory));
        //làm mới lại table
        listProducts = ProductDao.getAllProduct();
        loadToTable(listProducts);
    }//GEN-LAST:event_jbtnAddActionPerformed

    private void jbtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateActionPerformed
        String productCode = jtfProductCode.getText();
        String productName = jtfProductName.getText();
        //kiểm tra các trường nhập vào có rỗng hay không
        if ("".equals(productCode) || "".equals(productName)) {
            JOptionPane.showMessageDialog(this, bundle.getString("joEmptyInput"));
            return;
        }
        String description = jtaProductDescription.getText();
        double price;
        //kiểm tra tiền nhập vào có phải là một số hay không
        try {
            price = Double.parseDouble(jtfProductPrice.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputPrice"));
            return;
        }
        int quantity;
        //kiểm tra số lượng nhập vào có phải là một số hay không
        try {
            quantity = Integer.parseInt(jtfProductQuantity.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"));
            return;
        }
        String productCategory = jcbProductCategory.getSelectedItem().toString();
        Product product = new Product(productCode, productName, description, price, quantity, productCategory);
        //update lại database
        ProductDao.updateProduct(productCode, product, getCategoryId(productCategory));
        //làm mới lại table
        listProducts = ProductDao.getAllProduct();
        loadToTable(listProducts);
    }//GEN-LAST:event_jbtnUpdateActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        String productCode = jtfProductCode.getText();
        ProductDao.deleteProduct(productCode);
        listProducts = ProductDao.getAllProduct();
        loadToTable(listProducts);
        //load phần từ đầu tiên ra textfiel
        if (!listProducts.isEmpty()) {
            jtfProductCode.setText(listProducts.get(0).getProduct_code());
            jtfProductName.setText(listProducts.get(0).getProduct_name());
            jtaProductDescription.setText(listProducts.get(0).getDescription());
            jtfProductPrice.setText("" + listProducts.get(0).getPrice());
            jtfProductQuantity.setText("" + listProducts.get(0).getQuantity());
            jcbProductCategory.setSelectedIndex(getIndexCategory(listProducts.get(0).getCategory_name()));
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchActionPerformed
        String keyword = jtfSearchCode.getText();
        listProducts = ProductDao.searchProduct(keyword);
        loadToTable(listProducts);
    }//GEN-LAST:event_jbtnSearchActionPerformed

    private void jbtnListAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnListAllActionPerformed
        listProducts = ProductDao.getAllProduct();
        loadToTable(listProducts);
    }//GEN-LAST:event_jbtnListAllActionPerformed

    private void jbtnListByCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnListByCategoryActionPerformed
        int categoryId = getCategoryId(jcbProductCategorySearch.getSelectedItem().toString());
        listProducts = ProductDao.getListByID(categoryId);
        loadToTable(listProducts);
    }//GEN-LAST:event_jbtnListByCategoryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAdd;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnListAll;
    private javax.swing.JButton jbtnListByCategory;
    private javax.swing.JButton jbtnSearch;
    private javax.swing.JButton jbtnUpdate;
    private javax.swing.JComboBox<String> jcbProductCategory;
    private javax.swing.JComboBox<String> jcbProductCategorySearch;
    private javax.swing.JScrollPane jcpTextAreaDescription;
    private javax.swing.JLabel jlbListAllProduct;
    private javax.swing.JLabel jlbListByCategory;
    private javax.swing.JLabel jlbProductCategory;
    private javax.swing.JLabel jlbProductCode;
    private javax.swing.JLabel jlbProductDescription;
    private javax.swing.JLabel jlbProductName;
    private javax.swing.JLabel jlbProductPrice;
    private javax.swing.JLabel jlbProductQuantity;
    private javax.swing.JLabel jlbSearchProduct;
    private javax.swing.JTextArea jtaProductDescription;
    private javax.swing.JTable jtbProductTable;
    private javax.swing.JTextField jtfProductCode;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfProductPrice;
    private javax.swing.JTextField jtfProductQuantity;
    private javax.swing.JTextField jtfSearchCode;
    // End of variables declaration//GEN-END:variables
}
