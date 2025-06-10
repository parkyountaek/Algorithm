package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon30805 {
    static int N, M;
    static List<Integer> A = new ArrayList<>();
    static List<Integer> B = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }

        int aMax = Collections.max(A);
        int bMax = Collections.max(B);
        int maxValue = Math.max(aMax, bMax);

        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        for(int i = maxValue; i >= 0; i--) {
            while(true) {
                int aIndex = A.indexOf(i);
                int bIndex = B.indexOf(i);

                if(aIndex == -1 || bIndex == -1)
                    break;
                A = new ArrayList<>(A.subList(aIndex + 1, A.size()));
                B = new ArrayList<>(B.subList(bIndex + 1, B.size()));

                sb.append(i).append(" ");
                cnt++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb);
    }
}
