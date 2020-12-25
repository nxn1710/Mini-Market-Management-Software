/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fpt.edu.lab.controller;

import fpt.edu.lab.model.Product;
import java.awt.*;
import java.awt.print.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class PrintBill implements Printable {

    HashMap<Product, Integer> listProductsBuy;
    LocalDateTime timeNow;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    String sellerName;

    public PrintBill(HashMap<Product, Integer> listProductsBuy, LocalDateTime timeNow, String sellerName) {
        this.sellerName = sellerName;
        this.timeNow = timeNow;
        this.listProductsBuy = listProductsBuy;
        PrinterJob printjob = PrinterJob.getPrinterJob();
        printjob.setPrintable(this, getPageFormat(printjob));
        if (printjob.printDialog()) {
            try {
                printjob.print();
            } catch (Exception ex) {
                System.out.println("ERROR : " + ex);

            }
        }
    }

    /*CODE TO ALIGN TEXT
       * ----------------------
       * ---------------------------------------
       * --------------------------------------------------------
       * --------------------------------------------------------------------------
       * ------------------------------------------------------------------------------------------------
       * ----------------------------------------------------------------------------------------------------------------------------
       * ----------------------------------------------------------------------------------------------------------------------------------------------
       * ---------------------------------------------------------------------------------------------------------------------------------------------------
       * ---------------------------------------------------------------------------------------------------------------------------------------------------------
       * --------------------------------------------------------------------------------------------------------------------------------------------------------
       ----------------------------------------------------------------------------------------------------------------------------------------------------------*/
    public PageFormat getPageFormat(PrinterJob pj) {

        PageFormat pf = pj.defaultPage();
        Paper paper = pf.getPaper();

        double middleHeight = 8.0;
        double headerHeight = 2.0;
        double footerHeight = 2.0;
        double width = convert_CM_To_PPI(8);      //printer know only point per inch.default value is 72ppi
        double height = convert_CM_To_PPI(headerHeight + middleHeight + footerHeight);
        paper.setSize(width, height);
        paper.setImageableArea(
                0,
                10,
                width,
                height - convert_CM_To_PPI(1)
        );   //define boarder size    after that print area width is about 180 points

        pf.setOrientation(PageFormat.PORTRAIT);           //select orientation portrait or landscape but for this time portrait
        pf.setPaper(paper);

        return pf;
    }

    protected static double convert_CM_To_PPI(double cm) {
        return toPPI(cm * 0.393600787);
    }

    protected static double toPPI(double inch) {
        return inch * 72d;
    }

    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page == 0) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.translate((int) pageFormat.getImageableX(), (int) pageFormat.getImageableY());

            try {
                /*Draw Header*/
                int y = 20;
                int yShift = 10;
                int headerRectHeight = 200;
                int headerRectHeighta = 200;
                g2d.setFont(new Font("Monospaced", Font.PLAIN, 13));
                g2d.drawString("-------------------------------------", 12, y);
                y += yShift; //Line Breaker to the scale | Copy this statement and paste to enter Line Breaker
                g2d.drawString("-------------BILL----------------", 12, y);
                y += yShift;
                g2d.drawString("Date: " + dtf.format(timeNow), 12, y);
                y += yShift;
                g2d.drawString("Seller: " + sellerName, 12, y);
                y += yShift;
                g2d.drawString("-------------------------------------", 12, y);
                y += yShift;
                double totalPrice = 0;
                for (Product p : listProductsBuy.keySet()) {
                    g2d.drawString("Product Code: " + p.getProduct_code(), 12, y);
                    y += yShift;
                    g2d.drawString("Product Name: " + p.getProduct_name(), 12, y);
                    y += yShift;
                    g2d.drawString("Quantity: " + listProductsBuy.get(p) + " x " + p.getPrice()
                            + " =" + p.getPrice() * listProductsBuy.get(p), 12, y);
                    y += yShift;
                    g2d.drawString("-------------------------------------", 12, y);
                    y += yShift;
                    totalPrice += p.getPrice() * listProductsBuy.get(p);
                }
                g2d.drawString("Total Price: " + totalPrice, 12, y);
                y += yShift; 
                g2d.drawString("-------------------------------------", 12, y);
                y += headerRectHeight;
                return (PAGE_EXISTS);
            } catch (Exception ex) {
                System.out.println("ERROR : " + ex);
            }
            return (PAGE_EXISTS);
        } else {
            return (NO_SUCH_PAGE);
        }

    }
}
