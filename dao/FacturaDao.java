/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Factura;

/**
 *
 * @author student
 */
public class FacturaDao {
    private Connection con;
    
    public FacturaDao(Connection con) {
        this.con = con;
    }
    
    public void adaugaFactura(Factura f) throws SQLException {
        String sql = "INSERT INTO facturi VALUES (NULL, ?, ?)";
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, f.getNumar());
            stmt.setString(2, f.getSerie());
            stmt.executeUpdate();
        }
    }
    
    public List<Factura> getFacturi() throws SQLException {
        List<Factura> facturi = new ArrayList<>();
        String sql = "SELECT * FROM facturi";
        try (
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            while (rs.next()) {
                Factura f = new Factura();
                f.setId(rs.getInt("id"));
                f.setNumar(rs.getInt("numar"));
                f.setSerie(rs.getString("serie"));
                facturi.add(f);
            }
        }
        return facturi;
    }
}
