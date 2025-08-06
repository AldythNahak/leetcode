package sqrtx;

class Solution {
    public int mySqrt(int x) {
        int sqrt = (int) Math.sqrt((double) x);
        return sqrt;
    }
}

public class sqrtx {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(64)); // 100
    }
}
