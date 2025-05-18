package main

import (
	"fmt"
	"math"
)

func maxArea(height []int) int {
	if len(height) < 2 || len(height) > int(math.Pow(10, 5)) {
		return 0
	}

	leftWall, rightWall := 0, 1

	if len(height) == 2 {
		return max(height[leftWall], height[rightWall])
	}

	for i := 0; i < len(height)-1; i++ {
		if height[i] > height[(i+1)] && height[i] > height[leftWall] {
			leftWall = i
		}
	}

	fmt.Println(leftWall)
	fmt.Println(rightWall)

	fmt.Println("----")
	return max(leftWall, rightWall)
}

func run_maxArea() {
	fmt.Println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7})) //49
	// fmt.Println(maxArea([]int{1, 1}))                      //49
}
