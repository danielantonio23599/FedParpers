/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Daniel
 */
public class DocumentoBEAN {

    private int codigo;
    private String dataHora;
    private String assunto;
    private String remetente;
    private String corpoTexto;
    private String dataRecedido;
    private String dataLido;
    private UsuarioBEAN usuario;
    private StatusBEAN status;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getDataRecedido() {
        return dataRecedido;
    }

    public void setDataRecedido(String dataRecedido) {
        this.dataRecedido = dataRecedido;
    }

    public String getDataLido() {
        return dataLido;
    }

    public void setDataLido(String dataLido) {
        this.dataLido = dataLido;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getCorpoTexto() {
        return corpoTexto;
    }

    public void setCorpoTexto(String corpoTexto) {
        this.corpoTexto = corpoTexto;
    }

    public UsuarioBEAN getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioBEAN usuario) {
        this.usuario = usuario;
    }

    public StatusBEAN getStatus() {
        return status;
    }

    public void setStatus(StatusBEAN status) {
        this.status = status;
    }

}
