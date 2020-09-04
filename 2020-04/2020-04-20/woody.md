# Problem

- [문제 링크](https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/)

<br>

주어진 preorder 배열로 __*Binary Search Tree (이진 탐색 트리)*__ 를 만드는 문제입니다.

이진 탐색 트리는 왼쪽 자식 노드는 부모 노드보다 작아야 하고 오른쪽 자식 노드는 부모 노드보다 커야 합니다.

이 규칙은 노드 각각에만 적용되는게 아니라 전체 트리에도 적용이 됩니다.

예를 들면 예시로 주어진 배열에서 10 은 5 보다 크지만 더 상위 노드인 8 보다도 크기 때문에 5 의 오른쪽 자식 노드가 아니나 8 의 오른쪽 자식 노드로 생성되었습니다.

<br><br>

# Solution

재귀로 풀 수 있습니다.

왼쪽 노드는 단순하게 현재 부모 노드의 값과 비교해서 작으면 생성합니다.

오른쪽 노드는 조건이 있습니다.

우선 현재 노드보다 작은 숫자들은 전부 왼쪽 노드의 자식들로 만들어지기 때문에 오른쪽 노드를 검사할 때, 무조건 현재 노드보다 값이 큽니다.

그런데 오른쪽 노드는 현재 노드 뿐만 아니라 더 상위 노드까지도 확인해야 합니다.

만약 더 상위 노드보다도 더 큰 값이라면 현재 노드가 아닌 상위 노드의 오른쪽 자식으로 생성되어야 합니다.

<br><br>

# Java Code

```java
class Solution {
    int i = 0;
    
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bst(int[] preorder, int parent) {
        if (i == preorder.length || preorder[i] > parent) {
            return null;
        }
        
        TreeNode node = new TreeNode(preorder[i++]);
        node.left = bst(preorder, node.val);
        node.right = bst(preorder, parent);
        return node;
    }
}
```