package main

import "fmt"

func searchInsert(nums []int, target int) int {
	index := 0
	for i, n := range nums {
		if n >= target {
			index = i
			break
		}
	}

	if len(nums) > 0 && index == 0 && nums[len(nums)-1] < target {
		return len(nums)
	}

	return index
}

func run_searchInsert() {
	fmt.Println(searchInsert([]int{1, 3, 5, 6}, 5))
}
