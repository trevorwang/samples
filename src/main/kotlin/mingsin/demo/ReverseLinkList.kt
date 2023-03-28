package mingsin.demo

import mingsin.demo.listnode.ListNode

class ReverseLinkList {
    fun reverseList(head: ListNode?): ListNode? {
        var pre: ListNode? = null

        var cur = head

        while(cur !=null) {
            var next = cur.next

            cur.next = pre
            pre = cur



            cur = next

        }



        return pre
    }
}