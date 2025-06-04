package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2644 {
    static int[][] person;
    static boolean[] visited;
    static int n, personA, perssnB, m;

    static int DFS(int current, int answer) {
        visited[current] = true;

        if(current == perssnB)
            return answer;

        for(int i = 0; i < n; i++) {
            if(!visited[i] && person[current][i] == 1) {
                int result = DFS(i, answer + 1);
                if (result != -1) return result;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        person = new int[n][n];
        visited = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        personA = Integer.parseInt(st.nextToken()) - 1;
        perssnB = Integer.parseInt(st.nextToken()) - 1;

        m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            person[x - 1][y - 1] = 1;
            person[y - 1][x - 1] = 1;
        }

        int answer = 0;

        System.out.println(DFS(personA, answer));
    }
}
