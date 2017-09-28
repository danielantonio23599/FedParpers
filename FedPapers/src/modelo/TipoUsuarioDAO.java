/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Daniel
 */
public class TipoUsuarioDAO {

    private Connection connection;

    private PreparedStatement stmt;

    public TipoUsuarioDAO() {
        this.connection = ConnectionFactory.getConnection();;
    }

    public TipoUsuarioBEAN pegaCodigo(String tipoUser) {
        TipoUsuarioBEAN c = new TipoUsuarioBEAN();
        String sql = "select tipCodigo from tipo_usuario where tipNome = ?;";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, tipoUser);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c.setCod(rs.getInt(1));
            }
            stmt.close();
            return c;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<TipoUsuarioBEAN> listarALl() {
        ArrayList<TipoUsuarioBEAN> c = new ArrayList<TipoUsuarioBEAN>();
        String sql = "select * from tipo_usuario;";
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TipoUsuarioBEAN ca = new TipoUsuarioBEAN();
                ca.setCod(rs.getInt(1));
                ca.setNome(rs.getString(2));
                c.add(ca);
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        return c;
    }

    public TipoUsuarioBEAN tipo(int c) {
        TipoUsuarioBEAN car = new TipoUsuarioBEAN();
        String sql = "select tipCodigo,tipNome from usuario join tipo_usuario where tipCodigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, c);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                car.setCod(rs.getInt(1));
                car.setNome(rs.getString(2));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }
}
