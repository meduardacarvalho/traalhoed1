package trabalho;
public class ListaFilmes {
    private NodeSecundario primeiro;
    private int qtd;

    public ListaFilmes() {
        this.primeiro = null;
        this.qtd = 0;
    }

    public void inserirOrdenado(Filme filme) {
        NodeSecundario novoNode = new NodeSecundario(filme);

        if (primeiro == null) {
            primeiro = novoNode;
            primeiro.setProx(primeiro);
            primeiro.setAnte(primeiro);
        } else {
            NodeSecundario ultimo = primeiro.getAnte();
            novoNode.setProx(primeiro);
            novoNode.setAnte(ultimo);
            ultimo.setProx(novoNode);
            primeiro.setAnte(novoNode);
        }

        qtd++;
    }

    public void remover(String titulo) {
        if (primeiro != null) {
            NodeSecundario atual = primeiro;

            do {
                if (titulo.equals(atual.getInfo().getTitulo())) {
                    NodeSecundario anterior = atual.getAnte();
                    NodeSecundario proximo = atual.getProx();

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

    public Filme buscar(String titulo) {
        NodeSecundario atual = primeiro;

        do {
            if (titulo.equals(atual.getInfo().getTitulo())) {
                return atual.getInfo();
            }

            atual = atual.getProx();
        } while (atual != primeiro);

        return null;
    }

    public void exibir() {
        if (primeiro != null) {
            NodeSecundario atual = primeiro;

            do {
                System.out.println(atual.getInfo().toString());
                atual = atual.getProx();
            } while (atual != primeiro);
        }
    }

    public NodeSecundario getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(NodeSecundario primeiro) {
        this.primeiro = primeiro;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    
}