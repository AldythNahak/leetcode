package main

import (
	"fmt"
	"math"
)

func divide(dividend int, divisor int) int {
	const INT_MIN = -(1 << 31)
	const INT_MAX = (1 << 31) - 1

	if dividend < INT_MIN {
		dividend = INT_MIN
	}

	if divisor > INT_MAX {
		divisor = INT_MAX
	}

	if divisor == 0 {
		return 0
	}

	divideNumber := dividend / divisor
	divideNumber = int(math.RoundToEven(float64(divideNumber)))

	if divideNumber > INT_MAX {
		return INT_MAX
	} else if divideNumber < INT_MIN {
		return INT_MIN
	}

	return divideNumber
}

func run_divide() {
	fmt.Println(divide(10, 3))           //3
	fmt.Println(divide(7, -3))           //-2
	fmt.Println(divide(-2147483648, -1)) //2147483647
	fmt.Println(divide(2147483647, 2))   //1073741823

}
