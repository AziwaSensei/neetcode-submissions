class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        candidates.sort()

        fun dfs(idx: Int, path: MutableList<Int>, cur: Int) {
            if (cur == target) {
                res.add(ArrayList(path))
                return
            }

            for (i in idx until candidates.size) {
                if (i > idx && candidates[i] == candidates[i - 1]) continue
                if (cur + candidates[i] > target) break

                path.add(candidates[i])
                dfs(i + 1, path, cur + candidates[i])
                path.removeAt(path.size - 1)
            }
        }

        dfs(0, mutableListOf(), 0)
        return res
    }
}