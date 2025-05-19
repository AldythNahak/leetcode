<?php
class Solution
{

    /**
     * @param String[] $strs
     * @return String
     */
    function longestCommonPrefix($strs)
    {
        if (count($strs) == 0 || count($strs) > 200) {
            return "";
        }

        usort($strs, function ($a, $b) {
            return strlen($a) - strlen($b);
        });

        $lenShortText = strlen($strs[0]);
        $collectPrefix = array();
        
        for ($i = 0; $i < $lenShortText; $i++) { 
            if (count($collectPrefix) == $i) {
                array_push($collectPrefix, $strs[0][$i]);
            }

            if ($i > count($collectPrefix) || count($collectPrefix) == 0) {
                break;
            }

            foreach($strs as $text) {
                if ($text === "") {
                    continue;
                }
                
                if ($text[$i] != $collectPrefix[$i]) {
                    array_pop($collectPrefix);
                    break;
                }
            }
        }

        return implode("", $collectPrefix);
    }
}

$solution = new Solution;
print_r($solution->longestCommonPrefix(array("flower", "flow", "flight")) . "\n"); //fl
print_r($solution->longestCommonPrefix(array("flower", "flow", "")) . "\n"); //
print_r($solution->longestCommonPrefix(array("flower", "flower", "flower", "flower")) . "\n"); //flower
print_r($solution->longestCommonPrefix(array("ab", "a")) . "\n"); //a
print_r($solution->longestCommonPrefix(array("", "")) . "\n"); //
print_r($solution->longestCommonPrefix(array("a")) . "\n"); //a