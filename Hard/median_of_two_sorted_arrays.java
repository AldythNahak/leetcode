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