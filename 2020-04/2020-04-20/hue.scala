/**
 * Definition for a binary tree node.
 * class TreeNode(var _value: Int) {
 *   var value: Int = _value
 *   var left: TreeNode = null
 *   var right: TreeNode = null
 * }
 */
object Solution {
  def bstFromPreorder(preorder: Array[Int]): TreeNode = {
    bstFromPreorder(preorder, 0, preorder.length)
  }
  def bstFromPreorder(preorder: Array[Int], sIdx: Int, eIdx: Int): TreeNode = {
    if(sIdx == eIdx) {
      null
    }
    else {
      val currentValue = preorder(sIdx)
      val rightIdx = (sIdx until eIdx).foldLeft(eIdx) ( (current, newIdx) =>
        if(current < newIdx) current
        else if(preorder(newIdx) > currentValue) newIdx
        else current
      )
      val ret = new TreeNode(currentValue)
      ret.left = bstFromPreorder(preorder, sIdx + 1, rightIdx)
      ret.right = bstFromPreorder(preorder, rightIdx, eIdx)
      ret
    }
  }
}
