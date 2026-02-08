package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon14889 {
    static int N;
    static int[][] team;
    static int compare = Integer.MAX_VALUE;
    static boolean[] visited;

    static void backTracking(int count, int index) {
        if (N / 2 == count) {
            calculate(visited);
            return;
        }

        for (int i = index; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                backTracking(count + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    static void calculate(boolean[] visited) {
        int start = 0;
        int link = 0;

        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (visited[i] && visited[j]) {
                    start += team[i][j];
                    start += team[j][i];
                } else if (!visited[i] && !visited[j]) {
                    link += team[i][j];
                    link += team[j][i];
                }
            }
        }

        int diff = Math.abs(start - link);
        compare = Math.min(diff, compare);
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            N = Integer.parseInt(br.readLine());

            team = new int[N + 1][N + 1];
            visited = new boolean[N + 1];

            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int j = 1;
                while (st.hasMoreTokens()) {
                    team[i][j++] = Integer.parseInt(st.nextToken());
                }
            }

            backTracking(0, 1);

            System.out.println(compare);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
