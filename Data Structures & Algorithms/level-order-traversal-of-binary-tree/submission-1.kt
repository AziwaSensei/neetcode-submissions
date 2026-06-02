/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        if(root == null) return result

        val q = ArrayDeque<TreeNode?>()
        q.addLast(root)

        while(q.isNotEmpty()) {
            val depth = q.size
            val arr = mutableListOf<Int>()

            for (i in 0 until depth) {
                val node = q.removeFirst()
                arr.add(node?.`val` ?: 0)

                node?.left?.let { q.addLast(it) }
                node?.right?.let { q.addLast(it) }
            }
            result.add(arr)
        }
        return result.toList()

    }
}
