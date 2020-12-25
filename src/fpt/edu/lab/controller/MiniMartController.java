/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.controller;

import fpt.edu.lab.dao.LanguageDAO;
import fpt.edu.lab.model.Language;
import fpt.edu.lab.model.ListBean;
import fpt.edu.lab.model.User;
import fpt.edu.lab.view.BillingJPanel;
import fpt.edu.lab.view.ChangePasswordJPanel;
import fpt.edu.lab.view.HomePageJPanel;
import fpt.edu.lab.view.InventoryJPanel;
import fpt.edu.lab.view.ProductJPanel;
import fpt.edu.lab.view.ProductCategoryJPanel;
import fpt.edu.lab.view.ReportingJPanel;
import fpt.edu.lab.view.SupportJPanel;
import fpt.edu.lab.view.UserJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Viet Long
 */
public class MiniMartController {

    private Language language;
    private JPanel root;
    private String kindSelected = "";
    private ResourceBundle bundle;
    private Locale lang;
    private List<ListBean> listItem = null;
    private User currentUser;
    
    public MiniMartController(JPanel jpnRoot, User currentUser) {
        this.currentUser = currentUser;
        language = LanguageDAO.getLanguage();
        lang = new Locale(language.getCode(), language.getCountry());
        bundle = ResourceBundle.getBundle("fpt.edu.lab.language.Content", lang);
        this.root = jpnRoot;
    }

    public void setView(JPanel jpnItem, JLabel jlbItem) {
        kindSelected = "HomePage";
        jpnItem.setBackground(new Color(0, 102, 0));
        jlbItem.setBackground(new Color(0, 102, 0));

        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new HomePageJPanel(bundle,currentUser));
        root.validate();
        root.repaint();
    }

    public void setEvent(List<ListBean> listItem) {
        this.listItem = listItem;
        for (ListBean item : listItem) {
            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }

    class LabelEvent implements MouseListener {

        private JPanel node;
        private String kind;

        private JPanel jpnItem;
        private JLabel jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }

        @Override
        public void mouseClicked(MouseEvent me) {
            switch (kind) {
                
                case "HomePage":
                    node = new HomePageJPanel(bundle,currentUser);
                    break;
                case "User":
                    node = new UserJPanel(bundle);
                    break;
                case "Product":
                    node = new ProductJPanel(bundle);
                    break;
                case "Inventory":
                    node = new InventoryJPanel(bundle, currentUser);
                    break;
                case "ProductCategory":
                    node = new ProductCategoryJPanel(bundle);
                    break;
                case "Billing":
                    node = new BillingJPanel(bundle, currentUser);
                    break;
                case "Reporting":
                    node = new ReportingJPanel(bundle);
                    break;
                case "Support":
                    node = new SupportJPanel(bundle);
                    break;
                case "ChangePassword":
                    node = new ChangePasswordJPanel(bundle, currentUser);
                    break;
                default:
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSelected = kind;
            jpnItem.setBackground(new Color(51, 153, 102));
            jlbItem.setBackground(new Color(51, 153, 102));
        }

        @Override
        public void mouseReleased(MouseEvent me) {
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            jpnItem.setBackground(new Color(51, 153, 102));
            jlbItem.setBackground(new Color(51, 153, 102));
        }

        @Override
        public void mouseExited(MouseEvent me) {
            if (!kindSelected.equalsIgnoreCase(kind)) {
                jpnItem.setBackground(new Color(0, 102, 0));
                jlbItem.setBackground(new Color(0, 102, 0));
            }
        }

        private void setChangeBackgroud(String kind) {
            for (ListBean item : listItem) {
                if (item.getKind().equalsIgnoreCase(kind)) {
                    item.getJpn().setBackground(new Color(51, 153, 102));
                    item.getJlb().setBackground(new Color(51, 153, 102));
                } else {
                    item.getJpn().setBackground(new Color(0, 102, 0));
                    item.getJlb().setBackground(new Color(0, 102, 0));
                }
            }
        }

    }

}
