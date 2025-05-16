package main

import (
	"fmt"
	"strings"
)

func lengthOfLongestSubstring(s string) int {
	if len(s) == 0 || len(s) > 50000 {
		return 0
	}

	startIndex := make(map[string]int)
	longestSubtstring := 1
	startPosition := 0
	strSplit := strings.Split(s, "")

	for i, c := range strSplit {
		if _, ok := startIndex[c]; ok {
			if startIndex[c] >= startPosition {
				startPosition = startIndex[c] + 1
			}
		}

		startIndex[c] = i
		longestSubtstring = max(longestSubtstring, i-startPosition+1)
	}

	return longestSubtstring
}

func run_lengthOfLongestSubstring() {
	fmt.Println(lengthOfLongestSubstring("abcabcbb")) // 3
	fmt.Println(lengthOfLongestSubstring("bbbbb"))    // 1
	fmt.Println(lengthOfLongestSubstring("pwwkew"))   // 3
	fmt.Println(lengthOfLongestSubstring(""))         // 0
	fmt.Println(lengthOfLongestSubstring("au"))       // 2
	fmt.Println(lengthOfLongestSubstring("aab"))      // 2
}
