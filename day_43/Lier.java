package day_43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/* baekjoon 1043 */
public class Lier {
  static int N;
  static int M;
  static int truth;
  static HashMap<Integer, Boolean> knowPeople;
  static int answer;

  /* not yet */
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    knowPeople = new HashMap<>();
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < N; i++) {
      knowPeople.put(i + 1, false);
    }

    truth = Integer.parseInt(st.nextToken());
    if (truth == 0) {
      System.out.println(M);
      return;
    }

    for (int i = 0; i < truth; i++)
      knowPeople.put(Integer.parseInt(st.nextToken()), true);

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int numberOfPerson = Integer.parseInt(st.nextToken());
      boolean flag = false;
      for (int j = 0; j < numberOfPerson; j++) {
        if (knowPeople.get(Integer.parseInt(st.nextToken()))) {
          flag = true;
          break;
        }
      }

      if (!flag)
        answer++;
    }
    System.out.println(answer);

  }

}
