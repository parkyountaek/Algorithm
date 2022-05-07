package day_32;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BlackJack {
  static int N, M;
  static int[] card;
  static int total = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    card = new int[N];

    st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++)
      card[i] = Integer.parseInt(st.nextToken());
    for (int i = 0; i < N - 2; i++) {
      for (int j = i + 1; j < N - 1; j++) {
        for (int k = j + 1; k < N; k++) {
          if (card[i] + card[j] + card[k] <= M && card[i] + card[j] + card[k] > total) {
            total = card[i] + card[j] + card[k];
            System.out.println(String.format("%d %d %d = %d", card[i], card[j], card[k], total));
          }
        }
      }
    }
    System.out.println(total);

  }
}
