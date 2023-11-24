package trabalho;

public class ListaCategorias {
    private NodePrincipal primeiro;
    private int qtd;
    private NodePrincipal ultimo;
    public ListaCategorias() {
        this.primeiro = null;
        this.ultimo = null;
        this.qtd = 0;
    }


    public void inserirOrdenado(Categoria categoria) {
        NodePrincipal novoNode = new NodePrincipal(categoria);
        if (primeiro == null) {
            primeiro = novoNode;
            ultimo = novoNode;
        } else {
            NodePrincipal atual = primeiro;
            NodePrincipal anterior = null;
            while (atual != null && categoria.compareTo(atual.getInfo()) > 0) {
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
    public void remover(String descricao) {
        NodePrincipal atual = primeiro;
        NodePrincipal anterior = null;
        while (atual != null && !descricao.equals(atual.getInfo().getDescricao())) {
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

    public Categoria buscar(String descricao) {
        NodePrincipal atual = primeiro;
        while (atual != null) {
            if (descricao.equals(atual.getInfo().getDescricao())) {
                return atual.getInfo();
            }
            atual = atual.getProx();
        }
        return null;
    }

    public void exibir() {
        NodePrincipal atual = primeiro;
        while (atual != null) {
            System.out.println(atual.getInfo().getDescricao());
            atual = atual.getProx();
        }
    }

    public void setPrimeiro(NodePrincipal primeiro) {
        this.primeiro = primeiro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public NodePrincipal getUltimo() {
        return ultimo;
    }

    public void setUltimo(NodePrincipal ultimo) {
        this.ultimo = ultimo;
    }

    public NodePrincipal getPrimeiro() {
        return primeiro;
    }
}


