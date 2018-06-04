package poo22;

import java.sql.SQLException;
import java.util.Scanner;

public class inicio {
    
    public static void menuLogado(usuario user) throws SQLException {
    
    int escolha;
    boolean loop = true;
    
    }
    
    public static void menuInicial() throws SQLException {
    int escolha;
    boolean loop = true;
    String email;
    
       
    Scanner scan = new Scanner(System.in);

    while (loop) {            
            System.out.println("\nEscolha uma opção:");
            System.out.println("1-Cadastrar");
            System.out.println("2-Logar");
            System.out.println("3-Sair");
            
            escolha = scan.nextInt();
            
            switch (escolha) {
                case 1:
                    usuario.cadastro();
                    break;
                case 2:
                    email = usuario.login();
                    if (email != null) {
                        usuario user = new usuario(email);
                        menuLogado(user);
                    }
                    break;
                case 3:
                    loop = false;
                    break;
                default:
                    System.err.println("Opção invalida");
                    break;
            }
        }
}
    
/*public static void menuLogado(usuario user) throws SQLException {
    
    int escolha;
    boolean loop = true;
    
    Scanner scan = new Scanner(System.in);

    while (loop) {            
            System.out.println("\nEscolha uma opção:");
            System.out.println("1-Cadastrar Imovel");
            System.out.println("2-Editar cadastro de imovel");
            System.out.println("3-Listar Imoveis");
            System.out.println("4-Cadastrar Usuario");
            System.out.println("5-Editar cadastro de usuario");
            System.out.println("6-Sair");
            
            escolha = scan.nextInt();
            
            switch (escolha) {
                case 1:
                    dinheiro.enviar(user);
                    break;
                case 2:
                    dinheiro.depositar(user);
                    break;
                case 3:
                    dinheiro.solicitar(user);
                    break;
                case 7:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
}*/

    public static void main(String[] args) throws SQLException{
        
        menuInicial();
        
        System.out.println("Adeus!");
    }
}

    
    