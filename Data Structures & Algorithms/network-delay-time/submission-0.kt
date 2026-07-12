class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val pq = PriorityQueue<IntArray> {a, b -> a[0].compareTo(b[0])}
        val dist = IntArray(n + 1)
        Arrays.fill(dist, Int.MAX_VALUE)

        val map = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
        for(i in 0 until n) {
            map.put(i+1, mutableListOf<Pair<Int, Int>>())
        }

        for(time in times) {
            map.get(time[0])!!.add(time[1] to time[2])
        }

        dist[k] = 0
        pq.offer(intArrayOf(0, k))

        while(pq.isNotEmpty()) {
            val top = pq.poll()
            val cost = top[0]
            val node = top[1]

            if(cost > dist[node]) continue

            for(nei in map.get(node)!!) {
                val des = nei.first
                val c = nei.second

                if(dist[node] + c < dist[des]) {
                    dist[des] = dist[node] + c
                    pq.offer(intArrayOf(dist[des], des))
                }
            }
        }

        val res = dist.drop(1).maxOrNull() ?: Int.MAX_VALUE
        return if(res == Int.MAX_VALUE) -1 else res
    }
}
