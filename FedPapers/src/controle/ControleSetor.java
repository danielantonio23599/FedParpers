/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.SetorBEAN;
import modelo.SetorDAO;

/**
 *
 * @author Mateu
 */
public class ControleSetor {

    private SetorDAO setorDao = new SetorDAO();
    private int codigo = 0;

    public int atualizarCodigoSetor() {
        codigo++;
        return codigo;
    }

    public String cadastrarSetor(SetorBEAN setor) {
        boolean conferirCadastroIgual = this.conferirSetorExistente(setor);
        if (conferirCadastroIgual == true) {
            return "O setor " + setor.getNome() + " já está cadastrado!";
        } else {
            setor.setCod(this.atualizarCodigoSetor());
            setorDao.cadastrarSetor(setor);
            return "Setor " + setor.getNome() + " cadastrado com sucesso!";
        }

    }

    public ArrayList<SetorBEAN> verTodosSetores() {
        return setorDao.pegaSetor();
    }

    public ArrayList<SetorBEAN> localizarSetor(int codigoSetor) {
        return setorDao.localizarSetor(codigoSetor);
    }

    public boolean editarSetor(SetorBEAN setor) {
        return setorDao.editarSetor(setor);
    }

    public boolean removerSetor(int codigo) {
        boolean aux = this.verificaUser(codigo);
        if (aux == true) {
            setorDao.removerSetor(codigo);
            return true;
        } else {
            return false;
        }

    }

    public boolean conferirSetorExistente(SetorBEAN setor) {
        ArrayList<SetorBEAN> aux = setorDao.pegaSetor();
        boolean existe = false;
        if (aux.size() > 0) {
            for (SetorBEAN s : aux) {
                if (s.getNome().equals(setor.getNome())) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    public SetorBEAN pegaCodigo(String setor) {

        SetorBEAN ser = setorDao.pegaCodigo(setor);
        return ser;
    }

    private boolean verificaUser(int codigo) {
        boolean v = setorDao.veinculadoUsuario(codigo);
        if (v == true) {
            return true;
        } else {
            return false;
        }
    }
}
