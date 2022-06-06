package day_38;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class TreasureSearch {
  public static class Location {
    int row;
    int col;
    int distance;

    public Location(int row, int col, int distance) {
      this.row = row;
      this.col = col;
      this.distance = distance;
    }
  }

  static int R; // row
  static int C; // col
  static int answer;
  static boolean[][] isVisited;
  static int maxNum;
  static char[][] map; // treasure map
  static int[] canMoveR = { -1, 1, 0, 0 };
  static int[] canMoveC = { 0, 0, -1, 1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new char[R][C];

    for (int i = 0; i < R; i++) {
      map[i] = br.readLine().toCharArray();
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j] == 'L') {
          bfs(i, j);
        }
      }
    }
    Runtime.getRuntime().gc();
    long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    System.out.print(usedMemory + " bytes");
    System.out.println(answer);
    br.close();
  }

  public static void bfs(int x, int y) {
    isVisited = new boolean[R][C]; // visited check
    Queue<Location> queue = new LinkedList<Location>();
    maxNum = 0;
    queue.add(new Location(x, y, 0));
    isVisited[x][y] = true;
    while (!queue.isEmpty()) {
      // queue 하나 빼기
      Location current = queue.poll();

      for (int i = 0; i < 4; i++) {
        // 다음 위치
        int nextR = current.row + canMoveR[i];
        int nextC = current.col + canMoveC[i];

        // index 벗어나지 않을때
        if (nextR >= 0 && nextC >= 0 && nextR < R && nextC < C) {

          // "L"일때 queue add
          if (map[nextR][nextC] == 'L' && !isVisited[nextR][nextC]) {
            // 방문 여부 변경
            isVisited[nextR][nextC] = true;

            queue.add(new Location(nextR, nextC, current.distance + 1));
            answer = Math.max(answer, current.distance + 1);
          }
        }
      }
    }
  }
}
