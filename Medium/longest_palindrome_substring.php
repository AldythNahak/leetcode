<?php

class Solution
{

    /**
     * @param String $s
     * @return String
     */
    function longestPalindrome($s)
    {
        if (strlen($s) == 0 || strlen($s) > 1000) {
            return $s;
        }

        if ($s === strrev($s)) {
            return $s;
        }

        $resultMatch = $s[0];
        for ($i = 0; $i < strlen($s); $i++) {
            for ($j = $i + 1; $j <= strlen($s); $j++) {
                if ($s[$i] !== $s[($j - 1)]) {
                    continue;
                }

                if ($j > 1 && ($i + 1) < strlen($s) && $s[($i + 1)] !== $s[($j - 2)]) {
                    continue;
                }

                if (strlen($resultMatch) >= ($j - $i)) {
                    continue;
                }

                $strJoin = substr($s, $i, ($j - $i));
                $strJoinReverse = strrev($strJoin);

                // print_r($strJoin." = ".$strJoinReverse."\n");

                if ($strJoin == $strJoinReverse) {
                    $resultMatch = $strJoin;
                }
            }
        }

        return $resultMatch;
    }
}

$solution = new Solution;
print_r($solution->longestPalindrome("cbbd")."\n");
print_r($solution->longestPalindrome("babad")."\n");
print_r($solution->longestPalindrome("abcdbbfcba") . "\n");
print_r($solution->longestPalindrome("xaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuu"));
