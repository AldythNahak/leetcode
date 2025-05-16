package longest_subtstring_without_repeating_characters;

import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s.length() > 50000) {
            return 0;
        }

        HashMap<String, Integer> startIndex = new HashMap();
        int longestSubtstring = 1;
        int startPosition = 0;
        String[] strSplit = s.split("");

        for (int i = 0; i < strSplit.length; i++) {
            if(startIndex.containsKey(strSplit[i])) {
                if(startIndex.get(strSplit[i]) >= startPosition) {
                    startPosition = startIndex.get(strSplit[i]) + 1;
                }
            }

            startIndex.put(strSplit[i], i);
            longestSubtstring = Math.max(longestSubtstring, i - startPosition + 1);
        }

        return longestSubtstring;
    }
}

public class longest_subtstring_without_repeating_characters {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(solution.lengthOfLongestSubstring("bbbbb")); // 1
        System.out.println(solution.lengthOfLongestSubstring("pwwkew")); // 3
        System.out.println(solution.lengthOfLongestSubstring("")); // 0
        System.out.println(solution.lengthOfLongestSubstring("au")); // 2
        System.out.println(solution.lengthOfLongestSubstring("aab")); // 2
    }
}
