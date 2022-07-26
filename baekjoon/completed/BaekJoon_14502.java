package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_14502 {
  static int[][] board;
  static int N;
  static int M;
  static int count;
  static int[] moveR = { -1, 1, 0, 0 };
  static int[] moveC = { 0, 0, -1, 1 };
  static Queue<Location> queue;

  public static class Location {
    int r;
    int c;

    public Location(int r, int c) {
      this.r = r;
      this.c = c;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    board = new int[N][M];
    queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        board[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    makeWall(0);
    System.out.println(count);
  }

  public static void makeWall(int depth) {
    if (depth == 3) {
      bfs();
      return;
    }
    int[][] copyMatrix = new int[N][M];
    for (int i = 0; i < N; i++) {
      copyMatrix[i] = Arrays.copyOfRange(board[i], 0, M);
    }
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 0) {
          board[i][j] = 1;
          makeWall(depth + 1);
          board[i][j] = 0;
        }
      }
    }
  }

  public static void bfs() {
    Queue<Location> Q = new LinkedList<>(queue);
    int[][] matrix = new int[N][M];

    for (int i = 0; i < N; i++) {
      matrix[i] = board[i].clone();
      for (int j = 0; j < M; j++) {
        if (board[i][j] == 2)
          Q.add(new Location(i, j));
      }
    }

    while (!Q.isEmpty()) {
      Location current = Q.poll();

      for (int i = 0; i < 4; i++) {
        int currentR = current.r + moveR[i];
        int currentC = current.c + moveC[i];

        if (0 <= currentR && currentR < N && 0 <= currentC && currentC < M) {
          if (matrix[currentR][currentC] == 0) {
            matrix[currentR][currentC] = 2;
            Q.add(new Location(currentR, currentC));
          }
        }
      }
    }
    compareCount(matrix);
  }

  public static void compareCount(int[][] matrix) {
    int c = 0;
    for (int i = 0; i < N; i++)
      for (int j = 0; j < M; j++)
        if (matrix[i][j] == 0)
          c++;
    count = Math.max(c, count);
  }
}
