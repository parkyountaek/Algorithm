package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon7562 {
    static int testCase;
    static int length;
    static int[][] visit;
    static int[] currentPosition;
    static int[] targetPosition;
    static int[][] availableMove = {{-2, -1}, {-1, -2}, {2, -1}, {1, -2}, {-2, 1}, {-1, 2}, {2, 1}, {1, 2}};
    static int[] answer;

    static int BFS(int[] cur) {
        if(cur[0] == targetPosition[0] && cur[1] == targetPosition[1])
            return 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(cur);
        visit[cur[0]][cur[1]] = 1;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();

            for (int[] available : availableMove) {
                int nextX = current[0] + available[0];
                int nextY = current[1] + available[1];
                int move = current[2];

                if ((0 <= nextX && nextX < length) && (0 <= nextY && nextY < length) && visit[nextX][nextY] == 0) {
                    if (nextX == targetPosition[0] && nextY == targetPosition[1]) {
                        return move + 1;
                    }
                    queue.add(new int[]{nextX, nextY, move + 1});
                    visit[nextX][nextY] = 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        testCase = Integer.parseInt(br.readLine());
        answer = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            length = Integer.parseInt(br.readLine());
            visit = new int[length][length];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int currentX = Integer.parseInt(st.nextToken());
            int currentY = Integer.parseInt(st.nextToken());

            currentPosition = new int[]{currentX, currentY, 0};

            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());

            targetPosition = new int[]{targetX, targetY};

            int result = BFS(currentPosition);
            answer[i] = result;
        }

        for(int result: answer) {
            System.out.println(result);
        }
    }
}
