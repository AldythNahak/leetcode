<?php

class Solution {

    /**
     * @param Integer $x
     * @return Integer
     */
    function reverse($x) {
        $strX = strval($x);
        $isNegative = $strX[0] == "-";

        if($isNegative) {
            $strX = "-".strrev(substr($strX, 1, strlen($strX)));
        } else {
            $strX = strrev($strX);
        }

        $convToInteger = intval($strX);

        if($convToInteger < -(2**31) || $convToInteger > (2**31) - 1) {
            return 0;
        }

        return $convToInteger;
    }
}

$solution = new Solution;

print_r($solution->reverse(123)."\n"); //321
print_r($solution->reverse(-123)."\n"); //-321
print_r($solution->reverse(1534236469)."\n"); //0