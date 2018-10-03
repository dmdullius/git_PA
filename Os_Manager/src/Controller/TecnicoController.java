/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tecnico;
import ferramentas.CaixaDeDialogo;
import ferramentas.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author douglas dullius - 563620
 */
public class TecnicoController {

    Tecnico objTecnico;

    public TecnicoController(Tecnico objTecnico) {
        this.objTecnico = objTecnico;

    }

    public Tecnico buscar(String id) {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;
            id = objTecnico.getNome();
            String SQL = "";
            SQL = " SELECT nome, rg, cpf, data_nasc, rua, numero, bairro, cidade, telefone, celular, email";
            SQL += " FROM tecnicos";
            SQL += " WHERE nome = '" + id + "'";
            //stm.executeQuery(SQL);

            try {
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");

                objTecnico = new Tecnico();

                if (rs.next() == true) {
                    objTecnico.setNome(rs.getString(1));
                    objTecnico.setRG(rs.getString(2));
                    objTecnico.setCPF(rs.getString(3));
                    objTecnico.setData_nasc(rs.getString(4));
                    objTecnico.setRua(rs.getString(5));
                    objTecnico.setNumero(rs.getInt(6));
                    objTecnico.setBairro(rs.getString(8));
                    objTecnico.setBairro(rs.getString(7));
                    objTecnico.setTelefone(rs.getString(9));
                    objTecnico.setEmail(rs.getString(10));
                    objTecnico.setCelular(rs.getString(11));
                }
            } catch (SQLException ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Sua pesquisa não retornou resultados validos", "Erro de SQL: " + ex.toString(), 'e');
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente encontrado", " Pesquisa de Cliente", 'i');
        return objTecnico;
    }

    public boolean alterar() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE clientes SET nome=?, rg=?, cpf=?, dat_nasc=?, nome_fantasia=?, cnpj=?, rua=?, numero=?, bairro=?, telefone=?, telefone_comercial=?, celular=? WHERE nome=?");
            stmt.setString(1, objTecnico.getNome());
            stmt.setString(2, objTecnico.getRG());
            stmt.setString(3, objTecnico.getData_nasc());
            stmt.setString(4, objTecnico.getRua());
            stmt.setInt(8, objTecnico.getNumero());
            stmt.setString(9, objTecnico.getBairro());
            stmt.setString(10, objTecnico.getTelefone());
            stmt.setString(11, objTecnico.getEmail());
            stmt.setString(12, objTecnico.getCelular());

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

    /*public boolean incluir() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO clientes (nome, rg, cpf, data_nasc, nome_fantasia, cnpj, rua, numero, bairro, telefone, telefone_comercial, celular)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, objCliente.getNome());
            stmt.setString(2, objCliente.getRG());
            stmt.setString(3, objCliente.getData_Nasc());
            stmt.setString(4, objCliente.getNome_Fantasia());
            stmt.setString(6, objCliente.getCNPJ());
            stmt.setString(7, objCliente.getRua());
            stmt.setInt(8, objCliente.getNumero());
            stmt.setString(9, objCliente.getBairro());
            stmt.setString(10, objCliente.getTelefone());
            stmt.setString(11, objCliente.getTelefone_Comercial());
            stmt.setString(12, objCliente.getCelular());

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
        String id;
        id = objCliente.getNome();
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE clientes WHERE nome='" + id + "'");
            //stmt = con.prepareStatement("UPDATE aluno SET dataExclusao=? WHERE mat_alu=?");
            //stmt.setString(1, objAluno.getDataExclusao());
            stmt.setString(1, objCliente.getNome());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir o cliente selecionado", "Erro de SQL:  " + ex.toString(), 'i');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi excluido", "Cadastro de Clientes: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
              */
        }
