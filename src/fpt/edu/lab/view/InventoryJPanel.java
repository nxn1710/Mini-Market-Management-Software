/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.view;

import fpt.edu.lab.dao.CategoryDao;
import fpt.edu.lab.dao.ProductDao;
import fpt.edu.lab.dao.StockDao;
import fpt.edu.lab.dao.StockDetailsDao;
import fpt.edu.lab.dao.WareHouseDao;
import fpt.edu.lab.model.Category;
import fpt.edu.lab.model.Product;
import fpt.edu.lab.model.Stock;
import fpt.edu.lab.model.StockDetails;
import fpt.edu.lab.model.User;
import java.awt.Color;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hi
 */
public class InventoryJPanel extends javax.swing.JPanel {

    String flagBillType = "";
    String type = "";
    DefaultTableModel productTableModel;
    DefaultTableModel stocklTableModel;
    ResourceBundle bundle;
    User user;
    ArrayList<Product> listProducts;
    ArrayList<Category> categorys;
    DefaultListModel listCategoryModel;
    Product productSelected = null;
    HashMap<Product, Integer> listProductsStock = new HashMap<>();

    /**
     * Creates new form InventoryJPanel
     *
     * @param bundle
     * @param user
     */
    public InventoryJPanel(ResourceBundle bundle, User user) {
        initComponents();
        this.bundle = bundle;
        this.user = user;
        productTableModel = (DefaultTableModel) jtbProductTable.getModel();
        stocklTableModel = (DefaultTableModel) jtbStock.getModel();
        listCategoryModel = new DefaultListModel();
        jlCategory.setModel(listCategoryModel);
        listProducts = ProductDao.getAllProduct();
        categorys = CategoryDao.getAllCategory();
        addColumnProductTable();
        addColumnBillTable();
        loadProductTable(listProducts);
        loadCategory(categorys);
        setUpUILanguage(bundle);
    }

    public void setUpUILanguage(ResourceBundle bundle) {
        jLabel1.setText(bundle.getString("jlbFindCategory"));
        jbtnSearchCategory.setText(bundle.getString("jbtnSearch"));
        jLabel2.setText(bundle.getString("jlbFindingSomeProduct"));
        jlbEnterQuantity.setText(bundle.getString("jlbEnterQuantity"));
        jbtnSearchProduct.setText(bundle.getString("jbtnSearch"));
        jbtnUpdateQuantity.setText(bundle.getString("jbtnUpdateCategory"));
        jbtnDelete.setText(bundle.getString("jbtnDelete"));
        jLabel3.setText(bundle.getString("ProductCode"));
        jLabel4.setText(bundle.getString("ProductName"));
        jLabel5.setText(bundle.getString("Quantity"));
        jPanel2.setBorder(BorderFactory.createTitledBorder(bundle.getString("jlbProductCategory")));
        jPanel3.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnTableProduct")));
        jPanel4.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnBillStock")));
        jlbEnterQuantity1.setText(bundle.getString("jlbType"));
        jRadioButton1.setText(bundle.getString("jrdStockIn"));
        jRadioButton2.setText(bundle.getString("jrdStockOut"));
        btnAddStock.setText(bundle.getString("jbtnAddToStock"));
        jbtnCheckOut1.setText(bundle.getString("jbtnCheckOut"));
    }

    public void loadCategory(ArrayList<Category> categorys) {
        listCategoryModel.removeAllElements();
        for (Category cat : categorys) {
            listCategoryModel.addElement(cat.getCategoryName());
        }
    }

    public void clearStockTable() {
        while (stocklTableModel.getRowCount() > 0) {
            stocklTableModel.removeRow(0);
        }
    }

    public void loadStockTable(String type) {
        clearStockTable();
        for (Product p : listProductsStock.keySet()) {
            stocklTableModel.addRow(new Object[]{
                p.getProduct_code(), p.getProduct_name(), type, listProductsStock.get(p)
            });
        }
    }

    public void loadProductTable(ArrayList<Product> listProducts) {
        while (productTableModel.getRowCount() > 0) {
            productTableModel.removeRow(0);
        }
        for (Product p : listProducts) {
            productTableModel.addRow(new Object[]{
                p.getProduct_code(), p.getProduct_name(),
                p.getPrice(), p.getQuantity(), WareHouseDao.quantityProductInStock(p.getProduct_code()),
                p.getCategory_name()
            });
        }
    }

    public void addColumnProductTable() {
        productTableModel.addColumn(bundle.getString("ProductCode"));
        productTableModel.addColumn(bundle.getString("ProductName"));
        productTableModel.addColumn(bundle.getString("Price"));
        productTableModel.addColumn(bundle.getString("QuantityShelf"));
        productTableModel.addColumn(bundle.getString("QuantityStock"));
        productTableModel.addColumn(bundle.getString("Category"));
    }

    public void addColumnBillTable() {
        stocklTableModel.addColumn("Product Code");
        stocklTableModel.addColumn("Product Name");
        stocklTableModel.addColumn("Type");
        stocklTableModel.addColumn("Quantity");

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

    public boolean checkDuplicateInStock(String productCode) {
        for (Product p : listProductsStock.keySet()) {
            if (productCode.equals(p.getProduct_code())) {
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

        btnGroupTypeStock = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlCategory = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jtfSearchCategory = new javax.swing.JTextField();
        jbtnSearchCategory = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbProductTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jbtnSearchProduct = new javax.swing.JButton();
        btnAddStock = new javax.swing.JButton();
        jlbEnterQuantity = new javax.swing.JLabel();
        jtfQuantityInput = new javax.swing.JTextField();
        jlbEnterQuantity1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbStock = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jbtnUpdateQuantity = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();
        jbtnCheckOut1 = new javax.swing.JButton();
        jtfProductCode = new javax.swing.JTextField();
        jtfProductName = new javax.swing.JTextField();
        jtfQuantityUpdate = new javax.swing.JTextField();

        setLayout(new java.awt.GridBagLayout());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(240, 240, 240));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 200));

        jlCategory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jlCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlCategory);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Find some category:");

        jtfSearchCategory.setPreferredSize(new java.awt.Dimension(6, 30));

        jbtnSearchCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSearchCategory.setText("Search");
        jbtnSearchCategory.setPreferredSize(new java.awt.Dimension(75, 29));
        jbtnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchCategoryActionPerformed(evt);
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
                        .addComponent(jtfSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        jScrollPane2.setViewportView(jtbProductTable);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Finding some product:");

        jtfSearch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfSearch.setForeground(new java.awt.Color(153, 153, 153));
        jtfSearch.setText("Search by name or by code");
        jtfSearch.setPreferredSize(new java.awt.Dimension(177, 30));
        jtfSearch.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtfSearchFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jtfSearchFocusLost(evt);
            }
        });

        jbtnSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSearchProduct.setText("Search");
        jbtnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchProductActionPerformed(evt);
            }
        });

        btnAddStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddStock.setText("Add to Stock");
        btnAddStock.setPreferredSize(new java.awt.Dimension(113, 30));
        btnAddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddStockActionPerformed(evt);
            }
        });

        jlbEnterQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbEnterQuantity.setText("Enter Quantity:");

        jtfQuantityInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfQuantityInput.setPreferredSize(new java.awt.Dimension(6, 30));

        jlbEnterQuantity1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbEnterQuantity1.setText("Type:");

        btnGroupTypeStock.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton1.setSelected(true);
        jRadioButton1.setText("Sock In");

        btnGroupTypeStock.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton2.setText("Sock Out");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSearchProduct)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jlbEnterQuantity1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jRadioButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jRadioButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jlbEnterQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addComponent(jScrollPane2)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEnterQuantity)
                    .addComponent(jtfQuantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jlbEnterQuantity1)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(17, 17, 17))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Stock", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtbStock.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jScrollPane3.setViewportView(jtbStock);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Product Code");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jbtnUpdateQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnUpdateQuantity.setText("Update");
        jbtnUpdateQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnUpdateQuantityActionPerformed(evt);
            }
        });

        jbtnDelete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnDelete.setText("Delete");
        jbtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnDeleteActionPerformed(evt);
            }
        });

        jbtnCheckOut1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCheckOut1.setText("Check Out");
        jbtnCheckOut1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCheckOutActionPerformed(evt);
            }
        });

        jtfProductCode.setEditable(false);
        jtfProductCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfProductCode.setPreferredSize(new java.awt.Dimension(6, 30));

        jtfProductName.setEditable(false);
        jtfProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfProductName.setPreferredSize(new java.awt.Dimension(6, 30));

        jtfQuantityUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfQuantityUpdate.setPreferredSize(new java.awt.Dimension(6, 30));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jbtnUpdateQuantity)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnDelete)
                        .addGap(10, 10, 10)
                        .addComponent(jbtnCheckOut1))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jtfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addGap(18, 18, 18)
                            .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnCheckOut1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 346, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel1, new java.awt.GridBagConstraints());
    }// </editor-fold>//GEN-END:initComponents

    private void jlCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoryMouseClicked
        int categoryId = getCategoryId(jlCategory.getSelectedValue());
        listProducts = ProductDao.getListByID(categoryId);
        loadProductTable(listProducts);
    }//GEN-LAST:event_jlCategoryMouseClicked

    private void jbtnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchCategoryActionPerformed
        String category = jtfSearchCategory.getText();
        categorys = CategoryDao.searchCategory(category);
        loadCategory(categorys);
    }//GEN-LAST:event_jbtnSearchCategoryActionPerformed

    private void jtbProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductTableMouseClicked
        String productCode = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 0).toString();
        String productName = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 1).toString();
        String priceStr = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 2).toString();
        String quantityStr = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 3).toString();
        String category = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 5).toString();
        double price;
        //kiểm tra price nhập vào có là số hay không
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joPriceQuantity"));
            return;
        }
        int quantity;
        //kiểm tra quantity nhập vào có là số hay không
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"));
            return;
        }
        productSelected = new Product(productCode, productName, price, quantity, category);
    }//GEN-LAST:event_jtbProductTableMouseClicked

    private void jbtnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchProductActionPerformed
        String keyword = jtfSearch.getText();
        //kiểm tra key có phải là key mặc định
        if (keyword.equals("Search by name or by code")) {
            keyword = "";
        }
        listProducts = ProductDao.searchProduct(keyword);
        loadProductTable(listProducts);
    }//GEN-LAST:event_jbtnSearchProductActionPerformed

    private void btnAddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddStockActionPerformed
        String quantityStockStr = jtfQuantityInput.getText();
        int quantityStock = 0;
        if (jRadioButton1.isSelected()) {
            type = "In";
        } else if (jRadioButton2.isSelected()) {
            type = "Out";
        }
        //tất cả các sản phẩm trong hóa đơn stock phải là in hết hoặc là out hết, không được vừa stock in vừa stock out
        if (!flagBillType.equals("") && !flagBillType.equals(type)) {
            JOptionPane.showMessageDialog(this, bundle.getString("joTypeStock"));
            return;
        }
        //kiểm tra người dùng có chọn sản phẩm trên table hay không
        if (productSelected == null) {
            JOptionPane.showMessageDialog(this, bundle.getString("joPleaseChooseProduct"), bundle.getString("joAddWarning"), JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //kiểm tra số lượng nhập vào có phải là số hay không
                quantityStock = Integer.parseInt(quantityStockStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"), bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                return;
            }
            //kiểm tra số âm
            if (quantityStock <= 0) {
                JOptionPane.showMessageDialog(this, bundle.getString("joQuantity>0"), bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                return;
            }
            //nếu xuất hàng để đưa lên kệ hàng thì số lượng nhập không được lớn hơn sản phẩm trong kho
            if (type.equals("Out")) {
                if (quantityStock > WareHouseDao.quantityProductInStock(productSelected.getProduct_code())) {
                    JOptionPane.showMessageDialog(this, bundle.getString("joNotEnoughProductInStock"), bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
            //kiểm tra trùng trong stock
            if (checkDuplicateInStock(productSelected.getProduct_code())) {
                JOptionPane.showMessageDialog(this, bundle.getString("joCheckProductExistStock"), bundle.getString("joCheckProduct"), JOptionPane.WARNING_MESSAGE);
            } else {
                //put product to stock and refresh bill table
                listProductsStock.put(productSelected, quantityStock);
                flagBillType = type;
                loadStockTable(type);
            }
        }
    }//GEN-LAST:event_btnAddStockActionPerformed

    private void jtbStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbStockMouseClicked
        jtfProductCode.setText(stocklTableModel.getValueAt(jtbStock.getSelectedRow(), 0).toString());
        jtfProductName.setText(stocklTableModel.getValueAt(jtbStock.getSelectedRow(), 1).toString());
        jtfQuantityUpdate.setText(stocklTableModel.getValueAt(jtbStock.getSelectedRow(), 3).toString());
    }//GEN-LAST:event_jtbStockMouseClicked

    private void jbtnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCheckOutActionPerformed
        if (stocklTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, bundle.getString("joEmptyStock"));
        } else {
            Stock stock = new Stock();
            LocalDateTime timeNow = LocalDateTime.now();
            stock.setDate(timeNow);
            stock.setStaffName(user.getUsername());
            stock.setTypeStock(type);
            int idStock = StockDao.addStock(stock);
            for (Product p : listProductsStock.keySet()) {
                StockDetails stockDetails = new StockDetails();
                stockDetails.setStockId(idStock);
                stockDetails.setProductCode(p.getProduct_code());
                stockDetails.setQuantity(listProductsStock.get(p));
                StockDetailsDao.addStockDetails(stockDetails);
            }
            listProductsStock.clear();
            listProducts = ProductDao.getAllProduct();
            JOptionPane.showMessageDialog(this, bundle.getString("joStock"));
            loadProductTable(listProducts);
            clearStockTable();
            //clear flag
            flagBillType = "";
        }
    }//GEN-LAST:event_jbtnCheckOutActionPerformed

    private void jbtnUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateQuantityActionPerformed
        String pcode = jtfProductCode.getText();
        int newQuantity = Integer.parseInt(jtfQuantityUpdate.getText());
        for (Product p : listProductsStock.keySet()) {
            if (p.getProduct_code().equals(pcode)) {
                listProductsStock.replace(p, newQuantity);
            }
        }
        loadStockTable(type);
    }//GEN-LAST:event_jbtnUpdateQuantityActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        String pcode = jtfProductCode.getText();
        for (Product p : listProductsStock.keySet()) {
            if (p.getProduct_code().equals(pcode)) {
                listProductsStock.remove(p);
                break;
            }
        }
        jtfProductCode.setText("");
        jtfProductName.setText("");
        jtfQuantityUpdate.setText("");
        loadStockTable(type);
        //clear flag type
        if (stocklTableModel.getRowCount() == 0) {
            flagBillType = "";
        }
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jtfSearchFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSearchFocusGained
        if (jtfSearch.getText().equals("Search by name or by code")) {
            jtfSearch.setText("");
            jtfSearch.setForeground(Color.BLACK);
        }
    }//GEN-LAST:event_jtfSearchFocusGained

    private void jtfSearchFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtfSearchFocusLost
        if (jtfSearch.getText().isEmpty()) {
            jtfSearch.setForeground(Color.GRAY);
            jtfSearch.setText("Search by name or by code");
        }
    }//GEN-LAST:event_jtfSearchFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddStock;
    private javax.swing.ButtonGroup btnGroupTypeStock;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnCheckOut1;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnSearchCategory;
    private javax.swing.JButton jbtnSearchProduct;
    private javax.swing.JButton jbtnUpdateQuantity;
    private javax.swing.JList<String> jlCategory;
    private javax.swing.JLabel jlbEnterQuantity;
    private javax.swing.JLabel jlbEnterQuantity1;
    private javax.swing.JTable jtbProductTable;
    private javax.swing.JTable jtbStock;
    private javax.swing.JTextField jtfProductCode;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfQuantityInput;
    private javax.swing.JTextField jtfQuantityUpdate;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfSearchCategory;
    // End of variables declaration//GEN-END:variables
}
