package day_44;

import java.io.*;
import java.util.*;

public class GoodSequence {
  static int N;
  static Integer candidates[] = { 1, 2, 3 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());

    make("");
  }

  public static void make(String answer) {
    if (answer.length() == N) {
      System.out.println(answer);
      System.exit(0);
    }
    for (Integer candidate : candidates) {
      if (isGood(answer + candidate.toString()))
        make(answer + candidate.toString());
    }

  }

  public static boolean isGood(String sequence) {
    StringBuffer sb = new StringBuffer(sequence).reverse();
    for (int i = 1; i <= sb.length() / 2; i++) {
      if (sb.substring(0, i).equals(sb.substring(i, i * 2))) {
        return false;
      }
    }
    return true;
  }
}
