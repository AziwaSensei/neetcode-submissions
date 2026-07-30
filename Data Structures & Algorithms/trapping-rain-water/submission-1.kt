class Solution {
    fun trap(height: IntArray): Int {
        var leftMax = height[0]
        var rightMax = height[height.size - 1]
        var l = 0
        var r = height.size - 1
        var result = 0

        while(l < r) {
            if(leftMax < rightMax) {
                l++
                result += Math.max(0, leftMax - height[l])
                leftMax = Math.max(leftMax, height[l])
            } else {
                r--
                result += Math.max(0,rightMax - height[r])
                rightMax = Math.max(rightMax, height[r])
            }
        }

        return result
    }
}
