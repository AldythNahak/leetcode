class Solution {
    public boolean isPalindrome(int x) {
        String strX = String.valueOf(x);
        String strXR = new StringBuilder(strX).reverse().toString();
        return strX.equals(strXR);
    }
}

public class palindrome_number {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(121)); // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(10)); // false
    }
}