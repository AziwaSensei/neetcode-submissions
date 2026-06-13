class Solution {
    fun canJump(nums: IntArray): Boolean {
        val seen = mutableMapOf<Int, Boolean>()

        fun helper(index: Int): Boolean {
            if(seen.containsKey(index)) return seen[index]!!
            if(index == nums.size - 1) return true
            if(nums[index] == 0) {
                seen[index] = false
                return false
            }

            val end = Math.min(nums.size, index + nums[index] + 1)
            for(i in (index + 1) until end) {
                if(helper(i)) {
                    seen[i] = true
                    return true
                }
            }
            seen[index] = false
            return false
        }
        return helper(0)
    }
}
