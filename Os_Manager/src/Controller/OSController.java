/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.*;
import ferramentas.*;
import java.sql.*;

/**
 *
 * @author douglas dullius - 563620
 */
public class OSController {

    Ordem_Servico objOS;

    public OSController(Ordem_Servico objOS) {
        this.objOS = objOS;
    }

    
    public Ordem_Servico buscar(int id) {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;
            id = objOS.getCodigo();
            String SQL = "";
            SQL = " SELECT codigo, descricao, pendente, finalizado ";
            SQL += " FROM ordem_servico";
            SQL += " WHERE codigo = '" + id + "'";
            //stm.executeQuery(SQL);

            try {
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");

                objOS = new Ordem_Servico();

                if (rs.next() == true) {
                    objOS.setCodigo(rs.getInt(1));
                    objOS.setDescricao(rs.getString(2));
                    objOS.setPendente(rs.getString(3));
                    objOS.setFinalizado(rs.getString(4));
                    
                }
            } catch (SQLException ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Sua pesquisa não retornou resultados validos", "Erro de SQL: " + ex.toString(), 'e');
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        CaixaDeDialogo.obterinstancia().exibirMensagem("existem chamados abertos para este tecnico: ", " Pesquisa de chamados", 'i');
        return objOS;
    }


    public boolean alterar() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE  ordem_servico SET descricao=?, finalizado=?, pendente=? WHERE codigo=?");
            stmt.setString(1, objOS.getDescricao());
            stmt.setString(2, objOS.getFinalizado());
            stmt.setString(3, objOS.getPendente());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Impossivel alterar os dados do cliente", "Erro de SQL: " + ex.toString(), 'e');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi alterado", "Cadastro de Clientes: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean incluir() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO ordem_servico (descricao, pendente, finalizado)VALUES(?,?,?)");
            stmt.setString(1, objOS.getDescricao());
            stmt.setString(2, objOS.getFinalizado());
            stmt.setString(3, objOS.getPendente());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não é possivel inserir este cliente", "ERRO de SQL: " + ex.toString(), 'e');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi cadastrado", "Cadastro de Clientes: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean excluir() {
        int id;
        id = objOS.getCodigo();
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE clientes WHERE nome='" + id + "'");
            
            stmt.setInt(1, objOS.getCodigo());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir o cliente selecionado", "Erro de SQL:  " + ex.toString(), 'i');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi excluido", "Cadastro de Clientes: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
    
    //finaliza OS
    public  Ordem_Servico finalizar_OS(){
    String finalizar;
    
   
        
    return null;
}
    
}
