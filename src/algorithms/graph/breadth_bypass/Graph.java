package algorithms.graph.breadth_bypass;

import algorithms.graph.depth_bypass.Vertex;

import java.util.PriorityQueue;
import java.util.Queue;

public class Graph {
    private final int MAX_VERTEX_NUMBER = 10;
    private Vertex vertexArray[];
    private int adjMatrix[][];
    private int vertexNumber;
    private Queue<Integer> queue;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTEX_NUMBER];
        adjMatrix = new int[MAX_VERTEX_NUMBER][MAX_VERTEX_NUMBER];
        vertexNumber = 0;
        for (int i = 0; i < MAX_VERTEX_NUMBER; i++) {
            for (int j = 0; j < MAX_VERTEX_NUMBER; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        queue = new PriorityQueue<>();
    }

    public void addVertex(char label) {
        vertexArray[vertexNumber++] = new Vertex(label);
    }

    public void addEdge(int start, int end) {
        adjMatrix[start][end] = 1;
        adjMatrix[end][start] = 1;
    }

    public void displayVertex(int vertexIndex) {
        System.out.println(vertexArray[vertexIndex].getLabel());
    }

    public void bfc() {
        vertexArray[0].setVisited(true);
        displayVertex(0);
        queue.add(0);
        int adjVertex;

        while (!queue.isEmpty()) {
            int vertex = queue.remove();
            while ((adjVertex = getAdjUnvisitedVertex(vertex)) != -1) {
                vertexArray[adjVertex].setVisited(true);
                displayVertex(adjVertex);
                queue.add(adjVertex);
            }
        }

        for (int i = 0; i < vertexNumber; i++) {
            vertexArray[i].setVisited(false);
        }
    }

    private int getAdjUnvisitedVertex(int vertexIndex) {
        for (int i = 0; i < vertexNumber; i++) {
            if (adjMatrix[vertexIndex][i] == 1 && !vertexArray[i].isVisited()) {
                return i;
            }
        }
        return -1;
    }
}
