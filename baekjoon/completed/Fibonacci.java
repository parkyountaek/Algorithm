package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Fibonacci {
  static int T, N;
  static Integer[][] dp = new Integer[2][41];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    T = Integer.parseInt(st.nextToken());
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

    for (int i = 0; i < T; i++) {
      st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken());
      fibonacci(N);
      System.out.println(String.format("%d %d", dp[0][N], dp[1][N]));
    }
  }

  private static void fibonacci(int n) {
    if (dp[0][n] != null && dp[0][1] != null)
      return;
    for (int i = 2; i <= n; i++) {
      if (dp[0][i] == null && dp[1][i] == null) {
        dp[0][i] = dp[0][i - 2] + dp[0][i - 1];
        dp[1][i] = dp[1][i - 2] + dp[1][i - 1];
      }
    }
  }
}