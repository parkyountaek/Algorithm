package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon7453 {
    static int[] A;
    static int[] B;
    static int[] C;
    static int[] D;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n * n];
        int[] CD = new int[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long count = 0L;
        int left = 0;
        int right = CD.length - 1;

        while (left < AB.length && right >= 0) {
            int sum = AB[left] + CD[right];

            if (sum == 0) {
                int abVal = AB[left];
                int abCount = 0;
                while (left < AB.length && AB[left] == abVal) {
                    left++;
                    abCount++;
                }

                int cdVal = CD[right];
                int cdCount = 0;
                while (right >= 0 && CD[right] == cdVal) {
                    right--;
                    cdCount++;
                }

                count += (long) abCount * cdCount;

            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(count);
    }
}
