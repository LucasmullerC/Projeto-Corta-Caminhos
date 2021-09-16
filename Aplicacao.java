import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Aplicacao {
    public static void main(String[] args) throws IOException {
        Grafo<String> grafo = new Grafo<String>();
        // Ler Vertices.csv
        Scanner scanner = new Scanner(new File("Projeto-Grafos/vertices.csv"));
        scanner.useDelimiter(",");
        String[] vert;
        String[] arest;
        while (scanner.hasNext()) {
            vert = scanner.next().split(";");
            grafo.adicionarVertice(vert[0], vert[1]);
        }
        scanner.close();

        // Ler Arestas.csv
        Scanner scanner2 = new Scanner(new File("Projeto-Grafos/arestas.csv"));
        scanner2.useDelimiter(",");
        while (scanner2.hasNext()) {
            arest = scanner2.next().split(";");
            grafo.adicionarAresta(arest[0], Double.parseDouble(arest[1]), arest[2], arest[3]);
        }
        scanner2.close();

        grafo.imprimir();
    }

}