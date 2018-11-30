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

    private String numero;

    private int Cidade;

    private String bairro;

    private String Telefone;

    private String Celular;

    private String email;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getData_nasc() {
        return Data_nasc;
    }

    public void setData_nasc(String Data_nasc) {
        this.Data_nasc = Data_nasc;
    }

    public String getRua() {
        return Rua;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getCidade() {
        return Cidade;
    }

    public void setCidade(int Cidade) {
        this.Cidade = Cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
