package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Procession {
  public static int[][] A;
  public static int[][] B;

  public static void toggle(int r, int c) {
    for (int i = r; i < r + 3; i++) {
      for (int j = c; j < c + 3; j++) {
        A[i][j] = A[i][j] ^ 1;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    A = new int[N][M];
    B = new int[N][M];
    int cnt = 0;

    // A 행렬 먼저 받기
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        A[i][j] = row.charAt(j) - '0';
      }
    }

    // B 행렬 먼저 받기
    for (int i = 0; i < N; i++) {
      String row = br.readLine();
      for (int j = 0; j < M; j++) {
        B[i][j] = row.charAt(j) - '0';
      }
    }

    for (int i = 0; i < N - 2; i++) {
      for (int j = 0; j < M - 2; j++) {
        if (A[i][j] != B[i][j]) {
          toggle(i, j);
          cnt += 1;
        }
      }
    }

    int flag = 0;
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (A[i][j] == B[i][j])
          flag++;
      }
    }

    if (flag == N * M)
      System.out.println(cnt);
    else
      System.out.println(-1);
  }

}
