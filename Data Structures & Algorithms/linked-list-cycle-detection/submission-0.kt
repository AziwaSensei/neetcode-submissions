/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun hasCycle(head: ListNode?): Boolean {
        var fastPointer = head?.next?.next
        var currentPointer = head

        while(currentPointer?.next != null) {
            if(fastPointer == currentPointer) return true
            fastPointer = fastPointer?.next?.next
            currentPointer = currentPointer?.next
        }
        return false
    }
}
