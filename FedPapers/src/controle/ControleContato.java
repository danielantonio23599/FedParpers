/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.CargoBEAN;
import modelo.ContatoBEAN;
import modelo.ContatoDAO;
import modelo.UsuarioBEAN;

/**
 *
 * @author Mateu
 */
public class ControleContato {

    private ContatoDAO cd = new ContatoDAO();

    public UsuarioBEAN adicionar(ContatoBEAN aux2) {

        UsuarioBEAN u = this.verificaUser(aux2);
        if (u != null) {

            return u;
        } else {
            return null;
        }
    }

    public boolean verificaIgual(ContatoBEAN aux2, int i) {
        boolean aux = cd.verifica(aux2, i);
        if (aux == false) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<ContatoBEAN> contatoAll(int cod) {
        ArrayList<ContatoBEAN> aux = cd.verTodosContatos(cod);

        return aux;
    }

    public ArrayList<UsuarioBEAN> localizarFoto(int i, int j) {
        ArrayList<UsuarioBEAN> u = cd.localizarFoto(i, j);
        return u;
    }

    public ArrayList<ContatoBEAN> localizar(int i, int j) {
        ArrayList<ContatoBEAN> aux = cd.localizarContato(i, j);
        return aux;
    }

    public void editar(ContatoBEAN aux2) {
        cd.editarContato(aux2);
    }

    public void remover(int aux2) {
        cd.removerContato(aux2);
    }

    public UsuarioBEAN verificaUser(ContatoBEAN aux2) {
        UsuarioControl c = new UsuarioControl();
        UsuarioBEAN u = c.verificaUser(aux2.getEndEletronico());
        if (u != null) {
            return u;
        } else {
            return null;
        }
    }

    public boolean adicionar2(ContatoBEAN aux2, int i) {
        boolean aux = this.verificaIgual(aux2, i);
        if (aux == false) {
            cd.cadastrarContato2(aux2);
            return true;
        } else {
            return false;
        }
    }

    public void adicionar(ContatoBEAN aux2, UsuarioBEAN ad) {
        cd.cadastrarContato(aux2, ad);
    }

}
