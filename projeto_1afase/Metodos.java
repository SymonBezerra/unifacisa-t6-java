import java.util.Scanner;

public class Metodos {

    // ADICIONAR NOVO LIVRO
    public static int adicionarLivros(String[] livros, String[] autores, int quantidade, Scanner scanner) {
        if (quantidade < livros.length) {
            System.out.print("Informe o nome do livro a ser adicionado: ");
            String nomeLivro = scanner.nextLine();
            livros[quantidade] = nomeLivro;

            System.out.print("Informe o nome do autor: ");
            autores[quantidade] = scanner.nextLine();

            System.out.println("O livro " + livros[quantidade] + " do autor " + autores[quantidade] + " foi adicionado com sucesso!");
            System.out.println();

            quantidade++;
        } else {
            System.out.println("O limite de livros adicionados foi atingido!");
            System.out.println();
        }
        return quantidade;
    }

    public static int livrosRemovidos(String[] livros, int quantidade){
        int livrosRemovidos = 0;
        for (int i = 0; i < quantidade; i++) {
            if (livros[i] == null) {
                livrosRemovidos++;
            }
        }
        return livrosRemovidos;

    }
    // LISTAGEM DOS LIVROS
    public static void listarLivros(String[] livros, String[] autores, int quantidade) {
        int qntLivrosRemovidos = livrosRemovidos(livros, quantidade);
        if (quantidade == 0 || quantidade - qntLivrosRemovidos == 0 ) {
            System.out.println("Não existem livros a serem exibidos.");

        } else {
                System.out.println("Lista de livros: ");
                for (int i = 0; i < quantidade; i++) {
                    if (livros[i] != null) {
                        System.out.println((i + 1) + ") " + livros[i] + " - " + autores[i]);
                    }
                }
                System.out.println("Quantidade de livros cadastrados: " + (quantidade - qntLivrosRemovidos));
                System.out.println();

        }
    }

    // PESQUISA DE LIVROS
    public static void pesquisaLivros(String[] livros, String[] autores, int quantidade, Scanner scanner) {
        if (quantidade == 0) {
            System.out.println("Não existem livros para pesquisa.");
        } else {
            System.out.print("Digite o título do livro: ");
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
            System.out.println();
        }
    }

    // EXCLUIR LIVROS
    public static int excluirLivros(String[] livros, String[] autores, int quantidade, Scanner scanner) {
        if (quantidade == 0) {
            System.out.println("Não existem livros para serem excluídos.");
            System.out.println();

        } else {
            System.out.println("Qual livro você deseja excluir?");

            for (int i = 0; i < quantidade; i++) {
                System.out.println((i + 1) + ") " + livros[i] + " - " + autores[i]);
            }
            System.out.println("Digite a posição do livro a ser excluído: ");
            int excluir = scanner.nextInt();

            if (excluir >= 1 && excluir <= quantidade) {
                String livroRemovido = livros[excluir - 1];
                String autorRemovido = autores[excluir - 1];

                for (int i = excluir - 1; i < quantidade; i++) {
                    livros[i] = livros[i + 1];
                    autores[i] = autores[i + 1];
                }
                quantidade++;

                System.out.println("Livro " + livroRemovido + "do autor " + autorRemovido + " foi removido com sucesso.");
                System.out.println();

            } else {
                System.out.println("Número inválido. Nenhum livro foi excluído!");
                System.out.println();
            }
        }
        return quantidade;
    }
}


