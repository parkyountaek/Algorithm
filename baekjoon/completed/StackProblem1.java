package baekjoon.completed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StackProblem1 {
  static int N;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    Stack stack = new Stack();

    N = Integer.parseInt(st.nextToken());

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      String op;
      int value = 0;
      op = st.nextToken();
      if (st.countTokens() == 1) {
        value = Integer.parseInt(st.nextToken());
      }
      if (op.equals("push"))
        stack.push(value);
      else if (op.equals("pop"))
        stack.pop();
      else if (op.equals("size"))
        stack.size();
      else if (op.equals("empty"))
        stack.empty();
      else
        stack.top();
    }
  }

  public static class Stack {
    private ArrayList<Integer> stack;
    private int index;

    public Stack() {
      this.stack = new ArrayList<>();
      this.index = 0;
    }

    public void push(int value) {
      this.stack.add(value);
      this.index++;
    }

    public void pop() {
      if (this.stack.size() <= 0)
        System.out.println(-1);
      else {
        System.out.println(this.stack.get(this.index - 1));
        this.stack.remove(this.index - 1);
        this.index--;
      }
    }

    public void top() {
      if (this.stack.size() <= 0)
        System.out.println(-1);
      else
        System.out.println(this.stack.get(this.index - 1));
    }

    public void size() {
      System.out.println(this.stack.size());
    }

    public void empty() {
      if (this.index <= 0)
        System.out.println(1);
      else
        System.out.println(0);
    }
  }

}
