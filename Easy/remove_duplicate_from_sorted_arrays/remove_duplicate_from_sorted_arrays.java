package remove_duplicate_from_sorted_arrays;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> newNums = new HashSet<Integer>();
        for (int num : nums) {
            newNums.add(num);
        }
        return newNums.size();
    }
}

public class remove_duplicate_from_sorted_arrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.removeDuplicates(new int[] { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 }));
        System.out.println(solution.removeDuplicates(new int[] { 1, 1, 2 }));
    }
}
