class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if(intervals.size < 2) return intervals

        intervals.sortWith { arr0, arr1 -> arr0[0].compareTo(arr1[0]) }

        val res = mutableListOf<IntArray>(intervals[0])

        for(i in 1 until intervals.size) {
            val prev = res[res.size - 1]
            val prevStart = prev[0]
            val prevEnd = prev[1]

            if(intervals[i][0] <= prevEnd) {
                res[res.size - 1][1] = max(intervals[i][1], res[res.size - 1][1])
            } else {
                res.add(intervals[i])
            }
        }

        return res.toTypedArray()
    }
}
