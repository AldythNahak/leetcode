package main

import (
	"fmt"
	"strings"
)

func isValid(s string) bool {
	lenS := len(s)
	if lenS%2 == 0 || lenS > 10000 {
		return false
	}

	mapParentheses := map[string]string{
		"(": ")",
		"[": "]",
		"{": "}",
	}
	// collectParentheses := make([]string)
	strSplit := strings.Split(s, "")

	for i, _ := range strSplit {
		if i == 0 {
			for _, p := range mapParentheses {
				fmt.Println(p)
			}
		}

	}

	return true
}

func run_isValid() {
	fmt.Println(isValid("(]"))       //false
	fmt.Println(isValid("()[]{}"))   //true
	fmt.Println(isValid("([])"))     //true
	fmt.Println(isValid("(}{)"))     //false
	fmt.Println(isValid("([{}])"))   //true
	fmt.Println(isValid("(){}}{"))   //false
	fmt.Println(isValid("(([]){})")) //true
}
