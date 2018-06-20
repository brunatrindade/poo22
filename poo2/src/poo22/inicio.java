package poo22;

import java.sql.SQLException;
import java.util.Scanner;

public class inicio {

    public static void menuInicial() throws SQLException {
        
        int escolha;
        boolean loop = true;
        String user;

        db DB = new db();
        Scanner scan = new Scanner(System.in);

        while (loop) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1-Cadastrar Novo Usuario");
            System.out.println("2-Logar");
            System.out.println("3-Sair");

            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    usuario.cadastro(DB);
                    break;
                case 2:
                    user = usuario.login(DB);
                    if (user != null) {
                        usuario usuario = new usuario(user);
                        menuLogado(usuario, DB);
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

    public static void menuLogado(usuario user, db DB) throws SQLException {

        int escolha;
        boolean loop = true;

        Scanner scan = new Scanner(System.in);

        while (loop) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1-Cadastrar Imovel");
            System.out.println("2-Editar Cadastro de Imovel");
            System.out.println("3-Listar Imoveis");
            System.out.println("4-Excluir Cadastro de Imovel");
            System.out.println("5-Sair");

            escolha = scan.nextInt();

            switch (escolha) {
                case 1:
                    imovel.cadastrar_imovel(user, DB);
                    break;
                case 2:
                    imovel.editar_cadastro(user, DB);
                    break;
                case 3:
                    imovel.listar(user, DB);
                    break;
                case 4:
                    imovel.delete(user, DB);
                    break;
                case 5:
                    loop = false;
                    break;
                default:
                    System.out.println("Opção invalida");
                    break;
            }
        }
    }

    public static void main(String[] args) throws SQLException {

        menuInicial();

        System.out.println("Out!");
    }
}
