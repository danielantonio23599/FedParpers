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
import java.sql.Statement;
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

    public void cadastrarContato(ContatoBEAN contato, UsuarioBEAN aux) {
        String sql = "insert into"
                + " contato (conNome,conEmail,conCelular,conFoto, conTipoUser, conEnderecoEletronico,con_usuCodigo)"
                + " values (?,?,?,?,?,?,?);";

        try {
            System.out.println(contato.getCodigo());
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getCelular());
            System.out.println(aux.getFoto());
            stmt.setBytes(4, aux.getFoto());
            stmt.setString(5, contato.getTipoUser());
            stmt.setString(6, contato.getEndEletronico());
            stmt.setInt(7, contato.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<ContatoBEAN> verTodosContatos(int cod) {
        ArrayList<ContatoBEAN> arrayContato = new ArrayList<>();
        String sql = "select * from contato where con_usuCodigo = " + cod + ";";

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
                contato.setEmail(rs.getString(5));
                contato.setCelular(rs.getString(6));
                contato.setFoto(rs.getBytes(7));
                //adiciona os dados no array
                arrayContato.add(contato);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayContato;
    }

    public ArrayList<ContatoBEAN> localizarContato(int i, int j) {
        String sql = "select * from contato where conCodigo =" + i + " and con_usuCodigo =" + j + ";";
        ArrayList<ContatoBEAN> c = new ArrayList<ContatoBEAN>();
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
                contato.setEmail(rs.getString(5));
                contato.setCelular(rs.getString(6));
                contato.setFoto(rs.getBytes(7));
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
        String sql = "update contato set conNome = '" + contato.getNome() + "', conEnderecoEletronico "
                + "= '" + contato.getEndEletronico() + "',conTipoUser = '" + contato.getTipoUser() + "',conCelular = '" + contato.getCelular() + "',conEmail = '" + contato.getEmail() + "' where conCodigo"
                + " = " + contato.getCodigo() + ";";
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

    public boolean verifica(ContatoBEAN aux2, int i) {
        String sql = "select conCodigo "
                + "from contato "
                + "where (conEnderecoEletronico = '" + aux2.getEndEletronico() + "' or conEmail = '" + aux2.getEmail() + "') and con_usuCodigo = " + i + ";";
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

    public void cadastrarContato2(ContatoBEAN contato) {
        String sql = "insert into"
                + " contato (conNome,conEmail,conCelular, conTipoUser,con_usuCodigo)"
                + " values (?,?,?,?,?);";

        try {
            System.out.println(contato.getCodigo());
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getEmail());
            stmt.setString(3, contato.getCelular());
            stmt.setString(4, contato.getTipoUser());
            stmt.setInt(5, contato.getCodigo());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public ArrayList<UsuarioBEAN> localizarFoto(int i, int j) {
        String sql = "select conFoto,conCodigo from contato where conCodigo =" + i + " and con_usuCodigo =" + j + ";";
        System.out.println(sql);
        ArrayList<UsuarioBEAN> u = new ArrayList<UsuarioBEAN>();
        UsuarioBEAN u1 = new UsuarioBEAN();
        try {
            stmt = connection.prepareStatement(sql);

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u1.setFoto(rs.getBytes(1));
                u1.setCod(rs.getInt(2));
                u.add(u1);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return u;
    }
     public ResultSet consulta(String strSql) {
        try {
            //criando o objeto Statement para que seja possivel enviar as consultas
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //objeto do ResulSet para receber o resultado da consulta
            ResultSet rs = stmt.executeQuery(strSql);
            return rs;
        } catch (SQLException erro) {
            System.out.println("Erro 11111");
            System.err.println(erro.getMessage());
            return null;
        }
    }

}
