/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def insertionSortList(head: ListNode): ListNode = {
      var iter = head
      var currentNode: ListNode = null
      while(iter != null) {
        currentNode = insertNode(currentNode, iter.x)
        iter = iter.next
      }
      currentNode
    }
    def insertNode(head: ListNode, value: Int): ListNode = {
      if(head == null) {
        new ListNode(value)
      } else {
        if(head.x < value) {
          head.next = insertNode(head.next, value)
          head
        } else {
          new ListNode(value, head)
        }
      }
    }
}
