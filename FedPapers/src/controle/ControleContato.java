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

/**
 *
 * @author Mateu
 */
public class ControleContato {

    private ContatoDAO cd = new ContatoDAO();

    public boolean adicionar(ContatoBEAN aux2) {
        boolean aux = this.verificaIgual(aux2);
        if (aux == false) {
            cd.cadastrarContato(aux2);
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaIgual(ContatoBEAN aux2) {
        boolean aux = cd.verifica(aux2);
        if (aux == false) {
            return false;
        } else {
            return true;
        }
    }

    public ArrayList<ContatoBEAN> contatoAll(int cod) {
        ArrayList<ContatoBEAN> aux = cd.verTodosContatos( cod);
        return aux;
    }

    public ArrayList<ContatoBEAN> localizar(int parseInt) {
        ArrayList<ContatoBEAN> aux = cd.localizarContato(parseInt);
        return aux;
    }

    public void editar(ContatoBEAN aux2) {
        cd.editarContato(aux2);
    }

    public void remover(int aux2) {
        cd.removerContato(aux2);
    }
}
