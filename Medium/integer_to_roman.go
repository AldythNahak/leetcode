package main

import (
	"fmt"
	"math"
)

func intToRoman(num int) string {
	// symbolMap := map[string]int{"M": 1000, "CM": 900, "D": 500, "CD": 400, "C": 100, "XC": 90, "L": 50, "XL": 40, "X": 10, "IX": 9, "V": 5, "IV": 4, "I": 1}
	symbolMap := []string{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"}
	symbolVal := []int{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1}
	romanText := ""

	for symbolIndex, val := range symbolVal {
		if num >= val {
			totalSymbol := math.RoundToEven(float64(num / val))
			for i := 0; i < int(totalSymbol); i++ {
				romanText += symbolMap[symbolIndex]
				num -= val
			}
		}
	}

	return romanText
}

func run_intToRoman() {
	fmt.Println(intToRoman(3749)) //MMMDCCXLIX
	fmt.Println(intToRoman(58))   //LVIII
}
