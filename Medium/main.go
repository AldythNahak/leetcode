package main

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func main() {
	// run_addTwoNumbers()
	// run_lengthOfLongestSubstring()
	// run_longestPalindrome()
	// run_convert()
	// run_reverse()
	// run_myAtoi()
	// run_intToRoman()
	run_threeSum()
	// run_maxArea()
}
