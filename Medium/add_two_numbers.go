package main

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

// func main() {
// 	fmt.Println(addTwoNumbers([]int{2, 4, 3}, []int{5, 6, 4}))
// }
