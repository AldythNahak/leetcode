<?php

class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer[]
     */
    function twoSum($nums, $target)
    {
        $list = array();

        for ($i = 0; $i < count($nums); $i++) {
            $s = $target - $nums[$i];

            if (array_key_exists($s, $list)) {
                return array($list[$s], $i);
            }

            $list[$nums[$i]] = $i;
        }
    }
}

$solution = new Solution();

print_r($solution->twoSum(array(2, 7, 11, 15), 9)); //[0, 1]
print_r($solution->twoSum(array(3, 2, 4), 6)); //[1, 2]
print_r($solution->twoSum(array(3, 3), 6)); //[0, 1]
print_r($solution->twoSum(array(-3, 4, 3, 90), 0)); //[0, 2]
