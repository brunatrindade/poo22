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


    public static void cadastrar_imovel(usuario user, db DB) throws SQLException {
        Connection conn = DB.conn;
        
        imovel imovel = new imovel();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome:");
        imovel.nome = scan.nextLine();
        System.out.println("Endereco:");
        imovel.endereco_imovel = scan.nextLine();
        System.out.println("Descricao:");
        imovel.descricao = scan.nextLine();
        System.out.println("Tamanho:");
        imovel.tamanho = scan.nextLine();
        System.out.println("Vagas:");
        imovel.vagas = scan.nextLine();
        System.out.println("Preco Inicial:");
        imovel.preco_inicial = scan.nextLine();
        System.out.println("Vendido Por:");
        imovel.vendido_por = scan.nextLine();
        System.out.println("Listado Em:");
        imovel.listado_em = scan.nextLine();
        System.out.println("Finalizado Em:");
        imovel.finaliza_em = scan.nextLine();
        
        
            String sql = "INSERT INTO imovel(nome, endereco_imovel, descricao, tamanho, vagas, preco_inicial, vendido_por, listado_em, finaliza_em) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";  
          
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
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
        }  
            
            System.out.println("\nCadastro efetuado com sucesso!");
    }
    
    public static void editar_cadastro(usuario user, db DB) throws SQLException {
        String texto;
        String novoNome;
        String novoEnd;
        String novoDescr;
        String novoTam;
        String novoVagas;
        String novoPreco;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Digite o novo valor do campo ou enter para não modificar");
        System.out.println("Nome: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
            novoNome = texto;
        } else {
            novoNome = imovel.nome;
        }
        
        System.out.println("Endereço: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
           novoEnd = texto;
        } else {
            novoEnd = imovel.endereco_imovel;
        }
        
        System.out.println("Desrição: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
            novoDescr = texto;
        } else {
            novoDescr = imovel.descricao;
        }
        
        System.out.println("Tamanho: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
            novoTam = texto;
        } else {
            novoTam = imovel.tamanho;
        }
        
        System.out.println("Vagas: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
            novoVagas = texto;
        } else {
            novoVagas = imovel.vagas;
        }
        
        System.out.println("Preço: ");
        texto = scan.nextLine();
        if (!texto.equals("")) {
            novoPreco = texto;
        } else {
            novoPreco = imovel.preco_inicial;
        }
                 
        Connection conn = DB.conn;
        
        String sql = "UPDATE imovel SET nome = ?, endereco_imovel = ?, descricao = ?, tamanho = ?, vagas = ?, preco_inicial = ? WHERE user = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);  
        stmt.setString(1,novoNome);  
        stmt.setString(2,novoEnd);  
        stmt.setString(3,novoDescr);  
        stmt.setString(4,novoTam);
        stmt.setString(5,novoVagas);
        stmt.setString(6,novoPreco);
        stmt.setString(7,usuario.user);  
        stmt.execute();  
        stmt.close();  

        
        System.out.println("\nCadastro editado com sucesso!");

    }
    
    public static void listar(usuario user, db DB) throws SQLException {
        Connection conn = DB.conn;
        
        imovel i = new imovel();
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome: " + nome);
        System.out.println("Endereço do imóvel: " + endereco_imovel);
        System.out.println("Descrição: " + descricao);
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Vagas: " + vagas);
        System.out.println("Preço Inicial: " + preco_inicial);
        System.out.println("Vendido por: " + vendido_por);
        System.out.println("Listado em: " + listado_em);
        System.out.println("Finalizado em: " + finaliza_em);
    }
    }