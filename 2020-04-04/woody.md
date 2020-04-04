# Problem

- [문제 링크](https://leetcode.com/problems/move-zeroes/)

<br>

주어진 배열에서 0 인 값을 전부 오른쪽 끝으로 보내면 됩니다.

나머지 값은 정렬하는 것이 아니라 원래 있던 순서 그대로 둡니다.

또다른 배열을 만들지 않고 주어진 배열 안에서만 해결해야 합니다. **_in-place_**

연산을 최소화 해야 합니다.

<br><br>

# Solution

*__two-pointer__* 로 간단하게 문제를 풀 수 있습니다.

`index` 변수 하나를 선언하고 0 부터 시작합니다.

일반적인 `for` 문을 돌면서 `num` 값이 0 이 아닐 때만 `nums[index]` 에 넣어줍니다.

지나간 값은 다시 확인할 필요가 없기 때문에 `nums` 배열 자체에 갱신해주어도 문제가 없습니다.

`for` 문이 끝났을 때의 `index` 부터 배열 끝까지 남은 값을 0 으로 채워주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public void moveZeroes(int[] nums) {
        int index = 0;
        
        for (int num : nums) {
            if (num != 0) {
                nums[index++] = num;
            }
        }
        
        for (int i=index; i<nums.length; i++) {
            nums[i] = 0;
        }
    }
}
```