package reverse_integer;

class Solution {
    public int reverse(int x) {
        String strX = Integer.toString(x);
        Boolean isNegative = strX.charAt(0) == '-';

        if(isNegative) {
            strX = "-".concat(new StringBuilder(strX.substring(1)).reverse().toString());
        } else {
            strX = new StringBuilder(strX).reverse().toString();
        }


        Long convToLong = Long.parseLong(strX);

        if(convToLong < Integer.MIN_VALUE || convToLong > Integer.MAX_VALUE -1) {
            return 0;
        }

        return convToLong.intValue();
    }
}

public class reverse_integer {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.reverse(123)); // 321
        System.out.println(solution.reverse(-123)); // -321
        System.out.println(solution.reverse(1534236469)); // 0
    }
}