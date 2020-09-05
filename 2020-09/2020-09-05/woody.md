# Problem

- [문제 링크](https://leetcode.com/problems/all-elements-in-two-binary-search-trees/)

<br>

두 개의 트리가 주어졌을 때, 두 트리의 모든 노드에 있는 값들을 오름차순으로 정렬한 `List` 를 리턴하면 됩니다.

<br><br>

# Solution

트리를 순회하며 모든 값들을 담고, 정렬하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list = new ArrayList<>();
        
        inorder(root1, list);
        inorder(root2, list);
        
        Collections.sort(list);
        return list;
    }
    
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }
}
```
