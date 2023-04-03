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

/**
 * 198. 打家劫舍
 * 中等
 * 2.5K
 * 相关企业
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 *
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 400
 */
fun rob(nums: IntArray): Int {
    val n = nums.size
    if (n == 0) return 0
    val dp = IntArray(n + 1) { 0 }
    dp[0] = 0
    dp[1] = nums[0]

    for (i in 2..n) {
        dp[i] = max(dp[i - 1], nums[i - 1] + dp[i - 2])
    }
    return dp[n]
}

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 *
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 *
 * 输入：nums = [1,2,3]
 * 输出：3
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */

fun rob2(nums: IntArray): Int {
    fun robi(nums: IntArray): Int {
        val n = nums.size
        if (n == 0) return 0
        val dp = IntArray(n + 1) { 0 }
        dp[0] = 0
        dp[1] = nums[0]

        for (i in 2..n) {
            dp[i] = max(dp[i - 1], nums[i - 1] + dp[i - 2])
        }
        return dp[n]
    }

    val n = nums.size
    if (n == 1) return nums[0]
    val first = nums.take(n - 1).toIntArray()
    val last = nums.takeLast(n - 1).toIntArray()
    return max(robi(first), robi(last))
}

/**
 * 删除并获得点数
 * 给你一个整数数组 nums ，你可以对它进行一些操作。
 *
 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除 所有 等于 nums[i] - 1 和 nums[i] + 1 的元素。
 *
 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [3,4,2]
 * 输出：6
 * 解释：
 * 删除 4 获得 4 个点数，因此 3 也被删除。
 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
 * 示例 2：
 *
 * 输入：nums = [2,2,3,3,3,4]
 * 输出：9
 * 解释：
 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
 * 总共获得 9 个点数。
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 2 * 104
 * 1 <= nums[i] <= 104
 */

fun deleteAndEarn(nums: IntArray): Int {
    val n = nums.max()
    val sum = IntArray(n + 1) { 0 }
    for (i in nums.indices) {
        sum[nums[i]] += nums[i]
    }
    val dp = IntArray(n + 1) { 0 }
    dp[1] = sum[1]
    for (i in 2..n) {
        dp[i] = max(dp[i - 1], dp[i - 2] + sum[i])
    }
    return dp[n]
}

/**
 * 53. 最大子数组和
 *
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 *
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 *
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 *
 *
 * 提示：
 *
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 *
 *
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
fun maxSubArray(nums: IntArray): Int {
    val n = nums.size
    val dp = IntArray(n) { Int.MIN_VALUE }
    dp[0] = nums[0]
    for (i in 1 until n) {
        dp[i] = max(dp[i - 1] + nums[i], nums[i])
    }
    return dp.max()
}

fun main() {

//    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
//    println(generatePascalsTriangle(5).map { it.toString() })

//    println(canJump(intArrayOf(2, 3, 1, 1, 4)))
//    println(canJump(intArrayOf(3, 2, 1, 0, 4)))
//    println(canJump(intArrayOf(0)))
//    println(canJump(intArrayOf(2, 0)))
//    println(canJump(intArrayOf(2, 0, 0)))

//    println(jump(intArrayOf(2, 3, 1, 1, 4)))
//    println(jump2(intArrayOf(2, 3, 1, 1, 4)))
//    println(jump2(intArrayOf(2, 0, 0)))
//    println(jump(intArrayOf(2, 0, 0)))
//    println(rob2(intArrayOf(1, 2, 3, 1)))
//    println(deleteAndEarn(intArrayOf(1, 1, 1)))

    print(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}