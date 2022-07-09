package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1717 {
  static int n;
  static int m;
  static int[] set;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    set = new int[n + 1];
    for (int i = 0; i < n + 1; i++)
      set[i] = i;
    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int check = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (check == 1) {
        if (isSameParent(a, b))
          System.out.println("YES");
        else
          System.out.println("NO");
      } else {
        union(a, b);
      }
    }
  }

  public static int find(int x) {
    if (x == set[x])
      return x;
    return set[x] = find(set[x]);
  }

  public static void union(int x, int y) {
    x = find(x);
    y = find(y);
    if (x != y) {
      set[y] = x;
    }
  }

  public static boolean isSameParent(int x, int y) {
    x = find(x);
    y = find(y);

    return x == y;
  }

}
