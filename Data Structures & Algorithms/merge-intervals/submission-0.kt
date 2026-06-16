class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.size < 2) return intervals

        intervals.sortWith { arr1, arr2 -> arr1[0].compareTo(arr2[0]) }

        val res = mutableListOf<IntArray>()
        res.add(intervals[0])

        for(i in 1 until intervals.size) {
            val lastOutput = res[res.size - 1]
            if(intervals[i][0] <= lastOutput[1]) {
                res[res.size - 1][1] = max(res[res.size - 1][1], intervals[i][1])
            } else {
                res.add(intervals[i])
            }
        }

        return res.toTypedArray()
    }
}
