package day_39;

/* baekjoon 2580 */

import java.util.*;
import java.io.*;

public class Sudoku {
  static final int SUDOKU_SIZE = 9;
  static int[][] problem;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    problem = new int[SUDOKU_SIZE][SUDOKU_SIZE];

    for (int i = 0; i < SUDOKU_SIZE; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int j = 0; j < SUDOKU_SIZE; j++) {
        problem[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < SUDOKU_SIZE; i++) {
      for (int j = 0; j < SUDOKU_SIZE; j++) {
        if (problem[i][j] == 0) {
          solution(i, j);
          return;
        }
      }
    }
  }

  public static void print(int[][] matrix) {
    for (int i = 0; i < SUDOKU_SIZE; i++) {
      for (int j = 0; j < SUDOKU_SIZE; j++) {
        System.out.print(problem[i][j] + " ");
      }
      System.out.println();
    }
  }

  public static void solution(int r, int c) {
    if (c == SUDOKU_SIZE) {
      solution(r + 1, 0);
      return;
    }

    if (r == SUDOKU_SIZE) {
      print(problem);
      return;
    }

    if (problem[r][c] == 0) {
      for (int i = 1; i <= SUDOKU_SIZE; i++) {
        if (squardCheck(r, c, i, problem) && verticalCheck(c, i, problem) && horizontalCheck(i, problem[r])) {
          problem[r][c] = i;
          solution(r, c + 1);
        }
      }
      problem[r][c] = 0;
      return;
    }
    solution(r, c + 1);
  }

  // 사각형 확인
  public static boolean squardCheck(int r, int c, int v, int[][] matrix) {
    int startR = (r / 3) * 3;
    int endR = startR + 3;
    int startC = (c / 3) * 3;
    int endC = startC + 3;

    for (int i = startR; i < endR; i++) {
      for (int j = startC; j < endC; j++) {
        if (matrix[i][j] == v) {
          return false;
        }
      }
    }

    return true;
  }

  // 세로 확인
  public static boolean verticalCheck(int c, int v, int[][] matrix) {
    for (int i = 0; i < SUDOKU_SIZE; i++) {
      if (matrix[i][c] == v)
        return false;
    }
    return true;
  }

  // 가로 확인
  public static boolean horizontalCheck(int v, int[] matrix) {
    for (int i = 0; i < SUDOKU_SIZE; i++) {
      if (matrix[i] == v)
        return false;
    }

    return true;
  }
}
