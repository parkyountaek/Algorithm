package day_27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGB {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int[][] dp = new int[N][3];
    for(int i = 0; i < N; i++){
      st = new StringTokenizer(br.readLine());
      int R = Integer.parseInt(st.nextToken());
      int G = Integer.parseInt(st.nextToken());
      int B = Integer.parseInt(st.nextToken());
      if(i == 0){
        dp[i][0] = R;
        dp[i][1] = G;
        dp[i][2] = B;
      } else {
        dp[i][0] = R + Math.min(dp[i-1][1], dp[i-1][2]);
        dp[i][1] = G + Math.min(dp[i-1][0], dp[i-1][2]);
        dp[i][2] = B + Math.min(dp[i-1][0], dp[i-1][1]);
      }
    }
    System.out.println(Math.min(Math.min(dp[N-1][0], dp[N-1][1]), dp[N-1][2]));
  }
}
