<?php

class Solution
{

    /**
     * @param String $s
     * @return Integer
     */
    function myAtoi($s)
    {
        $s = trim($s);

        if (strlen($s) == 0 || strlen($s) > 200) {
            return 0;
        }

        $collectString = "";
        $isNegative = $s[0] == "-";

        for ($i = 0; $i < strlen($s); $i++) {
            if (($i == 0 && $isNegative) || ($i == 0 && $s[0] == '+')) {
                continue;
            }

            if(!preg_match("/[0-9]/", $s[$i])) {
                break;
            }
            
            $collectString .= $s[$i];
        }

        if(strlen($collectString) == 0) {
            return 0;
        }

        $resultInt = intval($collectString);
        
        if ($isNegative) {
            $resultInt = - ($resultInt);
        }

        if ($resultInt < - (2 ** 31)) {
            return - (2 ** 31);
        } else if ($resultInt > (2 ** 31) - 1) {
            return (2 ** 31) - 1;
        }

        return $resultInt;
    }
}

$solution = new Solution();

print_R($solution->myAtoi("+-12")."\n");
// print_R($solution->myAtoi("1337c0d3")."\n");
// print_R($solution->myAtoi("words and 987")."\n");
// print_R($solution->myAtoi("  -042")."\n");
// print_R($solution->myAtoi("20000000000000000000")."\n");
// print_R($solution->myAtoi("   +0 123")."\n");
// print_R($solution->myAtoi("21474836460")."\n");
