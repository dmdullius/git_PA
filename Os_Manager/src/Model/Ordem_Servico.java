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
public class Ordem_Servico {

    private String descricao;

    private String pendente;

    private String finalizado;

    private int codigo;

    private int tipo_problema;

    private int tecnico_codigo;

    private int cidade_codigo;

    /**
     *
     * @return
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     *
     * @param descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     *
     * @return
     */
    public String getPendente() {
        return pendente;
    }

    /**
     *
     * @param pendente
     */
    public void setPendente(String pendente) {
        this.pendente = pendente;
    }

    /**
     *
     * @return
     */
    public String getFinalizado() {
        return finalizado;
    }

    /**
     *
     * @param finalizado
     */
    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    /**
     *
     * @return
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return
     */
    public int getTipo_problema() {
        return tipo_problema;
    }

    /**
     *
     * @param tipo_problema
     */
    public void setTipo_problema(int tipo_problema) {
        this.tipo_problema = tipo_problema;
    }

    /**
     *
     * @return
     */
    public int getTecnico_codigo() {
        return tecnico_codigo;
    }

    /**
     *
     * @param tecnico_codigo
     */
    public void setTecnico_codigo(int tecnico_codigo) {
        this.tecnico_codigo = tecnico_codigo;
    }

    /**
     *
     * @return
     */
    public int getCidade_codigo() {
        return cidade_codigo;
    }

    /**
     *
     * @param cidade_codigo
     */
    public void setCidade_codigo(int cidade_codigo) {
        this.cidade_codigo = cidade_codigo;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getDescricao();

    }

}
