package mingsin.demo

import mingsin.demo.listnode.ListNode

class AddTwoNumber {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p = l1
        var q = l2
        val dummy = ListNode(0)
        var cur = dummy
        var carry = 0

        while (l1 != null || l2 != null) {
            val x = p?.v ?: 0
            val y = q?.v ?: 0
            val sum = x + y + carry
            carry = sum / 10
            val node = ListNode(sum % 10)
            cur.next = node

            if (p != null) {
                p = p.next
            }
            if (q != null) {
                q = q.next
            }
            cur = cur.next!!
        }
        return dummy.next
    }

}

