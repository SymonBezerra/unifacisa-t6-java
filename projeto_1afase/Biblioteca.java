import java.util.Scanner;

public class Biblioteca {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] livros = new String[100];
        String[] autores = new String[100];
        int quantidade = 0;
        int opcao;


        do {
            System.out.println("1) Adicionar \n2) Pesquisar \n3) Excluir \n4) Listar \n5) Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    quantidade = Metodos.adicionarLivros(livros, autores,quantidade, scanner);
                    break;
                case 2:
                    Metodos.pesquisaLivros(livros, autores, quantidade, scanner);
                    break;
                case 3:
                    quantidade = Metodos.excluirLivros(livros, autores, quantidade, scanner);
                    break;
                case 4:
                    Metodos.listarLivros(livros, autores, quantidade);
                    break;
                case 5:
                    System.out.println("Obrigado por utilizar nosso sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);

        scanner.close();

    }
}
