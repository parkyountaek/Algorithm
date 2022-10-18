package baekjoon.uncompleted;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Baekjoon_1253 {
  static int N;
  static List<Integer> arr;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    arr = Arrays.stream(br.readLine().split(" "))
        .map(Integer::parseInt)
        .collect(Collectors.toList());
    Collections.sort(arr);
    twoPointer();
  }

  public static void twoPointer() {
    int answer = 0;
    for (int i = 0; i < N; i++) {
      int start = 0, end = i - 1;
      while (start < end) {
        if (arr.get(start) + arr.get(end) < arr.get(i)) {
          start++;
        } else if (arr.get(start) + arr.get(end) < arr.get(i)) {
          end++;
        } else {
          answer++;
          break;
        }
      }
    }
    System.out.println(answer);
  }
}
