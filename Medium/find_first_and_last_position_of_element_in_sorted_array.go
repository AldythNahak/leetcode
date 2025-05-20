package main

import (
	"fmt"
)

func searchRange(nums []int, target int) []int {
	collectRange := []int{}
	for i, n := range nums {
		if n == target {
			collectRange = append(collectRange, i)
		}
	}

	if len(collectRange) == 0 {
		return []int{-1, -1}
	} else if len(collectRange) == 1 {
		collectRange = append(collectRange, collectRange[0])
	}

	return []int{collectRange[0], collectRange[len(collectRange)-1]}
}

func run_searchRange() {
	fmt.Println(searchRange([]int{5, 7, 7, 8, 8, 10}, 8))
	fmt.Println(searchRange([]int{1}, 1))
	fmt.Println(searchRange([]int{3, 3, 3}, 3))
	fmt.Println(searchRange([]int{0, 0, 1, 2, 2}, 5))
}
