package day_23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ZProblem {
  static int count = 0;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int r = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());
    int size = (int) Math.pow(2, N);
    divideAndConquer(size, r, c);
    System.out.println(count);
  }


  public static void divideAndConquer(int size, int r, int c){
    if(size == 1)
      return;
    int line = size / 2;
    if(r < line && c < line){ // 1사분면
      divideAndConquer(line, r, c);
    } else if(r < line && c >= line){ // 2사분면
      count += line*line;
      divideAndConquer(line, r, c-line);
    } else if(r >= line && c < line){ // 3사분면
      count += line*line*2;
      divideAndConquer(line, r-line, c); 
    }  else { // 4사분면
      count += line*line*3;
      divideAndConquer(line, r-line, c-line);
    }
  }
}
