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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPendente() {
        return pendente;
    }

    public void setPendente(String pendente) {
        this.pendente = pendente;
    }

    public String getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(String finalizado) {
        this.finalizado = finalizado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getTipo_problema() {
        return tipo_problema;
    }

    public void setTipo_problema(int tipo_problema) {
        this.tipo_problema = tipo_problema;
    }

    public int getTecnico_codigo() {
        return tecnico_codigo;
    }

    public void setTecnico_codigo(int tecnico_codigo) {
        this.tecnico_codigo = tecnico_codigo;
    }

    public int getCidade_codigo() {
        return cidade_codigo;
    }

    public void setCidade_codigo(int cidade_codigo) {
        this.cidade_codigo = cidade_codigo;
    }

    @Override
    public String toString() {
        return this.getDescricao();

    }

}
