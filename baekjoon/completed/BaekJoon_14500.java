package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_14500 {
  static int result;
  static int[][] board;
  static int[][] isVisited;
  static int N;
  static int M;
  static int[] moveR = { -1, 1, 0, 0 };
  static int[] moveC = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    isVisited = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        isVisited[i][j] = 1;
        dfs(i, j, 0, board[i][j]);
        isVisited[i][j] = 0;
        check(i, j);
      }
    }

    System.out.println(result);
  }

  public static void dfs(int r, int c, int depth, int value) {
    if (depth == 3) {
      result = Math.max(result, value);
      // 출력
      // if (result < value) {
      // result = value;
      // System.out.println("=========================");
      // for (int i = 0; i < N; i++)
      // System.out.println(Arrays.toString(isVisited[i]));
      // System.out.println("=========================");
      // }

      return;
    }

    for (int i = 0; i < 4; i++) {
      int currentR = r + moveR[i];
      int currentC = c + moveC[i];

      if (0 <= currentR && currentR < N && 0 <= currentC && currentC < M && isVisited[currentR][currentC] == 0) {
        isVisited[currentR][currentC] = 1;

        dfs(currentR, currentC, depth + 1, value + board[currentR][currentC]);
        isVisited[currentR][currentC] = 0;
      }
    }
  }

  static void check(int r, int c) {
    // 시작점 왼쪽 위 상단
    if (r < N - 2 && c < M - 1) // ㅏ
      result = Math.max(result, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 1][c + 1]);

    if (r < N - 2 && c > 0) // ㅓ
      result = Math.max(result, board[r][c] + board[r + 1][c] + board[r + 2][c] + board[r + 1][c - 1]);

    if (r < N - 1 && c < M - 2) // ㅜ
      result = Math.max(result, board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r + 1][c + 1]);

    if (r > 0 && c < M - 2) // ㅗ
      result = Math.max(result, board[r][c] + board[r][c + 1] + board[r][c + 2] + board[r - 1][c + 1]);
  }
}
