class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val q = PriorityQueue<Int>()
        for(num in nums) {
            q.offer(num)
            if(q.size > k) {
                q.poll()
            }
        }
        return q.peek()
    }
}
