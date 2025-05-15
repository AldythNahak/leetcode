package main

import (
	"fmt"
	"strconv"
)

func isPalindrome(x int) bool {
	strX := strconv.Itoa(x)
	var strXR string
	for _, v := range strX {
		strXR = string(v) + strXR
	}
	return strX == strXR
}

func run_isPalindrome() {
	fmt.Println(isPalindrome(121))  //true
	fmt.Println(isPalindrome(-121)) //false
	fmt.Println(isPalindrome(10))   //false
}
