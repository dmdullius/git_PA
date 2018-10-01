/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;

/**
 *
 * @author douglas dullius - 563620
 */
public class TecnicoController {
/*public Tecnico buscar(String id) {
        try {
            ConnectionFactory.abreConexao();
            ResultSet rs = null;
            id = objCliente.getNome();
            String SQL = "";
            SQL = " SELECT nome, rg, cpf, data_nasc, nome_fantasia, cnpj, rua, numero, bairro, telefone, telefone_comercial, celular";
            SQL += " FROM clientes";
            SQL += " WHERE nome = '" + id + "'";
            //stm.executeQuery(SQL);

            try {
                System.out.println("Vai Executar Conexão em buscar visitante");
                rs = ConnectionFactory.stmt.executeQuery(SQL);
                System.out.println("Executou Conexão em buscar aluno");

                objCliente = new Cliente();

                if (rs.next() == true) {
                    objCliente.setNome(rs.getString(1));
                    objCliente.setRG(rs.getString(2));
                    objCliente.setCPF(rs.getString(3));
                    objCliente.setData_Nasc(rs.getString(4));
                    objCliente.setNome_Fantasia(rs.getString(5));
                    objCliente.setCNPJ(rs.getString(6));
                    objCliente.setRua(rs.getString(7));
                    objCliente.setNumero(rs.getInt(8));
                    objCliente.setBairro(rs.getString(9));
                    objCliente.setTelefone(rs.getString(10));
                    objCliente.setTelefone_Comercial(rs.getString(11));
                    objCliente.setCelular(rs.getString(12));
                }
            } catch (SQLException ex) {
                CaixaDeDialogo.obterinstancia().exibirMensagem("Sua pesquisa não retornou resultados validos", "Erro de SQL: "+ex.toString(), 'e');
                return null;
            }

        } catch (Exception e) {
            System.out.println("ERRO: " + e.getMessage().toString());
            return null;
        }

        CaixaDeDialogo.obterinstancia().exibirMensagem("Cliente encontrado", " Pesquisa de Cliente", 'i');
        return objCliente;
    }


    public boolean alterar() {

        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {

            stmt = con.prepareStatement("UPDATE clientes SET nome=?, rg=?, cpf=?, dat_nasc=?, nome_fantasia=?, cnpj=?, rua=?, numero=?, bairro=?, telefone=?, telefone_comercial=?, celular=? WHERE nome=?");
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
            CaixaDeDialogo.obterinstancia().exibirMensagem("Impossivel alterar os dados do cliente", "Erro de SQL: "+ex.toString(), 'e');
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
            CaixaDeDialogo.obterinstancia().exibirMensagem("Não é possivel inserir este cliente", "ERRO de SQL: "+ex.toString(), 'e');
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
           CaixaDeDialogo.obterinstancia().exibirMensagem("Não foi possivel excluir o cliente selecionado", "Erro de SQL:  "+ex.toString(), 'i');
            return false;
        } finally {
            CaixaDeDialogo.obterinstancia().exibirMensagem("O cliente foi excluido", "Cadastro de Clientes: ", 'i');
            ConnectionFactory.closeConnection(con, stmt);
        */}





