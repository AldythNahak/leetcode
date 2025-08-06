package plus_one;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public int[] plusOne(int[] digits) {
        String summary = Arrays.stream(digits).mapToObj(String::valueOf).collect(Collectors.joining(""));
        BigInteger addSummary = new BigInteger(summary).add(BigInteger.ONE);
        String result = addSummary.toString();
        int[] newDigits = new int[result.length()];

        for (int i = 0; i < result.length(); i++) {
            newDigits[i] = result.charAt(i) - '0';
        }

        return newDigits;
    }
}

public class plus_one {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.plusOne(new int[] { 1, 2, 3 })); // 124
    }
}
