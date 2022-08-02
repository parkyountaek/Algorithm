package baekjoon.completed;

import java.io.*;
import java.util.*;

public class Baekjoon_10814 {
  static Map<Integer, List<String>> map;
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    map = new HashMap<>();
    N = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      int key = Integer.parseInt(st.nextToken());
      String value = st.nextToken();
      if (map.containsKey(key)) {
        List<String> values = map.get(key);
        values.add(value);
        map.put(key, values);
      } else {
        List<String> values = new ArrayList<>();
        values.add(value);
        map.put(key, values);
      }
    }

    for (Integer key : map.keySet()) {
      for (String value : map.get(key)) {
        System.out.println(key + " " + value);
      }
    }
  }
}
