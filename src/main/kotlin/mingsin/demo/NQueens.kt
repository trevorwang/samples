package mingsin.demo

class NQueens {

    fun solveProblems(n: Int): List<List<String>> {
        // 初始化棋盘
        val board = Array(n) {
            CharArray(n) { '.' }
        }
        val result = ArrayList<List<String>>()

        // 判断是否可以放置Queen
        fun isValid(row: Int, col: Int): Boolean {
            // 当前行有Queen
            for (r in 0 until row) {
                if (board[r][col] == 'Q') return false
            }

            // 左上方是否有 Q
            var i = row
            var j = col
            while (i >= 0 && j >= 0) {
                if (board[i][j] == 'Q') return false
                j--;i--
            }


            // 右上方有Q
            i = row
            j = col
            while (i >= 0 && j < board.size) {
                if (board[i][j] == 'Q') return false
                j++;i--
            }
            return true
        }

        fun backtrace(row: Int) {
            if (row == board.size) {
                result.add(board.map { String(it) })
                return
            }
            // 遍历列
            for (col in board.indices) {
                if (isValid(row, col)) {
                    board[row][col] = 'Q' // 放置 queen
                    backtrace(row + 1)
                    board[row][col] = '.'    // 恢复棋盘
                }
            }
        }
        backtrace(0)
        return result
    }


    fun solveNQueens(n: Int): List<List<String>> {

        val board = Array(n) { CharArray(n) { '.' } }
        val result = mutableListOf<List<String>>()

        fun isValid(row: Int, col: Int): Boolean {

            for (i in board.indices) {
                if (board[i][col] == 'Q') return false
            }

            var j = row - 1
            var k = col - 1
            while (j >= 0 && k >= 0) {
                if (board[j][k] == 'Q') return false
                j--;k--
            }

            var l = row - 1
            var m = col + 1
            while (l >= 0 && m < n) {
                if (board[l][m] == 'Q') return false
                l--;m++
            }
            return true
        }


        fun backtrace(row: Int) {
            if (row == n) {
                result.add(board.map { String(it) })
                return
            }
            for (col in 0 until n) {
                if (isValid(row, col)) {
                    board[row][col] = 'Q'
                    backtrace(row + 1)
                    board[row][col] = '.'
                }
            }
        }

        backtrace(0)
        return result
    }


    fun solveN(n: Int): List<List<String>> {
        val colArray = IntArray(n) { -1 }
        val onPath = mutableSetOf<Int>()
        val diagram1 = mutableSetOf<Int>()
        val diagram2 = mutableSetOf<Int>()
        val result = mutableListOf<List<String>>()


        fun dfs(row: Int) {
            if (row == n) {
                result.add(
//                    colArray.map { i -> ".".repeat(n).replaceRange(IntRange(i, i), "Q") }
                    colArray.map { i -> String(CharArray(n) { '.' }.apply { set(i, 'Q') }) }
                )
                println(colArray.joinToString())
                return
            }

            for (c in 0 until n) {
                if (onPath.contains(c)) continue
                if (diagram1.contains(row + c)) continue
                if (diagram2.contains(row - c)) continue

                colArray[row] = c
                onPath.add(c)
                diagram1.add(row + c)
                diagram2.add(row - c)

                dfs(row + 1)

                colArray[row] = -1
                onPath.remove(c)
                diagram1.remove(row + c)
                diagram2.remove(row - c)
            }
        }
        dfs(0)
        return result
    }

}

fun main() {
    println(NQueens().solveProblems(10).size)
    println(NQueens().solveNQueens(10).size)
    println(NQueens().solveN(8))
}