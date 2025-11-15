package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BaekJoon15961 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // N: 접시 수, d: 초밥 종류 수, k: 연속해서 먹는 개수, c: 쿠폰 번호
        int[] input = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int N = input[0];
        int d = input[1];
        int k = input[2];
        int c = input[3];

        int[] dishes = new int[N];
        for (int i = 0; i < N; i++) {
            dishes[i] = Integer.parseInt(br.readLine());
        }

        int[] count = new int[d + 1]; // 초밥 번호 1~d
        int unique = 0;               // 현재 윈도우의 서로 다른 초밥 개수
        int answer = 0;

        // 1. 초기 윈도우 구성 (0 ~ k-1)
        for (int i = 0; i < k; i++) {
            int sushi = dishes[i];
            if (count[sushi] == 0) unique++; // 처음 등장하면 종류 +1
            count[sushi]++;
        }

        // 2. 초기 최대값 계산 (쿠폰 포함 여부)
        answer = unique + (count[c] == 0 ? 1 : 0);

        // 3. 슬라이딩 윈도우
        for (int start = 1; start < N; start++) {
            // 빠지는 초밥
            int remove = dishes[start - 1];
            count[remove]--;
            if (count[remove] == 0) unique--;

            // 새로 들어오는 초밥 (원형 배열 처리)
            int add = dishes[(start + k - 1) % N];
            if (count[add] == 0) unique++;
            count[add]++;

            // 쿠폰 포함 최대값 계산
            int current = unique + (count[c] == 0 ? 1 : 0);
            answer = Math.max(answer, current);

            // 최대치 도달 시 종료 (k + 1)
            if (answer == k + 1) break;
        }

        System.out.println(answer);
    }
}
