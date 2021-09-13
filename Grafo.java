import java.util.ArrayList;
import java.util.Arrays;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Arestas<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Arestas<TIPO>>();
    }

    public void adicionarVertice(TIPO id, TIPO nome) {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(id, nome);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(TIPO ID, Double peso, TIPO dadoInicio, TIPO dadoFim) {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Arestas<TIPO> aresta = new Arestas<TIPO>(ID, peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO ID) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getIdentificador().equals(ID)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void imprimir() {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            vertice = this.vertices.get(i);
            System.out.print(vertice.getIdentificador() + ",");
            System.out.println(vertice.getNome());
        }
    }
}
