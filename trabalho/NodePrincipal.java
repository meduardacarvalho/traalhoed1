package trabalho;

public class NodePrincipal {
    private NodePrincipal ante;
    private Categoria info;
    private NodePrincipal prox;

    
    public NodePrincipal(Categoria info) {
        this.info = info;
        this.ante = null;
        this.prox = null;
    }

    
    public NodePrincipal getAnte() {
        return ante;
    }

    public Categoria getInfo() {
        return info;
    }

    public NodePrincipal getProx() {
        return prox;
    }

    
    public void setAnte(NodePrincipal ante) {
        this.ante = ante;
    }

    public void setInfo(Categoria info) {
        this.info = info;
    }

    public void setProx(NodePrincipal prox) {
        this.prox = prox;
    }
}


