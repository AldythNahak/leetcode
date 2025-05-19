<?php

class Solution
{

    /**
     * @param Integer $dividend
     * @param Integer $divisor
     * @return Integer
     */
    function divide($dividend, $divisor)
    {
        $INT_MIN = - (2 ** 31);
        $INT_MAX = (2 ** 31) - 1;

        if ($dividend < $INT_MIN) {
            $dividend = $INT_MIN;
        }

        if ($divisor > $INT_MAX) {
            $divisor = $INT_MAX;
        }

        if ($divisor == 0) {
            return 0;
        }

        $divideNumber = intval(floatval($dividend) / floatval($divisor));

        if ($divideNumber > $INT_MAX) {
            return $INT_MAX;
        } else if ($divideNumber < $INT_MIN) {
            return $INT_MIN;
        }

        return $divideNumber;
    }
}

$solution = new Solution;

print_r("\n" . $solution->divide(10, 3)); //3
print_r("\n" . $solution->divide(7, -3)); //-2
print_r("\n" . $solution->divide(-2147483648, -1)); //2147483647
print_r("\n" . $solution->divide(2147483647, 2)); //1073741823
