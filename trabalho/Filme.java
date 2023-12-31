package trabalho;

public class Filme implements Comparable<Filme> {
    private String titulo;
    private String genero;
    private String classificacao;
    private int ano;

    public Filme(String titulo, String genero, String classificacao, int ano) {
        this.titulo = titulo;
        this.genero = genero;
        this.classificacao = classificacao;
        this.ano = ano;
    }

    
    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public int getAno() {
        return ano;
    }

    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    @Override
    public int compareTo(Filme outroFilme) {
        return this.titulo.compareTo(outroFilme.getTitulo());
    }


    @Override
    public String toString() {
        return "Filme{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", classificacao='" + classificacao + '\'' +
                ", ano=" + ano +
                '}';
    }
}
