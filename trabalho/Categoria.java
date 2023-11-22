package trabalho;

public class Categoria implements Comparable<Categoria> {
    private String descricao; // nome da categoria
    private ListaFilmes lista; // referência para a lista de filmes daquela categoria

    // Construtor
    public Categoria(String descricao) {
        this.descricao = descricao;
        this.lista = new ListaFilmes();
    }

    // Getters
    public String getDescricao() {
        return descricao;
    }

    public ListaFilmes getLista() {
        return lista;
    }

    // Setters
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLista(ListaFilmes lista) {
        this.lista = lista;
    }

    // Método compareTo
    @Override
    public int compareTo(Categoria outraCategoria) {
        return this.descricao.compareTo(outraCategoria.getDescricao());
    }

    // Método toString
    @Override
    public String toString() {
        return "Categoria{" +
                "descricao='" + descricao + '\'' +
                ", lista=" + lista +
                '}';
    }
}


