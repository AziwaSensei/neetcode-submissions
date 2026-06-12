class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
        if(text1.length > text2.length) return longestCommonSubsequence(text2, text1)
        /*
        cat
        ^
        crabt
        ^

        if same i and j += 1
        else 
            same i, j += 1
            or 
            same j, i += 1
        */

        val maxSeen = mutableMapOf<String, Int>()
        fun helper(pos1: Int, pos2: Int): Int {
            val hash = "$pos1#$pos2"
            if(maxSeen.containsKey(hash)) return maxSeen[hash]!!
            if(pos1 >= text1.length || pos2 >= text2.length) return 0

            if(text1[pos1] == text2[pos2]) {
                maxSeen[hash] = 1 + helper(pos1 + 1, pos2 + 1)
                return maxSeen[hash]!!
            } else {
                maxSeen[hash] = Math.max(
                    helper(pos1 + 1, pos2),
                    helper(pos1, pos2 + 1)
                )
                return maxSeen[hash]!!
            }
        }
        return helper(0,0)
    }
}
