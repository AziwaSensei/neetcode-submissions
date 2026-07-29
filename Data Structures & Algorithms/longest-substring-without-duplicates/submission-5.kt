class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        val set = mutableSetOf<Char>()
        var result = 0

        for(i in 0 until s.length) {
            val c = s[i]

            while(set.contains(c)) {
                set.remove(s[start])
                start++
            }

            result = Math.max(result, i - start + 1)
            set.add(c)
        }

        return result
    }
}
