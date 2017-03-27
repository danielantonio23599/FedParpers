/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Mateu
 */
public class ContatoBEAN {
   private UsuarioBEAN usuario;
   private int codigo;
   private String tipoUser;
   private String endEletronico;
   private String Nome;

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    

    public String getEndEletronico() {
        return endEletronico;
    }

    public void setEndEletronico(String endEletronico) {
        this.endEletronico = endEletronico;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public UsuarioBEAN getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBEAN usuario) {
        this.usuario = usuario;
    }

   

   
    
   
}
