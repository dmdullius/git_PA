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
public class Cliente {

    private String Nome;

    private String RG;

    private String CPF;

    private String CNPJ;

    private String Data_Nasc;

    private String Nome_Fantasia;

    private String Rua;

    private int Numero;

    private String Bairro;

    private String Telefone;

    private String Telefone_Comercial;

    private String Celular;

    //variavel de referencia ao objeto
    Cliente objCliente;

    //Getter e Setters

    /**
     *
     * @return
     */
    public String getNome() {
        return Nome;
    }

    /**
     *
     * @param Nome
     */
    public void setNome(String Nome) {
        this.Nome = Nome;
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
    public String getCNPJ() {
        return CNPJ;
    }

    /**
     *
     * @param CNPJ
     */
    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    /**
     *
     * @return
     */
    public String getData_Nasc() {
        return Data_Nasc;
    }

    /**
     *
     * @param Data_Nasc
     */
    public void setData_Nasc(String Data_Nasc) {
        this.Data_Nasc = Data_Nasc;
    }

    /**
     *
     * @return
     */
    public String getNome_Fantasia() {
        return Nome_Fantasia;
    }

    /**
     *
     * @param Nome_Fantasia
     */
    public void setNome_Fantasia(String Nome_Fantasia) {
        this.Nome_Fantasia = Nome_Fantasia;
    }

    /**
     *
     * @return
     */
    public String getRua() {
        return Rua;
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
    public int getNumero() {
        return Numero;
    }

    /**
     *
     * @param Numero
     */
    public void setNumero(int Numero) {
        this.Numero = Numero;
    }

    /**
     *
     * @return
     */
    public String getBairro() {
        return Bairro;
    }

    /**
     *
     * @param Bairro
     */
    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
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
    public String getTelefone_Comercial() {
        return Telefone_Comercial;
    }

    /**
     *
     * @param Telefone_Comercial
     */
    public void setTelefone_Comercial(String Telefone_Comercial) {
        this.Telefone_Comercial = Telefone_Comercial;
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

}
