# Problem

- [문제 링크](https://leetcode.com/problems/maximum-subarray/)

<br>

배열이 주어졌을 때 부분합의 최대값을 구하는 문제입니다.

<br><br>

# Solution 1

정해는 DP 를 이용한 `O(n)` 솔루션입니다.

`nums[i]` 에는 **현재의 값** `nums[i]` 와 **이전까지의 합 + 현재의 값** 인 `nums[i-1] + nums[i]` 중에서

더 큰 값을 저장해가며 배열 끝까지 진행합니다.

`nums` 배열에는 각 인덱스까지 진행했을 때의 부분합이 저장되어 있기 때문에 그 중에서 가장 큰 값을 구하면 됩니다.

<br><br>

# Java Code 1

```java
class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        
        for (int i=1; i<nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i-1] + nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        return max;
    }
}
```

<br><br><br>

# Solution 2

문제에는 `O(n)` 에 풀고 나면 **_divide and conquer_** 로 풀어보라는 글이 있습니다.

배열을 두 개로 나누었을 때 **왼쪽 배열의 부분합**, **오른쪽 배열의 부분합**, 그리고 **겹치는 부분의 부분합**을 구해서 가장 큰 값을 계속 구하면 됩니다.

아래 그림에서처럼 세 부분에서 가장 큰 값을 `return` 하면서 계속 진행합니다.

<br>

![1](./image/maximum-subarray_1.png)

<br>

여기서 문제는 가운데 값을 어떻게 구하는 것인가 인데

가운데에서 시작해서 **왼쪽으로 연속된 부분합** `maxLeft` 를 구하고

**오른쪽으로 연속된 부분합** `maxRight` 를 구한 뒤

이 두개를 더한 값이 연속된 부분합입니다.

<br>

![1](./image/maximum-subarray_2.png)

<br><br>

# Java Code 2

```java
class Solution {
    public int maxSubArray(int[] nums) {
        return d_c(nums, 0, nums.length-1);
    }
    
    private int d_c(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left];
        }
        
        int mid = (left + right) / 2;
        int maxLeft = Integer.MIN_VALUE;
        int maxRight = Integer.MIN_VALUE; 
        
        int sum = 0;
        for (int i=mid; i>=left; i--) {
            sum += nums[i];
            maxLeft = Math.max(maxLeft, sum);
        }
        
        sum = 0;
        for (int i=mid+1; i<=right; i++) {
            sum += nums[i];
            maxRight = Math.max(maxRight, sum);
        }
        
        int piece = Math.max(d_c(nums, left, mid), d_c(nums, mid+1, right));
        return Math.max(maxLeft + maxRight, piece);
    }
}
```