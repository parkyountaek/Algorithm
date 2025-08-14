package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BeekJoon1967 {
    static int N;
    static List<Node>[] tree;
    static int maxWeight;
    static int halfRadius;
    static boolean[] visited;

    static class Node {
        int idx;
        int weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }
    }

    static void DFS(int current, int weight) {
        if(maxWeight < weight) {
            maxWeight = weight;
            halfRadius = current;
        }

        for(Node nextNode: tree[current]) {
            if(!visited[nextNode.idx]) {
                visited[nextNode.idx] = true;
                DFS(nextNode.idx, weight + nextNode.weight);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        visited = new boolean[N + 1];
        tree = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            int wight = Integer.parseInt(st.nextToken());

            tree[parent].add(new Node(child, wight));
            tree[child].add(new Node(parent, wight));
        }

        visited[1] = true;
        DFS(1, 0);

        visited = new boolean[N+1];
        visited[halfRadius] = true;
        DFS(halfRadius, 0);

        System.out.println(maxWeight);
    }
}
