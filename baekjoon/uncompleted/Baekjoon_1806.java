package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_1806 {
  static int N;
  static int S;
  static int[] arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    S = Integer.parseInt(st.nextToken());
    arr = new int[N];
    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(arr);
    twoPointer();
  }

  public static void twoPointer() {
    int answer = Integer.MAX_VALUE;
    int start = 0, end = 0;
    int sum = 0;
    while (start <= end && end <= N) {
      if (sum >= S) {
        answer = Math.min(answer, end - start);
        sum -= arr[start++];
      } else if (sum < S) {
        sum += arr[end++];
      }
    }
    System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
  }
}
