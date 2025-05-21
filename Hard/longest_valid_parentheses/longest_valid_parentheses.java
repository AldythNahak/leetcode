package longest_valid_parentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int longestValidParentheses(String s) {
        int countValidParentheses = 0;
        List<Integer> storeIndex = new ArrayList<>();
        storeIndex.add(-1);

        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '(') {
                storeIndex.add(i);
            } else {
                storeIndex.removeLast();
                if(storeIndex.size() == 0) {
                    storeIndex.add(i);
                } else {
                    countValidParentheses = Math.max(countValidParentheses, i - storeIndex.getLast());
                }
            }
        }

        return countValidParentheses;
    }
}

public class longest_valid_parentheses {
    public static void main(String[] args) {
        Solution solution = new Solution();

            System.out.println(solution.longestValidParentheses("(()")); //2
    System.out.println(solution.longestValidParentheses(")()())")); //4
    System.out.println(solution.longestValidParentheses("")); //0
    System.out.println(solution.longestValidParentheses("()(()")); //2
    System.out.println(solution.longestValidParentheses("()(())")); //6
    System.out.println(solution.longestValidParentheses("()")); //6
    }
}