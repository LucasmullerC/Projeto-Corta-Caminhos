import java.util.ArrayList;

public class Vertice<TIPO> {
    private TIPO identificador;
    private TIPO nome;
    private ArrayList<Arestas<TIPO>> arestasEntrada;
    private ArrayList<Arestas<TIPO>> arestasSaida;

    public Vertice(TIPO id, TIPO N) {
        this.identificador = id;
        this.nome = N;
        this.arestasEntrada = new ArrayList<Arestas<TIPO>>();
        this.arestasSaida = new ArrayList<Arestas<TIPO>>();
    }

    public TIPO getIdentificador() {
        return identificador;
    }

    public void setIdentificador(TIPO ident) {
        this.identificador = ident;
    }

    public TIPO getNome() {
        return nome;
    }

    public void setNome(TIPO N) {
        this.nome = N;
    }

    public void adicionarArestaEntrada(Arestas<TIPO> aresta) {
        this.arestasEntrada.add(aresta);
    }

    public void adicionarArestaSaida(Arestas<TIPO> aresta) {
        this.arestasSaida.add(aresta);
    }

    public ArrayList<Arestas<TIPO>> getArestasEntrada() {
        return arestasEntrada;
    }

    public ArrayList<Arestas<TIPO>> getArestasSaida() {
        return arestasSaida;
    }

    public String toString() {
        return this.nome + ", ";
    }
}
