class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val seen = mutableMapOf<String, Int>()

        fun ways(row: Int, col: Int): Int {
            val hash = "$row#$col" 

            if((row == m - 1) && (col == n - 1)) return 1
            if(row >= m || col >= n) return 0
            if(seen.contains(hash)) return seen.get(hash)!!

            seen[hash] = ways(row + 1, col) + ways(row, col + 1)
            return seen[hash]!!
        }

        return ways(0, 0)
    }
}
