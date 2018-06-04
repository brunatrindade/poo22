package poo22;

    import java.sql.SQLException;
    import java.util.Scanner;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.sql.ResultSet;
    import java.sql.SQLException;
    import java.sql.Statement;
    import java.sql.PreparedStatement;  

public class imovel {
    
    public static int id;
    public static String nome;
    public static String endereco_imovel;
    public static String descricao;
    public static String tamanho;
    public static String vagas;
    public static String preco_inicial;
    public static String vendido_por;
    public static String listado_em;
    public static String finaliza_em;


    public static void cadastrar_imovel (usuario user) throws SQLException {
        Poo22 DB = new Poo22();
        Connection conn = DB.conn;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome:");
        nome = scan.nextLine();
        System.out.println("Endereco:");
        endereco_imovel = scan.nextLine();
        System.out.println("Descricao:");
        descricao = scan.nextLine();
        System.out.println("Tamanho:");
        tamanho = scan.nextLine();
        System.out.println("Vagas:");
        vagas = scan.nextLine();
        System.out.println("Preco Inicial:");
        preco_inicial = scan.nextLine();
        System.out.println("Vendido Por:");
        vendido_por = scan.nextLine();
        System.out.println("Listado Em:");
        listado_em = scan.nextLine();
        System.out.println("Finalizado Em:");
        finaliza_em = scan.nextLine();

        
            String sql = "INSERT INTO usuario(nome, endereco_imovel, descricao, tamanho, vagas, preco_inicial, vendido_por, listado_em, finaliza_em) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";  
          
            PreparedStatement stmt = conn.prepareStatement(sql);  
            stmt.setString(1, nome);  
            stmt.setString(2, endereco_imovel);
            stmt.setString(3, descricao);
            stmt.setString(4, tamanho);
            stmt.setString(5, vagas);
            stmt.setString(6, preco_inicial);
            stmt.setString(7, vendido_por);
            stmt.setString(8, listado_em);
            stmt.setString(9, finaliza_em);
            stmt.execute();  
            stmt.close();  
            
            System.out.println("\nCadastro efetuado com sucesso!");
    }
    
    public static void editar_cadastro (usuario user) throws SQLException {
    
    }
    
    public static void listar (usuario user) throws SQLException {
        
    }
    }