class Solution {
    fun rob(nums: IntArray): Int {
        val seen = mutableMapOf<Int, Int>()

        fun robber(index: Int): Int {
            if(seen.containsKey(index)) return seen.get(index)!!
            if(index >= nums.size) return 0

            val rob = nums[index] + robber(index + 2)
            val notRob = robber(index + 1)
            val result = Math.max(rob, notRob)

            seen.put(index, result)
            return result
        }

        return robber(0)
    }
}
