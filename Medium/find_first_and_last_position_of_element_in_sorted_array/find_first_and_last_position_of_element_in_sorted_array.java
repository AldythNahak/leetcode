package find_first_and_last_position_of_element_in_sorted_array;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        List<Integer> collectRange = new ArrayList<>(); 

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                collectRange.add(i);
            }
        }

        if(collectRange.size() == 0) {
            return new int[]{-1,-1};
        } else if (collectRange.size() == 1) {
            collectRange.addLast(collectRange.getFirst());
            return collectRange.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[]{collectRange.getFirst(), collectRange.getLast()};
        }
    }
}

public class find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8));
        System.out.println(solution.searchRange(new int[] { 1 }, 1));
        System.out.println(solution.searchRange(new int[] { 3, 3, 3 }, 3));
        System.out.println(solution.searchRange(new int[] { 0, 0, 1, 2, 2 }, 2));
    }
}