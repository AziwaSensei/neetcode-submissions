class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        val seen = HashSet<Char>()
        var l = 0
        var res = 0 

        for((index, c) in s.withIndex()) {
            while(c in seen) {
                seen.remove(s[l])
                l++
            }

            seen.add(c)
            res = Math.max(res, index - l + 1)
        }
        return res
    }
}
