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
import javax.xml.transform.Source;

public class AreaDAO {

    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public AreaDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrarArea(AreaBEAN area) {
        String sql = "insert into area (areNome, areDescricao) values (?,?);";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, area.getNome());
            stmt.setString(2, area.getDescricao());

            //executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<AreaBEAN> pegaArea() {
        ArrayList<AreaBEAN> arraySetor = new ArrayList<>();
        String sql = "select * from area;";

        try {
            stmt = connection.prepareStatement(sql);

            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                AreaBEAN area = new AreaBEAN();
                area.setCod(rs.getInt(1));
                area.setNome(rs.getString(2));
                area.setDescricao(rs.getString(3));
                //adiciona os dados no array
                arraySetor.add(area);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arraySetor;
    }

    public ArrayList<AreaBEAN> localizarArea(int codigoArea) {
        String sql = "select * from area where areCodigo = ?;";
        ArrayList<AreaBEAN> arrayArea = new ArrayList<AreaBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoArea);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                AreaBEAN area = new AreaBEAN();
                area.setCod(rs.getInt(1));
                area.setNome(rs.getString(2));
                area.setDescricao(rs.getString(3));
                arrayArea.add(area);
                //adiciona os dados no array

            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayArea;
    }

    public boolean editarArea(AreaBEAN area) {
        String sql = "update area set areNome = ?, areDescrição = ? where areCodigo = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, area.getNome());
            stmt.setString(2, area.getDescricao());
            stmt.setInt(3, area.getCod());

            //executa
            int linhasAtualizadas = stmt.executeUpdate();
            stmt.close();
            if (linhasAtualizadas > 0) {
                System.out.println("Foram alterados " + linhasAtualizadas + " resgistros");
            }
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerArea(int codigoArea) {
        String sql = "delete from area where areCodigo = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, codigoArea);

            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public AreaBEAN pegaCodigo(String area) {
        AreaBEAN c = new AreaBEAN();
        String sql = "select areCodigo from area where areNome = ?;";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, area);
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

    public boolean verifiaUser(int codigo) {
        String sql = "select count(usu_areCodigo) from usuario join area where arecodigo = usu_areCodigo and arecodigo = ?;";
        int co = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                co = rs.getInt(1);
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException();
        }
        if (co > 0) {
            return false;
        } else {
            return true;
        }
    }
}
