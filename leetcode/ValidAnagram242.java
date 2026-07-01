package leetcode;

import java.util.Arrays;

public class ValidAnagram242 {
    public static void main(String[] args) {
        isAnagram("anagram", "nagaram");
    }

    public static boolean isAnagram(String s, String t) {
        char[] charArrayS = s.toCharArray();
        Arrays.sort(charArrayS);
        char[] charArrayT = t.toCharArray();
        Arrays.sort(charArrayT);

        String sortedS = new String(charArrayS);
        String sortedT = new String(charArrayT);

        return sortedS.equals(sortedT);
    }
}
