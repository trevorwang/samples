package mingsin.demo

import kotlin.math.abs

class Solution {
    /**
     * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
     *
     *
     * 示例 1:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     * 示例 2:
     *
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     *
     *
     * 提示：
     *
     * 你可以假设 nums 中的所有元素是不重复的。
     * n 将在 [1, 10000]之间。
     * nums 的每个元素都将在 [-9999, 9999]之间。
     */
    fun search(nums: IntArray, target: Int): Int {
        val n = nums.size
        var left = 0
        var right = n - 1

        while (left <= right) {
            var mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }

    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *
     * 请必须使用时间复杂度为 O(log n) 的算法。
     *
     *
     *
     * 示例 1:
     *
     * 输入: nums = [1,3,5,6], target = 5
     * 输出: 2
     * 示例 2:
     *
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     * 示例 3:
     *
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     *
     *
     * 提示:
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 为 无重复元素 的 升序 排列数组
     * -104 <= target <= 104
     */
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1

        while (left <= right) {
            var mid = left + (right - left) / 2
            if (nums[mid] == target) {
                return mid
            } else if (nums[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return left
    }

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     *
     *
     * 示例 1：
     *
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     * 示例 2：
     *
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 104
     * -104 <= nums[i] <= 104
     * nums 已按 非递减顺序 排序
     *
     *
     * 进阶：
     *
     * 请你设计时间复杂度为 O(n) 的算法解决本问题
     */
    fun sortedSquares(nums: IntArray): IntArray {
        var left = 0
        var right = nums.size - 1
        var squares = IntArray(nums.size)

        for (i in nums.size - 1 downTo 0) {
            if (abs(nums[left]) > abs(nums[right])) {
                squares[i] = nums[left] * nums[left]
                left++
            } else {
                squares[i] = nums[right] * nums[right]
                right--
            }
        }
        return squares
    }

    /**
     * 189. 轮转数组
     * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
     *
     * 示例 1:
     *
     * 输入: nums = [1,2,3,4,5,6,7], k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右轮转 1 步: [7,1,2,3,4,5,6]
     * 向右轮转 2 步: [6,7,1,2,3,4,5]
     * 向右轮转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     *
     * 输入：nums = [-1,-100,3,99], k = 2
     * 输出：[3,99,-1,-100]
     * 解释:
     * 向右轮转 1 步: [99,-1,-100,3]
     * 向右轮转 2 步: [3,99,-1,-100]
     *
     *
     * 提示：
     *
     * 1 <= nums.length <= 105
     * -231 <= nums[i] <= 231 - 1
     * 0 <= k <= 105
     *
     *
     * 进阶：
     *
     * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
     * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
     */

    fun rotate(nums: IntArray, k: Int): Unit {
        val n = nums.size
        var k = k % n
        val first = nums.takeLast(k)
        val last = nums.take(n - k)
        var index = 0

        for (i in first.indices) {
            nums[index] = first[i]
            index++
        }

        for (i in last.indices) {
            nums[index] = last[i]
            index++
        }
    }

    fun rotate2(nums: IntArray, k: Int): Unit {
        val len = nums.size
        val end = len - 1
        val realK = k % len
        for (i in 0 until realK) {
            val temp = nums[end]
            for (i in end downTo 1) {
                nums[i] = nums[i - 1]
            }
            nums[0] = temp
        }
    }

    fun rotate3(nums: IntArray, k: Int): Unit {
        fun reverse(nums: IntArray, start: Int, end: Int) {
            var left = start
            var right = end
            while (left < right) {
                val temp = nums[left]
                nums[left] = nums[right]
                nums[right] = temp

                left++
                right--
            }
        }

        var k = k % nums.size
        reverse(nums, 0, nums.size -1)
        reverse(nums, 0, k -1)
        reverse(nums, k, nums.size -1)
    }
}

fun main() {
//    println(Solution().search(intArrayOf(1, 2, 3, 4, 5, 6, 7), target = 6))
//    println(Solution().sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).map { it.toString() })

    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    Solution().rotate3(nums, 7)
    println(nums.map { it.toString() })
}
