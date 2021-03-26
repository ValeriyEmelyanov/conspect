package algorithms.graph.dfs_cicle;

import java.util.ArrayList;
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
 * Тесты
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
    public static int n, m;
    public static boolean flag = false;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> used = new ArrayList<>();
    public static ArrayList<Integer> path = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Считываем количество вершин и ребер
        n = scanner.nextInt();
        m = scanner.nextInt();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
            used.add(0);
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

        if (flag) {
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
            if (used.get(i) == 0) {
                // если не посещали вершину, то посещаем ее
                dfs(i);
                if (flag) {
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
        if (flag) {
            return; // если уже нашли цикл, то останавливаемся
        }

        used.set(v, 1); // посещаем вершину
        path.add(v); // добавляем ее в порядок обхода графа

        for (int i = 0; i < graph.get(v).size(); i++) {
            int to = graph.get(v).get(i); // следующая вершина графа
            if (used.get(to) == 1) { // если мы ее посетили, но не вышли из нее, значит мы нашли цикл
                path.add(to); // добавляем следующую вершину в порядок обхода графа
                flag = true; // ставим индикатор, что мы нашли цикл и останавливаемся
                return;
            }
            dfs(to); // если не посетили, то посещаем
            if (flag) {
                return; // если нашли цикл, то останавливаемся
            }
        }

        used.set(v, 2); // если не нашли цикл, то выходим из вершины
        path.remove(path.size() - 1);
    }
}
