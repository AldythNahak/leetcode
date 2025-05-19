package three_sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> collectSum = new ArrayList<>();
        if (nums.length < 3 || nums.length > 3000) {
            return collectSum;
        }

        int totalNum = nums.length;
        Arrays.sort(nums);

        for (int i = 0; i < totalNum - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int iLeft = i + 1;
            int iRight = totalNum - 1;

            while (iLeft < iRight) {
                List<Integer> listSumNum = Arrays.asList(nums[iLeft], nums[i], nums[iRight]);
                int sumNum = nums[iLeft] + nums[i] + nums[iRight];
                listSumNum.sort(Comparator.comparingInt(Integer::intValue));

                if (sumNum == 0) {
                    collectSum.add(listSumNum);

                    while (iLeft < iRight && nums[iLeft] == nums[iLeft + 1]) {
                        iLeft++;
                    }

                    while (iLeft < iRight && nums[iRight] == nums[iRight - 1]) {
                        iRight--;
                    }

                    iLeft++;
                    iRight--;
                } else if (sumNum < 0) {
                    iLeft++;
                } else {
                    iRight--;
                }
            }
        }

        collectSum.sort(Comparator.comparingInt(l -> l.get(0)));
        
        return collectSum;
    }
}

public class three_sum {
    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 2, -1, -4 })); // [[-1,-1,2],[-1,0,1]]
        System.out.println(solution.threeSum(new int[] { 0, 0, 0 })); // [[0,0,0]]
        System.out.println(solution.threeSum(new int[] { 3, -2, 1, 0 })); // []
        System.out.println(solution.threeSum(new int[] { 1, -1, -1, 0 })); // [[-1,0,1]]
        System.out.println(solution.threeSum(new int[] { -1, 0, 1, 0 })); // [[-1,0,1]]
        System.out.println(solution.threeSum(new int[] { 2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10 }));
        // [[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]

    }
}
