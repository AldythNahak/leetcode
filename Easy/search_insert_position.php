<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function searchInsert($nums, $target) {
        $index = 0;
        foreach($nums as $i => $n) {
            if($n >= $target) {
                $index = $i;
                break;
            }
        }

        if (count($nums) > 0 && $index == 0 && $nums[count($nums)-1] < $target) {
            return count($nums);
        }

        return $index;
    }
}

$solution = new Solution;

print_r($solution->searchInsert(array(1, 3, 5, 6), 5));
