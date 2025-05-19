package divide_two_integers;

class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend < Integer.MIN_VALUE) {
            dividend = Integer.MIN_VALUE;
        }

        if (divisor > Integer.MAX_VALUE) {
            divisor = Integer.MAX_VALUE;
        }

        if (divisor == 0) {
            return 0;
        }

        double divide = (double) dividend / divisor;
        int divideNumber = (int) divide;

        if (divideNumber > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (divideNumber < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }

        return divideNumber;
    }
}

public class divide_two_integers {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.divide(10, 3)); // 3
        System.out.println(solution.divide(7, -3)); // -2
        System.out.println(solution.divide(-2147483648, -1)); // 2147483647
        System.out.println(solution.divide(2147483647, 2)); // 1073741823

    }
}