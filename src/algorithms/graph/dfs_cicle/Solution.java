package algorithms.graph.dfs_cicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Задача:
 * Дан ориентированный невзвешенный граф.
 * Необходимо определить есть ли в нём циклы, и если есть, то вывести любой из них.
 * Входные данные:
 * В первой строке находятся два числа — количество вершин и ребер в графе соответственно.
 * Далее в  строках перечислены рёбра графа.
 * Каждое задаётся парой чисел — номерами начальной и конечной вершин соответственно.
 * Выходные данные
 * Если в графе нет цикла, то вывести «NO».
 * Иначе вывести «YES» и затем перечислить вершины в порядке обхода цикла.
 * Решение:
 * Для решения данной задачи используется поиск в глубину.
 * Вершины будем отмечать следующим образом:
 * 0 (белый) — мы еще не посещали вершину,
 * 1 (серый) — посетили вершину и не вышли из нее,
 * 2 (черный) — посетили вершину и вышли из неё.
 * graph - сам граф, для проверки на цикличность воспользуемся visited,
 * path - будем хранить порядок обхода графа.
 * Если мы захотим посетить 1 (серую) вершину, то это будет означать,
 * что мы отыскали цикл в этой вершине.
 * Тесты:
 * №  Входные данные  Выходные данные
 * 1	2 2
 *      1 2            YES
 *      2 1            1 2
 * 2	6 7
 *      1 2
 *      1 5
 *      2 3
 *      2 4
 *      4 6
 *      6 5            YES
 *      5 2            2 4 6 5
 * 3	6 6
 *      1 3
 *      2 4
 *      3 4
 *      1 2
 *      3 5
 *      3 6            NO
 */
public class Solution {
    public static final int WHITE = 0;
    public static final int GREY = 1;
    public static final int BLACK = 2;

    public static int n, m;
    public static boolean found = false;
    public static List<ArrayList<Integer>> graph = new ArrayList<>();
    public static List<Integer> visited = new ArrayList<>();
    public static List<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Считываем количество вершин и ребер
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            visited.add(WHITE);
        }
        // Считываем ребра и заполняем граф
        for (int i = 0; i < m; i++) {
            int v1 = scanner.nextInt();
            int v2 = scanner.nextInt();
            graph.get(v1).add(v2);
        }
        scanner.close();

        // Проверяем вершины на наличие цикла
        checkNodes();

        if (found) {
            // Если цикл найден
            int i = path.size() - 2; // последняя вершина цикла
            int to = path.get(path.size() - 1); // вершина в которой зациклились
            while (path.get(i) != to) { // получаем индекс вершины в которой зациклились
                i--;
            }
            System.out.println("YES");
            // Выводим вершины цикла
            while (i < path.size() - 1) {
                System.out.print(path.get(i) + " ");
                i++;
            }
            System.out.println();
        } else
            System.out.print("NO");
    }

    /**
     * Проверяем вершины на наличие цикла
     */
    static void checkNodes() {
        for (int i = 0; i <= n; i++) {
            if (visited.get(i) == WHITE) {
                // если не посещали вершину, то посещаем ее
                dfs(i);
                if (found) {
                    // если нашли цикл, то останавливаемся
                    return;
                }
            }
        }
    }

    /**
     * Поиск в глубину для каждой вершины
     * @param v вершина
     */
    static void dfs(int v) {
        if (found) {
            return; // если уже нашли цикл, то останавливаемся
        }

        visited.set(v, GREY); // посещаем вершину
        path.add(v); // добавляем ее в порядок обхода графа

        for (int i = 0; i < graph.get(v).size(); i++) {
            int to = graph.get(v).get(i); // следующая вершина графа
            if (visited.get(to) == GREY) { // если мы ее посетили, но не вышли из нее, значит мы нашли цикл
                path.add(to); // добавляем следующую вершину в порядок обхода графа
                found = true; // ставим индикатор, что мы нашли цикл и останавливаемся
                return;
            }
            dfs(to); // если не посетили, то посещаем
            if (found) {
                return; // если нашли цикл, то останавливаемся
            }
        }

        visited.set(v, BLACK); // если не нашли цикл, то выходим из вершины
        path.remove(path.size() - 1);
    }
}
