package length_of_last_word;

import java.util.Arrays;

class Solution {
    public int lengthOfLastWord(String s) {
        String[] collectString = s.strip().split("\\s+");
        return collectString[collectString.length - 1].length();
    }
}

public class length_of_last_word {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("hello world")); //5
    }
}
