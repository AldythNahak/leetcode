<?php

class ListNode
{
    public $val = 0;
    public $next = null;

    function __construct($val = 0, $next = null)
    {
        $this->val = $val;
        $this->next = $next;
    }
}

/**
 * Definition for a singly-linked list.
 * class ListNode {
 *     public $val = 0;
 *     public $next = null;
 *     function __construct($val = 0, $next = null) {
 *         $this->val = $val;
 *         $this->next = $next;
 *     }
 * }
 */
class Solution
{

    /**
     * @param ListNode $l1
     * @param ListNode $l2
     * @return ListNode
     */
    function addTwoNumbers($l1, $l2)
    {
        $node = new ListNode();
        $current = $node;
        $carry = 0;

        while ($l1 !== null || $l2 !== null || $carry > 0) {
            $v1 = $l1 !== null ? $l1->val : 0;
            $v2 = $l2 !== null ? $l2->val : 0;

            $sum = $v1 + $v2 + $carry;
            $carry = intdiv($sum, 10);
            $current->next = new ListNode($sum % 10);
            $current = $current->next;

            if ($l1 !== null) {
                $l1 = $l1->next;
            }

            if ($l2 !== null) {
                $l2 = $l2->next;
            }
        }

        return $node->next;
    }
}

function arrayToList($arr)
{
    $node = new ListNode();
    $current = $node;
    foreach ($arr as $val) {
        $current->next = new ListNode($val);
        $current = $current->next;
    }
    return $node->next;
}

function listToArray($node)
{
    $result = [];
    while ($node !== null) {
        $result[] = $node->val;
        $node = $node->next;
    }
    return $result;
}

$solution = new Solution();
$listTest = array(
    array(array(2, 4, 3), array(5, 6, 4)),
    array(array(9, 9, 9, 9, 9, 9, 9), array(9, 9, 9, 9)),
    array(array(0), array(0)),
);

foreach ($listTest as $num) {
    $num1 = arrayToList($num[0]);
    $num2 = arrayToList($num[1]);
    print_r(listToArray($solution->addTwoNumbers($num1, $num2)));
}
