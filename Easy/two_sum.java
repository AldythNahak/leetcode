import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int s = target - nums[i];

            if (map.containsKey(s)) {
                return new int[] { map.get(s), i };
            }

            map.put(nums[i], i);
        }

        return new int[0];
    }

}

public class two_sum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.twoSum(new int[] { 2, 7, 11, 15 }, 9));
        System.out.println(solution.twoSum(new int[] { 3, 2, 4 }, 6));
        System.out.println(solution.twoSum(new int[] { 3, 3 }, 6));
        System.out.println(solution.twoSum(new int[] { -3, 4, 3, 90 }, 0));
    }
}
