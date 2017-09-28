/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.LoginBEAN;
import modelo.LoginDAO;

/**
 *
 * @author Daniel
 */
public class LoginControl {

    private LoginDAO ld = new LoginDAO();

    public LoginBEAN adicionar(LoginBEAN l) {
        boolean verifica = this.verifica(l);
        if (verifica == true) {
            return null;
        } else {
            LoginBEAN i = ld.adicionar(l);
            return i;
        }
    }

    public String[] logar(String nome, LoginBEAN login) {
        String aux[] = new String[2];
        int l[] = ld.logar(nome, login);
        if ((l[0] == 1) && (l[1] > 0)) {
            aux[0] = "Seja Bem Vindo";
            aux[1] = l[1] + "";
            return aux;
        } else {
            aux[0] = null;
            aux[1] = null;
            return aux;
        }
    }

    private boolean verifica(LoginBEAN l) {
        boolean aux = ld.verificaIgual(l);
        if (aux == true) {
            return true;
        } else {
            return false;
        }
    }

}
