package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class BaekJoon_2941 {
  static Set<String> candidate = new HashSet<>(
      Set.of("c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="));
  static StringBuffer str;
  static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    str = new StringBuffer(st.nextToken());

    while (str.length() != 0) {
      if (str.length() >= 3 && candidate.contains(str.substring(0, 3))) {
        str = new StringBuffer(str.substring(3));
      } else if (str.length() >= 2 && candidate.contains(str.substring(0, 2))) {
        str = new StringBuffer(str.substring(2));
      } else {
        str = new StringBuffer(str.substring(1));
      }

      count++;
    }
    System.out.println(count);
  }
}
