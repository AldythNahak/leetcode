package main

import "fmt"

func longestValidParentheses(s string) int {
	countValidParentheses := 0
	storeIndex := []int{-1}

	for i, c := range s {
		if string(c) == "(" {
			storeIndex = append(storeIndex, i)
		} else {
			storeIndex = storeIndex[:len(storeIndex)-1]
			if len(storeIndex) == 0 {
				storeIndex = append(storeIndex, i)
			} else {
				countValidParentheses = max(countValidParentheses, i-storeIndex[len(storeIndex)-1])
			}
		}
	}

	return countValidParentheses
}

func run_longestValidParentheses() {
	fmt.Println(longestValidParentheses("(()"))    //2
	fmt.Println(longestValidParentheses(")()())")) //4
	fmt.Println(longestValidParentheses(""))       //0
	fmt.Println(longestValidParentheses("()(()"))  //2
	fmt.Println(longestValidParentheses("()(())")) //6
	fmt.Println(longestValidParentheses("()"))     //2
}
