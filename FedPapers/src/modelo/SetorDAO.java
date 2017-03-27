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

public class SetorDAO {

    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public SetorDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrarSetor(SetorBEAN setor) {
        String sql = "insert into setor (setNome, setDescricao) values (?, ?);";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, setor.getNome());
            stmt.setString(2, setor.getDescricao());

            //executa
            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<SetorBEAN> pegaSetor() {
        ArrayList<SetorBEAN> arraySetor = new ArrayList<>();
        String sql = "select * from setor;";

        try {
            stmt = connection.prepareStatement(sql);

            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                SetorBEAN setor = new SetorBEAN();
                setor.setCod(rs.getInt(1));
                setor.setNome(rs.getString(2));
                setor.setDescricao(rs.getString(3));
                //adiciona os dados no array
                arraySetor.add(setor);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arraySetor;
    }

    public ArrayList<SetorBEAN> localizarSetor(int codigoSetor) {
        String sql = "select * from setor where setCodigo = ?;";
        ArrayList<SetorBEAN> s = new ArrayList<SetorBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoSetor);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                SetorBEAN setor = new SetorBEAN();
                setor.setCod(rs.getInt(1));
                setor.setNome(rs.getString(2));
                setor.setDescricao(rs.getString(3));
                s.add(setor);
                //adiciona os dados no array

            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return s;
    }

    public boolean editarSetor(SetorBEAN setor) {
        String sql = "update setor set setNome = ?, setDescricao = ? where setCodigo = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setString(1, setor.getNome());
            stmt.setString(2, setor.getDescricao());
            stmt.setInt(3, setor.getCod());

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

    public boolean removerSetor(int codigoSetor) {
        String sql = "delete from setor where setCodigo = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);

            //seta os valores
            stmt.setInt(1, codigoSetor);

            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public SetorBEAN pegaCodigo(String setor) {
        SetorBEAN c = new SetorBEAN();
        String sql = "select setCodigo from setor where setNome = ?;";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, setor);
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

    public boolean veinculadoUsuario(int codigo) {
        String sql = "select count(usu_setCodigo) from usuario join setor where setcodigo = usu_setCodigo and setcodigo = ?;";
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
