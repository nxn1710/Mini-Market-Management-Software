/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.main;

import fpt.edu.lab.view.LoginJFrame;
import javax.swing.UIManager;

/**
 *
 * @author Viet Long
 */
public class Main {

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ignored) {
        }
        LoginJFrame login = new LoginJFrame();
        login.setVisible(true);
    }
}
