package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon1759 {
    static int L, C;
    static char[] secret;
    static boolean[] visited;
    static char[] vowl = {'a', 'e', 'i', 'o', 'u'};
    static StringBuilder sb = new StringBuilder();

    static void backTracking(int currentIdx, String answer) {
        if(answer.length() == L) {
            if(isValid(answer))
                sb.append(answer).append("\n");
            return;
        }

        for(int i = 0; i < C; i++) {
            if(!visited[i] && currentIdx < i) {
                visited[i] = true;
                answer += secret[i];
                backTracking(i, answer);
                answer = answer.substring(0, answer.length() - 1);
                visited[i] = false;
            }
        }
    }

    static boolean isValid(String answer) {
        int cnt = 0;
        for(char c: vowl) {
            if(answer.indexOf(c) != -1) {
                cnt++;
            }
        }
        if(cnt >= 1 && answer.length() - cnt >= 2)
            return true;
        return false;
    }

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            secret = new char[C];
            visited = new boolean[C];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i<C; i++) {
                secret[i] = st.nextToken().charAt(0);
            }

            Arrays.sort(secret);


            backTracking(-1, "");

            System.out.println(sb);
        } catch (Exception e) {

        }
    }
}
