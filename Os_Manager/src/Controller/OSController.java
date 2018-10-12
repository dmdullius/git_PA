/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Ordem_Servico;
import ferramentas.*;
import java.awt.Color;
import java.awt.Component;
import java.sql.*;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

/**
 *
 * @author douglas dullius - 563620
 */
public class OSController {

    Ordem_Servico objOS = new Ordem_Servico();
    
JTable jtbOS = null;
    public OSController(Ordem_Servico objOS, JTable jtbOS) {
        this.objOS = objOS;
        this.jtbOS = jtbOS;
        objOS = null;
            }
public void PreencheOS() {

        try {

            ConnectionFactory.abreConexao();

            Vector<String> cabecalhos = new Vector<String>();
            Vector dadosTabela = new Vector();
            cabecalhos.add("Código");
            cabecalhos.add("Técnico");
            cabecalhos.add("Descrição");
            cabecalhos.add("Pendente");
            cabecalhos.add("finalizado");

            ResultSet result = null;

            try {

                String SQL = "";
                SQL = " SELECT codigo, t.nome, descricao, pendente, finalizado ";
                SQL += " FROM ordem_servico a, tecnicos t ";
                SQL += " WHERE a.tecnicos_codigo = t.codigo ";
                SQL += " ORDER BY codigo ";

                result = ConnectionFactory.stmt.executeQuery(SQL);

                while (result.next()) {
                    Vector<Object> linha = new Vector<Object>();
                    linha.add(result.getInt(1));
                    linha.add(result.getString(2));
                    linha.add(result.getString(3));
                    linha.add(result.getString(4));
                    dadosTabela.add(linha);
                }

            } catch (SQLException e) {
                System.out.println("problemas para popular tabela...");
                System.out.println(e);
            }

            jtbOS.setModel(new DefaultTableModel(dadosTabela, cabecalhos) {

                @Override
                public boolean isCellEditable(int row, int column) {
                    return false;
                }
                // permite seleção de apenas uma linha da tabela
            });

            // permite seleção de apenas uma linha da tabela
            jtbOS.setSelectionMode(0);

            // redimensiona as colunas de uma tabela
            TableColumn column = null;
            for (int i = 0; i < 4; i++) {
                column = jtbOS.getColumnModel().getColumn(i);
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

            jtbOS.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {

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
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi alterado", "Cadastro de Clientes: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Impossivel alterar os dados do cliente", "Erro de SQL: " + ex.toString(), 'e');
            return false;
        } finally {

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
            CaixaDeDialogo.obterinstancia().exibirMensagem("A ordem de serviço foi cadastrada", "Cadastro de Chamados: ", 'i');
            return true;

        } catch (SQLException ex) {
            //CaixaDeDialogo.obterinstancia().exibirMensagem("Não é possivel inserir esta ordem de serviço", " " + ex.toString(), 'e');
            System.out.println("Erro: " +ex.toString());
            return false;
        } finally {

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
            stmt = con.prepareStatement("DELETE ordem_servico WHERE codigo='" + id + "'");

            stmt.setInt(1, objOS.getCodigo());

            stmt.executeUpdate();
            CaixaDeDialogo.obterinstancia().exibirMensagem("A ordem de serviço foi excluida", "Cadastro de Chamados: ", 'i');
            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir a ordem de serviço selecionada", "Erro de SQL:  " + ex.toString(), 'e');
            return false;
        } finally {

            ConnectionFactory.closeConnection(con, stmt);
        }

    }

}
