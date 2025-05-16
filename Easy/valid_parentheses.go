package main

import (
	"fmt"
	"strings"
)

func isValid(s string) bool {
	lenS := len(s)
	if lenS%2 != 0 || lenS > 10000 {
		return false
	}

	mapParentheses := map[string]string{
		"(": ")",
		"[": "]",
		"{": "}",
	}
	collectParentheses := []string{}
	strSplit := strings.Split(s, "")

	for i, c := range strSplit {
		stateValidChar := false
		for pStart, pClose := range mapParentheses {
			if i == 0 && c == pClose {
				return false
			}

			if len(collectParentheses) == 0 && c == pClose {
				return false
			}

			if c == pStart || c == pClose {
				stateValidChar = true
			}
		}

		if !stateValidChar {
			return false
		}

		if _, ok := mapParentheses[c]; ok {
			collectParentheses = append(collectParentheses, c)
			continue
		}

		lastCheck := collectParentheses[len(collectParentheses)-1]
		if v, ok := mapParentheses[lastCheck]; ok {
			if v == c {
				collectParentheses = collectParentheses[:len(collectParentheses)-1]
			} else {
				return false
			}
		} else {
			return false
		}
	}

	return len(collectParentheses) == 0
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
