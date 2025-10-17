package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BaekJoon1167 {
    static int V;
    static List<Node>[] tree;
    static boolean[] visited;
    static int maxNode;
    static int maxWeight;

    static class Node {
        int idx;
        int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static void dfs(int idx, int weight) {
        visited[idx] = true;

        if(weight > maxWeight) {
            maxWeight = weight;
            maxNode = idx;
        }

        for(Node node: tree[idx]) {
            if(!visited[node.idx]) {
                dfs(node.idx, node.weight + weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        tree = new ArrayList[V + 1];
        visited = new boolean[V + 1];

        for(int i = 0; i < V + 1; i++) {
            tree[i] = new ArrayList();
        }

        for (int i = 0; i < V; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1)
                    break;
                int weight = Integer.parseInt(st.nextToken());

                Node child = new Node(to, weight);
                Node parent = new Node(from, weight);

                tree[from].add(child);
                tree[to].add(parent);
            }
        }

        dfs(1, 0);

        visited = new boolean[V + 1];

        maxWeight = 0;
        dfs(maxNode, 0);

        System.out.println(maxWeight);
    }
}
