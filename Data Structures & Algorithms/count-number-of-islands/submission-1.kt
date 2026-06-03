class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        var numOfIslands = 0
        val seen = mutableSetOf<String>()

        fun countIslands(row: Int, col: Int) {
            val q = ArrayDeque<Pair<Int, Int>>()
            q.add(row to col)

            while(q.isNotEmpty()) {
                val (r, c) = q.poll()
                val hash = "$r#$c"
                seen.add(hash)
                val directions = arrayOf(
                    arrayOf(1,0),
                    arrayOf(-1,0),
                    arrayOf(0,1),
                    arrayOf(0,-1)
                )

                for(dir in directions) {
                    val newRow = r + dir[0]
                    val newCol = c + dir[1]

                    if(newRow < grid.size && newRow >= 0 && newCol < grid[0].size && newCol >= 0
                    && grid[newRow][newCol] == '1' && !seen.contains("$newRow#$newCol")) {
                        q.offer(newRow to newCol)
                    }
                }
            }
        }

        for(r in grid.indices) {
            for(c in grid[r].indices) {
                if(grid[r][c] == '1' && !seen.contains("$r#$c")) {
                    numOfIslands += 1
                    countIslands(r,c)
                }
            }
        }
        return numOfIslands
    }

}
