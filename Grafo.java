import java.util.ArrayList;
import java.util.Collections;

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

    public Vertice<TIPO> getVerticeNome(String Nome) {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getNome().equals(Nome)) {
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

    public void buscaEmLargura() {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.print(atual.getIdentificador() + ",");
        System.out.print(atual.getNome() + " ---> ");
        fila.add(atual);
        while (fila.size() > 0) {
            Vertice<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) { // se o vértice ainda não foi marcado
                    marcados.add(proximo);
                    System.out.print(proximo.getIdentificador() + ",");
                    System.out.print(proximo.getNome() + " ---> ");
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public void busca2(String Ninicio, String Nfinal) {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> caso1 = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> caso2 = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = getVerticeNome(Ninicio);
        Vertice<TIPO> Vfinal = getVerticeNome(Nfinal);
        if (atual == null || Vfinal == null) {
            System.out.print("Rua não encontrada!");
        } else {
            for (int i = 0; i < atual.getArestasSaida().size(); i++) {
                caso2.add(atual);
                marcados.add(atual.getArestasSaida().get(i).getFim());
                fila.add(atual.getArestasSaida().get(i).getFim());
                caso2.add(atual.getArestasSaida().get(i).getFim());
                while (fila.size() > 0) {
                    Vertice<TIPO> visitado = fila.get(0);
                    Vertice<TIPO> proximo = visitado.getArestasSaida().get(0).getFim();
                    if (!marcados.contains(proximo)) { // se o vértice ainda não foi marcado
                        marcados.add(proximo);
                        if (Vfinal == proximo) {
                            fila.clear();
                        }
                        fila.add(proximo);
                        caso2.add(proximo);
                    }
                    fila.remove(0);
                }
                marcados.clear();
                if (i == 0) {
                    caso1 = (ArrayList<Vertice<TIPO>>) caso2.clone();
                    caso2.clear();
                }
                if (caso1.size() > caso2.size() && caso2.size() != 0) {
                    caso1 = (ArrayList<Vertice<TIPO>>) caso2.clone();
                    caso2.clear();
                }
            }
            exibir(caso1);
        }
    }

    public void exibir(ArrayList<Vertice<TIPO>> lista) {
        for (int b = 0; b < lista.size(); b++) {
            if (lista.size() == b + 1) {
                System.out.print(lista.get(b).getIdentificador() + ",");
                System.out.print(lista.get(b).getNome());
            } else {
                System.out.print(lista.get(b).getIdentificador() + ",");
                System.out.print(lista.get(b).getNome() + " ---> ");
            }
        }
    }

}
