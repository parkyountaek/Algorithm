package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baekjoon1092 {
    static int N;
    static int M;
    static Integer[] cranes;
    static List<Integer> boxes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cranes = new Integer[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            cranes[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cranes, Collections.reverseOrder());

        M = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            boxes.add(Integer.parseInt(st.nextToken()));
        }
        boxes.sort(Comparator.reverseOrder());

        if (cranes[0] < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        while (!boxes.isEmpty()) {
            int craneIndex = 0;

            for (int i = 0; i < boxes.size();) {
                if(craneIndex >= cranes.length) {
                    break;
                }
                Integer crane = cranes[craneIndex];
                if (crane >= boxes.get(i)) {
                    boxes.remove(i);
                    craneIndex++;
                } else {
                    i++;
                }
            }
            answer++;
        }
        System.out.println(answer);

    }
}
