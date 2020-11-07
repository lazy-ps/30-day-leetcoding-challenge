import scala.annotation.tailrec


/**
 * Definition for singly-linked list.
 * class ListNode(_x: Int = 0, _next: ListNode = null) {
 *   var next: ListNode = _next
 *   var x: Int = _x
 * }
 */
object Solution {
  def addTwoNumbers(l1: ListNode, l2: ListNode): ListNode = {
    val l1Size = getSize(l1, 0)
    val l2Size = getSize(l2, 0)
    val newL2 = enlargeSize(l2, math.max(l1Size - l2Size, 0))
    val newL1 = enlargeSize(l1, math.max(l2Size - l1Size, 0))
    val ret = addSameSizedTwoNode(newL1, newL2)
    deleteLeadingZero(ret)
  }

  @tailrec
  def getSize(li: ListNode, currentSize: Int): Int = {
      if(li == null) currentSize else getSize(li.next, currentSize + 1)
  }

  @tailrec
  def deleteLeadingZero(li: ListNode): ListNode = {
    if(li.x == 0 && li.next != null) deleteLeadingZero(li.next) else li
  }

  @tailrec
  def enlargeSize(li: ListNode, size: Int): ListNode = {
    if(size == 0) li else enlargeSize(new ListNode(0, li), size - 1)
  }

  def addSameSizedTwoNode(l1: ListNode, l2: ListNode): ListNode = {
    if(l1 == null) {
      new ListNode(0)
    } else {
      val postNode = addSameSizedTwoNode(l1.next, l2.next)
      val newX = l1.x + l2.x + postNode.x
      val current = new ListNode(newX % 10, postNode.next)
      new ListNode(newX / 10, current)
    }
  }

}
