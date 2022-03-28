package day_28;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Home {
  static int R, C, K;
  static int[][] visited;
  static char[][] road;
  static int count;
  static int[] rowMove = {-1, 1, 0, 0};
  static int[] colMove = {0, 0, -1, 1};
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    visited = new int[R][C];
    road = new char[R][C];

    for(int i = 0; i < R; i++){
      st = new StringTokenizer(br.readLine());
      String map = st.nextToken();
      for(int j = 0; j < map.length(); j++){
        road[i][j] = map.charAt(j);
      }
    }

    visited[R-1][0] = 1;
    backTracking(R-1, 0, 1);
    System.out.println(count);
  }
  private static void backTracking(int r, int c, int moved) {
    if(c == C-1 && r == 0){
      if(moved == K)
        count++;
      return;
    }
    for(int i = 0; i < 4; i++){
      int nextR = r + rowMove[i];
      int nextC = c + colMove[i];
      if(nextR < 0 || nextC < 0 || nextR >= R || nextC >= C)
        continue;
      if(visited[nextR][nextC] == 1 || road[nextR][nextC] == 'T')
        continue;
      
      visited[nextR][nextC] = 1;
      backTracking(nextR, nextC, moved+1);
      visited[nextR][nextC] = 0;
    }
  }
}
