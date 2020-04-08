/**
 * Definition for singly-linked list.
 * class ListNode(var _x: Int = 0) {
 *   var next: ListNode = null
 *   var x: Int = _x
 * }
 */

/**
  리스트 size를 구한 후 중간에 해당하는 node 반환
  O(n) (n: input 으로 주어지는 리스트의 size)
*/
object Solution {
  def middleNode(head: ListNode): ListNode = {
    val listSize = getNodeSize(head, 0)
    getNextNode(head, listSize/2)
  }
  
  def getNextNode(node: ListNode, remainNext: Int): ListNode = {
    if(remainNext == 0) node
    else getNextNode(node.next, remainNext - 1)
  }
  
  def getNodeSize(head: ListNode, currentSize: Int): Int = {
    if(head == null) currentSize
    else getNodeSize(head.next, currentSize + 1)
  }
}
