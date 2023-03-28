package mingsin.demo

class QuickSort {

    fun quickSort(nums: List<Int>): List<Int> {
        if (nums.size <= 1) return nums
        val pilot = nums.first()
        val left = mutableListOf<Int>()
        val right = mutableListOf<Int>()
        for (i in 1 until nums.size) if (nums[i] > pilot) {
            right.add(nums[i])
        } else {
            left.add(nums[i])
        }
        return mutableListOf<Int>().apply {
            addAll(quickSort(left))
            add(pilot)
            addAll(quickSort(right))
        }
    }

    fun findTheKthBiggest(k: Int, nums: List<Int>): Int {
        val pilot = nums.first()
        var left = mutableListOf<Int>()
        val right = mutableListOf<Int>()

        for (i in 1 until nums.size) if (nums[i] >= pilot) {
            left.add(nums[i])
        } else {
            right.add(nums[i])
        }

        return if (left.size == k - 1) {
            pilot
        } else if (left.size > k - 1) {
            findTheKthBiggest(k, left)
        } else {
            findTheKthBiggest(k - left.size - 1, right)
        }
    }


    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (i in nums.indices) {
            if (map.contains(target - nums[i])) {
                return intArrayOf(i, map[target - nums[i]]!!)
            } else {
                map[nums[i]] = i
            }
        }
        return intArrayOf(0, 0)
    }

    fun climbStairs(n: Int): Int {
        if (n == 1) return 1
        var dp = IntArray(n + 1) { 0 }
        dp[1] = 1
        dp[2] = 2

        for (i in 3..n) {
            dp[i] = dp[i - 1] + dp[i - 2]
        }

        return dp[n]
    }
}

fun main() {

    var array = listOf(13, 3, 4, 5, 6, 11, 33, 8, 9)

    println(QuickSort().quickSort(array).map { it.toString() })


    println(QuickSort().findTheKthBiggest(3, array))
    println(QuickSort().climbStairs(1))
    println(QuickSort().climbStairs(5))

}