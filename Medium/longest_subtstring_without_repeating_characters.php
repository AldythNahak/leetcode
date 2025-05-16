<?php
class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function lengthOfLongestSubstring($s) {
        if ($s == "" || strlen($s) > 50000) {
            return 0;
        }

        $longestSubtstring = 1;
        $startIndex = array();
        $startPosition = 0;
        $strSplit = str_split($s);

        for($i = 0; $i < count($strSplit); $i++) {
            if(array_key_exists($strSplit[$i], $startIndex)) {
                if($startIndex[$strSplit[$i]] >= $startPosition) {
                    $startPosition = $startIndex[$strSplit[$i]] + 1;
                }
            }

            $startIndex[$strSplit[$i]] = $i;
            $longestSubtstring = max($longestSubtstring, $i - $startPosition + 1);
        }

        return $longestSubtstring;
    }
}

$solution = new Solution;
print_r($solution->lengthOfLongestSubstring("abcabcbb")); #3
print_r($solution->lengthOfLongestSubstring("bbbbb")); #1
print_r($solution->lengthOfLongestSubstring("pwwkew")); #3
print_r($solution->lengthOfLongestSubstring("")); #0
print_r($solution->lengthOfLongestSubstring("au")); #2
print_r($solution->lengthOfLongestSubstring("aab")); #2