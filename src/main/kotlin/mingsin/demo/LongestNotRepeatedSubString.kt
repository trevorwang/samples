package mingsin.demo

class LongestNotRepeatedSubString {
    fun lengthOfLongestSubstring(string: String): Pair<Int, String> {
        var l = string.length
        var i = 0
        var j = 0
        var max = 0
        var seen = mutableSetOf<Char>()
        var start = 0

        while (i < l && j < l) {
            if (string[j] in seen) {
                seen.remove(string[i])
                i++
            } else {
                seen.add(string[j])
                j += 1
                if (j - i > max) {
                    max = j - i
                    start = i
                }
            }
        }
        return Pair(max, string.substring(start, max + start))
    }
}

fun main() {
    println(LongestNotRepeatedSubString().lengthOfLongestSubstring("aaaaabbbbbbcccccccabcd"))
    println(LongestNotRepeatedSubString().lengthOfLongestSubstring("aaaab"))
    println(LongestNotRepeatedSubString().lengthOfLongestSubstring("ababcd"))
}