/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.List;
import javax.swing.DefaultListModel;
import model.Factura;
import service.MainService;

/**
 *
 * @author student
 */
public class MainFrame extends javax.swing.JFrame {

    private DefaultListModel<Factura> model = new DefaultListModel<>();
    
    public MainFrame() {
        initComponents();
        
//        MainService.getInstance().addFacturaListener(
//                new FacturaListener() {
//            @Override
//            public void facturaModificata() {
//                afisareFacturi();
//            }
//        });
        
        MainService.getInstance().addFacturaListener(() -> afisareFacturi());
        
        jList1.setModel(model);
        jMenuItem1.addActionListener(ev -> new AddFacturaFrame());
        jMenuItem2.addActionListener(ev -> System.exit(0));
        
        afisareFacturi();
        
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void afisareFacturi() {
        List<Factura> facturi = MainService.getInstance().getFacturi();
        model.clear();
        facturi.forEach(model::addElement);
    }
    
    private void stergeFactura() {
        Factura f = jList1.getSelectedValue();
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setViewportView(jList1);

        jMenu1.setText("Optiuni");

        jMenuItem1.setText("Adauga factura");
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Exit");
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<model.Factura> jList1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
