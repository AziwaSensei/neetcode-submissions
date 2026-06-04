class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        
        fun backtrack(index: Int, target: Int, current: MutableList<Int>) {
            if(target == 0) {
                println("Got here")
                result.add(current.toList())
                return
            }
            if(target < 0) return

            for(i in index until nums.size) {
                current.add(nums[i])
                backtrack(i, target - nums[i], current)
                current.removeAt(current.size - 1)
            }
        }

        backtrack(0, target, mutableListOf<Int>())

        return result
    }
}
