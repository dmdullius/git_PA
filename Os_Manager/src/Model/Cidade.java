/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import ferramentas.*;

/**
 *
 * @author douglas
 */
public class Cidade {

    Cidade objCidade;
    private String cidade;
    private int uf;

    /**
     *
     * @return
     */
    public String getCidade() {
        return cidade;
    }

    /**
     *
     * @param cidade
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     *
     * @return
     */
    public int getUf() {
        return uf;
    }

    /**
     *
     * @param uf
     */
    public void setUf(int uf) {
        this.uf = uf;
    }

}
