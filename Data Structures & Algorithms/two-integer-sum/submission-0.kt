class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for((i, num) in nums.withIndex()) {
            val diff = target - num

            map[diff]?.let {
                return intArrayOf(it, i)
            }
            map[num] = i
        }

        return intArrayOf()
    }
}
