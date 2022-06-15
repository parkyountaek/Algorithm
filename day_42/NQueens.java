package day_42;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/* baekjoon 9663 */
public class NQueens {
  static int N;
  static int answer;
  static int[][] chess; // chess 판
  static boolean[][] isVisited; // 방문 여부

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    chess = new int[N][N];
    isVisited = new boolean[N][N];

    dfs(0);

    System.out.println(answer);
  }

  public static void dfs(int depth) {

    if (depth == N) {
      // System.out.println("=".repeat(25));
      // for (int i = 0; i < N; i++)
      // System.out.println(Arrays.toString(chess[i]));
      // System.out.println("=".repeat(25));
      answer++;
      return;
    }

    for (int i = 0; i < N; i++) {
      if (canPut(chess, depth, i)) {
        chess[depth][i] = 1;
        dfs(depth + 1);
        chess[depth][i] = 0;
      }
    }
  }

  public static boolean canPut(int[][] map, int row, int col) {
    // 세로 확인
    for (int i = 0; i < N; i++)
      if (map[i][col] == 1)
        return false;

    // 우상-좌하 방향
    int pRow = row - 1;
    int pCol = col + 1;
    while (pRow >= 0 && pCol < N) {
      if (map[pRow--][pCol++] == 1)
        return false;
    }

    // 좌상-우하 방향
    pRow = row - 1;
    pCol = col - 1;
    while (pCol >= 0 && pRow >= 0) {
      if (map[pRow--][pCol--] == 1)
        return false;
    }

    return true;
  }
}
