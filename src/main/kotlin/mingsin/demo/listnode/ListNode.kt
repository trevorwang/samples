package mingsin.demo.listnode

class ListNode(var v: Int) {
    var next: ListNode? = null
}


fun ListNode?.toArray(): IntArray {
    var result = mutableListOf<Int>()
    var p = this
    while (p != null) {
        result.add(p.v)
        p = p.next
    }
    return result.toIntArray()
}

fun ListNode?.print() {
    return print(this?.toArray()?.joinToString())
}

fun deleteNode(head: ListNode?, v: Int): ListNode? {
    var p: ListNode? = head ?: return null
    if (p?.v == v) p = p.next
    p?.next = deleteNode(p?.next, v)
    return p
}

fun arrayToListNode(arrays: IntArray): ListNode? {
    var root = ListNode(0)
    var pre = root
    for (i in arrays) {
        var node = ListNode(i)
        pre.next = node
        pre = node
    }

    return root.next
}


fun main() {
    var listNode = intArrayOf(1, 3, 4, 5, 6, 6, 6, 7)

    arrayToListNode(listNode).print()
}