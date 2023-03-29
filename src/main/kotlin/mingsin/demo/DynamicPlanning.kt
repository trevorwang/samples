package mingsin.demo

import java.lang.Integer.min


fun minCostClimbingStairs(costs: IntArray): Int {
    val n = costs.size
    var dp = IntArray(n + 1) { 0 }
    dp[0] = 0
    dp[1] = 0
    // 动态规划问题
    for (i in 2..n) {
        dp[i] = min(dp[i - 1] + costs[i - 1], dp[i - 2] + costs[i - 2])
    }
    return dp[n]
}


fun dominantIndex(nums: IntArray): Int {
    var m1 = 0
    var m2 = 0
    var index = 0

    for (i in nums.indices) {

        if (nums[i] > m1) {
            m2 = m1
            m1 = nums[i]
            index = i
        } else if (nums[i] > m2) {
            m2 = nums[i]
        }
    }

    return if (m1 > m2 * 2) index else -1
}

fun generatePascalsTriangle(numRows: Int): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
//    result.add(listOf(1))
//    if (numRows == 1) return result
//    result.add(listOf(1, 1))
//    if (numRows == 2) return result
//    for (i in 2 until numRows) {
//        result.add(mutableListOf<Int>().apply {
//            add(1)
//            val pre = result[i - 1]
//            for (j in 0 until pre.size - 1) {
//                add(pre[j] + pre[j + 1])
//            }
//            add(1)
//        })
//    }
    for (i in 0 until numRows) {
        val temp = mutableListOf<Int>()
        for (j in 0..i) {
            if (j == 0 || j == i) {
                temp.add(1)
            } else {
                temp.add(result[i - 1][j] + result[i - 1][j - 1])
            }
        }
        result.add(temp)
    }
    return result
}


fun main() {

//    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
    println(generatePascalsTriangle(5).map { it.toString() })
}