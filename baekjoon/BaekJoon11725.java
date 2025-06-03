package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon11725 {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] answer;

    static void DFS(int current) {
        visited[current] = true;

        for(int i = 0; i < graph[current].size(); i++) {
            int value = graph[current].get(i);
            if(!visited[value]) {
                answer[value] = current + 1;
                DFS(value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N];
        visited = new boolean[N];
        answer = new int[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int pointA = Integer.parseInt(st.nextToken());
            int pointB = Integer.parseInt(st.nextToken());

            graph[pointA - 1].add(pointB - 1);
            graph[pointB - 1].add(pointA - 1);
        }

        DFS(0);

        for (int i = 1; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}
