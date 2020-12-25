/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.view;

import fpt.edu.lab.dao.LanguageDAO;
import java.util.ResourceBundle;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Hi
 */
public class SupportJPanel extends javax.swing.JPanel {

    ResourceBundle bundle;

    /**
     * Creates new form SupportJPanel
     */
    public SupportJPanel(ResourceBundle bundle) {
        initComponents();
        this.bundle = bundle;
        setUpUILanguage(bundle);
    }

    public void setUpUILanguage(ResourceBundle bundle) {
        jlbSupport.setText("<html>" + bundle.getString("jlbSupportText") + "</html>");
        jbtnChangeLanguage.setText(bundle.getString("jbtnChange"));
        jlbChooseLanguage.setText(bundle.getString("jlbChooseDefaultLanguage"));
        jPanel3.setBorder(BorderFactory.createTitledBorder(bundle.getString("jlbSupport")));
        jPanel2.setBorder(BorderFactory.createTitledBorder(bundle.getString("jpnLanguage")));
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
        jPanel2 = new javax.swing.JPanel();
        jlbChooseLanguage = new javax.swing.JLabel();
        jcbLanguage = new javax.swing.JComboBox<>();
        jbtnChangeLanguage = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jlbSupport = new javax.swing.JLabel();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Language", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jlbChooseLanguage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbChooseLanguage.setText("Choose Default Language: ");

        jcbLanguage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jcbLanguage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Select---", "English", "Vietnamese" }));
        jcbLanguage.setPreferredSize(new java.awt.Dimension(97, 30));

        jbtnChangeLanguage.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbtnChangeLanguage.setText("Change");
        jbtnChangeLanguage.setPreferredSize(new java.awt.Dimension(79, 30));
        jbtnChangeLanguage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnChangeLanguageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jlbChooseLanguage)
                .addGap(20, 20, 20)
                .addComponent(jcbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jbtnChangeLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(319, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbChooseLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnChangeLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Support", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jlbSupport.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jlbSupport.setText("Text");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbSupport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jlbSupport, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(312, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnChangeLanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnChangeLanguageActionPerformed
        String language = jcbLanguage.getSelectedItem().toString();
        String code = "", country = "";
        if (language.equalsIgnoreCase("Vietnamese")) {
            code = "vi";
            country = "VN";
        } else if (language.equalsIgnoreCase("English")) {
            code = "es";
            country = "US";
        }
        int choice = JOptionPane.showConfirmDialog(this, bundle.getString("joChangeLanguage"));
        if (choice == JOptionPane.YES_OPTION) {
            LanguageDAO.changeLanguage(code, country);
            JOptionPane.showMessageDialog(this, bundle.getString("joChangeLanguageSuccess"));
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(this, bundle.getString("joChangeLanguageCanceled"));
        }
    }//GEN-LAST:event_jbtnChangeLanguageActionPerformed

    public javax.swing.JButton getJb() {
        return jbtnChangeLanguage;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton jbtnChangeLanguage;
    private javax.swing.JComboBox<String> jcbLanguage;
    private javax.swing.JLabel jlbChooseLanguage;
    private javax.swing.JLabel jlbSupport;
    // End of variables declaration//GEN-END:variables
}
