/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Tecnico;
import ferramentas.CaixaDeDialogo;
import ferramentas.ConnectionFactory;
import java.awt.Color;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author douglas dullius - 563620
 */
public class TecnicoController {

    Tecnico objTecnico = null;
    JTable jtblistaTecnico = null;

    /**
     *
     * @param objTecnico
     * @param jtblistaTecnico
     */
    public TecnicoController(Tecnico objTecnico, JTable jtblistaTecnico) {
        this.objTecnico = objTecnico;
        this.jtblistaTecnico = jtblistaTecnico;

    }

    /**
     *
     * @return
     */
    public ResultSet buscarRelatorio() {
        ResultSet rs = null;
        try {
            ConnectionFactory.abreConexao();

            String SQL = "";
            SQL = " SELECT * from usuarios";
            try {
                System.out.println("Vai Executar Conexão em buscar relatorio");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
            } catch (SQLException ex) {
                System.out.println("ERRO de SQL: " + ex.getMessage().toString());
                return rs;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return rs;
        }

        System.out.println("Executou buscar relatório com sucesso");
        return rs;
    }

    /**
     *
     * @param id
     * @return
     */
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
                System.out.println("Vai Executar Conexão em buscar técnico");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar técnico");

                objTecnico = new Tecnico();

                if (rs.next() == true) {
                    objTecnico.setNome(rs.getString(1));
                    objTecnico.setRG(rs.getString(2));
                    objTecnico.setCPF(rs.getString(3));
                    objTecnico.setData_nasc(rs.getString(4));
                    objTecnico.setRua(rs.getString(5));
                    objTecnico.setNumero(String.valueOf(rs.getInt(6)));
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

        CaixaDeDialogo.obterinstancia().exibirMensagem("Técnico encontrado", " Pesquisa de Técnicos", 'i');
        return objTecnico;
    }

    /**
     *
     * @return
     */
    public boolean alterar() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE clientes SET nome=?, rg=?, cpf=?, dat_nasc=?,  rua=?, numero=?, bairro=?, telefone=?, email=?, celular=? WHERE nome=?");
            stmt.setString(1, objTecnico.getNome());
            stmt.setString(2, objTecnico.getRG());
            stmt.setString(3, objTecnico.getData_nasc());
            stmt.setString(4, objTecnico.getRua());
            stmt.setInt(8, Integer.parseInt(objTecnico.getNumero()));
            stmt.setString(9, objTecnico.getBairro());
            stmt.setString(10, objTecnico.getTelefone());
            stmt.setString(11, objTecnico.getEmail());
            stmt.setString(12, objTecnico.getCelular());

            stmt.executeUpdate();
            CaixaDeDialogo.obterinstancia().exibirMensagem("O técnico foi alterado", "Cadastro de Técnicos: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Impossivel alterar os dados do técnico", "Erro de SQL: " + ex.toString(), 'e');
            return false;
        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

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
            stmt = con.prepareStatement("INSERT INTO tecnicos (nome, rg, cpf, data_nasc, rua, numero, bairro, cidade_codigo, telefone, celular, email)VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, objTecnico.getNome());
            stmt.setString(2, objTecnico.getRG());
            stmt.setString(3, objTecnico.getCPF());
            stmt.setString(4, objTecnico.getData_nasc());
            stmt.setString(5, objTecnico.getRua());
            stmt.setInt(6, Integer.parseInt(objTecnico.getNumero()));
            stmt.setString(7, objTecnico.getBairro());
            stmt.setInt(8, objTecnico.getCidade());
            stmt.setString(9, objTecnico.getTelefone());
            stmt.setString(10, objTecnico.getCelular());
            stmt.setString(11, objTecnico.getEmail());

            stmt.executeUpdate();
            CaixaDeDialogo.obterinstancia().exibirMensagem("O Técnico foi cadastrado", "Cadastro de Técnicos: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não é possivel inserir este Técnico, causa:  " + ex.toString(), "ERRO de SQL: ", 'e');
            return false;
        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    /**
     *
     * @return
     */
    public boolean excluir() {
        String id;
        id = objTecnico.getNome();
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE tecnicos WHERE nome='" + id + "'");
            stmt.setString(1, objTecnico.getNome());
            stmt.executeUpdate();
            CaixaDeDialogo.obterinstancia().exibirMensagem("O Técnico foi excluido", "Cadastro de Técnicos: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir o Técnico selecionado", "Erro de SQL:  " + ex.toString(), 'i');
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);

        }
    }

    /**
     *
     */
    public void PreencheLista() {

        try {

            ConnectionFactory.abreConexao();

            Vector<String> cabecalhos = new Vector<String>();
            Vector dadosTabela = new Vector();
            cabecalhos.add("Código");
            cabecalhos.add("Nome");
            cabecalhos.add("Cidade");
            cabecalhos.add("Data Nasc.");
            cabecalhos.add("RG");
            cabecalhos.add("CPF");

            ResultSet result = null;

            try {

                String SQL = "";
                SQL = " SELECT codigo, nome, cidade_codigo, data_nasc, rg, cpf";
                SQL += " FROM tecnicos";
                SQL += " ORDER BY nome";

                result = ConnectionFactory.stmt.executeQuery(SQL);

                while (result.next()) {
                    Vector<Object> linha = new Vector<Object>();
                    linha.add(result.getInt(1));
                    linha.add(result.getString(2));
                    linha.add(result.getInt(3));
                    linha.add(result.getString(4));
                    linha.add(result.getString(5));
                    linha.add(result.getString(6));
                    dadosTabela.add(linha);
                }

            } catch (SQLException e) {
                System.out.println("problemas para popular tabela...");
                System.out.println(e);
            }

            jtblistaTecnico.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                // permite seleção de apenas uma linha da tabela
            });

            // permite seleção de apenas uma linha da tabela
            jtblistaTecnico.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < 4; i++) {
                column = jtblistaTecnico.getColumnModel().getColumn(i);
                switch (i) {
                    case 0:
                        column.setPreferredWidth(80);
                        break;
                    case 1:
                        column.setPreferredWidth(150);
                        break;
                    case 2:
                        column.setPreferredWidth(150);
                        break;
                }
            }

            jtblistaTecnico.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

                @Override
                public Component getTableCellRendererComponent(JTable table, Object value,
                        boolean isSelected, boolean hasFocus, int row, int column) {
                    super.getTableCellRendererComponent(table, value, isSelected,
                            hasFocus, row, column);
                    if (row % 2 == 0) {
                        setBackground(Color.LIGHT_GRAY);
                    } else {
                        setBackground(Color.WHITE);
                    }
                    return this;
                }
            });
            //return (true);

        } catch (Exception ex) {
            System.out.println("Erro: " + ex.getMessage().toString());
        }

    }
}
