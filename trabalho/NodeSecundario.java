package trabalho;

public class NodeSecundario {
    private NodeSecundario ante;
    private Filme info;
    private NodeSecundario prox;

    // Construtor
    public NodeSecundario(Filme info) {
        this.info = info;
        this.ante = null;
        this.prox = null;
    }

    // Getters
    public NodeSecundario getAnte() {
        return ante;
    }

    public Filme getInfo() {
        return info;
    }

    public NodeSecundario getProx() {
        return prox;
    }

    // Setters
    public void setAnte(NodeSecundario ante) {
        this.ante = ante;
    }

    public void setInfo(Filme info) {
        this.info = info;
    }

    public void setProx(NodeSecundario prox) {
        this.prox = prox;
    }
}
