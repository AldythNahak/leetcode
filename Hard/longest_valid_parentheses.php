<?php 

class Solution {

    /**
     * @param String $s
     * @return Integer
     */
    function longestValidParentheses($s) {
        $countValidParentheses = 0;
        $storeIndex = array(-1);

        for ($i = 0; $i < strlen($s); $i++) {
            if ($s[$i] == "(") {
                array_push($storeIndex, $i);
            } else {
                array_pop($storeIndex);

                if(empty($storeIndex)) {
                    array_push($storeIndex, $i);
                } else {
                    $countValidParentheses =  max($countValidParentheses, $i - $storeIndex[count($storeIndex)-1]);
                }
            }
        }

        return $countValidParentheses;
    }
}

$solution = new Solution();

print_r($solution->longestValidParentheses("(()")); //2
print_r($solution->longestValidParentheses(")()());")); //4
print_r($solution->longestValidParentheses("")); //0
print_r($solution->longestValidParentheses("()(()")); //2
print_r($solution->longestValidParentheses("()(());")); //6
print_r($solution->longestValidParentheses("()")); //6
