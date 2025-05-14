package main

import "slices"

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	if len(nums1) > 1000 || len(nums2) > 1000 {
		return 0
	}

	joinArr := append(nums1, nums2...)
	slices.Sort(joinArr)
	lenJoinArr := len(joinArr)

	if lenJoinArr == 0 || lenJoinArr > 2000 {
		return 0
	}

	mid := lenJoinArr / 2
	if lenJoinArr%2 == 1 {
		return float64(joinArr[mid])
	}

	return (float64(joinArr[mid-1]) + float64(joinArr[mid])) / 2.0
}
