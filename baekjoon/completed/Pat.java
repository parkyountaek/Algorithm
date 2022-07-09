package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Pat {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String L = st.nextToken();
    String R = st.nextToken();

    int count = 0;
    if (L.length() == R.length()) { // 같은 자리의 수가 아니면 0 리턴
      for (int i = 0; i < L.length(); i++) {
        if (L.charAt(i) != R.charAt(i)) // L과 R의 앞자리가 다를때 고려, ex 800 900
          break;
        if (L.charAt(i) == '8')
          count++;
      }
    }
    System.out.println(count);
  }
}
