package programmers;

import java.util.Arrays;

public class SecretMap {
    public static void main(String[] args) {
        int n = 5;
        int arr1[] = { 9, 20, 28, 18, 11 };
        int[] arr2 = { 30, 1, 21, 17, 28 };

        String[] result = solution(n, arr1, arr2);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            int temp = arr1[i] | arr2[i];

            answer[i] = intToSecret(temp, n);
        }
        return answer;
    }

    public static String intToSecret(int n, int len) {
        StringBuffer sb = new StringBuffer();
        int temp = n;
        while (temp != 0) {
            if (temp % 2 == 1)
                sb.append("#");
            else
                sb.append(" ");
            temp = temp >> 1;
        }
        if (sb.length() != len) {
            return " ".repeat(len - sb.length()) + sb.reverse().toString();
        }
        return sb.reverse().toString();
    }
}
