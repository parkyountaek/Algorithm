package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* baekjoon 2003 two pointer */
public class SumOfNumbers {
  static int N;
  static int M;
  static int A[];
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {

      A[i] = Integer.parseInt(st.nextToken());
    }
    twoPointer(A);
    System.out.println(count);
  }

  public static void twoPointer(int[] arr) {
    int start = 0;
    int end = 0;
    int sum = 0;
    while (true) {
      if (sum >= M) {
        sum -= arr[start++];
      } else if (end == N) {
        break;
      } else {
        sum += arr[end++];
      }

      if (sum == M) {
        count++;
      }

    }
  }
}