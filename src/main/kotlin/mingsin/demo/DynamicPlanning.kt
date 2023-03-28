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

fun main() {

    println(minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)))
}