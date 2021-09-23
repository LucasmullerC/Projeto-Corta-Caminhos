public class Arestas<TIPO> {
    private Double peso;
    private TIPO identificador;
    private Vertice<TIPO> inicio;
    private Vertice<TIPO> fim;

    public Arestas(TIPO id, Double peso, Vertice<TIPO> inicio, Vertice<TIPO> fim) {
        this.identificador = id;
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public TIPO getIdent() {
        return identificador;
    }

    public void setIdent(TIPO ident) {
        this.identificador = ident;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertice<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Vertice<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Vertice<TIPO> getFim() {
        return fim;
    }

    public void setFim(Vertice<TIPO> fim) {
        this.fim = fim;
    }

}