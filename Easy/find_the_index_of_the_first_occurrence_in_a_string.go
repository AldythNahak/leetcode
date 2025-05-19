package main

import (
	"fmt"
	"strings"
)

func strStr(haystack string, needle string) int {
	return strings.Index(haystack, needle)
}

func run_strStr() {
	fmt.Println(strStr("sadbutsad", "sad"))
	fmt.Println(strStr("leetcode", "leeto"))
}
