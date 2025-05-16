<?php

class Solution
{

    /**
     * @param String $s
     * @return Boolean
     */
    function isValid($s)
    {
        $lenS = strlen($s);

        if ($lenS % 2 !== 0 || $lenS > 10000) {
            return false;
        }

        $mapParentheses = array("(" => ")", "[" => "]", "{" => "}");
        $strSplit = str_split($s);
        $collectParentheses = array();

        for ($i = 0; $i < $lenS; $i++) {
            if ($i == 0 && in_array($strSplit[$i], array_values($mapParentheses))) {
                return false;
            }


            if (!array_key_exists($strSplit[$i], $mapParentheses) && !in_array($strSplit[$i], array_values($mapParentheses))) {
                return false;
            }

            if (array_key_exists($strSplit[$i], array: $mapParentheses)) {
                array_push($collectParentheses, $strSplit[$i]);
                continue;
            }

            $lastCheck = array_slice($collectParentheses, -1);
            if (empty($lastCheck) && in_array($strSplit[$i], array_values($mapParentheses))) {
                return false;
            }

            $lastCheck = $lastCheck[0];
            if ($mapParentheses[$lastCheck] == $strSplit[$i]) {
                array_pop($collectParentheses);
                continue;
            } else {
                return false;
            }
        }

        return count($collectParentheses) == 0;
    }
}

$solution = new Solution;
print_r($solution->isValid("(]")); //false
print_r($solution->isValid("()[]{}")); //true
print_r($solution->isValid("([])")); //true
print_r($solution->isValid("(}{)")); //false
print_r($solution->isValid("([{}])")); //true
print_r($solution->isValid("(){}}{")); //false
print_r($solution->isValid("(([]){})")); //true
