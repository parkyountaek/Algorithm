package day_47;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1976 {
  static int N;
  static int M;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    parent = new int[N + 1];
    for (int i = 0; i < N + 1; i++)
      parent[i] = i;
    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());
    for (int i = 1; i <= N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 1; j <= N; j++) {
        int isConnect = Integer.parseInt(st.nextToken());
        if (isConnect == 1) {
          union(i, j);
        }
      }
    }

    st = new StringTokenizer(br.readLine());
    int current = Integer.parseInt(st.nextToken());
    for (int i = 1; i < M; i++) {
      int next = Integer.parseInt(st.nextToken());
      if (!isSameParent(current, next)) {
        System.out.println("NO");
        System.exit(0);
      }
    }
    System.out.println("YES");
  }

  public static int find(int x) {
    if (x == parent[x])
      return x;
    return parent[x] = find(parent[x]);
  }

  public static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if (x != y) {
      if (x < y)
        parent[y] = x;
      else
        parent[x] = y;
    }
  }

  public static boolean isSameParent(int x, int y) {
    x = find(x);
    y = find(y);

    return x == y;
  }

}
