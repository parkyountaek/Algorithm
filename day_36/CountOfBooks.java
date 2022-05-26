package day_36;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CountOfBooks {
  static int N;
  static int[] counts = new int[10];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    if(N < 10)
      Arrays.fill(counts, 1, N, 1);
    else {
      
    }

  }
}
