public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(0);
        ListNode current = node;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = v1 + v2 + carry;
            carry = sum / 10;

            current.next = new ListNode(sum % 10);
            current = current.next;

            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        return node.next;
    }
}

public class add_two_numbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.addTwoNumbers(new int[] { 2, 7, 11, 15 }, 9));
        // System.out.println(solution.addTwoNumbers(new int[] { 3, 2, 4 }, 6));
        // System.out.println(solution.addTwoNumbers(new int[] { 3, 3 }, 6));
        // System.out.println(solution.addTwoNumbers(new int[] { -3, 4, 3, 90 }, 0));
    }
}