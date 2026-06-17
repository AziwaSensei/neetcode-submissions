class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val res = mutableListOf<IntArray>()
        
        for(i in 0 until intervals.size) {
            if(newInterval[1] < intervals[i][0]) {
                res.add(newInterval)
                for(j in i until intervals.size) {
                    res.add(intervals[j])
                }
                return res.toTypedArray()
            } else if(newInterval[0] > intervals[i][1]) {
                res.add(intervals[i])
            } else {
                newInterval[0] = min(intervals[i][0], newInterval[0])
                newInterval[1] = max(intervals[i][1], newInterval[1])
            }
        }

        res.add(newInterval)
        return res.toTypedArray()
    }
}
