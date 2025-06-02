package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon16929 {
    static char[][] graph;
    static boolean[][] visited;
    static int N, M;
    static int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    static boolean DFS(int row, int col, int prevRow, int prevCol) {
        visited[row][col] = true;

        for (int d = 0; d < 4; d++) {
            int nextRow = row + dir[d][0];
            int nextCol = col + dir[d][1];

            if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M) continue;
            if (graph[nextRow][nextCol] != graph[row][col]) continue;

            if (!visited[nextRow][nextCol]) {
                if (DFS(nextRow, nextCol, row, col)) return true;
            } else if (nextRow != prevRow || nextCol != prevCol) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (DFS(i, j, -1, -1)) {
                        System.out.println("Yes");
                        return;
                    }
                }
            }
        }

        System.out.println("No");
    }
}
