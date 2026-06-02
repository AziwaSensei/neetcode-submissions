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
        val priorityQueue = PriorityQueue<Int>(compareByDescending {it} )

        fun helper(root: TreeNode?) {
            if(root == null) return

            helper(root?.left)
            priorityQueue.add(root?.`val`!!)
            if(priorityQueue.size > k) {
                priorityQueue.poll()
            }
            helper(root?.right)
        }

        helper(root)

        return priorityQueue.peek()
    }
}
