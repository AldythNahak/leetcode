package main

import (
	"fmt"
	"regexp"
)

func isMatch(s string, p string) bool {
	regx := fmt.Sprintf("^%s$", p)
	isMatch, err := regexp.MatchString(regx, s)
	if err != nil {
		return false
	}

	return isMatch
}

func run_isMatch() {
	fmt.Println(isMatch("aa", "a"))  //False
	fmt.Println(isMatch("aa", "a*")) //True
	fmt.Println(isMatch("ab", ".*")) //True
}
