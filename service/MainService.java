/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.FacturaDao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.Factura;
import view.FacturaListener;

/**
 *
 * @author student
 */
public class MainService {
    private Connection con;
    private List<FacturaListener> listeners = new ArrayList<>();
    
    private MainService() {
        try {
            String url = "jdbc:mysql://localhost/java1pcurs8";
            String user = "root";
            String pass = "";
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private static final class SingletonHolder {
        private static final MainService SINGLETON = new MainService();
    }
    
    public static MainService getInstance() {
        return SingletonHolder.SINGLETON;
    }
    
    public void adaugaFactura(int numar, String serie) {
        Factura f = new Factura();
        f.setNumar(numar);
        f.setSerie(serie);
        
        FacturaDao facturaDao = new FacturaDao(con);
        try {
            facturaDao.adaugaFactura(f);
            listeners.forEach(fl -> fl.facturaModificata());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Factura> getFacturi() {
        FacturaDao facturaDao = new FacturaDao(con);
        try {
            return facturaDao.getFacturi();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        return Collections.emptyList();
    }
    
    public void addFacturaListener(FacturaListener f) {
        listeners.add(f);
    }
}
