package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CardSort_1715 {
  static int N;
  static PriorityQueue<Long> cardSet;
  static Long count = 0l;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    cardSet = new PriorityQueue<>();

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      cardSet.add(Long.parseLong(st.nextToken()));
    }

    while (cardSet.size() > 1) {
      long front = cardSet.poll();
      long back = cardSet.poll();

      count += front + back;
      cardSet.add(front + back);
    }

    System.out.println(count);
  }
}
