<?php

class Solution
{

    /**
     * @param Integer $num
     * @return String
     */
    function intToRoman($num)
    {
        $symbolMap = array(
            "M" => 1000,
            "CM" => 900,
            "D" => 500,
            "CD" => 400,
            "C" => 100,
            "XC" => 90,
            "L" => 50,
            "XL" => 40,
            "X" => 10,
            "IX" => 9,
            "V" => 5,
            "IV" => 4,
            "I" => 1
        );

        $romanText = "";

        foreach ($symbolMap as $roman => $val) {
            if ($num >= $val) {
                $totalSymbol = floor($num / $val);
                for ($i = 0; $i < $totalSymbol; $i++) {
                    $romanText .= $roman;
                    $num -= $val;
                }
            }
        }

        return $romanText;
    }
}

$solution = new Solution;

print_r($solution->intToRoman(3749)."\n"); //MMMDCCXLIX
print_r($solution->intToRoman(58)."\n");   //LVIII
