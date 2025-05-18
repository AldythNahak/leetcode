package main

import (
	"fmt"
	"strconv"
)

func reverse(x int) int {
	strX := strconv.Itoa(x)
	isNegative := string(strX[0]) == "-"

	if isNegative {
		strX = "-" + reverseString(strX[1:len(strX)])
	} else {
		strX = reverseString(strX)
	}

	convToInteger, err := strconv.Atoi(strX)
	if err != nil {
		return 0
	}

	if convToInteger < -(1<<31) || convToInteger > (1<<31)-1 {
		return 0
	}

	return convToInteger
}

func run_reverse() {
	fmt.Println(reverse(123))        //321
	fmt.Println(reverse(-123))       //-321
	fmt.Println(reverse(1534236469)) //0
}
