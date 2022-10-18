package baekjoon.uncompleted;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baekjoon_2470 {
  static int N;
  static int[] set;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    set = new int[N];
    st = new StringTokenizer(br.readLine());
    for(int i = 0; i < N; i++) {
      set[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(set);
    
    two_pointer(set);
  }

  public static void two_pointer(int[] set) {
    int start =0, end = 0, total = 0;
    while(true) {
      
    }
  }
}
