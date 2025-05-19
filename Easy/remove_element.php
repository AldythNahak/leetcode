<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $val
     * @return Integer
     */
    function removeElement($nums, $val) {
        return count(array_filter($nums, function($v) use ($val){
            return $v !== $val;
        }));
    }
}

$solution = new Solution;

print_r($solution->removeElement([3, 2, 2, 3], 3));
print_r($solution->removeElement([0, 1, 2, 2, 3, 0, 4, 2], 2));