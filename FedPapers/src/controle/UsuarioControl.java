/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import modelo.CargoBEAN;
import modelo.UsuarioBEAN;
import modelo.UsuarioDAO;

/**
 *
 * @author Daniel
 */
public class UsuarioControl {

    private UsuarioDAO ud = new UsuarioDAO();

    public String adicionar(UsuarioBEAN u) {
        boolean auz = this.verificaIgual(u);
        if (auz != false) {
            ud.adicionar(u);
            return "Cadastro feito com sucesso";
        } else {
            return "Hà usuário cadastro com algun campo de CPF,SIAPE,E-mail ou Endereco Eletronico...Mude os valores!";
        }
    }

    public ArrayList<UsuarioBEAN> listarALL() {
        ArrayList<UsuarioBEAN> c = ud.listar();
        return c;
    }

    private boolean verificaIgual(UsuarioBEAN u) {
        ArrayList<UsuarioBEAN> aox = ud.listar();
        if (aox.size() > 0) {
            for (UsuarioBEAN usu : aox) {
                if ((usu.getCPF().equals(u.getCPF())) || (usu.getSiape() == u.getSiape()) || (usu.getEmail().equals(u.getEmail())) || (usu.getEnderecoEletronico().equals(u.getEnderecoEletronico()))) {
                    return false;
                }
            }
            return true;
        }
        return true;
    }

    public ArrayList<UsuarioBEAN> localizar(int i) {
        ArrayList<UsuarioBEAN> aux = ud.localizar(i);
        if (aux.size() > 0) {
            return aux;
        }
        return null;
    }

    public String editarUser(UsuarioBEAN u) {
        boolean auz = this.verificaIgualEdit(u);
        if (auz != false) {
            ud.editarUser(u);
            return "Edição feita com sucesso!";
        } else {
            return "Hà usuário cadastro com algun campo de CPF,SIAPE,E-mail ou Endereco Eletronico...Mude os valores!";
        }
    }

    public void excluir(int i, int log) {
        ud.remover(i, log);
    }

    private boolean verificaIgualEdit(UsuarioBEAN u) {
        boolean aux = ud.verificaEmail(u);
        if (aux == false) {
            return false;
        } else {
            return true;
        }
    }

    

    public void atualizarFoto(UsuarioBEAN u) {
        ud.atualizarFoto(u);
    }

}
