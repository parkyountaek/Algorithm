package leetcode;

import java.util.*;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] data = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(data);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String str: strs) {
            String sorted = (sort(str));

            if(map.containsKey(sorted)) {
                List<String> strings = map.get(sorted);
                strings.add(str);
                map.put(sorted, strings);
            } else {
                List<String> strings = new ArrayList<>();
                strings.add(str);
                map.put(sorted, strings);
            }
        }


        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            entry.getValue().sort(null);
            answer.add(entry.getValue());
        }

        return answer;
    }

    public static String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
