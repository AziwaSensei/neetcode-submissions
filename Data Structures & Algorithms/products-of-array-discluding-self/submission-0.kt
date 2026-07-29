class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val leftArr = IntArray(nums.size)
        val rightArr = IntArray(nums.size)
        leftArr[0] = 1
        rightArr[nums.size - 1] = 1

        for(i in 1 until nums.size) {
            leftArr[i] = leftArr[i-1] * nums[i - 1]
        }

        for(i in nums.size - 2 downTo 0) {
            rightArr[i] = rightArr[i + 1] * nums[i + 1]
        }

        return leftArr.mapIndexed { index, value ->
            rightArr[index] * value
        }.toIntArray()
    }
}
