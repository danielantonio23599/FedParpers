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

/**
 *
 * @author Daniel
 */
public class DocumentoDAO {

    //armazena o obj de conexão com o BD mySql
    private Connection connection;
    //obj stmt que executa as consultas no BD
    private PreparedStatement stmt;

    public DocumentoDAO() {
        //inicializa a conexão com o BD
        this.connection = ConnectionFactory.getConnection();
    }

    public int cadastrarDoc(DocumentoBEAN doc) {
        String sql = "insert into"
                + " documento (docData,docAssunto,docRemetente,docCorpoTexto, doc_usuCodigo,doc_staCodigo)"
                + " values (?,?,?,?,?,?);";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, doc.getDataHora());
            stmt.setString(2, doc.getAssunto());
            stmt.setString(3, doc.getRemetente());
            stmt.setString(4, doc.getCorpoTexto());
            stmt.setInt(5, doc.getCodigo());
            stmt.setInt(6, 4);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return this.buscar(doc);
    }

    public void enviar(int doc, int usu) {
        String sql = "insert into"
                + " destinatarioInterno (dei_docCodigo,dei_usuCodigo)"
                + " values (?,?);";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, doc);
            stmt.setInt(2, usu);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.mudaStatusEnviado(doc);
    }

    public void mudaStatusEnviado(int i) {
        String sql = "update documento set doc_staCodigo = 1 where docCodigo"
                + " = " + i + ";";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void mudaStatusLido(int i) {
        String sql = "update documento set doc_staCodigo = 3 where docCodigo"
                + " = " + i + ";";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataRecebido(String dh, int cod) {
        String sql = "update documento set docDataRecebido = '" + dh + "' where docCodigo"
                + " = " + cod + ";";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDataLido(String dh, int cod) {
        String sql = "update documento set docDataLido = '" + dh + "' where docCodigo"
                + " = " + cod + ";";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private int buscar(DocumentoBEAN doc) {
        String sql = "select docCodigo from documento where docData = '" + doc.getDataHora() + "' ;";
        int c = 0;
        try {
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                c = rs.getInt(1);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return c;
    }

    public ArrayList<DocumentoBEAN> docRecebidos(int cod) {
        ArrayList<DocumentoBEAN> docs = new ArrayList<DocumentoBEAN>();
        String sql = "select docCodigo,docData,docDataRecebido,docDataLido,docAssunto,docRemetente,docCorpoTexto, usuEnderecoEletronico as Destinatario, staNome from documento join status join destinatariointerno join usuario where docCodigo = dei_docCodigo and dei_usuCodigo =usuCodigo and staCodigo = doc_staCodigo and staCodigo = 3 and usuCodigo = " + cod + ";";

        try {
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                DocumentoBEAN doc = new DocumentoBEAN();
                UsuarioBEAN u = new UsuarioBEAN();
                StatusBEAN s = new StatusBEAN();
                doc.setCodigo(rs.getInt(1));
                doc.setDataHora(rs.getString(2));
                doc.setDataRecedido(rs.getString(3));
                doc.setDataLido(rs.getString(4));
                doc.setAssunto(rs.getString(5));
                doc.setRemetente(rs.getString(6));
                doc.setCorpoTexto(rs.getString(7));
                u.setEnderecoEletronico(rs.getString(8));
                s.setNome(rs.getString(9));
                doc.setStatus(s);
                doc.setUsuario(u);
                docs.add(doc);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return docs;
    }

    public ArrayList<DocumentoBEAN> docNotLidos(int cod) {
        ArrayList<DocumentoBEAN> docs = new ArrayList<DocumentoBEAN>();
        String sql = "select docCodigo,docData,docDataRecebido,docAssunto,docRemetente,docCorpoTexto, usuEnderecoEletronico as Destinatario, staNome from documento join status join destinatariointerno join usuario where docCodigo = dei_docCodigo and dei_usuCodigo =usuCodigo and staCodigo = doc_staCodigo and staCodigo != 3 and usuCodigo =" + cod + ";";

        try {
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                DocumentoBEAN doc = new DocumentoBEAN();
                UsuarioBEAN u = new UsuarioBEAN();
                StatusBEAN s = new StatusBEAN();
                doc.setCodigo(rs.getInt(1));
                doc.setDataHora(rs.getString(2));
                doc.setDataRecedido(rs.getString(3));
                doc.setAssunto(rs.getString(4));
                doc.setRemetente(rs.getString(5));
                doc.setCorpoTexto(rs.getString(6));
                u.setEnderecoEletronico(rs.getString(7));
                s.setNome(rs.getString(8));
                System.out.println("Status nomeDao --"+s.getNome());
                doc.setUsuario(u);
                doc.setStatus(s);
                docs.add(doc);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return docs;
    }

    public ArrayList<DocumentoBEAN> docEnviados(int cod) {
        ArrayList<DocumentoBEAN> docs = new ArrayList<DocumentoBEAN>();
        String sql = "select docCodigo,docData,docDataRecebido,docDataLido,docAssunto,docRemetente,docCorpoTexto,desEnd, staNome from documento join destinatariointerno join (select usuCodigo as desCodigo, usuEnderecoEletronico as desEnd from usuario) as destinatario join status join usuario where doc_usuCodigo = usuCodigo and staCodigo = doc_staCodigo and desCodigo = dei_usuCodigo and dei_docCodigo = docCodigo and usuCodigo =" + cod + ";";

        try {
            stmt = connection.prepareStatement(sql);
            //executa
            ResultSet rs = stmt.executeQuery();
            //joga resultado da consulta no arrayList
            while (rs.next()) {
                DocumentoBEAN doc = new DocumentoBEAN();
                UsuarioBEAN u = new UsuarioBEAN();
                StatusBEAN s = new StatusBEAN();
                doc.setCodigo(rs.getInt(1));
                doc.setDataHora(rs.getString(2));
                doc.setDataRecedido(rs.getString(3));
                doc.setDataLido(rs.getString(4));
                doc.setAssunto(rs.getString(5));
                doc.setRemetente(rs.getString(6));
                doc.setCorpoTexto(rs.getString(7));
                u.setEnderecoEletronico(rs.getString(8));
                doc.setUsuario(u);
                s.setNome(rs.getString(9));
                doc.setStatus(s);

                docs.add(doc);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return docs;
    }

    public ArrayList<DocumentoBEAN> docTodos(int cod) {
        ArrayList<DocumentoBEAN> todos = new ArrayList<DocumentoBEAN>();
        ArrayList<DocumentoBEAN> re = this.docRecebidos(cod);
        ArrayList<DocumentoBEAN> en = this.docEnviados(cod);
        ArrayList<DocumentoBEAN> nl = this.docNotLidos(cod);
        if (nl != null) {
            for (DocumentoBEAN d : nl) {
                todos.add(d);
            }
        }
        if (en != null) {
            for (DocumentoBEAN d : en) {
                todos.add(d);
            }
        }
        if (re != null) {
            for (DocumentoBEAN d : re) {
                todos.add(d);
            }
        }
        return todos;
    }

    public ResultSet consulta(String strSql) {
        try {
            //criando o objeto Statement para que seja possivel enviar as consultas
            Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            //objeto do ResulSet para receber o resultado da consulta
            ResultSet rs = stmt.executeQuery(strSql);
            return rs;
        } catch (SQLException erro) {
            System.err.println(erro.getMessage());
            return null;
        }
    }

}
