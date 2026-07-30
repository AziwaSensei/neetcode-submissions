/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        val sortedList = intervals.sortedWith { a, b -> a.start.compareTo(b.start) }

        for(i in 1 until sortedList.size) {
            val prevInterval = sortedList[i-1]
            val currInterval = sortedList[i]
            if(currInterval.start < prevInterval.end) return false
        }
        return true
    }
}
