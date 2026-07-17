/**
 * Definition of Interval:
 * class Interval(var start: Int, var end: Int) {}
 */

class Solution {
    fun canAttendMeetings(intervals: List<Interval>): Boolean {
        /**
        sort by start. 
        1. start and end dont conflict
        2. Conflicts. (Starts same, enda > startb)
        0-----1
        0-----------------5 -- flag and return false
              1----2
              1-------3 -- flag and return false
                  2-------5  
        */

        val sorted = intervals.sortedBy { it.start }

        for(i in 1 until sorted.size) {
            val prev = sorted[i-1]
            val prevEnd = prev.end
            val curr = sorted[i]
            val currStart = curr.start

            println("$prevEnd + :$currStart")
            if(prevEnd > currStart) return false
        }

        return true
    }
}
