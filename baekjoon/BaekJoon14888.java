package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon14888 {
    static int N;
    static int[] numbers;
    static boolean[] visited;
    static int[] operators;
    static long maxAnswer = Integer.MIN_VALUE;
    static long minAnswer = Integer.MAX_VALUE;

    public static void backTracking(int depth, long value) {
        if(depth == numbers.length) {
            maxAnswer = Math.max(value, maxAnswer);
            minAnswer = Math.min(value, minAnswer);

            return;
        }

        if(operators[0] > 0) {
            operators[0] -= 1;
            backTracking(depth + 1, value + numbers[depth]);
            operators[0] += 1;
        }
        if(operators[1] > 0) {
            operators[1] -= 1;
            backTracking(depth + 1, value - numbers[depth]);
            operators[1] += 1;
        }
        if(operators[2] > 0) {
            operators[2] -= 1;
            backTracking(depth + 1, value * numbers[depth]);
            operators[2] += 1;
        }
        if(operators[3] > 0){
            operators[3] -= 1;
            backTracking(depth + 1, value / numbers[depth]);
            operators[3] += 1;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];

        numbers = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        operators = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        backTracking(1, numbers[0]);

        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }
}
