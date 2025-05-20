package longest_valid_parentheses;

class Solution {
    public int longestValidParentheses(String s) {
        // int 
        
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