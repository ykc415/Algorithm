package com.example.algorithm

import org.junit.Test

import org.junit.Assert.*


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 *
 *
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.

 */

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    override fun equals(other: Any?): Boolean {
        if(other is ListNode?) {
            var n1 : ListNode? = this
            var n2 = other as ListNode?

            while (true) {
                if(n1?.`val` != n2?.`val`) {
                    return false
                }

                if(n1?.next == null && n2?.next == null) {
                    break
                }

                n1 = n1?.next
                n2 = n2?.next

            }

            return true
        }

        return super.equals(other)
    }
}

class MySolution {

    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var result: ListNode? = null
        var lastNode: ListNode? = null
        var n1 = l1
        var n2 = l2
        var before_val = 0

        while (true) {
            var added_value = (n1?.`val` ?: 0) + (n2?.`val` ?: 0) + before_val/10

            before_val = added_value

            if(added_value >= 10) {
                added_value %= 10
            }

            val newNode = ListNode(added_value)

            if(result == null) {
                result = newNode
            }

            lastNode?.next = newNode
            lastNode = newNode

            if(n1?.next == null && n2?.next == null && before_val < 10) {
                break
            }

            n1 = n1?.next
            n2 = n2?.next

        }

        return result
    }

    @Test
    fun testCase0() {
        val input0 = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }

        val input1 = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
            }
        }

        val output = addTwoNumbers(input0, input1)

        val expected = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        assertEquals(expected, output)
    }

    @Test
    fun testCase1() {
        val input0 = ListNode(5)
        val input1 = ListNode(5)

        val output = addTwoNumbers(input0, input1)

        val expected = ListNode(0).apply {
            next = ListNode(1)
        }

        assertEquals(expected, output)
    }
}


class AnotherSolution {
    fun another_answer(l1: ListNode?, l2: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        var p = l1
        var q = l2
        var curr: ListNode? = dummyHead
        var carry = 0
        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = carry + x + y
            carry = sum / 10
            curr!!.next = ListNode(sum % 10)
            curr = curr.next
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (carry > 0) {
            curr!!.next = ListNode(carry)
        }
        return dummyHead.next
    }


    @Test
    fun testCase0() {
        val input0 = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }

        val input1 = ListNode(5).apply {
            next = ListNode(6).apply {
                next = ListNode(4)
            }
        }

        val output = another_answer(input0, input1)

        val expected = ListNode(7).apply {
            next = ListNode(0).apply {
                next = ListNode(8)
            }
        }

        assertEquals(expected, output)
    }

    @Test
    fun testCase1() {
        val input0 = ListNode(5)
        val input1 = ListNode(5)

        val output = another_answer(input0, input1)

        val expected = ListNode(0).apply {
            next = ListNode(1)
        }

        assertEquals(expected, output)
    }


}