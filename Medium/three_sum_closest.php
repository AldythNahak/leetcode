<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @param Integer $target
     * @return Integer
     */
    function threeSumClosest($nums, $target) {
        if (count($nums) < 3 || count($nums) > 3000) {
            return 0;
        }

        $totalNum = count($nums);
        sort($nums);
        $lastSumClosest = $nums[0] + $nums[1] + $nums[2];

        for ($i = 0; $i < $totalNum - 1; $i++) {
            $iLeft = $i + 1;
            $iRight = $totalNum - 1;

            while ($iLeft < $iRight) {
                $sumNum = $nums[$iLeft] + $nums[$i] + $nums[$iRight];
                $closest = intval(abs(floatval($target) - floatval($sumNum)));
                $lastClosest = intval(abs(floatval($target) - floatval($lastSumClosest)));

                if ($target == $sumNum) {
                    return $sumNum;
                }

                if ($closest < $lastClosest) {
                    $lastSumClosest = $sumNum;
                }

                if ($sumNum < $target) {
                    $iLeft++;
                } else {
                    $iRight--;
                }
                }
        }
        return $lastSumClosest;
    }
}

$solution = new Solution;

print_r($solution->threeSumClosest(array(-1, 2, 1, -4), 1)); // 2
print_r($solution->threeSumClosest(array(0, 0, 0), 1)); // 0
print_r($solution->threeSumClosest(array(0, 1, 2), 3)); // 3
print_r($solution->threeSumClosest(array(10, 20, 30, 40, 50, 60, 70, 80, 90), 1)); // 60
print_r($solution->threeSumClosest(array(4, 0, 5, -5, 3, 3, 0, -4, -5), -2)); // -2
print_r($solution->threeSumClosest(array(-4, 2, 2, 3, 3, 3), 0)); // 0
print_r($solution->threeSumClosest(array(1, 1, 1, 0), 100)); // 3