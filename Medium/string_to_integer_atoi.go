package main

import (
	"fmt"
	"strconv"
	"strings"
)

func myAtoi(s string) int {
	s = strings.TrimSpace(s)

	if len(s) == 0 || len(s) > 200 {
		return 0
	}

	var collectString string
	isNegative := string(s[0]) == "-"

	for i := 0; i < len(s); i++ {
		if (i == 0 && isNegative) || (i == 0 && string(s[i]) == "+") || string(s[i]) == "" {
			continue
		}

		_, err := strconv.Atoi(string(s[i]))
		if err != nil {
			break
		}

		collectString = collectString + string(s[i])
	}

	resultInt, err := strconv.Atoi(collectString)
	if err != nil {
		if len(collectString) > 5 {
			if isNegative {
				return -(1 << 31)
			} else {
				return (1 << 31) - 1
			}
		}
		return 0
	}

	if isNegative {
		resultInt = -(resultInt)
	}

	if resultInt < -(1 << 31) {
		return -(1 << 31)
	} else if resultInt > (1<<31)-1 {
		return (1 << 31) - 1
	}

	return resultInt
}

func run_myAtoi() {
	fmt.Println(myAtoi("1337c0d3"))
	fmt.Println(myAtoi("  -042"))
	fmt.Println(myAtoi("20000000000000000000"))
	fmt.Println(myAtoi("+1"))
}
