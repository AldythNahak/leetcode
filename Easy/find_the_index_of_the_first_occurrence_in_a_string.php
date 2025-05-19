<?php

class Solution {

    /**
     * @param String $haystack
     * @param String $needle
     * @return Integer
     */
    function strStr($haystack, $needle) {
        $index = strpos($haystack, $needle);
        return intval($index < 0 || $index == "" ? -1 : $index);
    }
}

$solution = new Solution;

print_r($solution->strStr("sadbutsad", "sad"));
print_r($solution->strStr("leetcode", "leeto"));
print_r($solution->strStr("lentest", "test"));