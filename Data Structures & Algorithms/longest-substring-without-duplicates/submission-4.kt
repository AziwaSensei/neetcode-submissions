class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var start = 0
        val map = HashSet<Char>()
        var result = 0

        for(i in 0 until s.length) {
            val c = s[i]
            while(c in map) {
                map.remove(s[start])
                start++
            }

            map.add(s[i])
            result = Math.max(result, i - start + 1)
        }
        return result

    }
}
