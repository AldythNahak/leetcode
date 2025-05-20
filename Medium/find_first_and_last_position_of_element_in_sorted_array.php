<?php

class Solution {

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function searchRange($nums, $target) {
        $collectRange = array();
        
        foreach($nums as $i => $n) {
            if($n == $target) {
                array_push($collectRange, $i);
            }
        }

        if(count($collectRange) == 0) {
            return array(-1,-1);
        } else if(count($collectRange) == 1) {
            return array_pad($collectRange, 2, $collectRange[0]);
        } else {
            return array($collectRange[0], $collectRange[count($collectRange)-1]);
        }
    }
}

$solution = new Solution;

print_r($solution->searchRange(array(5,7,7,8,8,10), 8));
print_r($solution->searchRange(array(1), 1));
print_r($solution->searchRange(array(3,3,3), 3));
print_r($solution->searchRange(array(0,0,1,2,2), 2));