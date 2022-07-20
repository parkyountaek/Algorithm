package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BaekJoon_14500 {
  static int result;
  static int[][] borad;
  static int[][] isVisited;
  static int N;
  static int M;
  static int[] moveR = { -1, 1, 0, 0 };
  static int[] moveC = { 0, 0, -1, 1 };

  public static class Point {
    int r;
    int c;
    boolean isVertical;
    boolean isHorizen;
    Point mid;

    public Point(int r, int c, boolean isVertical, boolean isHorizen) {
      this.r = r;
      this.c = c;
      this.isVertical = isVertical;
      this.isHorizen = isHorizen;
    }

    public void setIsVertical(boolean isVertical) {
      this.isVertical = isVertical;
    }

    public void setIsHorizen(boolean isHorizen) {
      this.isHorizen = isHorizen;
    }

    public void setMid(Point mid) {
      this.mid = mid;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    borad = new int[N][M];
    isVisited = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        borad[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        isVisited[i][j] = 1;
        dfs(new Point(i, j, false, false), 0, borad[i][j]);
        isVisited[i][j] = 0;
      }
    }

    System.out.println(result);
  }

  public static void dfs(Point point, int depth, int value) {
    if (depth == 3) {
      // result = Math.max(result, value);
      if (result < value) {
        result = value;
        System.out.println("=========================");
        for (int i = 0; i < N; i++)
          System.out.println(Arrays.toString(isVisited[i]));
        System.out.println("=========================");
      }

      return;
    }

    boolean isVertical = false;
    boolean isHorizen = false;
    Point mid;
    // 가운데로 탐색
    if (depth == 2) {
      if ((point.isHorizen && !point.isVertical) || (!point.isHorizen && point.isVertical)) {
        System.out.println("======dddddddd=====" + point.isHorizen + "==" + point.isVertical + "=");
        for (int i = 0; i < N; i++)
          System.out.println(Arrays.toString(isVisited[i]));
        System.out.println("======dddddddd========");
        for (int i = -1; i < 2; i += 2) {
          if (point.isHorizen) {
            int currentR = point.mid.r + i;
            if (0 <= currentR && currentR < N) {
              isVisited[currentR][point.c] = 1;
              dfs(new Point(currentR, point.c, isVertical, isHorizen), depth + 1, value + borad[currentR][point.c]);
              isVisited[currentR][point.c] = 0;
            }
          } else if (point.isVertical) {
            int currentC = point.mid.c + i;
            if (0 <= currentC && currentC < N) {
              isVisited[point.r][currentC] = 1;
              dfs(new Point(point.r, currentC, isVertical, isHorizen), depth + 1, value + borad[point.r][currentC]);
              isVisited[point.r][currentC] = 0;
            }
          }
        }
      }
    }

    for (int i = 0; i < 4; i++) {
      int currentR = point.r + moveR[i];
      int currentC = point.c + moveC[i];

      if ((moveR[i] == -1 || moveR[i] == 1) && moveC[i] == 0)
        isVertical = true;
      if ((moveC[i] == -1 || moveC[i] == 1) && moveR[i] == 0)
        isHorizen = true;

      if (0 <= currentR && currentR < N && 0 <= currentC && currentC < M && isVisited[currentR][currentC] == 0) {
        isVisited[currentR][currentC] = 1;
        Point next = new Point(currentR, currentC, isVertical, isHorizen);
        if (depth == 1) {
          mid = new Point(currentR, currentC, isVertical, isHorizen);
          next.setMid(mid);
        }

        dfs(next, depth + 1, value + borad[currentR][currentC]);
        isVisited[currentR][currentC] = 0;
      }
    }
  }
}
