/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        
        fun dfs(node: TreeNode?, depth: Int) {
            if(node == null) return

            if(result.size == depth) {
                result.add(mutableListOf())
            }

            result[depth].add(node?.`val`!!)
            dfs(node?.left, depth + 1)
            dfs(node?.right, depth + 1)
        }
        dfs(root, 0)
        return result.toList()

    }
}
