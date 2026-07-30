class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        /*
        insert newInterval
        sort the intervals
        merge overlaps
        */
        val arr = mutableListOf<IntArray>()
        arr.addAll(intervals)
        arr.add(newInterval)
        arr.sortWith { arr0, arr1 -> arr0[0].compareTo(arr1[0])}

        val res = mutableListOf<IntArray>(arr[0])

        for(i in 1 until arr.size) {
            val prev = res[res.size - 1]
            val curr = arr[i]

            if(curr[0] <= prev[1]) { // if current start < or equal to prev end
                res[res.size - 1][1] = max(curr[1], prev[1])
            } else {
                res.add(curr)
            }
        }

        return res.toTypedArray()
    }
}
