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
import modelo.AreaBEAN;
import modelo.AreaDAO;
import modelo.SetorBEAN;
import modelo.SetorDAO;

/**
 *
 * @author Mateu
 */
public class ControleArea {

    private AreaDAO areaDao = new AreaDAO();
    private int codigo = 0;

    public int atualizarCodigoArea() {
        codigo++;
        return codigo;
    }

    public String cadastrarArea(AreaBEAN area) {
        boolean conferirCadastroIgual = this.conferirAreaExistente(area);
        if (conferirCadastroIgual == true) {
            return "A área " + area.getNome() + " já está cadastrada!";
        } else {
            area.setCod(this.atualizarCodigoArea());
            areaDao.cadastrarArea(area);
            return "Área " + area.getNome() + " cadastrada com sucesso!";
        }

    }

    public ArrayList<AreaBEAN> verTodasAreas() {
        return areaDao.pegaArea();
    }

    public ArrayList<AreaBEAN> localizarArea(int codigoArea) {
        return areaDao.localizarArea(codigoArea);
    }

    public boolean editarArea(AreaBEAN area) {
        return areaDao.editarArea(area);
    }

    public boolean removerArea(int codigo) {
        boolean aux = this.verificaUser(codigo);
        if (aux == true) {
            areaDao.removerArea(codigo);
            return true;
        } else {
            return false;
        }

    }

    public boolean conferirAreaExistente(AreaBEAN area) {
        ArrayList<AreaBEAN> aux = areaDao.pegaArea();
        boolean existe = false;
        if (aux.size() > 0) {
            for (AreaBEAN a : aux) {
                if (a.getNome().equals(area.getNome())) {
                    existe = true;
                }
            }
        }
        return existe;
    }

    private boolean verificaUser(int codigo) {
        boolean v = areaDao.verifiaUser(codigo);
        if (v == true) {
            return true;
        } else {
            return false;
        }
    }
}
