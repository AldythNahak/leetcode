package main

import (
	"fmt"
	"slices"
)

func removeDuplicates(nums []int) int {
	slices.Sort(nums)
	return len(slices.Compact(nums))
}

func run_removeDuplicates() {
	fmt.Println(removeDuplicates([]int{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}))
	fmt.Println(removeDuplicates([]int{1, 1, 2}))
}
