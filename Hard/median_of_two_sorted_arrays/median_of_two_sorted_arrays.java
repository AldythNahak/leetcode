package median_of_two_sorted_arrays;
import java.util.Arrays;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > 1000 || nums2.length > 1000) {
            return 0.0;
        }

        int[] merged = new int[nums1.length + nums2.length];
        System.arraycopy(nums1, 0, merged, 0, nums1.length);
        System.arraycopy(nums2, 0, merged, nums1.length, nums2.length);

        Arrays.sort(merged);
        int len = merged.length;

        if (len == 0 || len > 2000) {
            return 0.0;
        }

        if (len % 2 == 1) {
            return (double) merged[len / 2];
        } else {
            return ((double) merged[len / 2 - 1] + (double) merged[len / 2]) / 2.0;
        }
    }
}

public class median_of_two_sorted_arrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(new int[] {1, 2, 3, 4, 5}, new int[] {6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17}));
    }
}