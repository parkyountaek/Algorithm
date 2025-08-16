package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1926 {
    static int R, C;
    static int[][] map;
    static boolean[][] visited;
    static int[][] availableMove = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int maxArea;
    static int count;

    static int DFS(int r, int c) {
        int area = 1;
        visited[r][c] = true;

        for (int[] move : availableMove) {
            int nextR = r + move[0];
            int nextC = c + move[1];

            if (nextR >= 0 && nextR < R && nextC >= 0 && nextC < C
                    && !visited[nextR][nextC] && map[nextR][nextC] == 1) {
                area += DFS(nextR, nextC);
            }
        }

        return area;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    int area = DFS(i, j);
                    maxArea = Math.max(area, maxArea);
                    count++;
                }
            }
        }

        System.out.println(count);
        System.out.println(maxArea);
    }
}
