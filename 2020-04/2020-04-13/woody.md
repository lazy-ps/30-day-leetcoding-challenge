# Problem

- [문제 링크](https://leetcode.com/problems/contiguous-array/)

<br>

0 과 1 의 개수가 같은 가장 긴 부분배열의 길이를 구하면 됩니다.

<br><br>

# Solution

`HashMap` 을 사용하여 풀 수 있습니다.

`map` 에는 `<flag, index>` 를 저장합니다.

`flag` 는 `nums` 를 순회하며 값이 0 이면 -1, 1 이면 +1 해줍니다.

`nums = [0 0 0 0 1 1]` 을 예로 들면 `flag = [-1, -2, -3, -4, -3, -2]` 입니다.

`index` 값이 1, 5 일 때 `flag` 값이 -2 로 동일한데 `index` 1 ~ 5 까지는 0 과 1 의 개수가 같은 **_contiguous array_** 가 성립된다는 뜻입니다.

따라서 `flag` 가 -2 일 때의 인덱스 값을 미리 저장해두고 또 다시 -2 를 만났을 때 두 인덱스 사이의 거리를 계산하여 길이를 구하면 됩니다.

초기값이 0 부터 시작하므로 `map.put(0, -1)` 을 추가하고, `map` 에 이미 키값이 존재한다면 새로운 값으로 갱신하지 않아야 합니다.

<br><br>

# Java Code

```java
class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int flag = 0;
        int max = 0;
        
        for (int i=0; i<nums.length; i++) {
            flag += (nums[i] == 0) ? -1 : 1;
            
            if (map.containsKey(flag)) {
                max = Math.max(max, i - map.get(flag));
            } else {
                map.put(flag, i);
            }
        }
        
        return max;
    }
}
```