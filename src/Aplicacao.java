package src;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Aplicacao {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String v1, v2;
        System.out.println("Digite o ponto que deseja começar:");
        v1 = input.nextLine();
        System.out.println("Digite o ponto que deseja chegar:");
        v2 = input.nextLine();
        Grafo grafo = new Grafo();
        grafo.setVertices(LerDoArquivo.lerGrafo("Projeto-Grafos/teste.txt"));
        Vertice i1 = new Vertice();
        Vertice i2 = new Vertice();
        i1 = grafo.encontrarVertice(v1);
        i2 = grafo.encontrarVertice(v2);

        List<Vertice> resultado = new ArrayList<Vertice>();
        Dijkstra algoritmo = new Dijkstra();
        resultado = algoritmo.encontrarMenorCaminhoDijkstra(grafo, i1, i2);
        System.out.println("Esse é o menor caminho feito pelo algoritmo:" + resultado);
    }
}
