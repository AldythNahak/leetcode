package string_to_integer_atoi;

import java.math.BigInteger;
import java.util.ArrayList;

class Solution {
    public int myAtoi(String s) {
        s = s.trim();

        if (s.length() == 0 || s.length() > 200) {
            return 0;
        }

        String collectString = "";
        Boolean isNegative = s.charAt(0) == '-';

        for (int i = 0; i < s.length(); i++) {
            if ((i == 0 && isNegative) || (i == 0 && s.charAt(i) == '+')) {
                continue;
            }

            if(!Character.isDigit(s.charAt(i)) || (i > 0 && s.charAt(i) == ' ')) {
                break;
            }

            collectString = collectString.concat(Character.toString(s.charAt(i)));
        }

        if(collectString.length() == 0 || collectString == "0") {
            return 0;
        }

        BigInteger convToBigInteger = new BigInteger(collectString);

        if(isNegative) {
            convToBigInteger = convToBigInteger.negate();
        }

        if(convToBigInteger.compareTo(BigInteger.valueOf(-(1L << 31))) < 0) {
            return Integer.MIN_VALUE;
        } else if (convToBigInteger.compareTo(BigInteger.valueOf((1L << 31) - 1)) > 0) {
            return Integer.MAX_VALUE;
        }

        return convToBigInteger.intValue();
    }
}

public class string_to_integer_atoi {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("1337c0d3"));
        System.out.println(solution.myAtoi("words and 987"));
        System.out.println(solution.myAtoi("  -042"));
        System.out.println(solution.myAtoi("20000000000000000000"));
        System.out.println(solution.myAtoi("   +0 123"));
        System.out.println(solution.myAtoi("21474836460"));
    }
}
