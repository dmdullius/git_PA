/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.usuario;

/**
 *
 * @author dmdullius
 */
public class LoginControler {

    public boolean Login(String usuario, String senha) {
        //INÍCIO CONEXÃO COM O BANCO DE DADOS
        System.out.println("Vai abrir a conexão com o banco de dados");
        ConnectionFactory.abreConexao();

        ResultSet rs = null;
        usuario user;

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT login, senha");
        sql.append("FROM usuarios");
        sql.append("WHERE login = '" + usuario + "'");
        sql.append("AND senha = '" + senha + "' ");

        try {
            System.out.println("Vai Executar Conexão em buscar area");
            rs = ConnectionFactory.stmt.executeQuery(sql.toString());
            System.out.println("Executou Conexão em buscar area");

            if (rs.next() == true) {
                user = new usuario();
                user.setNome(rs.getString("nome"));
                user.setLogin(rs.getString("login"));

            }
        } catch (SQLException ex) {
            System.out.println("ERRO de SQL: " + ex.getMessage().toString());
            
        } finally {
            Connection con = ConnectionFactory.getConnection();
            System.out.println("Vai fechar a conexão com o banco de dados");
            ConnectionFactory.closeConnection(con);
        }
        return false;

        

    }
}
