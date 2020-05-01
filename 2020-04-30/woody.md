# Problem

![](../images/30-check-valid-in-a-binary-tree-1.png)
![](../images/30-check-valid-in-a-binary-tree-2.png)

<br>

Valid 한 Tree 를 구하는 문제입니다.

Valid 하기 위한 조건은 주어진 루트 노드부터 시작하여 주어진 `arr` 순서대로 같은 값을 갖고 있어야 합니다.

그리고 반드시 리프 노드로 끝나야 합니다.

<br><br>

# Solution

재귀로 풀 수 있습니다.

우선 무조건 false 인 조건들을 먼저 처리합니다.

본래라면 `node == null` 조건을 먼저 처리하겠지만 이번 풀이에서는 `null` 인 노드는 아예 진입하지 않게 했기 때문에 루트 노드에서만 처리하면 됩니다.

`index` 가 `arr` 의 길이를 넘어서거나 `node.val` 값이 배열에 있는 값과 다르면 `false` 입니다.

`node.left == null && node.right == null` 라면 해당 노드는 리프 노드입니다.

`index` 가 `arr` 마지막 인덱스와 같으면 해당 **_Valid Sequence_** 입니다.

위의 두 경우에 해당하지 않는다면 `left`, `right` 중에서 `null` 이 아닌 곳으로 진입시키면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean isValidSequence(TreeNode root, int[] arr) {
        if (root == null) {
            return (arr.length == 0);
        }
        
        return isValid(root, arr, 0);
    }
    
    public boolean isValid(TreeNode node, int[] arr, int index) {
        if (index >= arr.length || node.val != arr[index]) {
            return false;
        }
        
        if (node.left == null && node.right == null) {
            return (index == arr.length - 1);
        }
        
        return (node.left != null && isValid(node.left, arr, index + 1)) ||
               (node.right != null && isValid(node.right, arr, index + 1));
    }
}
```