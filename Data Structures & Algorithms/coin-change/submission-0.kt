class Solution {
    fun coinChange(coins: IntArray, amount: Int): Int {
        val memo = mutableMapOf<Int, Int>()

        fun dfs(amt: Int): Int {
            if(memo.containsKey(amt)) return memo[amt]!!

            if(amt == 0) return 0

            var res = 1_000_000_000
            for(coin in coins) {
                if(amt - coin >= 0) {
                    res = minOf(res, 1 + dfs(amt - coin))
                }
            }
            memo[amt] = res
            return res
        }

        val minCoins = dfs(amount)
        return if(minCoins == 1_000_000_000) -1 else minCoins
    }
}
