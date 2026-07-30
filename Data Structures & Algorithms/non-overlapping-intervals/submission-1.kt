class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        /*
        Sort and merge - count the merges
        */

        intervals.sortWith { arr0, arr1 -> arr0[0].compareTo(arr1[0]) }

        val res = mutableListOf<IntArray>(intervals[0])
        var count = 0

        for(i in 1 until intervals.size) {
            val prev = res[res.size - 1]

            if(intervals[i][0] < prev[1]) { //1,2 1,4, 2,4
                res[res.size - 1][1] = min(prev[1], intervals[i][1])
                count += 1
            } else {
                res.add(intervals[i])
            }
        }

        return count
    }
}
