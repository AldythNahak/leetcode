<?php

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function romanToInt($s) {
        $symbolMap = array("I" => 1, "V" => 5, "X" => 10, "L" => 50, "C" => 100, "D" => 500, "M" => 1000);
        $s = str_split(strtoupper($s)); 
        $total = 0;

        for($i = 0; $i < count($s); $i++) {
            if(!array_key_exists($s[$i], $symbolMap)) {
                break;
            }

            if ($i > 0) {
                if (($s[$i] == "V" || $s[$i] == "X") && $s[$i-1] == "I") {
                    $total -= 2;
                }

                if (($s[$i] == "L" || $s[$i] == "C") && $s[$i-1] == "X") {
                    $total -= 20;
                }

                if (($s[$i] == "D" || $s[$i] == "M") && $s[$i-1] == "C") {
                    $total -= 200;
                }
            }

            $total += $symbolMap[$s[$i]];
        }

        return $total;
    }
}

$solution = new Solution;
print_r($solution->romanToInt("MCMXCIV"));