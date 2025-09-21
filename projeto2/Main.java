package projeto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);
        boolean sair = false;
        int opcao;
        while (!sair) {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("Digite 'L' para Livro ou 'R' para Revista: ");
                    String tipo = scanner.next().toUpperCase();
                    scanner.nextLine();
                    if (tipo.equals("L")) {
                        Livro livro = criarLivro(scanner);
                        biblioteca.adicionarMaterial(livro);
                        System.out.println("Livro adicionado com sucesso!");
                    } else if (tipo.equals("R")) {
                        Revista revista = criarRevista(scanner);
                        biblioteca.adicionarMaterial(revista);
                        System.out.println("Revista adicionada com sucesso!");
                    } else {
                        System.out.println("Tipo inválido. Tente novamente.");
                    }
                    break;
                case 2:
                    System.out.println("Listando todos os materiais:");
                    biblioteca.listarMateriais();
                    break;
                case 3:
                    System.out.print("Digite o título para buscar: ");
                    String titulo = scanner.nextLine();
                    Material material = biblioteca.buscarPorTitulo(titulo);
                    if (material != null) {
                        System.out.println("Material encontrado: " + material);
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;
                case 4:
                    System.out.print("Digite o autor para buscar: ");
                    String autor = scanner.nextLine();
                    var resultados = biblioteca.buscarPorAutor(autor);
                    if (!resultados.isEmpty()) {
                        System.out.println("Materiais encontrados:");
                        for (Material m : resultados) {
                            System.out.println(m);
                        }
                    } else {
                        System.out.println("Nenhum material encontrado para o autor informado.");
                    }
                    break;
                case 5:
                    System.out.print("Digite o título para remover: ");
                    String tituloRemover = scanner.nextLine();
                    boolean removido = biblioteca.removerPorTitulo(tituloRemover);
                    if (removido) {
                        System.out.println("Material removido com sucesso.");
                    } else {
                        System.out.println("Material não encontrado.");
                    }
                    break;
                case 6:
                    System.out.println("Saindo...");
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("Menu da Biblioteca:");
        System.out.println("1. Adicionar Material");
        System.out.println("2. Listar Materiais");
        System.out.println("3. Buscar por Título");
        System.out.println("4. Buscar por Autor");
        System.out.println("5. Remover por Título");
        System.out.println("6. Sair");
    }

    public static Livro criarLivro(Scanner scanner) {
        while(true) {
            System.out.print("Digite o título do livro: ");
            String titulo = scanner.nextLine();
            System.out.print("Digite o autor do livro: ");
            String autor = scanner.nextLine();
            System.out.print("Digite o gênero do livro (FICCAO/NAO_FICCAO): ");
            String generoStr = scanner.nextLine().toUpperCase();
            if (
                titulo.trim().isEmpty() || autor.trim().isEmpty()
            ) {
                System.out.println("Título e autor não podem ser vazios. Tente novamente.");
                continue;
            } else if (
                !generoStr.trim().equals("FICCAO") && !generoStr.trim().equals("NAO_FICCAO")
            ) {
                System.out.println("Gênero inválido. Tente novamente.");
                continue;
            } else {
                Genero genero = Genero.valueOf(generoStr);
                return new Livro(titulo, autor, genero);
            }
        }
    }

    public static Revista criarRevista(Scanner scanner) {
        while(true) {
            System.out.print("Digite o título da revista: ");
            String titulo = scanner.nextLine();
            System.out.print("Digite o autor da revista: ");
            String autor = scanner.nextLine();
            System.out.print("Digite o número da revista: ");
            int numero = scanner.nextInt();
            scanner.nextLine();
            if (
                titulo.trim().isEmpty() || autor.trim().isEmpty()
            ) {
                System.out.println("Título e autor não podem ser vazios. Tente novamente.");
                continue;
            } else if (numero <= 0) {
                System.out.println("Número inválido. Tente novamente.");
                continue;
            } else {
                return new Revista(titulo, autor, numero);
            }
        }
    }
}
