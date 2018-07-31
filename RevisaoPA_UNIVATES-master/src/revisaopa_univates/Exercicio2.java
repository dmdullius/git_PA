/*
 * Exercício2: Criar uma conexão com a base de dados PostgreSQL
 */
package revisaopa_univates;

import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Jonas
 */
public class Exercicio2 {
    
    public static void main(String[] args){
        
        System.out.println("Vai abrir a conexão com o banco de dados");
        ConnectionFactory.abreConexao();
        Connection con = ConnectionFactory.getConnection();
        
        System.out.println("Vai fechar a conexão com o banco de dados");
        ConnectionFactory.closeConnection(con);
    }
    
}
