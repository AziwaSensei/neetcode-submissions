/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return listOf()

        // var level = 0
        var q = ArrayDeque<Pair<Int, TreeNode?>>()
        q.addLast(0 to root)
        var result = mutableListOf<MutableList<Int>>()

        while(!q.isEmpty()) {
            val (level, n) = q.pop()
            val currentLevelList = result.getOrNull(level)

            if(currentLevelList == null) {
                result.add(level, mutableListOf<Int>())
            }

            result.getOrNull(level)?.add(n?.`val` ?: 0)
            if(n?.left != null) q.addLast(level + 1 to n?.left)
            if(n?.right != null) q.addLast(level + 1 to n?.right)
            
            // level += 1
        }

        return result.toList()

    }
}
