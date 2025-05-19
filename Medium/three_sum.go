package main

import (
	"fmt"
	"sort"
)

func threeSum(nums []int) [][]int {
	collectSum := [][]int{}

	if len(nums) < 3 || len(nums) > 3000 {
		return collectSum
	}

	totalNum := len(nums)
	sort.Slice(nums, func(i, j int) bool { return nums[i] < nums[j] })

	for i := 0; i < totalNum-2; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}

		iLeft, iRight := i+1, totalNum-1
		for iLeft < iRight {
			listSumNum := []int{nums[iLeft], nums[i], nums[iRight]}
			sort.Slice(listSumNum, func(i, j int) bool { return listSumNum[i] < listSumNum[j] })
			sumNum := nums[iLeft] + nums[i] + nums[iRight]
			if sumNum == 0 {
				collectSum = append(collectSum, listSumNum)
				for iLeft < iRight && nums[iLeft] == nums[iLeft+1] {
					iLeft++
				}
				for iLeft < iRight && nums[iRight] == nums[iRight-1] {
					iRight--
				}

				iLeft++
				iRight--
			} else if sumNum < 0 {
				iLeft++
			} else {
				iRight--
			}
		}
	}

	sort.Slice(collectSum, func(i, j int) bool { return collectSum[i][2] > collectSum[j][2] })

	return collectSum
}

func run_threeSum() {
	fmt.Println(threeSum([]int{-1, 0, 1, 2, -1, -4})) //[[-1,-1,2],[-1,0,1]]
	fmt.Println(threeSum([]int{0, 0, 0}))             //[[0,0,0]]
	fmt.Println(threeSum([]int{3, -2, 1, 0}))         //[]
	fmt.Println(threeSum([]int{1, -1, -1, 0}))        //[[-1,0,1]]
	fmt.Println(threeSum([]int{-1, 0, 1, 0}))         //[[-1,0,1]]
	fmt.Println(threeSum([]int{2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10}))
	//[[-10,5,5],[-5,0,5],[-4,2,2],[-3,-2,5],[-3,1,2],[-2,0,2]]
}
