package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1707 {
    static int K, V, E;
    static List<Integer>[] graph;
    static int[] visitied;

    static boolean DFS(int current, int group) {
        visitied[current] = group;

        for (int value : graph[current]) {
            if (visitied[value] == 0) {
                if (!DFS(value, group * -1)) return false;
            } else if (visitied[value] == visitied[current]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());


        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            graph = new ArrayList[V];
            for (int j = 0; j < V; j++) {
                graph[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                graph[A - 1].add(B - 1);
                graph[B - 1].add(A - 1);
            }

            visitied = new int[V];

            boolean isBipartite = true;

            for (int j = 0; j < V; j++) {
                if (visitied[j] == 0) {
                    if (!DFS(j, 1)) {
                        isBipartite = false;
                        break;
                    }
                }
            }
            System.out.println(isBipartite ? "YES" : "NO");
        }
    }
}
