class Solution {
    val seen = mutableMapOf<Int, Int>()

    fun climbStairs(n: Int): Int {
        if(seen.containsKey(n)) return seen.get(n)!!

        if(n<=0) return 0
        if(n==1) return 1
        if(n==2) return 2

        val result = climbStairs(n-1) + climbStairs(n-2)
        seen.put(n, result)
        return result
    }
}
