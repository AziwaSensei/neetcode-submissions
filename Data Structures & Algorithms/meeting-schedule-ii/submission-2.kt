/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun minMeetingRooms(intervals: List<Interval>): Int {
        /*
        two pqs. one holding earliest start time, one holding earliest end times
        pull from earliest start time and put into earliest end time for each iteration
        return count of rooms in earliest endtime
        */

        val earliestComparator = compareBy<Interval> { it.start }
        val latestComparator = compareBy<Interval> { it.end }

        val earliest = PriorityQueue<Interval>(earliestComparator)
        val latest = PriorityQueue<Interval>(latestComparator)

        for(interval in intervals) {
            earliest.offer(interval)
        }

        while(earliest.isNotEmpty()) {
            val interval = earliest.poll()
            if(latest.isEmpty()) {
                latest.offer(interval)
            } else {
                val top = latest.peek()
                if(interval.start >= top.end) {
                    latest.poll()
                } 
                latest.offer(interval)
            }
        }

        return latest.size
    }
}
