<?php

class Solution {

    /**
     * @param String $s
     * @param String $p
     * @return Boolean
     */
    function isMatch($s, $p) {
        return preg_match("/^$p$/", $s);
    }
}

$solution = new Solution;
print_r($solution->isMatch("aa", "a")."\n"); //False
print_r($solution->isMatch("aa", "a*")."\n"); //True
print_r($solution->isMatch("ab", ".*")."\n"); //True