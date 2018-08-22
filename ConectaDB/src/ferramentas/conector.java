package ferramentas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author dmdullius
 */
public class conector {

    private String url;
    private String user;
    private String senha;

    public void Conexao() {
        url = "jdbc:postgresql://localhost:5432/Aula_db";
        user = "postgres";
        senha = "postgres";
    }
 private Connection getConnection() throws SQLException{
        try {
            Class.forName("org.postgresql.Driver");
           
            Connection con = DriverManager.getConnection(url, user, senha);
            return con;
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, "O driver não foi encontrado", "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
  public  int executeUpdate(String query){
        try{
            Connection con = getConnection();
            Statement stm = con.createStatement();
            System.out.println(query);
            int res=stm.executeUpdate(query);
            con.close();
            return res;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas com a conexão\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
 
    public ResultSet executeQuery(String query){
        try{
            Connection con = getConnection();
            Statement stm = con.createStatement();
            ResultSet rs = stm.executeQuery(query);
            //con.close();
            return rs;
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Problemas com a conexão\n"+ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            return null;
        }
    }
}

