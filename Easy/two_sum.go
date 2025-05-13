package main

func twoSum(nums []int, target int) []int {
	list := make(map[int]int)

	for i, n := range nums {
		s := target - n
		if j, isMatch := list[s]; isMatch {
			return []int{j, i}
		}
		list[n] = i
	}

	return nil
}

// func main() {
// 	fmt.Println(twoSum([]int{2, 7, 11, 15}, 9)) //[0, 1]
// 	fmt.Println(twoSum([]int{3, 2, 4}, 6))      //[1, 2]
// 	fmt.Println(twoSum([]int{3, 3}, 6))         //[0, 1]
// 	fmt.Println(twoSum([]int{-3, 4, 3, 90}, 0)) //[0, 2]
// }
