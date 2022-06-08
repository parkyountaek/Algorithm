package day_40;

import java.util.*;
import java.io.*;

public class HidePlay {
  /* baekjoon 1697 */

  public static class Location {
    int time;
    int position;

    Location(int time, int position) {
      this.time = time;
      this.position = position;
    }
  }

  static int N;
  static int K;
  static Queue<Location> queue;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    queue = new LinkedList<>();
    visited = new boolean[100001];
    bfs();

    // Runtime.getRuntime().gc();
    // long usedMemory = Runtime.getRuntime().totalMemory() -
    // Runtime.getRuntime().freeMemory();
    // System.out.print(usedMemory + " bytes");
  }

  public static void bfs() {
    queue.add(new Location(0, N));
    visited[N] = true;
    while (!queue.isEmpty()) {
      Location current = queue.poll();

      if (current.position == K) {
        System.out.println(current.time);
        return;
      }
      if (0 <= current.position - 1 && !visited[current.position - 1]) {
        queue.add(new Location(current.time + 1, current.position - 1));
        visited[current.position - 1] = true;
      }
      if (current.position + 1 < visited.length && !visited[current.position + 1]) {
        queue.add(new Location(current.time + 1, current.position + 1));
        visited[current.position + 1] = true;
      }
      if (current.position * 2 < visited.length && !visited[current.position * 2]) {
        queue.add(new Location(current.time + 1, current.position * 2));
        visited[current.position * 2] = true;
      }
    }
  }

}
