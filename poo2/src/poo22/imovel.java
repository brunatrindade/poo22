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
    public static String endereco;
    public static String tipo;
    public static String descricao;
    public static int tamanho;
    public static int vagas;
    public static int preco_inicial;
    public static String listado_em;
    public static String finaliza_em;


    public static void cadastrar_imovel(usuario user, db DB) throws SQLException {  
        
        String DB_URL = "jdbc:mysql://localhost/poo2";
        String USER = "root";
        String PASS = "";
        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Scanner scan = new Scanner(System.in);
        
        System.out.println("Nome:");
        nome = scan.nextLine();
        System.out.println("Endereco:");
        endereco = scan.nextLine();
        System.out.println("Tipo de imovel:");
        tipo = scan.nextLine();
        System.out.println("Descricao:");
        descricao = scan.nextLine();
        System.out.println("Tamanho:");
        tamanho = scan.nextInt();
        System.out.println("Vagas:");
        vagas = scan.nextInt();
        System.out.println("Preco Inicial:");
        preco_inicial = scan.nextInt();
        System.out.println("Listado Em:");
        listado_em = scan.nextLine();                
        System.out.println("Finalizado Em:");
        finaliza_em = scan.nextLine();
        
        
        String sql = "INSERT INTO imoveis(nome, endereco, usuario_id, tipo, descricao, tamanho, vagas, preco_inicial, listado_em, finaliza_em) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";  
          
        PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);  
            stmt.setString(2, endereco);
            stmt.setInt(3, usuario.id);
            stmt.setString(4, tipo);
            stmt.setString(5, descricao);
            stmt.setInt(6, tamanho);
            stmt.setInt(7, vagas);
            stmt.setInt(8, preco_inicial);
            stmt.setString(9, listado_em);
            stmt.setString(10, finaliza_em);
            stmt.execute();
        
        System.out.println("\nCadastro efetuado com sucesso!");
    }
    
    public static void editar_cadastro(usuario user, db DB) throws SQLException {
        
        String DB_URL = "jdbc:mysql://localhost/poo2";
        String USER = "root";
        String PASS = "";
        
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        String novoNome;
        String novoEnd;
        String novoDescr;
        int novoTam;
        int novoVagas;
        int novoPreco;
        
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Escolha o imovel que voce deseja alterar (pelo codigo): ");
        imovel.id = scan.nextInt();
        
        System.out.println("\nDigite o novo valor do campo");
        
        System.out.println("Nome: ");
        novoNome = scan.nextLine();
        if (novoNome != null) {
            imovel.nome = novoNome;
        } 
        
        System.out.println("Endereço: ");
        novoEnd = scan.nextLine();
        if (novoEnd != null) {
           imovel.endereco = novoEnd;
        }
        
        System.out.println("Desrição: ");
        novoDescr = scan.nextLine();
        if (novoDescr != null) {
            imovel.descricao = novoDescr;
        } 
        
        System.out.println("Tamanho: ");
        novoTam = scan.nextInt();
        if (novoTam != 0) {
            imovel.tamanho = novoTam;
        } 
        
        System.out.println("Vagas: ");
        novoVagas = scan.nextInt();
        if (novoVagas != 0) {
            imovel.vagas = novoVagas;
        } 
        
        System.out.println("Preço: ");
        novoPreco = scan.nextInt();
        if (novoPreco != 0) {
            imovel.preco_inicial = novoPreco;
        } 


        String sql = "UPDATE imoveis SET nome = ?, endereco = ?, descricao = ?, tamanho = ?, vagas = ?, preco_inicial = ? WHERE id = ?";
        
        
        PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,imovel.nome);
            stmt.setString(2,imovel.endereco);
            stmt.setString(3,imovel.descricao);
            stmt.setInt(4,imovel.tamanho);
            stmt.setInt(5,imovel.vagas);
            stmt.setInt(6,imovel.preco_inicial);
            stmt.setInt(7,imovel.id);
            stmt.execute();
            stmt.close();  
        
        System.out.println("\nCadastro editado com sucesso!");

    }
    
    public static void listar(usuario user, db DB) throws SQLException {
        
        String DB_URL = "jdbc:mysql://localhost/poo2";
        String USER = "root";
        String PASS = "";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        
        Scanner scan = new Scanner(System.in);
        Statement st = conn.createStatement();
                   
        ResultSet rs = conn.createStatement().executeQuery("SELECT nome, endereco, tipo, descricao, tamanho, vagas, preco_inicial, listado_em, finaliza_em FROM imoveis");
        
        //precorre o resultset
           while (rs.next()) {
               nome = rs.getString("nome");
               endereco = rs.getString("endereco");
               tipo = rs.getString("tipo");
               descricao = rs.getString("descricao");
               tamanho = rs.getInt("tamanho");
               vagas = rs.getInt("vagas");
               preco_inicial = rs.getInt("preco_inicial");
               listado_em = rs.getString("listado_em");
               finaliza_em = rs.getString("finaliza_em");
               
 
               System.out.print("\nnome: " + imovel.nome);
               System.out.print(", \nendereco: " + imovel.endereco);
               System.out.print(", \ntipo: " + imovel.tipo);
               System.out.print(", \ndescricao: " + imovel.descricao);
               System.out.print(", \ntamanho: " + imovel.tamanho);
               System.out.print(", \nvagas: " + imovel.vagas);
               System.out.print(", \npreco inicial: " + imovel.preco_inicial);
               System.out.print(", \nlistado em: " + imovel.listado_em);
               System.out.print("\ne finalizado em: " + imovel.finaliza_em + "\n");
           }
    }
    
        public static void delete(usuario user, db DB) throws SQLException {
        String DB_URL = "jdbc:mysql://localhost/poo2";
        String USER = "root";
        String PASS = "";

        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

        Scanner scan = new Scanner(System.in);

        System.out.println("Escolha o imovel que voce deseja alterar (pelo codigo): ");
        imovel.id = scan.nextInt();
        
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM imoveis WHERE id = ?");

        stmt.setInt(1, imovel.id);
        stmt.execute();
        stmt.close();

        System.out.println("\nCadastro excluido com sucesso!");
    }
}
