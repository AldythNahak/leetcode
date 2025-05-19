<?php
class Solution {

    /**
     * @param Integer[] $nums
     * @return Integer
     */
    function removeDuplicates($nums) {
        return count(array_unique($nums));
    }
}

$solution = new Solution;
print_r($solution->removeDuplicates(array(0,0,1,1,1,2,2,3,3,4)));
print_r($solution->removeDuplicates(array(1,1,2)));