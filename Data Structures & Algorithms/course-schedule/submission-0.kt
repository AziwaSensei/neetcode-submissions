class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val graph = mutableMapOf<Int, MutableList<Int>>()

        for (i in 0 until numCourses) {
            graph[i] = mutableListOf()
        }
        for (prereq in prerequisites) {
            val (crs, pre) = prereq
            graph[crs]!!.add(pre)
        }

        val v = mutableSetOf<Int>()
        fun dfs(n: Int): Boolean {
            if(v.contains(n)) return false
            v.add(n)

            for(node in graph.get(n)!!) {
                if(!dfs(node)) return false
            }
            v.remove(n)
            return true
        }

        for(i in 0 until numCourses) {
            if(!dfs(i)) return false
        }
        return true
    }
}
