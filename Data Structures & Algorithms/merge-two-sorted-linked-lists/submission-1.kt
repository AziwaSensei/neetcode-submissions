/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        // two pointers moving between both lists
        var finalList: ListNode? = ListNode(0)
        val result = finalList
        var l1 = list1
        var l2 = list2

        while(l1 != null && l2 != null) {
            if(l1?.`val`!! <= l2?.`val`!!) {
                finalList?.next = ListNode(l1?.`val` ?: 0)
                l1 = l1?.next
            } else {
                finalList?.next = ListNode(l2?.`val` ?: 0)
                l2 = l2?.next
            }
            finalList = finalList?.next
        }

        while(l1 != null) {
            finalList?.next = ListNode(l1?.`val` ?: 0)
            l1 = l1?.next
            finalList = finalList?.next
        }

        while(l2 != null) {
            finalList?.next = ListNode(l2?.`val` ?: 0)
            l2 = l2?.next
            finalList = finalList?.next
        }

        return result?.next
    }
}
