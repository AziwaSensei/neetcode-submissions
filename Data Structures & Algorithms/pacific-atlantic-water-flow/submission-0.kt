class Solution {
    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        /*
        get all points of atlantic and pacific.
        from pacific, try to get to end and see if it's atlantic. add that point
        from atlantic, try to get to end and see if it's pacific. add that point
        */

        val pacificPoints = mutableSetOf<String>()
        val atlanticPoints = mutableSetOf<String>()
        val results = mutableListOf<MutableList<Int>>()
        val visitedPacific = mutableSetOf<Pair<Int, Int>>()
        val visitedAltantic = mutableSetOf<Pair<Int, Int>>()

        for(i in 0 until heights.size) {
            pacificPoints.add("$i#0")
            atlanticPoints.add("$i#${heights[0].size - 1}")
        }

        for(i in 0 until heights[0].size) {
            pacificPoints.add("0#$i")
            atlanticPoints.add("${heights.size - 1}#$i")
        }

        fun dfs(row: Int, col: Int, visited: MutableSet<Pair<Int, Int>>) {
            if(visited.contains(row to col)) return
            visited.add(row to col)

            val directions = arrayOf(
                arrayOf(1,0), arrayOf(-1,0), arrayOf(0,1), arrayOf(0,-1)
            )

            for(dir in directions) {
                val newRow = row + dir[0]
                val newCol = col + dir[1]

                if(newRow < heights.size && newRow >= 0
                && newCol < heights[0].size && newCol >= 0
                && heights[newRow][newCol] >= heights[row][col]) {
                    dfs(newRow, newCol, visited)
                }
            }
        }

        for(point in pacificPoints) {
            val split = point.split("#")
            val row = split[0]
            val col = split[1]

            dfs(row.toInt(), col.toInt(), visitedPacific)
        }

        for(point in atlanticPoints) {
            val split = point.split("#")
            val row = split[0]
            val col = split[1]

            dfs(row.toInt(), col.toInt(), visitedAltantic)
        }

        for(r in heights.indices) {
            for(c in heights[0].indices) {
                if((r to c) in visitedPacific && (r to c) in visitedAltantic) {
                    results.add(mutableListOf(r, c))
                }
            }
        }

        return results
    }
}
