package trabalho;
public class ListaCategorias {
    private NodePrincipal primeiro;
    private int qtd;

    public ListaCategorias() {
        this.primeiro = null;
        this.qtd = 0;
    }

    public void inserirOrdenado(Categoria categoria) {
        NodePrincipal novoNode = new NodePrincipal(categoria);

        if (primeiro == null) {
            primeiro = novoNode;
            primeiro.setProx(primeiro);
            primeiro.setAnte(primeiro);
        } else {
            NodePrincipal ultimo = primeiro.getAnte();
            novoNode.setProx(primeiro);
            novoNode.setAnte(ultimo);
            ultimo.setProx(novoNode);
            primeiro.setAnte(novoNode);
        }

        qtd++;
    }

    public void remover(String descricao) {
        if (primeiro != null) {
            NodePrincipal atual = primeiro;

            do {
                if (descricao.equals(atual.getInfo().getDescricao())) {
                    NodePrincipal anterior = atual.getAnte();
                    NodePrincipal proximo = atual.getProx();

                    anterior.setProx(proximo);
                    proximo.setAnte(anterior);

                    if (atual == primeiro) {
                        primeiro = proximo;
                    }

                    qtd--;
                    break;
                }

                atual = atual.getProx();
            } while (atual != primeiro);
        }
    }

    public Categoria buscar(String descricao) {
        NodePrincipal atual = primeiro;

        do {
            if (descricao.equals(atual.getInfo().getDescricao())) {
                return atual.getInfo();
            }

            atual = atual.getProx();
        } while (atual != primeiro);

        return null;
    }

    public void exibir() {
        if (primeiro != null) {
            NodePrincipal atual = primeiro;

            do {
                System.out.println(atual.getInfo().getDescricao());
                atual = atual.getProx();
            } while (atual != primeiro);
        }
    }

    public NodePrincipal getPrimeiro() {
        return primeiro;
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
}





    


