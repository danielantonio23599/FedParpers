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

public class ContatoDAO {

    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public ContatoDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public void cadastrarContato(ContatoBEAN contato) {
        String sql = "insert into"
                + " contato (conNome, conTipoUser, conEnderecoEletronico,con_usuCodigo)"
                + " values (?,?,?,?);";

        try {
            System.out.println(contato.getCodigo());
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTipoUser());
            stmt.setString(3, contato.getEndEletronico());
            stmt.setInt(4, contato.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ContatoBEAN> verTodosContatos( int cod) {
        ArrayList<ContatoBEAN> arrayContato = new ArrayList<>();
        String sql = "select * from contato where con_usuCodigo = "+cod+";";

        try {
            stmt = connection.prepareStatement(sql);

            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                ContatoBEAN contato = new ContatoBEAN();
                contato.setCodigo(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setEndEletronico(rs.getString(3));
                contato.setTipoUser(rs.getString(4));
                //adiciona os dados no array
                arrayContato.add(contato);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayContato;
    }

    public ArrayList<ContatoBEAN> localizarContato(int codigoContato) {
        String sql = "select * from contato where conCodigo = ?;";
        ArrayList<ContatoBEAN> c = new ArrayList<ContatoBEAN>();
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, codigoContato);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                ContatoBEAN contato = new ContatoBEAN();
                contato.setCodigo(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setEndEletronico(rs.getString(3));
                contato.setTipoUser(rs.getString(4));
                c.add(contato);
                //adiciona os dados no array
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public boolean editarContato(ContatoBEAN contato) {
        String sql = "update contato set conNome = '"+contato.getNome()+"', conEnderecoEletronico = '"+contato.getEndEletronico()+"',conTipoUser = '"+contato.getTipoUser()+"' where conCodigo = "+contato.getCodigo()+";";
        System.out.println(sql);
        System.out.println(contato.getCodigo());
        System.out.println(contato.getNome());
        System.out.println(contato.getEndEletronico());
        System.out.println(contato.getTipoUser());
        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();            
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean removerContato(int codigoContato) {
        String sql = "delete from contato where conCodigo = ?;";

        try {
            //prepared statement para inserção
            stmt = connection.prepareStatement(sql);
            //seta os valores
            stmt.setInt(1, codigoContato);
            //executa
            stmt.execute();
            stmt.close();
            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verifica(ContatoBEAN aux2) {
        String sql = "select concodigo "
                + "from contato "
                + "where conEnderecoEletronico = '"+aux2.getEndEletronico()+"';";
        int c = 0;
        try {
            stmt = connection.prepareStatement(sql);
           
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

}
