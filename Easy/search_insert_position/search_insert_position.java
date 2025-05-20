package search_insert_position;

class Solution {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= target) {
                index = i;
                break;
            }
        }

        if (nums.length > 0 && index == 0 && nums[nums.length - 1] < target) {
            return nums.length;
        }

        return index;
    }
}

public class search_insert_position {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.searchInsert(new int[] { 2, 7, 11, 15 }, 9));
    }
}
