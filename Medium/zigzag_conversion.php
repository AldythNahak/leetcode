<?php

class Solution {

    /**
     * @param String $s
     * @param Integer $numRows
     * @return String
     */
    function convert($s, $numRows) {
        if(strlen($s) <= 1 || strlen($s) > 1000 || $numRows <= 1 || $numRows > 1000) {
            return $s;
        }

        $collectZigzag = array();
        $isStraight = false;
        $currRow = 0;

        for($i = 0; $i < strlen($s); $i++) {
            if(!isset($collectZigzag[$currRow])) {
                array_push($collectZigzag, "");
            }
        
            if($currRow == 0) {
                $isStraight = true;
            } else if($currRow == $numRows - 1) {
                $isStraight = false;
            }

            $collectZigzag[$currRow] .= $s[$i];

            if($isStraight) {
                $currRow += 1;
            } else {
                $currRow -= 1;
            }
        }

        return implode("", $collectZigzag);
    }
}

$solution = new Solution;

print_r($solution->convert("PAYPALISHIRING", 3));