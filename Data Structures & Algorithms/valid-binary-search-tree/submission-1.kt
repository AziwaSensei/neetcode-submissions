/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun isValidBST(root: TreeNode?): Boolean {
        fun validate(root: TreeNode?, left: Int = Int.MIN_VALUE, right: Int = Int.MAX_VALUE): Boolean {
            if(root == null) return true

            if(root?.`val`!! <= left || root?.`val`!! >= right) return false

            return (validate(root?.left, left, root?.`val`!!) 
            && validate(root?.right, root?.`val`!!, right))
        }

        return validate(root)
    }
}
