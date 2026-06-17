class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        /*
        sorted by start time - if conflict, by end time (early end)
        add first time
        starting from second time, if end start is after end, add
        if start is same as end, update end time with min
        */

        intervals.sortBy { it[0] }

        var removed = 0
        var prevEnd = intervals[0][1]

        for(i in 1 until intervals.size) {
            val start = intervals[i][0]
            val end = intervals[i][1]

            if(prevEnd <= start) {
                prevEnd = end
            } else {
                removed += 1
                prevEnd = Math.min(prevEnd, end)
            }
        }

        return removed
    }
}
