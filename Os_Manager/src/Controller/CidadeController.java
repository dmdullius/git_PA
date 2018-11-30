/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Cidade;
import ferramentas.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author douglas
 */
public class CidadeController {

    Cidade objCidade;

    /**
     *
     * @param objCidade
     */
    public CidadeController(Cidade objCidade) {
        this.objCidade = objCidade;
    }

    /**
     *
     * @return
     */
    public boolean incluir() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO cidades ( cidade, uf_codigo)VALUES(?,?)");
            stmt.setString(1, objCidade.getCidade());
            stmt.setInt(1, objCidade.getUf());
            stmt.executeUpdate();
            CaixaDeDialogo.obterinstancia().exibirMensagem("A cidade foi cadastrada", "Cadastro de cidades: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não é possivel inserir esta cidade: " + ex.toString() + ": ", "ERRO de SQL: " + ex.toString(), 'e');
            System.out.println("Erro: " + ex.getLocalizedMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
