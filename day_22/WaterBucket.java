package day_22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class WaterBucket{
  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());
    int store = 0; // 구매해야하는 물병의 수

    while(true) {
      int tmp = N + store;
      int count = 0; // K와 비교하기 위해 개수 셈, 합쳐지지 못하고 남은 병의 수(2의 n승이 아닐때 count 증가됨!)
      while(tmp > 0) {
        if(tmp % 2 != 0)
          count++;
        tmp /= 2;
      }
      if(count <= K)
        break;

      store++;
    }
    System.out.println(store);
  }
}
