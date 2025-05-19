package main

import (
	"fmt"
	"math"
)

func divide(dividend int, divisor int) int {
	if dividend < -(1 << 31) {
		dividend = -(1 << 31)
	} else if dividend > (1<<31)-1 {
		dividend = (1 << 31) - 1
	}

	if divisor < -(1 << 31) {
		divisor = -(1 << 31)
	} else if divisor > (1<<31)-1 {
		divisor = (1 << 31) - 1
	}

	if divisor == 0 {
		return 0
	}

	return int(math.RoundToEven(float64(dividend) / float64(divisor)))
}

func run_divide() {
	fmt.Println(divide(10, 3))
	fmt.Println(divide(7, -3))
	fmt.Println(divide(-2147483648, -1))

}
