package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1068 {
    static int N;
    static int[][] tree;
    static boolean[] visited;
    static int deleteNode;
    static int answer;

    static void dfs(int node) {
        visited[node] = true;

        if (node == deleteNode)
            return;

        boolean isLeaf = true;
        for (int i = 0; i < N; i++) {
            if (tree[node][i] == 1 && !visited[i] && i != deleteNode) {
                isLeaf = false;
                dfs(i);
            }
        }

        if (isLeaf) {
            answer++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        int root = 0;
        for (int i = 0; i < N; i++) {
            int node = Integer.parseInt(st.nextToken());
            if (node == -1) {
                root = i;
                continue;
            }
            tree[i][node] = 1;
            tree[node][i] = 1;
        }
        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(answer);
    }
}
