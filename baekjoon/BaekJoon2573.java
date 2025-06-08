package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2573 {
    static int[][] ice;
    static int N, M;
    static boolean[][] visited;
    static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int answer = 0;
    static int year = 0;

    static void melt() {
        int[][] melt_ice = new int[N][M];

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (ice[row][col] != 0) {
                    int cnt = 0;
                    for (int[] d : direction) {
                        int nextRow = row + d[0];
                        int nextCol = col + d[1];

                        if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                            if (ice[nextRow][nextCol] == 0)
                                cnt++;
                        }
                    }
                    melt_ice[row][col] = cnt;
                }
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                ice[row][col] -= melt_ice[row][col];
                if (ice[row][col] < 0) ice[row][col] = 0;
            }
        }
    }


    static void DFS(int row, int col) {
        visited[row][col] = true;

        for (int[] d : direction) {
            int nextRow = row + d[0];
            int nextCol = col + d[1];

            if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                if (!visited[nextRow][nextCol] && ice[nextRow][nextCol] != 0) {
                    DFS(nextRow, nextCol);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ice = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            visited = new boolean[N][M];
            answer = 0;
            for (int row = 0; row < N; row++) {
                for (int col = 0; col < M; col++) {
                    if (!visited[row][col] && ice[row][col] != 0) {
                        DFS(row, col);
                        answer++;
                    }
                }
            }

            if (answer == 0) {
                System.out.println(0);
                break;
            }
            if (answer >= 2) {
                System.out.println(year);
                break;
            }
            melt();
            year++;
        }
    }
}
