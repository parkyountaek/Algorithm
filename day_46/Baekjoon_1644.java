package day_46;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_1644 {
  static int N;
  static boolean[] isPrime;
  static int count;
  static List<Integer> primeSet = new ArrayList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    isPrime = new boolean[N + 1];
    // 에라토스테네스의 체 사용
    setPrime();
    twoPointer();
    System.out.println(count);
  }

  // 에라토스테네스의 체
  static void setPrime() {
    for (int i = 2; i * i <= N; i++) {
      for (int j = i * i; j <= N; j += i) {
        isPrime[j] = true;
      }
    }
    for (int i = 2; i <= N; i++)
      if (isPrime[i] == false)
        primeSet.add(i);
  }

  static void twoPointer() {
    int sum = 0;
    int start = 0;
    int end = 0;
    while (true) {
      if (sum >= N)
        sum -= primeSet.get(start++);
      else if (end == primeSet.size())
        break;
      else
        sum += primeSet.get(end++);

      if (sum == N)
        count++;
    }
  }
}
