package add_binary;

import java.math.BigInteger;

class Solution {
    public String addBinary(String a, String b) {
        BigInteger bA = new BigInteger(a, 2);       
        BigInteger bB = new BigInteger(b, 2);
        BigInteger summary = bA.add(bB);
        return new String(summary.toString(2));      
    }
}

public class add_binary {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("111", "1")); // 100
    }
}
