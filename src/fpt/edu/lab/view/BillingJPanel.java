/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.view;

import fpt.edu.lab.controller.PrintBill;
import fpt.edu.lab.dao.BillDao;
import fpt.edu.lab.dao.BillDetailsDao;
import fpt.edu.lab.dao.CategoryDao;
import fpt.edu.lab.dao.ProductDao;
import fpt.edu.lab.model.Bill;
import fpt.edu.lab.model.BillDetails;
import fpt.edu.lab.model.Category;
import fpt.edu.lab.model.Product;
import fpt.edu.lab.model.User;
import java.awt.Font;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Hi
 */
public class BillingJPanel extends javax.swing.JPanel {

    DefaultTableModel productTableModel;
    DefaultTableModel billTableModel;
    DefaultListModel listCategoryModel;
    ResourceBundle bundle;
    ArrayList<Product> listProducts;
    ArrayList<Category> categorys;
    HashMap<Product, Integer> listProductsBuy = new HashMap<>();
    Product productSelected = null;
    User user;

    /**
     * Creates new form BillingJPanel
     *
     * @param bundle
     * @param user
     */
    public BillingJPanel(ResourceBundle bundle, User user) {
        initComponents();
        this.user = user;
        this.bundle = bundle;
        productTableModel = (DefaultTableModel) jtbProductTable.getModel();
        billTableModel = (DefaultTableModel) jtbBill.getModel();
        listCategoryModel = new DefaultListModel();
        jlCategory.setModel(listCategoryModel);
        listProducts = ProductDao.getAllProduct();
        categorys = CategoryDao.getAllCategory();
        setUpUILanguage(bundle);
        addColumnProductTable();
        addColumnBillTable();
        loadProductTable(listProducts);
        loadCategory(categorys);
        jtbProductTable.setFont(new Font("Tahoma", Font.PLAIN, 14));
    }

    public void setUpUILanguage(ResourceBundle bundle) {
        jLabel1.setText(bundle.getString("jlbFindCategory"));
        jbtnSearchCategory.setText(bundle.getString("jbtnSearch"));
        jLabel2.setText(bundle.getString("jlbFindingSomeProduct"));
        jlbEnterQuantity.setText(bundle.getString("jlbEnterQuantity"));
        jbtnSearchProduct.setText(bundle.getString("jbtnSearch"));
        btnAddCart.setText(bundle.getString("jbtnAddToBill"));
        jbtnUpdateQuantity.setText(bundle.getString("jbtnUpdateCategory"));
        jbtnDelete.setText(bundle.getString("jbtnDelete"));
        jbtnCheckOut.setText(bundle.getString("jbtnCheckOut"));
        jLabel6.setText(bundle.getString("jlbTotalBillPrice"));
        jLabel3.setText(bundle.getString("ProductCode"));
        jLabel4.setText(bundle.getString("ProductName"));
        jLabel5.setText(bundle.getString("Quantity"));
        jpnListCategory.setBorder(BorderFactory.createTitledBorder(bundle.getString("jlbProductCategory")));
        jPanel2.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnTableProduct")));
        jPanel3.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnBill")));
    }

    public void loadCategory(ArrayList<Category> categorys) {
        listCategoryModel.removeAllElements();
        for (Category cat : categorys) {
            listCategoryModel.addElement(cat.getCategoryName());
        }
    }

    public void loadProductTable(ArrayList<Product> listProducts) {
        while (productTableModel.getRowCount() > 0) {
            productTableModel.removeRow(0);
        }
        for (Product p : listProducts) {
            productTableModel.addRow(new Object[]{
                p.getProduct_code(), p.getProduct_name(),
                p.getPrice(), p.getQuantity(), p.getCategory_name(), p.getDescription()
            });
        }
    }

    public void addColumnProductTable() {
        productTableModel.addColumn(bundle.getString("ProductCode"));
        productTableModel.addColumn(bundle.getString("ProductName"));
        productTableModel.addColumn(bundle.getString("Price"));
        productTableModel.addColumn(bundle.getString("Quantity"));
        productTableModel.addColumn(bundle.getString("Category"));
        productTableModel.addColumn(bundle.getString("Description"));
    }

    public void addColumnBillTable() {
        billTableModel.addColumn(bundle.getString("ProductCode"));
        billTableModel.addColumn(bundle.getString("ProductName"));
        billTableModel.addColumn(bundle.getString("Quantity"));
        billTableModel.addColumn(bundle.getString("Price"));
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

    public void clearBillTable() {
        while (billTableModel.getRowCount() > 0) {
            billTableModel.removeRow(0);
        }
    }

    public void loadBillTable() {
        double totalPrice = 0;
        clearBillTable();
        for (Product p : listProductsBuy.keySet()) {
            billTableModel.addRow(new Object[]{
                p.getProduct_code(), p.getProduct_name(), listProductsBuy.get(p), p.getPrice() * listProductsBuy.get(p)
            });
            totalPrice += p.getPrice() * listProductsBuy.get(p);
        }
        jtfTotalPrice.setText("" + totalPrice);
    }

    public boolean checkDuplicateInBill(String productCode) {
        for (Product p : listProductsBuy.keySet()) {
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

        jpnListCategory = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlCategory = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jtfSearchCategory = new javax.swing.JTextField();
        jbtnSearchCategory = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtbProductTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jtfSearch = new javax.swing.JTextField();
        jbtnSearchProduct = new javax.swing.JButton();
        btnAddCart = new javax.swing.JButton();
        jlbEnterQuantity = new javax.swing.JLabel();
        jtfQuantityInput = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbBill = new javax.swing.JTable();
        jtfProductCode = new javax.swing.JTextField();
        jtfProductName = new javax.swing.JTextField();
        jtfQuantityUpdate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtfTotalPrice = new javax.swing.JTextField();
        jbtnCheckOut = new javax.swing.JButton();
        jbtnUpdateQuantity = new javax.swing.JButton();
        jbtnDelete = new javax.swing.JButton();

        jpnListCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "List Category", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jpnListCategory.setForeground(new java.awt.Color(240, 240, 240));
        jpnListCategory.setPreferredSize(new java.awt.Dimension(200, 200));

        jlCategory.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        jlCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlCategoryMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlCategory);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Find some category");

        jtfSearchCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jbtnSearchCategory.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSearchCategory.setText("Search");
        jbtnSearchCategory.setPreferredSize(new java.awt.Dimension(75, 30));
        jbtnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchCategoryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpnListCategoryLayout = new javax.swing.GroupLayout(jpnListCategory);
        jpnListCategory.setLayout(jpnListCategoryLayout);
        jpnListCategoryLayout.setHorizontalGroup(
            jpnListCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListCategoryLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpnListCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jpnListCategoryLayout.createSequentialGroup()
                        .addComponent(jtfSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(11, Short.MAX_VALUE))
            .addComponent(jScrollPane1)
        );
        jpnListCategoryLayout.setVerticalGroup(
            jpnListCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnListCategoryLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpnListCategoryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSearchCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Table Product", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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
        jtfSearch.setPreferredSize(new java.awt.Dimension(6, 30));

        jbtnSearchProduct.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnSearchProduct.setText("Search");
        jbtnSearchProduct.setPreferredSize(new java.awt.Dimension(73, 30));
        jbtnSearchProduct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSearchProductActionPerformed(evt);
            }
        });

        btnAddCart.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAddCart.setText("Add to Bill");
        btnAddCart.setPreferredSize(new java.awt.Dimension(91, 30));
        btnAddCart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCartActionPerformed(evt);
            }
        });

        jlbEnterQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbEnterQuantity.setText("Enter Quantity: ");

        jtfQuantityInput.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfQuantityInput.setPreferredSize(new java.awt.Dimension(6, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jlbEnterQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfQuantityInput, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAddCart, javax.swing.GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
                    .addComponent(jbtnSearchProduct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jbtnSearchProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddCart, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbEnterQuantity)
                    .addComponent(jtfQuantityInput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Bill", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jtbBill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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
        jScrollPane3.setViewportView(jtbBill);

        jtfProductCode.setEditable(false);
        jtfProductCode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfProductCode.setPreferredSize(new java.awt.Dimension(6, 30));

        jtfProductName.setEditable(false);
        jtfProductName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfProductName.setPreferredSize(new java.awt.Dimension(6, 30));

        jtfQuantityUpdate.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtfQuantityUpdate.setPreferredSize(new java.awt.Dimension(6, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Product Code");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Product Name");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Quantity");

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Total Bill Price");

        jtfTotalPrice.setEditable(false);
        jtfTotalPrice.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jtfTotalPrice.setText("0");
        jtfTotalPrice.setPreferredSize(new java.awt.Dimension(15, 30));

        jbtnCheckOut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnCheckOut.setText("Check Out");
        jbtnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCheckOutActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtnCheckOut, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtfTotalPrice, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jtfTotalPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jbtnCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jbtnUpdateQuantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnUpdateQuantity.setText("Update Quantity");
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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfQuantityUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(jtfProductName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jtfProductCode, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jbtnUpdateQuantity)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfProductCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfProductName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtfQuantityUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtnUpdateQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25))))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnListCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpnListCategory, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtbProductTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbProductTableMouseClicked
        String productCode = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 0).toString();
        String productName = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 1).toString();
        String priceStr = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 2).toString();
        String quantityStr = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 3).toString();
        String category = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 4).toString();
        String description = productTableModel.getValueAt(jtbProductTable.getSelectedRow(), 5).toString();
        double price;
        try {
            price = Double.parseDouble(priceStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joPriceQuantity"));
            return;
        }
        int quantity;
        try {
            quantity = Integer.parseInt(quantityStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"));
            return;
        }
        productSelected = new Product(productCode, productName, description, price, quantity, category);
    }//GEN-LAST:event_jtbProductTableMouseClicked

    private void jbtnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchCategoryActionPerformed
        String category = jtfSearchCategory.getText();
        categorys = CategoryDao.searchCategory(category);
        loadCategory(categorys);
    }//GEN-LAST:event_jbtnSearchCategoryActionPerformed

    private void jbtnSearchProductActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSearchProductActionPerformed
        String keyword = jtfSearch.getText();
        if (keyword.equals("")) {
            //
        }
        listProducts = ProductDao.searchProduct(keyword);
        loadProductTable(listProducts);
    }//GEN-LAST:event_jbtnSearchProductActionPerformed

    private void btnAddCartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCartActionPerformed
        String purQuantityStr = jtfQuantityInput.getText();
        int purQuantity = 0;
        //tạo ra 1 hashmap với key là sản phẩm và value là số lượng khách hàng mua
        //kiểm tra xem người dùng có chọn sản phẩm trên table 
        if (productSelected == null) {
            JOptionPane.showMessageDialog(this, bundle.getString("joPleaseChooseProduct"), bundle.getString("joAddWarning"), JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                //kiểm tra số lượng có phải là số hay không
                purQuantity = Integer.parseInt(purQuantityStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"), bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                return;
            }
            // kiểm tra số âm và = 0
            if (purQuantity <= 0) {
                JOptionPane.showMessageDialog(this, bundle.getString("joQuantity>0"), bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                return;
                //kiểm tra số lượng mua không được lớn hơn số lượng sản phẩm trên kệ
            } else if (purQuantity > productSelected.getQuantity()) {
                JOptionPane.showMessageDialog(this, bundle.getString("joQuantityPush<QuantityProduct"),
                        bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                return;
            }
            //kiểm tra xem product đã có trên bill
            if (checkDuplicateInBill(productSelected.getProduct_code())) {
                JOptionPane.showMessageDialog(this, bundle.getString("joCheckProduct"), bundle.getString("joCheckProduct"), JOptionPane.WARNING_MESSAGE);
            } else {
                //đưa sản phẩm vào bill
                listProductsBuy.put(productSelected, purQuantity);
                loadBillTable();
            }
        }
    }//GEN-LAST:event_btnAddCartActionPerformed

    private void jlCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlCategoryMouseClicked
        int categoryId = getCategoryId(jlCategory.getSelectedValue());
        listProducts = ProductDao.getListByID(categoryId);
        loadProductTable(listProducts);
    }//GEN-LAST:event_jlCategoryMouseClicked

    private void jtbBillMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbBillMouseClicked
        jtfProductCode.setText(billTableModel.getValueAt(jtbBill.getSelectedRow(), 0).toString());
        jtfProductName.setText(billTableModel.getValueAt(jtbBill.getSelectedRow(), 1).toString());
        jtfQuantityUpdate.setText(billTableModel.getValueAt(jtbBill.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_jtbBillMouseClicked

    private void jbtnUpdateQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnUpdateQuantityActionPerformed
        String pcode = jtfProductCode.getText();
        int newQuantity;
        //kiểm tra số lượng là số hay không
        try {
            newQuantity = Integer.parseInt(jtfQuantityUpdate.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, bundle.getString("joInputQuantity"));
            return;
        }
        //thay đổi value(số lượng khách hàng mua) trong hashmap
        for (Product p : listProductsBuy.keySet()) {
            if (p.getProduct_code().equals(pcode)) {
                //kiểm tra số lượng mới không được lớn hơn số lượng của sản phẩm trên kệ hàng
                if (newQuantity <= p.getQuantity()) {
                    listProductsBuy.replace(p, newQuantity);
                    break;
                } else {
                    JOptionPane.showMessageDialog(this, bundle.getString("joQuantityPush<QuantityProduct"),
                            bundle.getString("joWarningQuantity"), JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        }
        loadBillTable();
    }//GEN-LAST:event_jbtnUpdateQuantityActionPerformed

    private void jbtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnDeleteActionPerformed
        String pcode = jtfProductCode.getText();
        for (Product p : listProductsBuy.keySet()) {
            if (p.getProduct_code().equals(pcode)) {
                listProductsBuy.remove(p);
                break;
            }
        }
        jtfProductCode.setText("");
        jtfProductName.setText("");
        jtfQuantityUpdate.setText("");
        loadBillTable();
    }//GEN-LAST:event_jbtnDeleteActionPerformed

    private void jbtnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCheckOutActionPerformed
        //kiểm tra xem có sản phẩm nào trong bill hay không mới thực hiện việc checkout
        if (billTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, bundle.getString("billEmpty"));
        } else {
            Bill bill = new Bill();
            //get ngày giờ hiện tại
            LocalDateTime timeNow = LocalDateTime.now();
            bill.setOrder_date(timeNow);
            bill.setSellername(user.getUsername());
            bill.setTotal_price(Double.parseDouble(jtfTotalPrice.getText()));
            int idBill = BillDao.addBill(bill);
            for (Product p : listProductsBuy.keySet()) {
                BillDetails billDetails = new BillDetails();
                billDetails.setBill_id(idBill);
                billDetails.setProduct_code(p.getProduct_code());
                // price = price của sản phẩm nhân cho số lượng khách hàng mua
                billDetails.setPrice(p.getPrice() * listProductsBuy.get(p));
                billDetails.setQuantity(listProductsBuy.get(p));
                BillDetailsDao.addBill(billDetails);
            }
            //gọi hàm in ra bill
            PrintBill printBill = new PrintBill(listProductsBuy, timeNow, user.getFullname());
            //clear bill
            clearBillTable();
            listProductsBuy.clear();
            jtfTotalPrice.setText("0");
            listProducts = ProductDao.getAllProduct();
            loadProductTable(listProducts);
        }
    }//GEN-LAST:event_jbtnCheckOutActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbtnCheckOut;
    private javax.swing.JButton jbtnDelete;
    private javax.swing.JButton jbtnSearchCategory;
    private javax.swing.JButton jbtnSearchProduct;
    private javax.swing.JButton jbtnUpdateQuantity;
    private javax.swing.JList<String> jlCategory;
    private javax.swing.JLabel jlbEnterQuantity;
    private javax.swing.JPanel jpnListCategory;
    private javax.swing.JTable jtbBill;
    private javax.swing.JTable jtbProductTable;
    private javax.swing.JTextField jtfProductCode;
    private javax.swing.JTextField jtfProductName;
    private javax.swing.JTextField jtfQuantityInput;
    private javax.swing.JTextField jtfQuantityUpdate;
    private javax.swing.JTextField jtfSearch;
    private javax.swing.JTextField jtfSearchCategory;
    private javax.swing.JTextField jtfTotalPrice;
    // End of variables declaration//GEN-END:variables
}
