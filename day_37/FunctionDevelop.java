package day_37;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FunctionDevelop {
  public static void main(String[] args) {
    // int[] answer = solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 });
    int[] answer = solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 });
    System.out.println(Arrays.toString(answer));
  }

  public static int[] solution(int[] progresses, int[] speeds) {
    int pointer = 0;
    int count = 0;
    int[] answer = {};
    while (pointer < progresses.length) {
      for (int i = pointer; i < progresses.length; i++)
        progresses[i] += speeds[i];
      count = 0;

      while (pointer < progresses.length && progresses[pointer] >= 100) {
        pointer++;
        count++;
      }
      if (count != 0) {
        int[] temp = new int[] { count };
        answer = Arrays.copyOfRange(answer, 0, answer.length + 1);
        System.arraycopy(temp, 0, answer, answer.length - 1, temp.length);
      }
    }

    return answer;
  }
}
