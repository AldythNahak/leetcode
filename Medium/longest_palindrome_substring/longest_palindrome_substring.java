package longest_palindrome_substring;

class Solution {
    public String longestPalindrome(String s) {
        if(s.length() == 0 || s.length() > 1000)  {
            return s;
        }

        if(s.equals(new StringBuilder(s).reverse())) {
            return s;
        }

        String resultMatch = s.substring(0, 1);
        for(int i = 0; i < s.length(); i++) {
            for(int j = i + 1; j <= s.length(); j++) {
                if(s.charAt(i) != s.charAt(j-1)) {
                    continue;
                }

                if (j > 1 && i + 1 < s.length() && s.charAt(i+1) != s.charAt(j-2)) {
                    continue;
                }

                if (resultMatch.length() >= j - i) {
                    continue;
                }

                String strJoin = s.substring(i, j);
                String strJoinReverse = new StringBuilder(strJoin).reverse().toString();

                if (strJoin.equals(strJoinReverse)) {
                    resultMatch = strJoin;
                }
            }
        } 

        return resultMatch;
    }
}

public class longest_palindrome_substring {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("ccc"));
    }
}
