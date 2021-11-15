import java.io.*;

// public class Main {
public class Divide_1992 {
  static int[][] matrix;
  static String result = "";
  public static void main(String[] args) {
    try{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());

      matrix = new int[N][N];


      for(int i = 0; i < N; i++){
        String st = br.readLine();
        for(int j = 0; j < N; j++){
          matrix[i][j] = (int)(st.charAt(j)-'0');
        }
      }

      solution(0, 0, N);
      System.out.println(result);
    } catch(IOException e){
      e.printStackTrace();
    }
  }

  public static void solution(int row, int col, int size){
    int color = matrix[row][col];
    if(colorCheck(row, col, size)){
      if(color == 1){
        result+="1";
      } else {
        result+="0";
      }
    } else {
      result+="(";
      solution(row, col, (int)(size / 2));
      solution(row, col + (int)(size / 2), (int)(size / 2));
      solution(row + (int)(size / 2), col, (int)(size / 2));
      solution(row + (int)(size / 2), col  + (int)(size / 2), (int)(size / 2));
      result+=")";
    }
  }

  public static Boolean colorCheck(int row, int col, int size){
    int color = matrix[row][col];
    for(int i = row; i < row + size; i++){
      for(int j = col; j < col + size; j++){
        if(matrix[i][j] != color)
          return false;
      }
    }
    return true;
  }
}
