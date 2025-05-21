package main

import (
	"fmt"
	"math"
	"sort"
)

func threeSumClosest(nums []int, target int) int {
	if len(nums) < 3 || len(nums) > 3000 {
		return 0
	}

	totalNum := len(nums)
	sort.Slice(nums, func(i, j int) bool { return nums[i] < nums[j] })
	lastSumClosest := nums[0] + nums[1] + nums[2]

	for i := 0; i < totalNum; i++ {
		iLeft, iRight := i+1, totalNum-1
		for iLeft < iRight {
			sumNum := nums[iLeft] + nums[i] + nums[iRight]
			closest := int(math.Abs(float64(target - sumNum)))
			lastClosest := int(math.Abs(float64(target - lastSumClosest)))

			// fmt.Printf("%d | %d | %d \n", sumNum, closest, lastClosest)

			if target == sumNum {
				return sumNum
			}

			if closest < lastClosest {
				lastSumClosest = sumNum
			}

			if sumNum < target {
				iLeft++
			} else {
				iRight--
			}
		}
	}

	return lastSumClosest
}

func run_threeSumClosest() {
	fmt.Println(threeSumClosest([]int{-1, 2, 1, -4}, 1))                       //2
	fmt.Println(threeSumClosest([]int{0, 0, 0}, 1))                            //0
	fmt.Println(threeSumClosest([]int{0, 1, 2}, 3))                            //3
	fmt.Println(threeSumClosest([]int{10, 20, 30, 40, 50, 60, 70, 80, 90}, 1)) //60
	fmt.Println(threeSumClosest([]int{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2))      //-2
	fmt.Println(threeSumClosest([]int{-4, 2, 2, 3, 3, 3}, 0))                  //0
	fmt.Println(threeSumClosest([]int{1, 1, 1, 0}, 100))                       //3
}
