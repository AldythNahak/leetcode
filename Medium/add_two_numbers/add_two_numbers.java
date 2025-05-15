package add_two_numbers;

import java.util.ArrayList;
import java.util.List;

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

    public static ListNode arrayToList(int[] arr) {
        ListNode node = new ListNode(0);
        ListNode current = node;
        for (int val : arr) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return node.next;
    }

    public static int[] listToArray(ListNode head) {
        List<Integer> tempList = new ArrayList<>();
        while (head != null) {
            tempList.add(head.val);
            head = head.next;
        }

        int[] result = new int[tempList.size()];
        for (int i = 0; i < tempList.size(); i++) {
            result[i] = tempList.get(i);
        }
        return result;
    }
}

public class add_two_numbers {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][][] listTest = new int[][][] {
                { { 2, 4, 3 }, { 5, 6, 4 } },
                { { 9, 9, 9, 9, 9, 9, 9 }, { 9, 9, 9, 9 } },
                { { 0 }, { 0 } }
        };

        for (int i = 0; i < listTest.length; i++) {
            ListNode num1 = solution.arrayToList(listTest[i][0]);
            ListNode num2 = solution.arrayToList(listTest[i][1]);
            System.out.println(solution.listToArray(solution.addTwoNumbers(num1, num2)));
        }
    }
}