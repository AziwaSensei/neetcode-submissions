class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)

        for(task in tasks) {
            count[task - 'A']++
        }

        val maxHeap = PriorityQueue<Int>(compareByDescending {it} )
        for(cnt in count) {
            if(cnt > 0) {
                maxHeap.offer(cnt)
            }
        }

        var time = 0
        val q = ArrayDeque<Pair<Int, Int>>()

        while(q.isNotEmpty() || maxHeap.isNotEmpty()) {
            time++

            if(maxHeap.isEmpty()) {
                time = q.first().second
            } else {
                val cnt = maxHeap.poll() - 1
                if(cnt > 0) {
                    q.offer(Pair(cnt, time + n))
                }
            }

            if(q.isNotEmpty() && q.first().second == time) {
                maxHeap.offer(q.removeFirst().first)
            }
        }

        return time
    }
}
