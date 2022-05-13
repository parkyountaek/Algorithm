package day_34;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class StackProblem2 {
  static int N;
  static Stack<Integer> stack = new Stack<Integer>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String op = st.nextToken();
      Integer value = -1;
      if (st.countTokens() == 1) {
        value = Integer.valueOf(st.nextToken());
      }
      print(op, value);
    }
  }

  public static void print(String op, Integer value) {
    switch (op) {
      case "push":
        stack.push(value);
        break;
      case "pop":
        if (stack.empty())
          System.out.println(-1);
        else
          System.out.println(stack.pop());
        break;
      case "top":
        if (stack.empty())
          System.out.println(-1);
        else
          System.out.println(stack.peek());
        break;
      case "size":
        System.out.println(stack.size());
        break;
      case "empty":
        if (stack.empty())
          System.out.println(1);
        else
          System.out.println(0);
        break;
      default:
        break;
    }
  }
}
