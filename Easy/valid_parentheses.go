package main

import (
	"fmt"
)

func isValid(s string) bool {
	lenS := len(s)
	if lenS%2 == 0 || lenS > 10000 {
		return false
	}

	// mapParentheses := map[string]string{
	// 	"(": ")",
	// 	"[": "]",
	// 	"{": "}",
	// }
	// strSplit := strings.Split(s, "")

	// for i, c := range strSplit {
	// 	// 	if(i == 0 && Object.values(mapParentheses).includes(s[i])) {
	// 	//   return false;
	// 	// }
	// }

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
