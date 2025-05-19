package longest_common_prefix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs.length > 200) {
            return "";
        }

        Arrays.sort(strs, Comparator.comparingInt(String::length));
        int lenShortText = strs[0].length();
        ArrayList<String> collectPrefix = new ArrayList<>();

        for (int i = 0; i < lenShortText; i++) {
            if (collectPrefix.size() == i) {
                collectPrefix.add(Character.toString(strs[0].charAt(i)));
            }

            if (i > collectPrefix.size() || collectPrefix.size() == 0) {
                break;
            }

            for (int j = 0; j < strs.length; j++) {
                if (strs[j].equals("")) {
                    continue;
                }

                if (!collectPrefix.get(i).equals(Character.toString(strs[j].charAt(i)))) {
                    collectPrefix.remove(collectPrefix.size()-1);
                    break;
                }
            }
        }
    
        return new String().join("", collectPrefix);
    }
}

public class longest_common_prefix {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "flight" })); // fl
        System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flow", "" })); // fl
        System.out.println(solution.longestCommonPrefix(new String[] { "flower", "flower", "flower", "flower" })); // flower
        System.out.println(solution.longestCommonPrefix(new String[] { "ab", "a" })); // a
        System.out.println(solution.longestCommonPrefix(new String[] { "", "" })); //
        System.out.println(solution.longestCommonPrefix(new String[] { "dog", "racecar", "car" })); //
        System.out.println(solution.longestCommonPrefix(new String[] { "a" })); // a
    }
}
