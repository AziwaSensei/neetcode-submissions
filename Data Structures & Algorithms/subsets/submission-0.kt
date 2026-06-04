class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun dfs(nums: IntArray, index: Int, current: MutableList<Int>) {
            if(index >= nums.size) {
                result.add(current.toList())
                return
            }

            val num = nums[index]
            current.add(num)
            dfs(nums, index + 1, current)
            current.removeAt(current.size - 1)
            dfs(nums, index + 1, current)
        }

        dfs(nums, 0, mutableListOf<Int>())

        return result
    }
}
