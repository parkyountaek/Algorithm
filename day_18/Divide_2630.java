package day_18;

import java.io.*;
import java.util.StringTokenizer;

// public class Main {
public class Divide_2630 {
  static int[][] matrix;
  static int blue = 0;
  static int white = 0;
  public static void main(String[] args){
    try {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      matrix = new int[N][N];

      StringTokenizer st;

      for(int i = 0; i < N; i++){
        st = new StringTokenizer(br.readLine(), " ");
        for(int j = 0; j < N; j++){
          matrix[i][j] = Integer.parseInt(st.nextToken());
        }
      }
      solution(0,0,N);
      System.out.println(white);
      System.out.println(blue);
    } catch (IOException e){
      e.printStackTrace();
    }
  }

  public static void solution(int row, int col, int size){
    if(checking(row, col, size)){
      if(matrix[row][col] == 1)
        blue++;
      else 
        white++;
    } else {
      solution(row, col, (int)(size/2));
      solution(row+(int)(size/2), col, (int)(size/2));
      solution(row, col+(int)(size/2), (int)(size/2));
      solution(row+(int)(size/2), col+(int)(size/2), (int)(size/2));
    }
  }

  // 한 색깔로 같으면 true / 아니면 false
  public static Boolean checking(int row, int col, int size){
    int color = matrix[row][col]; // 첫번째 색깔 체킹
    for(int i = row; i < row + size; i++){
      for(int j = col; j < col + size; j++){
        if(matrix[i][j] != color)
          return false;
      }
    }
    return true;
  }
}