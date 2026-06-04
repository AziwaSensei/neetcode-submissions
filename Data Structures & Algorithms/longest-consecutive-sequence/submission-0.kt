class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        // all sequences have no left neighbor
        val s = nums.toSet()
        var longest = 0

        for(n in nums) {
            if(!s.contains(n-1)) { // start of a sequence
                var l = 0

                while(s.contains(n + l)) {
                    l+=1
                }
                longest = Math.max(l, longest)
            }
        }
        return longest
    }
}
