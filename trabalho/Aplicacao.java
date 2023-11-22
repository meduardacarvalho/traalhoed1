package trabalho;

import java.util.Scanner;

public class Aplicacao {
 private ListaCategorias listaCategorias;

    public Aplicacao() {
        this.listaCategorias = new ListaCategorias();
    }

    // (a) Procedimento para cadastrar um novo filme no cadastro de filmes.
    public void cadastrarFilme(Filme filme, String descricaoCategoria) {
        Categoria categoria = listaCategorias.buscar(descricaoCategoria);
        if (categoria == null) {
            categoria = new Categoria(descricaoCategoria);
            listaCategorias.inserirOrdenado(categoria);
        }
        categoria.getLista().inserirOrdenado(filme);
    }

    // (b) Procedimento para remover um filme.
    public void removerFilme(Filme filme) {
        for (NodePrincipal node = listaCategorias.getPrimeiro(); node != null; node = node.getProx()) {
            Categoria categoria = node.getInfo();
            ListaFilmes listaFilmes = categoria.getLista();
            if (listaFilmes.buscar(filme.getTitulo()) != null) {
                listaFilmes.remover(filme.getTitulo());
                if (listaFilmes.getQtd() == 0) {
                    listaCategorias.remover(categoria.getDescricao());
                }
                break;
            }
        }
    }

    // (c) Procedimento para exibir os dados de um dado filme.
    public void exibirDadosFilme(Filme filme) {
        for (NodePrincipal node = listaCategorias.getPrimeiro(); node != null; node = node.getProx()) {
            Categoria categoria = node.getInfo();
            ListaFilmes listaFilmes = categoria.getLista();
            Filme filmeEncontrado = listaFilmes.buscar(filme.getTitulo());
            if (filmeEncontrado != null) {
                System.out.println(filmeEncontrado.toString());
                break;
            }
        }
    }

    // (d) Procedimento para editar os dados de um filme.
    public void editarDadosFilme(Filme filme, Filme novosDados) {
        for (NodePrincipal node = listaCategorias.getPrimeiro(); node != null; node = node.getProx()) {
            Categoria categoria = node.getInfo();
            ListaFilmes listaFilmes = categoria.getLista();
            Filme filmeEncontrado = listaFilmes.buscar(filme.getTitulo());
            if (filmeEncontrado != null) {
                filmeEncontrado.setTitulo(novosDados.getTitulo());
                filmeEncontrado.setGenero(novosDados.getGenero());
                filmeEncontrado.setClassificacao(novosDados.getClassificacao());
                filmeEncontrado.setAno(novosDados.getAno());
                break;
            }
        }
    }

    // (e) Procedimento para exibir as informações de todos os filmes cadastrados na plataforma em todas as categorias.
    public void exibirTodosFilmes() {
        for (NodePrincipal node = listaCategorias.getPrimeiro(); node != null; node = node.getProx()) {
            Categoria categoria = node.getInfo();
            System.out.println("Categoria: " + categoria.getDescricao());
            categoria.getLista().exibir();
        }
    }

    // (f) Procedimento para exibir as informações de todos os filmes cadastrados na plataforma em uma dada categoria.
    public void exibirFilmesCategoria(String descricaoCategoria) {
        Categoria categoria = listaCategorias.buscar(descricaoCategoria);
        if (categoria != null) {
            categoria.getLista().exibir();
        }
    } 
    public void menu() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1. Cadastrar filme");
            System.out.println("2. Remover filme");
            System.out.println("3. Exibir dados de um filme");
            System.out.println("4. Editar dados de um filme");
            System.out.println("5. Exibir todos os filmes");
            System.out.println("6. Exibir filmes por categoria");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = sc.nextInt();
            sc.nextLine(); // consome a quebra de linha
            switch (opcao) {
                case 1:
                    // Implementação do cadastro de filme
                    System.out.println("Digite o título do filme:");
                    String titulo = sc.nextLine();
                    System.out.println("Digite o gênero do filme:");
                    String genero = sc.nextLine();
                    System.out.println("Digite a classificação do filme:");
                    String classificacao = sc.nextLine();
                    System.out.println("Digite o ano do filme:");
                    int ano = sc.nextInt();
                    sc.nextLine(); // consome a quebra de linha
                    System.out.println("Digite a descrição da categoria do filme:");
                    String descricaoCategoria = sc.nextLine();
                    Filme filme = new Filme(titulo, genero, classificacao, ano);
                    cadastrarFilme(filme, descricaoCategoria);
                    break;
                case 2:
                    // Implementação da remoção de filme
                    System.out.println("Digite o título do filme a ser removido:");
                    titulo = sc.nextLine();
                    filme = new Filme(titulo, "", "", 0); // os outros campos não são necessários para a remoção
                    removerFilme(filme);
                    break;
                case 3:
                    // Implementação da exibição dos dados de um filme
                    System.out.println("Digite o título do filme a ser exibido:");
                    titulo = sc.nextLine();
                    filme = new Filme(titulo, "", "", 0); // os outros campos não são necessários para a exibição
                    exibirDadosFilme(filme);
                    break;
                case 4:
                    // Implementação da edição dos dados de um filme
                    System.out.println("Digite o título do filme a ser editado:");
                    titulo = sc.nextLine();
                    filme = new Filme(titulo, "", "", 0); // os outros campos não são necessários para a edição
                    System.out.println("Digite o novo título do filme:");
                    String novoTitulo = sc.nextLine();
                    System.out.println("Digite o novo gênero do filme:");
                    String novoGenero = sc.nextLine();
                    System.out.println("Digite a nova classificação do filme:");
                    String novaClassificacao = sc.nextLine();
                    System.out.println("Digite o novo ano do filme:");
                    int novoAno = sc.nextInt();
                    sc.nextLine(); // consome a quebra de linha
                    Filme novosDados = new Filme(novoTitulo, novoGenero, novaClassificacao, novoAno);
                    editarDadosFilme(filme, novosDados);
                    break;
                case 5:
                    // Implementação da exibição de todos os filmes
                    exibirTodosFilmes();
                    break;
                case 6:
                    // Implementação da exibição de filmes por categoria
                    System.out.println("Digite a descrição da categoria:");
                    descricaoCategoria = sc.nextLine();
                    exibirFilmesCategoria(descricaoCategoria);
                    break;
                case 7:
                    System.out.println("Saindo...");
                    sc.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
    
   

}


