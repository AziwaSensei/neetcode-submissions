/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        /*
        using a priority queue, traverse tree in order and get top kth element.
        */
        val arr = mutableListOf<Int>()

        fun helper(root: TreeNode?) {
            if(root == null) return

            helper(root?.left)
            arr.add(root?.`val`!!)
            helper(root?.right)
        }

        helper(root)

        return arr[k-1]
    }
}
