class Solution {
    data class FrequentElement(val elem: Int, val freq: Int)

    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for(num in nums) {
            map[num] = map[num]?.let {
                it + 1
            } ?: 1
        }
        
        val q = PriorityQueue<FrequentElement>(object: Comparator<FrequentElement> {
            override fun compare(a: FrequentElement, b: FrequentElement): Int {
                return a.freq.compareTo(b.freq)
            }
        })

        for((key, value) in map.entries) {
            q.offer(FrequentElement(key, value))
        }

        while(q.size > k) {
            q.poll()
        }

        val result = mutableListOf<Int>()
        while(q.isNotEmpty()) {
            result.add(q.poll().elem)
        }

        return result.toIntArray()
    }
}
