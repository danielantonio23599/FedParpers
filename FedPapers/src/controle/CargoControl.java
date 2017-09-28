/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.CargoBEAN;
import modelo.CargoDAO;

/**
 *
 * @author Daniel
 */
public class CargoControl {

    private static CargoDAO ca = new CargoDAO();

    public boolean adicionar(CargoBEAN ca) {
        boolean aux1 = this.verificaNome(ca);
        if (aux1 == false) {
            boolean aux = this.ca.adicionar(ca);
            if (aux == true) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public ArrayList<CargoBEAN> listarALL() {
        ArrayList<CargoBEAN> dados = ca.listarALl();
        return dados;
    }

    public void editar(CargoBEAN c) {
        this.ca.editar(c);
    }

    public ArrayList<CargoBEAN> localizar(int i) {
        ArrayList<CargoBEAN> aux = ca.localizar(i);
        return aux;
    }

    public boolean excluir(int cod) {
        boolean aux = this.veinculadoUsuario(cod);
        if (aux == true) {
            ca.excluir(cod);
            return true;
        } else {
            return false;
        }
    }

    private boolean verificaNome(CargoBEAN c) {
        ArrayList<CargoBEAN> k = ca.listarALl();
        for (CargoBEAN cg : k) {
            if (cg.getNome().equals(c.getNome())) {
                return true;
            }
        }
        return false;
    }

    public CargoBEAN pegaCodigo(String cargo) {
        CargoBEAN car = ca.pegaCodigo(cargo);
        return car;
    }

    private boolean veinculadoUsuario(int c) {
        boolean v = ca.veinculadoUsuario(c);
        if (v == true) {
            return true;
        } else {
            return false;
        }
    }
}
