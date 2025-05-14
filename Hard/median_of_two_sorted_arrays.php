<?php

class Solution {

    /**
     * @param Integer[] $nums1
     * @param Integer[] $nums2
     * @return Float
     */
    function findMedianSortedArrays($nums1, $nums2) {
        if (count($nums1) > 1000 || count($nums2) > 1000) {
		    return 0;
	    }

        $joinArr = array_merge($nums1, $nums2);
        sort($joinArr);
        $lenJoinArr = count($joinArr);

        if ($lenJoinArr == 0 || $lenJoinArr > 2000) {
            return 0;
        }

        $mid = $lenJoinArr / 2;
        if ($lenJoinArr % 2 == 1) {
            return floatval($joinArr[$mid]);
        }

        return floatval(($joinArr[$mid-1] + $joinArr[$mid]) / 2.0);
    }
}

$solution = new Solution;
// print_r($solution->findMedianSortedArrays([1,3], [2]));
// print_r($solution->findMedianSortedArrays([1,2], [3,4]));
print_r($solution->findMedianSortedArrays([1,2,3,4,5], [6,7,8,9,10,11,12,13,14,15,16,17]));