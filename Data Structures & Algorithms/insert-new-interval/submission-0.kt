class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        /*
        if end time of new interval < start time of current intervals
            append newInterval and the rest of the intervals and return
        if end time of current interval < start time of new interval
            append current interval and continue
        else
            merge
            take min time between current time and new interval &
            max time between current time and new interval

        append new interval 
        return res
        */

        val res = mutableListOf<IntArray>()
        for(i in intervals.indices) {
            if(newInterval[1] < intervals[i][0]) {
                res.add(newInterval)
                return (res + intervals.sliceArray(i until intervals.size)).toTypedArray()
            } else if(intervals[i][1] < newInterval[0]) {
                res.add(intervals[i])
            } else {
                // merge
                newInterval[0] = min(intervals[i][0], newInterval[0])
                newInterval[1] = max(intervals[i][1], newInterval[1])
            }
        }

        res.add(newInterval)
        return res.toTypedArray()
    }
}
