package three_sum_closest;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3 || nums.length > 3000) {
            return 0;
        }

        int totalNum = nums.length;
        Arrays.sort(nums);
        int lastSumClosest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < totalNum - 1; i++) {
            int iLeft = i + 1;
            int iRight = totalNum - 1;

            while (iLeft < iRight) {
                int sumNum = nums[iLeft] + nums[i] + nums[iRight];
                int closest = Math.abs(target - sumNum);
                int lastClosest = Math.abs(target - lastSumClosest);

                if (target == sumNum) {
                    return sumNum;
                }

                if (closest < lastClosest) {
                    lastSumClosest = sumNum;
                }

                if (sumNum < target) {
                    iLeft++;
                } else {
                    iRight--;
                }
            }
        }

        return lastSumClosest;
    }
}

public class three_sum_closest {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSumClosest(new int[] { -1, 2, 1, -4 }, 1)); // 2
        System.out.println(solution.threeSumClosest(new int[] { 0, 0, 0 }, 1)); // 0
        System.out.println(solution.threeSumClosest(new int[] { 0, 1, 2 }, 3)); // 3
        System.out.println(solution.threeSumClosest(new int[] { 10, 20, 30, 40, 50, 60, 70, 80, 90 }, 1)); // 60
        System.out.println(solution.threeSumClosest(new int[] { 4, 0, 5, -5, 3, 3, 0, -4, -5 }, -2)); // -2
        System.out.println(solution.threeSumClosest(new int[] { -4, 2, 2, 3, 3, 3 }, 0)); // 0
        System.out.println(solution.threeSumClosest(new int[] { 1, 1, 1, 0 }, 100)); // 3
    }
}
