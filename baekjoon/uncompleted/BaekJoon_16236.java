package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BaekJoon_16236 {
  static int N;
  static int M;
  static int time;
  static int[][] matrix;
  static boolean[][] isVisited;
  static int[] moveR = { -1, 1, 0, 0 };
  static int[] moveC = { 0, 0, -1, 1 };
  static Queue<Fish> queue;

  public static class Fish {
    int r;
    int c;
    int distance;
    int sharkSize;
    int count;

    public Fish(int r, int c, int distance, int sharkSize, int count) {
      this.r = r;
      this.c = c;
      this.distance = distance;
      this.sharkSize = sharkSize;
      this.count = count;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    matrix = new int[N][N];
    isVisited = new boolean[N][N];
    queue = new LinkedList<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < st.countTokens(); j++) {
        int value = Integer.parseInt(st.nextToken());
        matrix[i][j] = value;
        if (value == 9) {
          queue.add(new Fish(i, j, 0, 2, 0));
          matrix[i][j] = 0;
        }
      }
    }
    while (true) {

    }

  }

  public static void bfs() {
    while (queue.isEmpty()) {
      Fish currnet = queue.poll();

      for (int i = 0; i < 4; i++) {
        int cr = currnet.r + moveR[i];
        int cc = currnet.c + moveC[i];
        if (0 <= cc && cc < N && 0 <= cr && cr < N) {
          if (currnet.sharkSize >= matrix[cr][cc] && matrix[cr][cc] != 0) {
            queue.add(new Fish(cr, cc, currnet.distance + 1, currnet.sharkSize + 1, currnet.count + 1));
            matrix[cr][cc] = 0;
          }
        }

      }
    }
  }
}
