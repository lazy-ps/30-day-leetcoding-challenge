# Problem

- [문제 링크](https://leetcode.com/problems/subarray-sum-equals-k/)

<br>

원소의 합이 `k` 가 되는 **연속된 부분배열**의 갯수를 구하는 문제입니다.

<br><br>

# Solution 1

단순하게 `O(n^2)` 시간복잡도로 구할 수 있습니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        if (nums.length == 0) return 0;
        
        int n = nums.length;
        int count = 0;
        
        for (int i=0; i<n; i++) {
            int sum = 0;
            
            for (int j=i; j<n; j++) {
                sum += nums[j];
                
                if (sum == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
```

<br><br><br>

# Solution 2

[Two Sum](https://leetcode.com/problems/two-sum/) 문제와 비슷한 원리로 풀 수 있습니다.

**Two Sum** 문제에서 우리는 `O(n^2)` 으로 일일히 합을 구하는 방법 대신 `HashMap` 에 지나온 원소의 값을 저장하는 방법으로 `O(n)` 시간복잡도에 문제를 해결할 수 있었습니다.

이와 마찬가지로 지나온 합을 `HashMap` 에 저장해두면 `O(n)` 으로 답을 구할 수 있습니다.

`sum[x]` 를 0 부터 `x` 인덱스까지의 합이라고 할 때 `i` 부터 `j` 까지 부분배열의 합은 `sum[j] - sum[i]` 입니다.

합이 `k` 가 되어야 하므로 `sum[j] - sum[i] = k` 식이라고 할 수 있고, `sum[j]` 를 구했을 때 `HashMap` 안에 `sum[i] (sum[j] - k)` 가 존재한다면 `i ~ j` 부분배열의 합이 `k` 라는 것을 알 수 있습니다.

<br><br>

# Java Code 2

```java
class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            count += map.getOrDefault(sum - k, 0);
            map.compute(sum, (key, value) -> (value == null) ? 1 : value + 1);
        }
        
        return count;
    }
}
```
