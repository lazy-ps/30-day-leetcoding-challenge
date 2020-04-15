# Problem

- [문제 링크](https://leetcode.com/problems/product-of-array-except-self/)

<br>

`Input` 배열이 주어졌을 때 `Output` 배열을 출력합니다.

`Output` 배열은 `Input` 배열과 길이가 같고 `output[i]` 는 `input[i]` 를 제외한 모든 input 배열 값들의 곱입니다.

**Note** 와 **Follow up** 을 보면 나누기를 쓰지 않고 `O(n)` 시간복잡도와 `O(1)` 공간복잡도로 구해야 합니다.

<br><br>

# Solution

나누기를 쓰지 말라고 한 이유는 `nums` 배열의 모든 값을 곱한 뒤 for 문을 돌면서 `/ nums[i]` 만 해주면 되기 때문입니다.

<br>

arr | value | | | |
:--: | :--: | :--: | :--: | :--:
Input | 1 | 2 | 3 | 4
Output | 2 * 3 * 4 | 1 * 3 * 4 | 1 * 2 * 4 | 1 * 2 * 3

<br>

arr | value | | | |
:--: | :--: | :--: | :--: | :--:
Input | 1 | 2 | 3 | 4
left -> right |  | 1 | 1 * 2 | 1 * 2 * 3
right -> left | 2 * 3 * 4 | 3 * 4 | 4 | 

<br>

처음 위의 표를 Input 값 기준으로 왼쪽, 오른쪽으로 나누면 아래에 있는 표 처럼 바꿀 수 있습니다.

left -> right 에서는 이전 인덱스까지의 누적 곱을 넣어줍니다.

right -> left 에서는 반대방향으로 똑같이 곱해서 넣어줍니다.

처음에 `Arrays.fill(res, 1)` 를 사용하여 다 1 값으로 채운 뒤에 왼쪽에서 오른쪽으로 구할 때도 acc 변수를 사용했습니다.

그런데 `Arrays.fill` 하나 때문에 그런지 2ms 가 나와서 안쓰는 방향으로 구현했더니 1ms 100% 가 나왔습니다.

<br><br>

# Java Code

```java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        
        res[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            res[i] = res[i-1] * nums[i-1];
        }
        
        int acc = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            acc *= nums[i+1];
            res[i] *= acc;
        }
        
        return res;
    }
    
}
```