<?php
class Solution
{

    /**
     * @param Integer[] $nums
     * @return Integer[][]
     */
    function threeSum($nums)
    {
        $collectSum = array();
        if (count($nums) < 3 || count($nums) > 3000) {
            return $collectSum;
        }

        $totalNum = count($nums);
        sort($nums);

        for ($i = 0; $i < $totalNum - 2; $i++) {
            if ($i > 0 && $nums[$i] == $nums[$i - 1]) {
                continue;
            }

            $iLeft = $i + 1;
            $iRight = $totalNum - 1;

            do {
                $listSumNum = array($nums[$iLeft], $nums[$i], $nums[$iRight]);
                sort($listSumNum);
                $sumNum = array_sum($listSumNum);

                if ($sumNum == 0) {
                    array_push($collectSum, $listSumNum);
                    while ($iLeft < $iRight && $nums[$iLeft] == $nums[$iLeft + 1]) {
                        $iLeft++;
                    }

                    while ($iLeft < $iRight && $nums[$iRight] == $nums[$iRight - 1]) {
                        $iRight--;
                    }

                    $iLeft++;
                    $iRight--;
                } else if ($sumNum < 0) {
                    $iLeft++;
                } else {
                    $iRight--;
                }
            } while ($iLeft < $iRight);
        }

        usort($collectSum, function ($a, $b) {
            return $b[2] - $a[2];
        });

        return $collectSum;
    }
}

$solution = new Solution;

print_r($solution->threeSum(array(-1, 0, 1, 2, -1, -4))); //[[-1,-1,2],[-1,0,1]]
print_r($solution->threeSum(array(0, 0, 0)));             //[[0,0,0]]
print_r($solution->threeSum(array(3, -2, 1, 0)));         //[]
print_r($solution->threeSum(array(1, -1, -1, 0)));        //[[-1,0,1]]
print_r($solution->threeSum(array(-1, 0, 1, 0)));         //[[-1,0,1]]
print_r($solution->threeSum(array(2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10)));
//[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]