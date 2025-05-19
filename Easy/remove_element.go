package main

import (
	"fmt"
	"slices"
)

func removeElement(nums []int, val int) int {
	return len(slices.DeleteFunc(nums, func(i int) bool {
		return i == val
	}))
}

func run_removeElement() {
	fmt.Println(removeElement([]int{3, 2, 2, 3}, 3))
	fmt.Println(removeElement([]int{0, 1, 2, 2, 3, 0, 4, 2}, 2))
}
