# Problem

- [문제 링크](https://leetcode.com/problems/jump-game/)

<br>

첫번째 인덱스에서 점프를 반복하여 마지막 인덱스에 도달할 수 있는지 판단하는 문제입니다.

- 주어지는 배열은 음수가 아닌 수들로 이루어짐
- 최대 현재 위치의 값만큼 점프 가능
    - `nums[i]` 가 3 이라면 1 또는 2 또는 3 만큼 점프 가능

<br><br>

# Solution

`nums[i]` 값만큼만 이동하는게 아니라 최대 이동거리이기 때문에 나머지 거리들도 다 이동할 수 있습니다.

즉 `nums[i]` 가 3 이라면 1, 2, 3 만큼 이동할 수 있기 때문에

현재 위치 `i` 에서 `i + nums[i]` 이하의 모든 인덱스는 점프 가능한 인덱스가 됩니다.

그래서 `arrived` 배열을 선언하여 현재 위치에서 최대로 이동할 수 있는 인덱스 값을 계속해서 갱신해줍니다.

만약 `arrived` 값이 마지막 인덱스인 `n-1` 이상이 된다면 우리는 마지막 인덱스에 도달할 수 있습니다.

한 가지 예외처리 해주어야 할 것은 `arrived` 가 `i` 보다 낮아지면 더 이상 계산할 필요가 없습니다.

현재 위치 `i` 가 5 일 때 `arrived` 가 4 라면, 0 ~ 4 인덱스들에서 가장 멀리 점프를 해도 4 까지밖에 도달하지 못한다는 뜻입니다.

따라서 5 이상의 인덱스에서는 더이상 계산할 필요 없이 `false` 가 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int arrived = 0;
        
        for (int i = 0; i < n && i <= arrived; i++) {
            arrived = Math.max(arrived, i + nums[i]);
            
            if (arrived >= n-1) {
                return true;
            }
        }
        
        return false;
    }
}
```