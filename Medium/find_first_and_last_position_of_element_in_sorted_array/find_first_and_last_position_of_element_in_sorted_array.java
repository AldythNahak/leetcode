package find_first_and_last_position_of_element_in_sorted_array;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int[] newSearchRange(int[] nums, int target) {
        int first = findBound(nums, target, true);
        if (first == -1) {
            return new int[]{-1, -1}; // target not found at all
        }
        int last = findBound(nums, target, false);
        return new int[]{first, last};
    }

    private int findBound(int[] nums, int target, boolean isFirst) {
        int left = 0, right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;
                if (isFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int[] searchIndex(int[] nums, int target) {
        int first = findIndex(true, nums, target);
        if (first == -1) {
            return new int[]{-1, -1}; // target not found at all
        }
        int last = findIndex(false, nums, target);
        return new int[]{first, last};
    }

    private int findIndex(boolean isFirst, int[] nums, int target) {
        int result = -1;
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int start = left + ((right - left) / 2);

            if (nums[start] == target) {
                result = start;
                if(isFirst) {
                    right = start - 1;
                } else {
                    left = start + 1;
                }
            } else if (nums[start] < target) {
                left = start + 1;
            } else {
                right = start - 1;
            }
        }

        return result;
    }
}

public class find_first_and_last_position_of_element_in_sorted_array {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(solution.newSearchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(solution.newSearchRange(new int[] { 5, 7, 7, 8, 8, 9, 9, 10 }, 9)));
        // System.out.println(Arrays.toString(solution.searchRange(new int[] { 1 }, 1)));
        // System.out.println(Arrays.toString(solution.searchRange(new int[] { 3, 3, 3 }, 3)));
        // System.out.println(Arrays.toString(solution.searchRange(new int[] { 0, 0, 1, 2, 2 }, 2)));
        System.out.println(Arrays.toString(solution.searchIndex(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
        System.out.println(Arrays.toString(solution.searchIndex(new int[] { 5, 7, 7, 8, 8, 9, 9, 10 }, 9)));
    }
}