/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.ArrayList;
import modelo.TipoUsuarioBEAN;
import modelo.TipoUsuarioDAO;

/**
 *
 * @author Daniel
 */
public class TipoUsuarioControl {

    private TipoUsuarioDAO t = new TipoUsuarioDAO();

    public TipoUsuarioBEAN pegaCodigo(String tipoUser) {
        TipoUsuarioBEAN tipo = t.pegaCodigo(tipoUser);
        return tipo;
    }

    public ArrayList<TipoUsuarioBEAN> pegaTipoU() {
        ArrayList<TipoUsuarioBEAN> tipo = t.listarALl();
        return tipo;
    }

}
