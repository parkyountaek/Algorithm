package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    String word = st.nextToken();
    int wordLength = word.length();
    for (int i = 0; i < word.length(); i++) {
      if (isPalindrom(word.substring(i))) {
        break;
      }
      wordLength++;
    }
    System.out.println(wordLength);
  }

  private static boolean isPalindrom(String s) {
    int start = 0;
    int last = s.length() - 1;
    while (start <= last) {
      if (s.charAt(start) != s.charAt(last))
        return false;
      start++;
      last--;
    }
    return true;
  }
}
