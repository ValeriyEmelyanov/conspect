package algorithms.graph.depth_bypass;


import java.util.Stack;

public class Graph {
    private final int MAX_VERTEX_NUMBER = 10;
    private Vertex vertexArray[];
    private int adjMatrix[][];
    private int vertexNumber;
    private Stack<Integer> stack;

    public Graph() {
        vertexArray = new Vertex[MAX_VERTEX_NUMBER];
        adjMatrix = new int[MAX_VERTEX_NUMBER][MAX_VERTEX_NUMBER];
        vertexNumber = 0;
        for (int i = 0; i < MAX_VERTEX_NUMBER; i++) {
            for (int j = 0; j < MAX_VERTEX_NUMBER; j++) {
                adjMatrix[i][j] = 0;
            }
        }
        stack = new Stack<>();
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

    public void dfs() {
        vertexArray[0].setVisited(true);
        displayVertex(0);
        stack.push(0);

        while (!stack.isEmpty()) {
            int vertexIndex = getAdjUnvisitedVertex(stack.peek());
            if (vertexIndex == -1) {
                stack.pop();
            } else {
                vertexArray[vertexIndex].setVisited(true);
                displayVertex(vertexIndex);
                stack.push(vertexIndex);
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
