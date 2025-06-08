package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1520 {
    static int[][] map;
    static int[][] dp;
    static int M, N;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    static int DFS(int row, int col) {
        if (row == M - 1 && col == N - 1)
            return 1;

        if (dp[row][col] != -1) return dp[row][col];

        dp[row][col] = 0;

        for (int[] d : dir) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];

            if (nextRow < 0 || nextRow >= M || nextCol < 0 || nextCol >= N)
                continue;

            if (map[nextRow][nextCol] < map[row][col]) {
                dp[row][col] += DFS(nextRow, nextCol);
            }
        }

        return dp[row][col];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }

        System.out.println(DFS(0, 0));
    }
}
