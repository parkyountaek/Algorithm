package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon1260 {
    public static void DFS(int[] visited, int[][] graph, int current, int N, StringBuilder sb) {
        visited[current] = 1;
        sb.append((current + 1)).append(" ");

        for(int col = 0; col < N; col++) {
            if(visited[col] != 1 && graph[current][col] == 1) {
                DFS(visited, graph, col, N, sb);
            }
        }
    }

    public static void BFS(int[] visited, int[][] graph, int current, int N, StringBuilder sb) {
        Queue<Integer> queue = new ArrayDeque<>();
        visited[current] = 0;
        queue.add(current);

        while(!queue.isEmpty()) {
            Integer value = queue.poll();
            sb.append((value + 1)).append(" ");
            for(int col = 0; col < N; col++) {
                if(visited[col] != 0 && graph[value][col] == 1) {
                    queue.add(col);
                    visited[col] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int [][] graph = new int[N][N];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());

            graph[row - 1][col - 1] = 1;
            graph[col - 1][row - 1] = 1;
        }

        int[] visited  = new int[N];

        StringBuilder sb = new StringBuilder();
        DFS(visited, graph, V-1, N, sb);
        System.out.println(sb);

        sb = new StringBuilder();
        BFS(visited, graph, V-1, N, sb);
        System.out.println(sb);
    }
}
