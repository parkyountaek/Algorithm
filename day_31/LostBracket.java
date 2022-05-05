package day_31;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LostBracket {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String[] word = st.nextToken().split("-");
    int answer;
    for (int i = 0; i < word.length; i++) {
      word[i] = plusExpression(word[i]);
    }
    answer = Integer.parseInt(word[0]);
    for (int i = 1; i < word.length; i++) {
      answer -= Integer.parseInt(word[i]);
    }
    System.out.println(answer);
  }

  private static String plusExpression(String expression) {
    String[] ex = expression.split("\\+"); // <- Dangling meta character error => '\\' 붙여주기
    int value = 0;
    for (int i = 0; i < ex.length; i++) {
      value += Integer.parseInt(ex[i]);
    }
    return Integer.toString(value);
  }
}
