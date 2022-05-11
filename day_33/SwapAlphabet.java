package day_33;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SwapAlphabet {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuffer word = new StringBuffer(st.nextToken());

    for (int i = 0; i < word.length(); i++) { // A: 65, a: 97, 32 차이 / Z: 90, z:122
      if (65 <= word.charAt(i) && word.charAt(i) < 91)
        word.replace(i, i + 1, Character.toString((char) (word.charAt(i) + 32)));
      else if (97 <= word.charAt(i) && word.charAt(i) < 123)
        word.replace(i, i + 1, Character.toString((char) (word.charAt(i) - 32)));
    }
    System.out.println(word.toString());

  }
}
