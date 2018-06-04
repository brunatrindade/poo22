package poo22;

import java.sql.SQLException;
import java.util.Scanner;

 import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.sql.PreparedStatement;  

public class usuario {
    
    public static int id;
    public static String user;
    public static String senha;
    
    public usuario (String email) throws SQLException {
        Poo22 DB = new Poo22();
        Connection conn = DB.conn;
        
        String sql = "SELECT * FROM users WHERE email = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, email); 
 
        ResultSet rs = stmt.executeQuery();
        
        while (rs.next()) {
            usuario.id = rs.getInt("id");
            usuario.user = rs.getString("user");
            usuario.senha = rs.getString("senha");
        }
    }
    
    public static void cadastro() throws SQLException {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Usuario:");
        user = scan.nextLine();
        System.out.println("Senha:");
        senha = scan.nextLine();
        
        Poo22 DB = new Poo22();
         
        Connection conn = DB.conn;
        
            String sql = "INSERT INTO usuario(user,senha) VALUES(?,?)";  
          
            PreparedStatement stmt = conn.prepareStatement(sql);  
            stmt.setString(1, user);  
            stmt.setString(2, senha);    
            stmt.execute();  
            stmt.close();  
            
            System.out.println("\nCadastro efetuado com sucesso!");
    }
    
    public static String login() throws SQLException {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Usuario:");
        user = scan.nextLine();
        System.out.println("Senha:");
        senha = scan.nextLine();
        
        Poo22 DB = new Poo22();
        Connection conn = DB.conn;
        
        String sql = "SELECT * FROM usuario WHERE user = ? AND senha = ?";
        
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);
        stmt.setString(2, senha);  
 
        ResultSet rs = stmt.executeQuery();

        if (!rs.next()) {
            System.err.println("Dados incorretos");
            user = null;
            return user;
        } else {
            return user;
        }
    }
    
}