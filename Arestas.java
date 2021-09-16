public class Arestas<TIPO> {
    private Double peso;
    private TIPO identificador;
    private TIPO inicio;
    private TIPO fim;

    public Arestas(TIPO id, Double peso, TIPO inicio, TIPO fim) {
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

    public TIPO getInicio() {
        return inicio;
    }

    public void setInicio(TIPO inicio) {
        this.inicio = inicio;
    }

    public TIPO getFim() {
        return fim;
    }

    public void setFim(TIPO fim) {
        this.fim = fim;
    }

}