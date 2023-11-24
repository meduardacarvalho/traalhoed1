package trabalho;

public class ListaFilmes {
    private NodeSecundario primeiro;
    private int qtd;
    private NodeSecundario ultimo;


    public ListaFilmes() {
        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }

    
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

