/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.UsuarioBEAN;
import modelo.UsuarioDAO;

/**
 *
 * @author Daniel
 */
public class PerfilControl {
        private UsuarioDAO ud = new UsuarioDAO();
     public String editarUser(UsuarioBEAN u) {
        boolean auz = this.verificaIgualEdit(u);
        if (auz != false) {
            ud.editarUserA(u);
            return "Edição feita com sucesso!";
        } else {
            return "Hà usuário cadastro com algun campo de CPF,SIAPE,E-mail ou Endereco Eletronico...Mude os valores!";
        }
    }

    private boolean verificaIgualEdit(UsuarioBEAN u) {
       boolean aux = ud.verificaEmail(u);
       if(aux == true){
       return true;
       }else{
       return false;
       }
    }

}
