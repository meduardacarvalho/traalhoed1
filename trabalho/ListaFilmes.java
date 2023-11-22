package trabalho;

public class ListaFilmes {
    private NodeSecundario primeiro;
    private int qtd;
    private NodeSecundario ultimo;

    // Construtor
    public ListaFilmes() {
        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }

    // Método de inserção ordenada na lista
    public void inserirOrdenado(Filme filme) {
        NodeSecundario novoNode = new NodeSecundario(filme);
        if (primeiro == null) {
            primeiro = novoNode;
            ultimo = novoNode;
        } else {
            NodeSecundario atual = primeiro;
            NodeSecundario anterior = null;
            while (atual != null && filme.compareTo(atual.getInfo()) > 0) {
                anterior = atual;
                atual = atual.getProx();
            }
            if (anterior == null) {
                novoNode.setProx(primeiro);
                primeiro = novoNode;
            } else {
                novoNode.setProx(atual);
                anterior.setProx(novoNode);
            }
        }
        qtd++;
    }

    // Método de remoção na lista
    public void remover(String titulo) {
        NodeSecundario atual = primeiro;
        NodeSecundario anterior = null;
        while (atual != null && !titulo.equals(atual.getInfo().getTitulo())) {
            anterior = atual;
            atual = atual.getProx();
        }
        if (atual != null) {
            if (anterior == null) {
                primeiro = primeiro.getProx();
            } else {
                anterior.setProx(atual.getProx());
            }
            qtd--;
        }
    }

    // Método de busca na lista
    public Filme buscar(String titulo) {
        NodeSecundario atual = primeiro;
        while (atual != null) {
            if (titulo.equals(atual.getInfo().getTitulo())) {
                return atual.getInfo();
            }
            atual = atual.getProx();
        }
        return null;
    }

    // Método de exibição da lista
    public void exibir() {
        NodeSecundario atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getInfo().toString());
            atual = atual.getProx();
        }
    }

    public NodeSecundario getPrimeiro() {
        return primeiro;
    }

    public int getQtd() {
        return qtd;
    }

    public NodeSecundario getUltimo() {
        return ultimo;
    }
}

