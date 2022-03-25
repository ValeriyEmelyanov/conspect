package algorithms.graph.dijkstra;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * Входные данные:
 *  В первой строке указаны два числа: число вершин и число ребер графа.
 *  Далее идут строки с описанием ребер. Их количество равно числу ребер.
 *  В каждой строке указаны 3 числа: исходящая вершина, входящая вершина, вес ребра.
 *  В последней строке указаны 2 номера вершины:
 *  начальная и конечная вершина, кратчайший путь между которыми нужно найти.
 * Выходные данные:
 *  минимальное расстояние между заданными вершинами.
 *  Если пути нет, то нужно вернуть -1.
 *
 * Sample Input:
 * 4 8
 * 1 2 6
 * 1 3 2
 * 1 4 10
 * 2 4 4
 * 3 1 5
 * 3 2 3
 * 3 4 8
 * 4 2 1
 * 1 4
 *
 * Sample Output:
 * 9
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");
        int numOfVertexes = Integer.parseInt(input[0]);
        int numOfEdges = Integer.parseInt(input[1]);

        Map<Integer, List<Vertex>> adj = new TreeMap<>();
        for (int i = 0; i < numOfEdges; i++) {
            input = scanner.nextLine().split(" ");
            int num1 = Integer.parseInt(input[0]) - 1;
            int num2 = Integer.parseInt(input[1]) - 1;
            int weight = Integer.parseInt(input[2]);
            List<Vertex> list = adj.computeIfAbsent(num1, k -> new ArrayList<>());
            list.add(new Vertex(num2, weight));
        }

        input = scanner.nextLine().split(" ");
        int start = Integer.parseInt(input[0]) - 1;
        int finish = Integer.parseInt(input[1]) - 1;

        Dpq dpq = new Dpq(numOfVertexes, adj);
        dpq.dijkstra(start);

        System.out.println(dpq.getDistance(finish));
    }

    static class Dpq {
        private final int[] dist;
        private final Set<Integer> settled;
        private final PriorityQueue<Vertex> pq;
        private final int numOfVertexes;
        private final Map<Integer, List<Vertex>> adj;

        public Dpq(int numOfVertexes, Map<Integer, List<Vertex>> adj) {
            this.numOfVertexes = numOfVertexes;
            this.adj = adj;
            this.dist = new int[numOfVertexes];
            settled = new HashSet<>();
            pq = new PriorityQueue<>(numOfVertexes);
        }

        public int getDistance(int finish) {
            return dist[finish] == Integer.MAX_VALUE ? -1 : dist[finish];
        }

        public void dijkstra(int start) {
            for (int i = 0; i < numOfVertexes; i++) {
                dist[i] = Integer.MAX_VALUE;
            }

            pq.add(new Vertex(start, 0));
            dist[start] = 0;

            while (settled.size() < numOfVertexes) {
                if (pq.isEmpty()) {
                    return;
                }

                int u = pq.remove().num;

                settled.add(u);

                processNeighbours(u);
            }

        }

        private void processNeighbours(int u) {
            int edgeDist = -1;
            int newDist = -1;

            List<Vertex> list = adj.get(u);
            if (list == null) {
                return;
            }

            for (Vertex v : list) {
                if (!settled.contains(v.num)) {
                    edgeDist = v.weight;
                    newDist = dist[u] + edgeDist;
                    if (newDist < dist[v.num]) {
                        dist[v.num] = newDist;
                    }
                    pq.add(new Vertex(v.num, dist[v.num]));
                }
            }
        }
    }

    static class Vertex implements Comparable<Vertex> {
        public int num;
        public int weight;

        public Vertex(int num, int weight) {
            this.num = num;
            this.weight = weight;
        }

        @Override
        public int compareTo(Vertex v2) {
            return Integer.compare(weight, v2.weight);
        }
    }
}
