package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	node := &ListNode{}
	current := node
	carry := 0

	for l1 != nil || l2 != nil || carry > 0 {
		v1, v2 := 0, 0

		if l1 != nil {
			v1 = l1.Val
			l1 = l1.Next
		}

		if l2 != nil {
			v2 = l2.Val
			l2 = l2.Next
		}

		sum := v1 + v2 + carry
		carry = sum / 10

		current.Next = &ListNode{Val: sum % 10}
		current = current.Next
	}

	return node.Next
}

func arrayToList(arr []int) *ListNode {
	node := &ListNode{}
	current := node

	for _, val := range arr {
		current.Next = &ListNode{Val: val}
		current = current.Next
	}

	return node.Next
}

func listToArray(node *ListNode) []int {
	var result []int
	for node != nil {
		result = append(result, node.Val)
		node = node.Next
	}
	return result
}

func run_addTwoNumbers() {
	listTest := [][][]int{
		{
			{2, 4, 3}, // First number
			{5, 6, 4}, // Second number
		},
		{
			{9, 9, 9, 9, 9, 9, 9},
			{9, 9, 9, 9},
		},
		{
			{0},
			{0},
		},
	}

	for _, num := range listTest {
		num1 := arrayToList(num[0])
		num2 := arrayToList(num[1])
		fmt.Println(listToArray(addTwoNumbers(num1, num2)))
	}
}
