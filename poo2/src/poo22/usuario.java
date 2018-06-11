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
    public static String nome;
    public static String cpf;
    public static String telefone;
    public static String email;
    public static String sexo;
    public static String data_nasc;
    public static String endereco;

    public usuario(String user) throws SQLException {
        db DB = new db();
        Connection conn = DB.conn;

        String sql = "SELECT * FROM usuario WHERE user = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, user);

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            usuario.id = rs.getInt("id");
            usuario.user = rs.getString("usuario");
            usuario.senha = rs.getString("senha");
        }
    }

    public static void cadastro(db DB) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Nome:");
        nome = scan.nextLine();
        System.out.println("Cpf:");
        cpf = scan.nextLine();
        System.out.println("Telefone:");
        telefone = scan.nextLine();
        System.out.println("Email:");
        email = scan.nextLine();
        System.out.println("Endereco:");
        endereco = scan.nextLine();
        System.out.println("Sexo:");
        sexo = scan.nextLine();
        System.out.println("Data de Nascimento:");
        data_nasc = scan.nextLine();
        System.out.println("Usuario:");
        user = scan.nextLine();
        System.out.println("Senha:");
        senha = scan.nextLine();

        Connection conn = DB.conn;

        String sql = "INSERT INTO usuario(nome, cpf, telefone, email, endereco, sexo, data_nasc, user, senha) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.setString(3, telefone);
            stmt.setString(4, email);
            stmt.setString(5, endereco);
            stmt.setString(6, sexo);
            stmt.setString(7, data_nasc);
            stmt.setString(8, user);
            stmt.setString(9, senha);
            stmt.execute();
        }

        System.out.println("\nCadastro efetuado com sucesso!");
    }

    public static String login(db DB) throws SQLException {
        Scanner scan = new Scanner(System.in);

        System.out.println("Usuario:");
        user = scan.nextLine();
        System.out.println("Senha:");
        senha = scan.nextLine();

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
