package day_38;

import java.io.*;
import java.util.*;

public class TreasureSearch {
  static int R; // row
  static int C; // col
  static int answer;

  static String[][] map; // treasure map
  static int[][] canMove = new int[][] { // 이동 가능한 부분
      { -1, 0 },
      { 1, 0 },
      { 0, -1 },
      { 0, 1 }
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());

    map = new String[R][C];

    for (int i = 0; i < R; i++) {
      st = new StringTokenizer(br.readLine());
      map[i] = st.nextToken().split("");
    }

    for (int i = 0; i < R; i++) {
      for (int j = 0; j < C; j++) {
        if (map[i][j].equals("L")) {
          int result = bfs(i, j);

          if (answer < result)
            answer = result;
        }
      }
    }

    System.out.println(answer);
  }

  public static int bfs(int x, int y) {
    boolean[][] isVisited = new boolean[R][C];
    Queue<Integer[]> queue = new LinkedList<>();
    int[][] longDistance = new int[R][C];
    int maxNum = 0;
    queue.add(new Integer[] { x, y });

    while (!queue.isEmpty()) {

      // queue 하나 빼기
      Integer[] current = queue.poll();

      // 방문 여부 변경
      isVisited[current[0]][current[1]] = true;
      for (int i = 0; i < canMove.length; i++) {
        // 다음 위치
        Integer[] next = new Integer[] { current[0] + canMove[i][0], current[1] + canMove[i][1] };

        // index 벗어날때 continue
        if (next[0] < 0 || next[1] < 0 || next[0] >= R || next[1] >= C) {
          continue;
        }

        // "L"일때 queue add
        if (map[next[0]][next[1]].equals("L") && !isVisited[next[0]][next[1]]) {
          queue.add(new Integer[] { next[0], next[1] });
          longDistance[next[0]][next[1]] = Math.max(longDistance[current[0]][current[1]] + 1,
              longDistance[next[0]][next[1]]);
          if (maxNum < longDistance[next[0]][next[1]])
            maxNum = longDistance[next[0]][next[1]];
        }

      }
    }
    longDistance = null;
    // return Arrays.stream(longDistance)
    // .flatMapToInt(arr -> Arrays.stream(arr))
    // .max()
    // .getAsInt();
    return maxNum;
  }
}
