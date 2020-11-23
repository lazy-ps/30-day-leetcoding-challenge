/**
 * Definition for a binary tree node.
 * class TreeNode(_value: Int = 0, _left: TreeNode = null, _right: TreeNode = null) {
 *   var value: Int = _value
 *   var left: TreeNode = _left
 *   var right: TreeNode = _right
 * }
 */
object Solution {
  def rob(root: TreeNode): Int = {
    math.max(rob(root, true), rob(root, false))
  }

  def rob(root: TreeNode, theft: Boolean): Int = {
    if(root == null) {
      0
    } else if(theft) {
      root.value + rob(root.left, false) + rob(root.right, false)
    } else {
      math.max(rob(root.left, true), rob(root.left, false)) +
        math.max(rob(root.right, true), rob(root.right, false))
    }
  }
}
