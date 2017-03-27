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

/**
 *
 * @author Daniel
 */
public class LoginDAO {

    private Connection connection;
    private PreparedStatement stmt;

    public LoginDAO() {
        this.connection = ConnectionFactory.getConnection();;
    }

    public LoginBEAN adicionar(LoginBEAN l) {
        String sql = "insert into login (logLogin, logSenha) values (?, md5(?));";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            stmt.execute();
            stmt.close();
            LoginBEAN i = this.pegaCod(l);
            return i;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private LoginBEAN pegaCod(LoginBEAN l) {
        LoginBEAN pc = new LoginBEAN();
        String sql = "select logCodigo,logLogin from login  where logLogin = ? and logSenha = md5(?);";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                pc.setCod((rs.getInt(1)));
                pc.setLogin(rs.getString(2));
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pc;
    }

    public LoginBEAN pegalogin(int login) {
        LoginBEAN car = new LoginBEAN();
        String sql = "select logCodigo,logLogin,logSenha from usuario join login where logCodigo = ?;";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, login);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                car.setCod(rs.getInt(1));
                car.setLogin(rs.getString(2));
                car.setSenha(rs.getString(3));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return car;
    }

    void removerLogin(int log) {
        String sql = "delete from login where logCodigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, log);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public int[] logar(String aux, LoginBEAN login) {
        int logar[] = new int[2];
        String sql = "select "
                + " count(usuCodigo), "
                + " usuCodigo "
                + "from usuario join login join tipo_usuario "
                + "where logCodigo = usu_logCodigo and "
                + "tipCodigo = usu_tipCodigo and logLogin = '" + login.getLogin() + "' and logSenha = md5('" + login.getSenha() + "') and tipNome = '" + aux + "' ;";
        System.out.println(sql);
        try {
            stmt = connection.prepareStatement(sql);
            // stmt.setString(1, login.getLogin());
            //stmt.setString(2, login.getSenha());
            //stmt.setString(3, aux);
            System.out.println("Resultado");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                logar[0] = rs.getInt(1);
                System.out.println(logar[0]);

                logar[1] = rs.getInt(2);
                System.out.println(logar[1]);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return logar;
    }

    public boolean verificaIgual(LoginBEAN l) {
        int c = 0;
        String sql = "select count(logCodigo) from login  where logLogin = ? and logSenha = md5(?);";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, l.getLogin());
            stmt.setString(2, l.getSenha());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                c = rs.getInt(1);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (c > 0) {
            return true;
        } else {
            return false;
        }
    }

   public void editar(UsuarioBEAN u) {
        String sql = "update login  set logSenha = md5('"+u.getLogin().getSenha() +
                 "')where logCodigo = "+u.getLogin().getCod()+";";
        
       System.out.println(u.getLogin().getCod());
        try {
            stmt = connection.prepareStatement(sql);
           // stmt.setString(1, u.getLogin().getSenha());
            //stmt.setInt(2, u.getLogin().getCod());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        
    }
}
