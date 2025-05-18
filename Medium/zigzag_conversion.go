package main

import (
	"fmt"
	"strings"
)

func convert(s string, numRows int) string {
	if len(s) <= 1 || len(s) > 1000 || numRows <= 1 || numRows > 1000 {
		return s
	}

	var collectZigzag []string
	currRow := 0
	isStraight := true

	for i := 0; i < len(s); i++ {
		if i < numRows {
			collectZigzag = append(collectZigzag, "")
		}

		if currRow == 0 {
			isStraight = true
		} else if currRow == numRows-1 {
			isStraight = false
		}

		collectZigzag[currRow] += string(s[i])

		if isStraight {
			currRow++
		} else {
			currRow--
		}
	}

	return strings.Join(collectZigzag, "")
}

func run_convert() {
	fmt.Println(convert("PAYPALISHIRING", 3))
}
