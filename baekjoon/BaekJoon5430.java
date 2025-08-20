package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BaekJoon5430 {
    static int N;

    static class Solver {
        String method;
        Deque<Integer> deque;

        public Solver(String method, String deque) {
            this.method = method;
            this.deque = new ArrayDeque<>();
            String substring = deque.substring(1, deque.length() - 1);
            String[] replaceArray = substring.isBlank() ? new String[]{} : substring.split(",");
            for(String replace: replaceArray) {
                this.deque.add(Integer.parseInt(replace));
            }
        }

        public String getAnswer() {
            boolean reversed = false;
            for (char c : method.toCharArray()) {
                if (c == 'R') {
                    reversed = !reversed;
                } else {
                    if (deque.isEmpty()) return "error";
                    if (reversed) deque.removeLast();
                    else deque.removeFirst();
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            while (!deque.isEmpty()) {
                sb.append(reversed ? deque.removeLast() : deque.removeFirst());
                if (!deque.isEmpty()) sb.append(",");
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String method = st.nextToken();
            String length = br.readLine();
            st = new StringTokenizer(br.readLine());

            Solver solver = new Solver(method, st.nextToken());
            sb.append(solver.getAnswer())
                    .append("\n");
        }

        System.out.println(sb);
    }
}
