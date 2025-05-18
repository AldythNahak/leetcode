package regular_expression_matching;

class Solution {
    public boolean isMatch(String s, String p) {
        String regx = "^"+p+"$";
        return (boolean) s.matches(regx);
    }
}

public class regular_expression_matching {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isMatch("aa", "a")); // False
        System.out.println(solution.isMatch("aa", "a*")); // True
        System.out.println(solution.isMatch("ab", ".*")); // True
    }
}
