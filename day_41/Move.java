package day_41;

import java.util.*;
import java.io.*;

/* baekjoon 2206 */

public class Move {
  public static class Location {
    int r;
    int c;
    int distance;
    boolean isCrash;

    public Location(int r, int c, int distance, boolean isCrash) {
      this.r = r;
      this.c = c;
      this.distance = distance;
      this.isCrash = isCrash;
    }
  }

  static int N;
  static int M;
  static int[][] map;
  static boolean[][] visited;
  static int[][] canMove = {
      { -1, 0 },
      { 1, 0 },
      { 0, -1 },
      { 0, 1 },
  };
  static Queue<Location> queue;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    queue = new LinkedList<>();
    map = new int[N][M];
    visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String[] mapElements = st.nextToken().split("");
      for (int j = 0; j < M; j++)
        map[i][j] = Integer.parseInt(mapElements[j]);
    }

    bfs(0, 0, false);

  }

  public static void bfs(int r, int c, boolean isCrash) {
    queue.add(new Location(r, c, 1, isCrash));
    visited[r][c] = true;

    while (!queue.isEmpty()) {
      Location current = queue.poll();

      if (current.r == N - 1 && current.c == M - 1) {
        System.out.println(current.distance);
        return;
      }

      for (int i = 0; i < canMove.length; i++) {
        int nextR = current.r + canMove[i][0];
        int nextC = current.c + canMove[i][1];

        if ((0 <= nextR && nextR < N) && (0 <= nextC && nextC < M && !visited[nextR][nextC])) {
          if (map[nextR][nextC] == 0) { // 벽이 아니면
            visited[nextR][nextC] = true;
            queue.add(new Location(nextR, nextC, current.distance + 1, current.isCrash));
          } else { // 벽이면
            if (!current.isCrash) {
              visited[nextR][nextC] = true;
              queue.add(new Location(nextR, nextC, current.distance + 1, true));
            }
          }
        }
      }
    }
    System.out.println("-1");
  }
}
