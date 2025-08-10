import java.util.*;

public class SubstringEqual012 {
    public static int findLongestSubstring(String s) {
        int count0 = 0, count1 = 0, count2 = 0;
        int maxLen = 0;

        // Map of difference pair to first index
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1); // diff10#diff21 format

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '0') count0++;
            else if (ch == '1') count1++;
            else if (ch == '2') count2++;

            int diff10 = count1 - count0;
            int diff21 = count2 - count1;

            String key = diff10 + "#" + diff21;

            if (map.containsKey(key)) {
                maxLen = Math.max(maxLen, i - map.get(key));
            } else {
                map.put(key, i);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "0102010";
        System.out.println("Length of longest substring: " + findLongestSubstring(s));
    }
}
