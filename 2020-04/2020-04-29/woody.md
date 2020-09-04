# Problem

- [문제 링크](https://leetcode.com/problems/binary-tree-maximum-path-sum/)

<br>

이어진 노드의 합들 중 최대값을 구하는 문제입니다.

한 가지 헷갈릴만한 점은 모든 노드는 한붓그리기처럼 쭉 이어져야 합니다.

예를 들어 노드 A 를 꼭대기라고 하면 왼쪽 자식과 오른쪽 자식 둘 다 연결되지만

꼭대기가 아니라면 왼쪽과 오른쪽 노드 중 하나만 선택되어야 합니다.

<br><br>

# Solution

재귀로 풀 수 있습니다.

`node.left` 와 `node.right` 각각의 합을 구합니다.

만약 음수라면 `max` 합을 구할 수 없으므로 최소한 0 이 되어야 합니다.

합이 음수라면 해당 노드는 끊어버린다고 생각하면 됩니다.

그리고 두 자식 노드와 `node.val` 의 합을 `max` 값과 비교하여 갱신합니다.

`return` 하는 값은 부모 노드에게 올려 보내는 값입니다.

부모 노드에게 올려 보낸다는 것은 현재 `node` 가 꼭대기가 아니라는 뜻이므로 왼쪽과 오른쪽의 합 중 더 큰 값과 합친 값을 `return` 합니다.

<br><br>

# Java Code

```java
class Solution {
    int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        getSum(root);
        return max;
    }
    
    public int getSum(TreeNode node) {
        if (node == null) return 0;
        
        int leftSum = Math.max(getSum(node.left), 0);
        int rightSum = Math.max(getSum(node.right), 0);
        
        max = Math.max(max, leftSum + rightSum + node.val);
        
        return Math.max(leftSum, rightSum) + node.val;
    }
}
```