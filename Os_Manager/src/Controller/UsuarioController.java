package Controller;

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
import Model.Usuario;
import ferramentas.CaixaDeDialogo;

/**
 *
 * @author dmdullius
 */
public class UsuarioController {

    Usuario objUsuario;
    JTable jtbUsuarios = null;

    public UsuarioController(Usuario objUsuario, JTable jtbUsuarios) {
        this.objUsuario = objUsuario;
        this.jtbUsuarios = jtbUsuarios;
    }

    
    public boolean incluir() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO usuarios (nome, login, senha, codigo_tipo) VALUES (?,?,?,?)");
            stmt.setString(1, objUsuario.getNome());
            stmt.setString(2, objUsuario.getLogin());
            stmt.setString(3, objUsuario.getSenha());
            stmt.setInt(4, objUsuario.getTipo());
            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            return false;
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public Usuario buscar(String id) {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;
            id = objUsuario.getNome();
            String SQL = "";
            SQL = " SELECT codigo, nome, login, codigo_tipo ORDER BY codigo_tipo";
            SQL += " FROM usuarios";

            try {
                System.out.println("Vai Executar Conexão em buscar usuário");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar usuário");

                objUsuario = new Usuario();

                if (rs.next() == true) {
                    objUsuario.setNome(rs.getString(1));
                    objUsuario.setLogin(rs.getString(2));
                    objUsuario.setTipo(rs.getInt(3));

                }
            } catch (SQLException ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Sua pesquisa não retornou resultados validos", "Erro de SQL: " + ex.toString(), 'e');
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        CaixaDeDialogo.obterinstancia().exibirMensagem("Usuário encontrado", " Pesquisa de Usuários", 'i');
        return objUsuario;
    }
//metodos github professor alterar e excluir

    public boolean alterar() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE usuarios SET nome=?, login=?, senha=? WHERE nome=?");
            stmt.setString(1, objUsuario.getNome());
            stmt.setString(2, objUsuario.getLogin());
            stmt.setString(3, objUsuario.getSenha());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Impossivel alterar os dados do Usuário", "Erro de SQL: " + ex.toString(), 'e');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi alterado", "Gerenciamento de usuários: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        }

    }

    public boolean excluir() {
        String id;
        id = objUsuario.getNome();
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE usuarios WHERE nome='" + id + "'");

            stmt.setString(1, objUsuario.getNome());

            stmt.executeUpdate();

            return true;

        } catch (SQLException ex) {
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir o cliente selecionado", "Erro de SQL:  " + ex.toString(), 'i');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O usuário foi excluido", "Gerenciamneto de usuários: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}
