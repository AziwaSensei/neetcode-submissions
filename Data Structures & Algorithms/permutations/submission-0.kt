class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val picked = BooleanArray(nums.size)

        fun dfs(curr: MutableList<Int>) {
            if(curr.size == nums.size) {
                res.add(curr.toList())
                return
            }

            for(i in nums.indices) {
                if(!picked[i]) {
                    curr.add(nums[i])
                    picked[i] = true
                    dfs(curr)
                    curr.removeAt(curr.size - 1)
                    picked[i] = false
                }
            }
        }
        dfs(mutableListOf<Int>())
        return res
    }
}
