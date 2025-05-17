package main

import (
	"fmt"
)

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func longestPalindrome(s string) string {
	if len(s) == 0 || len(s) > 1000 {
		return s
	}

	if s == reverseString(s) {
		return s
	}

	var resultMatch string
	strSplit := []rune(s)
	lenStr := len(strSplit)
	resultMatch = string(strSplit[0])
	for i := 0; i < lenStr; i++ {
		for j := i + 1; j <= lenStr; j++ {
			if strSplit[i] != strSplit[j-1] {
				continue
			}

			if j > 1 && i+1 < lenStr && strSplit[i+1] != strSplit[j-2] {
				continue
			}

			if len(resultMatch) >= j-i {
				continue
			}

			strJoin := string(strSplit[i:j])
			strJoinReverse := reverseString(strJoin)

			// if i == 1 {
			// fmt.Printf("%d - %d \n", i, j)
			// }

			if strJoin == strJoinReverse {
				resultMatch = strJoin
			}
		}
	}

	return resultMatch
}

func run_longestPalindrome() {
	// start := time.Now()
	fmt.Println(longestPalindrome("cbbd"))
	fmt.Println(longestPalindrome("babad"))
	fmt.Println(longestPalindrome("ccc"))
	fmt.Println(longestPalindrome("xaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuuvvvvvvvvvvwwwwwwwwwwxxxxxxxxxxyyyyyyyyyyzzzzzzzzzzyyyyyyyyyyxxxxxxxxxxwwwwwwwwwwvvvvvvvvvvuuuuuuuuuuttttttttttssssssssssrrrrrrrrrrqqqqqqqqqqppppppppppoooooooooonnnnnnnnnnmmmmmmmmmmllllllllllkkkkkkkkkkjjjjjjjjjjiiiiiiiiiihhhhhhhhhhggggggggggffffffffffeeeeeeeeeeddddddddddccccccccccbbbbbbbbbbaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffffgggggggggghhhhhhhhhhiiiiiiiiiijjjjjjjjjjkkkkkkkkkkllllllllllmmmmmmmmmmnnnnnnnnnnooooooooooppppppppppqqqqqqqqqqrrrrrrrrrrssssssssssttttttttttuuuuuuuuuu"))
	// d := time.Since(start)
	// fmt.Println(d)
}
