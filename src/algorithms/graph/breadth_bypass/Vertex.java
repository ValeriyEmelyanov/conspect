package algorithms.graph.breadth_bypass;

public class Vertex {
    private char label;
    private boolean visited;

    public Vertex(char label) {
        this.label = label;
        this.visited = false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }
}
