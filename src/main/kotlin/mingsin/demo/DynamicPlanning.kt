package mingsin.demo

import java.lang.Integer.max
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

/**
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个下标。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 *
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
fun canJump(nums: IntArray): Boolean {
    val dp = IntArray(nums.size) { 0 }
    for (i in nums.indices) {
        val k = if (i > 0) dp[i - 1] else 0
        if (k < i) return false
        dp[i] = max(i + nums[i], k)
    }
    return true
}

/**
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 *
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 *
 * 0 <= j <= nums[i]
 * i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 * 示例 2:
 *
 * 输入: nums = [2,3,0,1,4]
 * 输出: 2
 *
 *
 * 提示:
 *
 * 1 <= nums.length <= 104
 * 0 <= nums[i] <= 1000
 * 题目保证可以到达 nums[n-1]
 */
fun jump(nums: IntArray): Int {
    if (nums.size <= 1) return 0
    val dp = IntArray(nums.size) { Int.MAX_VALUE }
    dp[0] = 0
    for (i in 1 until nums.size) {
        for (j in 0 until i) {
            if (nums[j] + j >= i) {
                dp[i] = min(dp[i], dp[j] + 1)
            }
        }

    }
    return dp[nums.size - 1]
}

fun jump2(nums: IntArray): Int {
    if (nums.size <= 1) return 0
    var jump = 0
    var curEnd = 0
    var curFarthest = 0

    for (i in 0 until nums.size - 1) {
        curFarthest = max(curFarthest, nums[i] + i)

        if (i == curEnd) {
            jump += 1
            curEnd = curFarthest
        }
    }
    return jump
}


fun main() {

//    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
//    println(generatePascalsTriangle(5).map { it.toString() })

//    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
//    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
//    println(canJump(intArrayOf(0)))
//    println(canJump(intArrayOf(2, 0)))
//    println(canJump(intArrayOf(2, 0, 0)))

    println(jump(intArrayOf(2, 3, 1, 1, 4)))
    println(jump2(intArrayOf(2, 3, 1, 1, 4)))
    println(jump2(intArrayOf(2, 0, 0)))
    println(jump(intArrayOf(2, 0, 0)))
}