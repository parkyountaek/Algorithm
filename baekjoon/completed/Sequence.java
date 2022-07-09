package baekjoon.completed;

import java.io.*;
import java.util.*;

public class Sequence {
  static int N, K;
  static ArrayList<Integer> array = new ArrayList<>();
  static String[] numbers;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    for (String number : st.nextToken().split(","))
      array.add(Integer.parseInt(number));
    calculateSeq(0);
    String result = array.toString().replace("[", "").replace("]", "").replace(", ", ",");
    System.out.println(result);
  }

  public static void calculateSeq(int depth) {
    if (depth == K)
      return;
    for (int i = 0; i < array.size() - 1; i++)
      array.set(i, array.get(i + 1) - array.get(i));
    array.remove(array.size() - 1);
    calculateSeq(depth + 1);
  }
}
