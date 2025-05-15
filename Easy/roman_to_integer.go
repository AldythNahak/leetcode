package main

import (
	"fmt"
	"strings"
)

func romanToInt(s string) int {
	symbolMap := map[string]int{"I": 1, "V": 5, "X": 10, "L": 50, "C": 100, "D": 500, "M": 1000}
	total := 0
	strSplit := strings.Split(strings.ToUpper(s), "")

	for i, c := range strSplit {
		if _, ok := symbolMap[c]; !ok {
			break
		}

		if i > 0 {
			if (c == "V" || c == "X") && strSplit[i-1] == "I" {
				total -= 2
			}

			if (c == "L" || c == "C") && strSplit[i-1] == "X" {
				total -= 20
			}

			if (c == "D" || c == "M") && strSplit[i-1] == "C" {
				total -= 200
			}
		}

		total += symbolMap[c]
	}

	return total
}

func run_romanToInt() {
	fmt.Println(romanToInt("MCMXCIV"))
}
