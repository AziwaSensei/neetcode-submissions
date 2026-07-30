/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        if(intervals.isEmpty()) return 0

        val sorted = intervals.sortedWith { a, b -> a.start.compareTo(b.start) }
        val q = PriorityQueue<Interval>(object: Comparator<Interval> {
            override fun compare(a: Interval, b: Interval): Int {
                return a.end.compareTo(b.end)
            }
        })

        q.offer(sorted[0])

        for(i in 1 until sorted.size) {
            val onTopEndTime = q.peek().end

            if(onTopEndTime <= sorted[i].start) {
                q.poll()  
            } 
            q.offer(sorted[i])
        }

        return q.size 
    }
}
