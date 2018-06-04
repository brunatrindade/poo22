package poo22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Poo22 {

    /**
     * @param args the command line arguments
     */
    public static int main(String[] args) {
        
       // dados da conexão
       String DB_URL = "jdbc:mysql://localhost/poo2";
       String USER = "admin";
       String PASS = "andrbru";
    
       int id = 0;
        
    try {
           Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
           System.out.println("Conectado.");
           
           conn.createStatement().execute("INSERT INTO cadastro(nome_completo, cpf, telefone, email, endereco, sexo, data_nasc, usuario, senha) "
                   + "VALUES ('?', '?', '?', '?', '?', '?', '?', '?', '?');");          
           
           ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM cadastro");

           
           //precorre o resultset
           /*while (rs.next()) {
               int id = rs.getInt("id");
               String nome_completo = rs.getString("nome");
               String cpf = rs.getString("cpf");
               String telefone = rs.getString("telefone");
               String email = rs.getString("email");
               String endereco = rs.getString("endereco");
               String sexo = rs.getString("sexo");
               String data_nasc = rs.getString("data_nac");
               String usuario = rs.getString("usuario");
               String senha = rs.getString("senha");
               
 
               System.out.print("ID: " + id);
               System.out.print(", nome: " + nome_completo);
               System.out.print(", cpf: " + cpf);
               System.out.print(", telefone: " + telefone);
               System.out.print(", email: " + email);
               System.out.print(", endereco: " + endereco);
               System.out.print(", sexo: " + sexo);
               System.out.print(", data_nasc: " + data_nasc);
               System.out.print(", usuario: " + usuario);
               System.out.print("e senha: " + senha);
           }*/
           
           while (rs.next()) {
                id = rs.getInt("id");
           }
           
           
           System.out.println("Finalizou.");
            
        } catch (SQLException ex) {
            //Logger.getLogger(ConectandoBanco.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex);
        }
    
        return id;
        
    }
    Connection conn;
}
