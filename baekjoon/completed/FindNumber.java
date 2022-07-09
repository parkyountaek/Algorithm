package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class FindNumber {
  static int N, M;
  static int[] A;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    A = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(A);

    st = new StringTokenizer(br.readLine());
    M = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < M; i++) {
      int result = Arrays.binarySearch(A, Integer.parseInt(st.nextToken()));

      if (result >= 0)
        System.out.println("1");
      else
        System.out.println("0");
    }
  }
}
