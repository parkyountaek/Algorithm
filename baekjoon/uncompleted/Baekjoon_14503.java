package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_14503 {
  static int N, M, r, c, d;
  static int[][] map;
  static int[] go_r = new int[] { 0, -1, 0, 1 };
  static int[] go_c = new int[] { -1, 0, 1, 0 };

  public static class Robot {
    int row;
    int col;
    int count;
    int direction;

    public Robot(int row, int col, int count, int direction) {
      this.row = row;
      this.col = col;
      this.count = count;
      this.direction = direction;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    map = new int[N][M];

    /**
     * 현재 위치, 방향 입력
     */
    st = new StringTokenizer(br.readLine());
    r = Integer.parseInt(st.nextToken()) - 1;
    c = Integer.parseInt(st.nextToken()) - 1;
    d = Integer.parseInt(st.nextToken());

    /**
     * map 입력
     */
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        map[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    solution();
  }

  public static void solution() {
    Queue<Robot> queue = new LinkedList<>();
    if (map[r][c] == 1)
      queue.add(new Robot(r, c, 0, d));
    else
      queue.add(new Robot(r, c, 1, d));
    map[r][c] = 1;
    while (!queue.isEmpty()) {
      Robot now = queue.poll();
      map[now.row][now.col] = 1;
      /**
       * 4방향 탐색
       */
      boolean flag = true;
      /**
       * 현재 방향을 기준으로 왼쪽 부터 탐색 필요
       */
      for (int i = 0; i < 4; i++) {
        if (check(now.row + go_r[(i + now.direction) % 4], now.col + go_c[(i + now.direction) % 4])) {
          queue.add(new Robot(now.row + go_r[(i + now.direction) % 4], now.col + go_c[(i + now.direction) % 4],
              now.count + 1, (i + now.direction) % 4));
          flag = false;
          break;
        }
      }
      if (!flag)
        continue;
      if (now.direction == 0) {
        if (0 <= now.row + 1 && now.row + 1 < N) {
          queue.add(new Robot(now.row + 1, now.col, now.count, now.direction));
        } else {
          System.out.println(now.count);
          return;
        }
      } else if (now.direction == 1) {
        if (0 <= now.col - 1 && now.col - 1 < M) {
          queue.add(new Robot(now.row, now.col - 1, now.count, now.direction));
        } else {
          System.out.println(now.count);
          return;
        }
      } else if (now.direction == 2) {
        if (0 <= now.row - 1 && now.row - 1 < N) {
          queue.add(new Robot(now.row - 1, now.col, now.count, now.direction));
        } else {
          System.out.println(now.count);
          return;
        }
      } else {
        if (0 <= now.col + 1 && now.col + 1 < M) {
          queue.add(new Robot(now.row, now.col + 1, now.count, now.direction));
        } else {
          System.out.println(now.count);
          return;
        }
      }
    }
  }

  public static boolean check(int r, int c) {
    if ((0 <= r && r < N) && (0 <= c && c < M)) {
      if (map[r][c] == 0)
        return true;
    }
    return false;
  }
}
