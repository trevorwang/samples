import mingsin.demo.listnode.ListNode

/**
 * 给定单链表的头节点 head ，将所有索引为奇数的节点和索引为偶数的节点分别组合在一起，然后返回重新排序的列表。
 *
 * 第一个节点的索引被认为是 奇数 ， 第二个节点的索引为 偶数 ，以此类推。
 *
 * 请注意，偶数组和奇数组内部的相对顺序应该与输入时保持一致。
 *
 * 你必须在 O(1) 的额外空间复杂度和 O(n) 的时间复杂度下解决这个问题。
 *
 *  
 *
 * 示例 1:
 *
 *
 *
 * 输入: head = [1,2,3,4,5]
 * 输出: [1,3,5,2,4]
 * 示例 2:
 *
 *
 *
 * 输入: head = [2,1,3,5,6,4,7]
 * 输出: [2,3,6,7,1,5,4]
 *
 *
 * 提示:
 *
 * n ==  链表中的节点数
 * 0 <= n <= 104
 * -106 <= Node.val <= 106
 *
 * 作者：LeetCode
 * 链接：https://leetcode.cn/leetbook/read/top-interview-questions-medium/xvdwtj/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */

fun oddEvenList(head: ListNode?): ListNode? {
//    var dummy = ListNode(1) // 保留偶数节点
//    var cur: ListNode? = dummy
//    var p = head
//
//    var pre: ListNode? = null
//    var count = 0
//    while (p != null) {
//        if (count % 2 == 1) {
//            pre?.next = p.next   // 删除偶数节点
//            cur?.next = p  // 保存到临时链表
//            cur = cur?.next
//        } else {
//            pre = p
//        }
//        p = p.next
//        count += 1
//    }
//    pre?.next = dummy.next
//    cur?.next = null    //删除最有一个节点可能存在的历史链接
//    return head

    if (head == null) return head
    var odd = head
    var even = head.next
    var eventHead = even

    while (even?.next != null) {
        odd?.next = even.next
        odd = odd?.next

        even.next = odd?.next
        even = even.next
    }
    odd?.next = eventHead
    return head
}


fun deleteListNode(head: ListNode?, target: ListNode): ListNode? {
    var p = head
    var pre = p

    while (p != null) {
        if (p.v == target.v) {
            pre?.next = p.next
        }
        pre = p
        p = p.next
    }
    return head
}