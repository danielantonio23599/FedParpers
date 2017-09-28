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
public class UsuarioDAO {

    private Connection connection;

    private PreparedStatement stmt;

    public UsuarioDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void adicionar(UsuarioBEAN u) {
        String sql = "insert into usuario(usuNome,usuSobrenome,usuSiape,"
                + "usuCPF,usuRG,usuDataNascimento,usuEmail,usuEnderecoEletronico,"
                + "usuTelefoneCelular,usuTelefoneFixo,usu_tipCodigo,usu_carCodigo,"
                + "usu_setCodigo,usu_logCodigo,usu_areCodigo)"
                + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getSobreNome());
            stmt.setInt(3, u.getSiape());
            stmt.setString(4, u.getCPF());
            stmt.setString(5, u.getRG());
            stmt.setString(6, u.getData());
            stmt.setString(7, u.getEmail());
            stmt.setString(8, u.getEnderecoEletronico());
            stmt.setString(9, u.getCelular());
            stmt.setString(10, u.getTelefone());
            stmt.setInt(11, u.getTipoUsu().getCod());
            stmt.setInt(12, u.getCargo().getCod());
            stmt.setInt(13, u.getSetor().getCod());
            stmt.setInt(14, u.getLogin().getCod());
            stmt.setInt(15, u.getArea().getCod());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<UsuarioBEAN> listar() {
        int c;
        int aa;
        int ss;
        int tt;
        ArrayList<UsuarioBEAN> uAL = new ArrayList<UsuarioBEAN>();
        String sql = "select usuCodigo,usuNome,usuSobrenome,usuSiape,usuCPF,usuRG,usuDataNascimento,usuEmail,"
                + "usuEnderecoEletronico,usuTelefoneCelular,"
                + "usuTelefoneFixo,usu_tipCodigo,usu_carCodigo,usu_setCodigo, usu_logCodigo,usu_areCodigo from usuario;";

        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioBEAN u = new UsuarioBEAN();
                u.setCod(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setSobreNome(rs.getString(3));
                u.setSiape(rs.getInt(4));
                u.setCPF(rs.getString(5));
                u.setRG(rs.getString(6));
                u.setData(rs.getString(7));
                u.setEmail(rs.getString(8));
                u.setEnderecoEletronico(rs.getString(9));
                u.setCelular(rs.getString(10));
                u.setTelefone(rs.getString(11));
                tt = rs.getInt(12);
                c = rs.getInt(13);
                ss = rs.getInt(14);
                int login = rs.getInt(15);
                aa = rs.getInt(16);
                //pega o cargo
                CargoDAO i = new CargoDAO();
                ArrayList<CargoBEAN> cc = i.localizar(c);
                //seta o cargo
                for (CargoBEAN x : cc) {
                    u.setCargo(x);
                }
                //pega a area
                AreaDAO area = new AreaDAO();
                ArrayList<AreaBEAN> a = area.localizarArea(aa);
                //seta a area
                for (AreaBEAN ar : a) {
                    u.setArea(ar);
                }
                //pega o setor
                SetorDAO s = new SetorDAO();
                ArrayList<SetorBEAN> sertor = s.localizarSetor(ss);
                //seta o setor
                for (SetorBEAN ser : sertor) {
                    u.setSetor(ser);
                }
                //pega login
                LoginDAO objL = new LoginDAO();
                LoginBEAN logi = objL.pegalogin(login);
                //seta login
                u.setLogin(logi);
                //pega TipoUsuario
                TipoUsuarioDAO tu = new TipoUsuarioDAO();
                TipoUsuarioBEAN tipo = tu.tipo(tt);
                //seta tipoUsuario
                u.setTipoUsu(tipo);
                //adiciona no array
                uAL.add(u);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return uAL;
    }

    public ArrayList<UsuarioBEAN> localizar(int i) {
        int c;
        int aa;
        int ss;
        int tt;
        ArrayList<UsuarioBEAN> uAL = new ArrayList<UsuarioBEAN>();
        String sql = "select usuCodigo,usuNome,usuSobrenome,usuSiape,usuCPF,usuRG,"
                + "usuDataNascimento,usuEmail,usuEnderecoEletronico,usuTelefoneCelular,"
                + "usuTelefoneFixo,usu_tipCodigo,usu_carCodigo,usu_setCodigo,usu_logCodigo,"
                + "usu_areCodigo,usuFoto from usuario where usuCodigo = ?;";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, i);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                UsuarioBEAN u = new UsuarioBEAN();
                u.setCod(rs.getInt(1));
                u.setNome(rs.getString(2));
                u.setSobreNome(rs.getString(3));
                u.setSiape(rs.getInt(4));
                u.setCPF(rs.getString(5));
                u.setRG(rs.getString(6));
                u.setData(rs.getString(7));
                u.setEmail(rs.getString(8));
                u.setEnderecoEletronico(rs.getString(9));
                u.setCelular(rs.getString(10));
                u.setTelefone(rs.getString(11));
                tt = rs.getInt(12);
                c = rs.getInt(13);
                ss = rs.getInt(14);
                int login = rs.getInt(15);
                aa = rs.getInt(16);
                u.setFoto(rs.getBytes(17));
                System.out.println(u.getFoto());
                //pega o cargo
                CargoDAO j = new CargoDAO();
                ArrayList<CargoBEAN> cc = j.localizar(c);
                //seta o cargo
                for (CargoBEAN x : cc) {
                    u.setCargo(x);
                }
                //pega a area
                AreaDAO area = new AreaDAO();
                ArrayList<AreaBEAN> a = area.localizarArea(aa);
                //seta a area
                for (AreaBEAN ar : a) {
                    u.setArea(ar);
                }
                //pega o setor
                SetorDAO s = new SetorDAO();
                ArrayList<SetorBEAN> sertor = s.localizarSetor(ss);
                //seta o setor
                for (SetorBEAN ser : sertor) {
                    u.setSetor(ser);
                }
                //pega login
                LoginDAO objL = new LoginDAO();
                LoginBEAN logi = objL.pegalogin(login);
                //seta login
                u.setLogin(logi);

                //pega TipoUsuario
                TipoUsuarioDAO tu = new TipoUsuarioDAO();
                TipoUsuarioBEAN tipo = tu.tipo(tt);
                //seta tipoUsuario
                u.setTipoUsu(tipo);
                //adiciona no array
                uAL.add(u);
            }
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return uAL;
    }

    public void editarUser(UsuarioBEAN u) {
        String sql = "update usuario  set usuNome = '" + u.getNome() + "' ,usuSobrenome = '" + u.getSobreNome() + "',"
                + " usuSiape = " + u.getSiape() + " ,usuCPF = '" + u.getCPF() + "', usuRG = '" + u.getRG() + "', "
                + "usuDataNascimento = '" + u.getData() + "',usuEmail = '" + u.getEmail() + "' ,usuEnderecoEletronico = "
                + "'" + u.getEnderecoEletronico() + "',usuTelefoneCelular = '" + u.getCelular() + "',"
                + "usuTelefoneFixo = '" + u.getTelefone() + "' ,usu_tipCodigo = ? ,usu_carCodigo = ?,usu_setCodigo"
                + " = ?,usu_areCodigo = ? where usuCodigo = ?;";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, u.getTipoUsu().getCod());
            stmt.setInt(2, u.getCargo().getCod());
            stmt.setInt(3, u.getSetor().getCod());
            stmt.setInt(4, u.getArea().getCod());
            stmt.setInt(5, u.getCod());
            stmt.executeUpdate();
            stmt.close();
            // LoginDAO l = new LoginDAO();
            // int usu = this.pegaFKLogin(u);
            // u.getLogin().setCod(usu);
            // l.editar(u);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void editarUserA(UsuarioBEAN u) {
        String sql = "update usuario  set usuNome = '" + u.getNome() + "' ,usuSobrenome = '" + u.getSobreNome() + "',"
                + " usuSiape = " + u.getSiape() + " ,usuCPF = '" + u.getCPF() + "', usuRG = '" + u.getRG() + "', "
                + "usuDataNascimento = '" + u.getData() + "',usuEmail = '" + u.getEmail() + "' ,usuEnderecoEletronico = "
                + "'" + u.getEnderecoEletronico() + "',usuTelefoneCelular = '" + u.getCelular() + "',"
                + "usuTelefoneFixo = '" + u.getTelefone() + "',usu_carCodigo = ?,usu_setCodigo"
                + " = ?,usu_areCodigo = ? where usuCodigo = ?;";

        try {
            stmt = connection.prepareStatement(sql);

            stmt.setInt(1, u.getCargo().getCod());
            stmt.setInt(2, u.getSetor().getCod());
            stmt.setInt(3, u.getArea().getCod());
            stmt.setInt(4, u.getCod());
            stmt.executeUpdate();
            stmt.close();
            LoginDAO l = new LoginDAO();
            int usu = this.pegaFKLogin(u);
            u.getLogin().setCod(usu);
            l.editar(u);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void remover(int c, int log) {
        String sql = "delete from usuario where usuCodigo = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, c);
            stmt.execute();
            stmt.close();
            LoginDAO l = new LoginDAO();
            l.removerLogin(log);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public boolean verificaEmail(UsuarioBEAN u) {
        String sql = "select count(usuCodigo) from usuario where (usuEmail = ? or usuCPF = ? or usuSiape = ? or usuEnderecoEletronico = ?) and usuCodigo != ?;";
        int co = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, u.getEmail());
            stmt.setString(2, u.getCPF());
            stmt.setInt(3, u.getSiape());
            stmt.setString(4, u.getEnderecoEletronico());
            stmt.setInt(5, u.getCod());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                co = rs.getInt(1);
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (co > 0) {
            return false;
        } else {
            return true;
        }
    }

    private int pegaFKLogin(UsuarioBEAN u) {
        String sql = "select usu_logCodigo from usuario where usuCodigo = ?;";
        int co = 0;
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setInt(1, u.getCod());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                co = rs.getInt(1);
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return co;
    }

    public void atualizarFoto(UsuarioBEAN u) {
        String sql = "update usuario  set usuFoto = ? where usuCodigo = ?;";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setBytes(1, u.getFoto());

            System.out.println(u.getFoto());
            stmt.setInt(2, u.getCod());
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public UsuarioBEAN verificaUser(String E) {
        UsuarioBEAN u = new UsuarioBEAN();
        u.setCod(0);
        String sql = "select usuFoto,usuCodigo from usuario where usuEnderecoEletronico ='" + E + "'";
        try {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u.setFoto(rs.getBytes(1));
                u.setCod(rs.getInt(2));
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (u.getCod() != 0) {
            return u;
        } else {
            return null;
        }
    }

    public UsuarioBEAN verificaUpdate(ArrayList<ContatoBEAN> aux) {
        UsuarioBEAN u = new UsuarioBEAN();
        String sql = "select count(usuCodigo) from usuario where usuEnderecoEletronico = '" + aux.get(0).getEndEletronico() + "' and usuFoto != ?;";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setBytes(1, aux.get(0).getFoto());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                u.setFoto(rs.getBytes(1));
            }
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (!u.getFoto().equals("")) {
            return u;
        } else {
            return null;
        }
    }
}
