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

    public void adicionarAresta(TIPO ID, Double peso, String dadoInicio, String dadoFim) {

        Vertice<TIPO> inicio = this.getVerticeString(dadoInicio);
        Vertice<TIPO> fim = this.getVerticeString(dadoFim);
        Arestas<TIPO> aresta = new Arestas<TIPO>(ID, peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVerticeString(String ID) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getIdentificador().equals(ID)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public Vertice<TIPO> getVertice(Vertice<TIPO> ID) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getIdentificador().equals(ID)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    // public void imprimir() {
    // // Vertice<TIPO> vertice = null;
    // // Arestas<TIPO> aresta = null;
    // // String inicio, fim;
    // // boolean in = false;
    // // for (int i = 0; i < this.arestas.size(); i++) {
    // // aresta = this.arestas.get(i);
    // // for (int b = 0; b < this.vertices.size(); b++) {
    // // vertice = this.vertices.get(b);
    // // if (aresta.getInicio().toString().charAt(0) ==
    // // vertice.getIdentificador().toString().charAt(0)) {
    // // System.out.print(vertice.getIdentificador() + ",");
    // // System.out.print(vertice.getNome() + " ---> ");
    // // in = true;
    // // }
    // // if (in == true
    // // & aresta.getFim().toString().charAt(0) ==
    // // vertice.getIdentificador().toString().charAt(0)) {
    // // System.out.print(vertice.getIdentificador() + "," + vertice.getNome());
    // // if (this.arestas.size() != i + 1) {
    // // System.out.print(" ---> ");
    // // }

    // // }
    // // }
    // // }
    // }

    public void buscaEmLargura() {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        // System.out.println(atual.getIdentificador());
        System.out.print(atual.getIdentificador() + ",");
        System.out.print(atual.getNome() + " ---> ");
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) { // se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    // System.out.println(proximo.getIdentificador());
                    System.out.print(proximo.getIdentificador() + ",");
                    System.out.print(proximo.getNome() + " ---> ");
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }
}
