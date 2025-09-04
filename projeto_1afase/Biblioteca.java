import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] livros = new String[50];
        String[] autores = new String[50];
        int quantidade = 0;

        int opcao;

        do {
            System.out.println("1) Adicionar \n2) Pesquisar \n3) Excluir \n4) Listar \n5) Sair");
            System.out.print("Digite sua opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            if (opcao == 1) {
                System.out.println("Você deseja ADICIONAR livros.");
                quantidade = Biblioteca.adicionarLivros(scanner, livros, autores, quantidade);
            } else if (opcao == 2) {
                System.out.println("Você deseja PESQUISAR um livro");
                Biblioteca.pesquisaLivros(scanner, livros, autores, quantidade);
            } else if (opcao == 3) {
                System.out.println("Você deseja EXCLUIR um livro");
                quantidade = Biblioteca.excluiLivros(scanner, livros, autores, quantidade);
            } else if (opcao == 4) {
                System.out.println("Você deseja LISTAR todos os livros");
                Biblioteca.listarLivros (livros, autores, quantidade);
            } else if (opcao == 5){
                System.out.println("Obrigado por utilizar nosso sistema.");
            } else {
                System.out.println("Opcão inválida! Tente novamente.");
            }
        } while (opcao != 5);
        scanner.close();
    }

    public static int adicionarLivros(Scanner scanner, String[] livros, String[] autores, int quantidade) {
        System.out.println("Informe o nome do livro a ser adicionado: ");
        String nomeLivro = scanner.nextLine();
        System.out.println("Informe o nome do autor: ");
        String nomeAutor = scanner.nextLine();
        System.out.println("O livro " + nomeLivro + " do autor " + nomeAutor + " foi adicionado com sucesso!\n");
        livros[quantidade] = nomeLivro;
        autores[quantidade] = nomeAutor;
        quantidade++;
        return quantidade;
    }

    public static void listarLivros(String[] livros, String[] autores, int quantidade) {
        if (quantidade == 0) {
            System.out.println("Não existem livros a serem exibidos.");
        } else {
            System.out.println("Lista de livros: ");
            for (int i = 0; i < quantidade; i++) {
                System.out.println((i + 1) + ") " + livros[i] + " - " + autores[i]);
            }
            System.out.println("Quantidade de livros cadastrados: " + quantidade);
        }
    }

    public static void pesquisaLivros(Scanner scanner, String[] livros, String[] autores, int quantidade) {
        if (quantidade == 0) {
            System.out.println("Não existem livros para pesquisa.");
        } else {
            System.out.println("Digite o título do livro: ");
            String titulo = scanner.nextLine();
            for (int i = 0; i < quantidade; i++) {
                if (livros[i].equalsIgnoreCase(titulo)) {
                    System.out.println("Livro encontrado!");
                    System.out.println("Nome do Livro: " + livros[i]);
                    System.out.println("Nome do autor: " + autores[i]);
                    System.out.println();
                    return;
                }
            }
            System.out.println("Livro não encontrado!");
        }
    }

    public static int excluiLivros(Scanner scanner, String[] livros, String[] autores, int quantidade) {
        System.out.println("Digite o título do livro a ser excluído: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (int i = 0; i < quantidade; i++) {
            if (livros[i].equalsIgnoreCase(titulo)) {
                for (int j = i; j < quantidade - 1; j++) {
                    livros[j] = livros[j + 1];
                    autores[j] = autores[j + 1];
                }
                livros[quantidade - 1] = null;
                autores[quantidade - 1] = null;
                quantidade--;
                System.out.println("Livro excluído com sucesso!"); 
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Livro não encontrado!");
        }
        return quantidade;
    }
}
