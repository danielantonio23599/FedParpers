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
public class UsuarioBEAN {
    private int cod;
    private String nome;
    private String sobreNome;
    private String CPF;
    private String RG;
    private String Data;
    private String telefone;
    private String celular;
    private String email;
    private String enderecoEletronico;
    private int siape;
    private byte[] foto;
    private byte[] assinatura;
    private LoginBEAN login;
    private AreaBEAN area;
    private CargoBEAN cargo;
    private SetorBEAN setor;
    private TipoUsuarioBEAN tipoUsu;

    public AreaBEAN getArea() {
        return area;
    }

    public void setArea(AreaBEAN area) {
        this.area = area;
    }
    

    public LoginBEAN getLogin() {
        return login;
    }

    public void setLogin(LoginBEAN login) {
        this.login = login;
    }

    public CargoBEAN getCargo() {
        return cargo;
    }

    public void setCargo(CargoBEAN cargo) {
        this.cargo = cargo;
    }

    public SetorBEAN getSetor() {
        return setor;
    }

    public void setSetor(SetorBEAN setor) {
        this.setor = setor;
    }

    public TipoUsuarioBEAN getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(TipoUsuarioBEAN tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getData() {
        return Data;
    }

    public void setData(String Data) {
        this.Data = Data;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnderecoEletronico() {
        return enderecoEletronico;
    }

    public void setEnderecoEletronico(String enderecoEletronico) {
        this.enderecoEletronico = enderecoEletronico;
    }

    public int getSiape() {
        return siape;
    }

    public void setSiape(int siape) {
        this.siape = siape;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public byte[] getAssinatura() {
        return assinatura;
    }

    public void setAssinatura(byte[] assinatura) {
        this.assinatura = assinatura;
    }
    
}
