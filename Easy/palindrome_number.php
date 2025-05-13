<?php

class Solution
{

    /**
     * @param Integer $x
     * @return Boolean
     */
    function isPalindrome($x)
    {
        $strX = strval($x);
        return strrev($strX) === $strX;
    }
}

$solution = new Solution();

print_r($solution->isPalindrome(121)); //true
print_r($solution->isPalindrome(-121)); //false
print_r($solution->isPalindrome(10)); //false