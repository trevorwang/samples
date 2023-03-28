package mingsin.demo

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    val m = nums1.size
    val n = nums2.size
    val len = m + n
    var i = 0
    var j = 0
    var left = 0
    var right = 0

    for (x in 0..len / 2) {
        left = right
        if (i < m && (j >= n || nums1[i] < nums2[j])) {
            right = nums1[i]
            i++
        } else {
            right = nums2[j]
            j++
        }
    }
    return if (len % 2 == 1) {
        right * 1.0
    } else {
        (left + right) / 2.0
    }

}


fun main() {
    val nums1 = intArrayOf(1)
    val nums2 = intArrayOf()
    println()
    val r = findMedianSortedArrays(nums1 = nums1, nums2 = nums2)
    println(r)
}