package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon11400 {
    static int V, E;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] disc, low;
    static int time = 0;

    static List<int[]> bridges = new ArrayList<>();

    static void dfs(int u, int parent) {
        visited[u] = true;
        disc[u] = low[u] = ++time;

        for (int v : graph[u]) {
            if (!visited[v]) {
                dfs(v, u);

                low[u] = Math.min(low[u], low[v]);

                // 단절선 조건
                if (low[v] > disc[u]) {
                    bridges.add(new int[]{Math.min(u, v), Math.max(u, v)});
                }

                // 역방향 간선 (부모로 가는 것 제외)
            } else if (v != parent) {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        disc = new int[V + 1];
        low = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent].add(child);
            graph[child].add(parent);
        }

        for (int i = 1; i <= V; i++) {
            if (!visited[i]) dfs(i, -1);
        }

        // 정렬
        bridges.sort((x, y) -> {
            if (x[0] == y[0]) return x[1] - y[1];
            return x[0] - y[0];
        });

        // 출력
        System.out.println(bridges.size());
        for (int[] e : bridges) {
            System.out.println(e[0] + " " + e[1]);
        }
    }
}
