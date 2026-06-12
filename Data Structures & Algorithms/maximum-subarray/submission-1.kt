class Solution {
    fun maxSubArray(nums: IntArray): Int {
        /*
        Keep track of max sum seen before
        */
        if(nums.isEmpty()) return 0
        var maxSeenBefore = 0
        var result = nums[0]

        for(num in nums) {
            if(maxSeenBefore < 0) {
                maxSeenBefore = 0
            }
            maxSeenBefore += num
            result = Math.max(maxSeenBefore, result)
        }
        return result
    }
}
