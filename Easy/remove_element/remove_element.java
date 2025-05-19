package remove_element;

import java.util.Arrays;

class Solution {
    public int removeElement(int[] nums, int val) {
        return Arrays.stream(nums).filter(number -> number != val).toArray().length;
    }
}

public class remove_element {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.removeElement(new int[] { 3, 2, 2, 3 }, 3));
        System.out.println(solution.removeElement(new int[] { 0, 1, 2, 2, 3, 0, 4, 2 }, 2));
    }
}
