/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author douglas dullius - 563620
 */
public class Tecnico {

    private String nome;

    private String login;

    private String senha;

    private String RG;

    private String CPF;

    private String Data_nasc;

    private String Rua;

    private int numero;

    private int Cidade;

    private String bairro;

    private String Telefone;

    private String Celular;

    private String email;

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getLogin() {
        return login;
    }

    /**
     *
     * @param login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     *
     * @return
     */
    public String getSenha() {
        return senha;
    }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     *
     * @return
     */
    public String getRG() {
        return RG;
    }

    /**
     *
     * @param RG
     */
    public void setRG(String RG) {
        this.RG = RG;
    }

    /**
     *
     * @return
     */
    public String getCPF() {
        return CPF;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */
    public String getData_nasc() {
        return Data_nasc;
    }

    /**
     *
     * @param Data_nasc
     */
    public void setData_nasc(String Data_nasc) {
        this.Data_nasc = Data_nasc;
    }

    /**
     *
     * @return
     */
    public String getRua() {
        return Rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

   

    /**
     *
     * @param Rua
     */
    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    /**
     *
     * @return
     */
    public int getCidade() {
        return Cidade;
    }

    /**
     *
     * @param Cidade
     */
    public void setCidade(int Cidade) {
        this.Cidade = Cidade;
    }

    /**
     *
     * @return
     */
    public String getBairro() {
        return bairro;
    }

    /**
     *
     * @param bairro
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return Telefone;
    }

    /**
     *
     * @param Telefone
     */
    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    /**
     *
     * @return
     */
    public String getCelular() {
        return Celular;
    }

    /**
     *
     * @param Celular
     */
    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

}
