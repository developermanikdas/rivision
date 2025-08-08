import java.util.*;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int sLen = s.length(), pLen = p.length();

        if (sLen < pLen) return result;

        int[] sCount = new int[26];
        int[] pCount = new int[26];

        // Count frequency of p
        for (int i = 0; i < pLen; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        if (Arrays.equals(pCount, sCount)) result.add(0);

        for (int i = pLen; i < sLen; i++) {
            // Slide the window
            sCount[s.charAt(i) - 'a']++;                  // add right char
            sCount[s.charAt(i - pLen) - 'a']--;           // remove left char

            if (Arrays.equals(pCount, sCount)) {
                result.add(i - pLen + 1);
            }
        }

        return result;
    }
}
