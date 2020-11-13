/**
 * Definition for a Node.
 * class Node(var _value: Int) {
 *   var value: Int = _value
 *   var left: Node = null
 *   var right: Node = null
 *   var next: Node = null
 * }
 */

import scala.annotation.tailrec


object Solution {
  def connect(root: Node): Node = {
    if(root != null) connect(List(root))
    root
  }

  @tailrec
  def connect(nodeList: List[Node]): List[Node] = {

    nodeList.zip(nodeList.tail).foreach { case (a, b) => a.next = b }

    val nextList = nodeList.flatMap { node =>
      (node.left, node.right) match {
        case (null, null) => Nil
        case (null, r) => List(r)
        case (l, null) => List(l)
        case (l, r) => List(l, r)
      }
    }

    if(nextList.nonEmpty) connect(nextList) else Nil
  }
}
