package trabalho;

public class Categoria implements Comparable<Categoria> {
    private String descricao; 
    private ListaFilmes lista;

    
    public Categoria(String descricao) {
        this.descricao = descricao;
        this.lista = new ListaFilmes();
    }

    public String getDescricao() {
        return descricao;
    }

    public ListaFilmes getLista() {
        return lista;
    }

  
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLista(ListaFilmes lista) {
        this.lista = lista;
    }

    
    @Override
    public int compareTo(Categoria outraCategoria) {
        return this.descricao.compareTo(outraCategoria.getDescricao());
    }

    
    @Override
    public String toString() {
        return "Categoria{" +
                "descricao='" + descricao + '\'' +
                ", lista=" + lista +
                '}';
    }
}


