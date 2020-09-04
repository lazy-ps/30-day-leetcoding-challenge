# Problem

- [문제 링크](https://leetcode.com/problems/search-in-rotated-sorted-array/)

<br>

정렬한 후에 Rotate 된 배열이 주어지면 `target` 의 인덱스를 찾아 리턴하는 문제입니다.

<br><br>

# Solution

우선 __정렬된 배열 탐색__ 에서 이분탐색으로 풀 수 있다는 것을 알 수 있습니다.

보통은 rotate 의 기준이 된 인덱스를 찾은 뒤, `target` 의 크기를 비교하여 둘 중 한쪽만 이분탐색하여 찾아냅니다.

<br>

```html
Input: nums = [4,5,6,7,0,1,2], target = 5
Output: 2
```

<br>

위 예시를 기준으로 rotate 되기 전의 진짜 최소값인 0 의 위치는 인덱스 4 입니다.

그럼 인덱스 4 를 기준으로 왼쪽 0 ~ 3 와 4 ~ 6 중 `target` 이 위치할 만한 범위를 대상으로 이분탐색을 하면 됩니다.

<br>

그런데 사실 기준점을 찾지 않아도 답을 구할 수 있습니다.

`lo, mid, hi` 값으로 일반적인 이분 탐색을 하면서 그때그때마다 `target` 이 들어갈 범위를 찾습니다.

다시 위의 예시를 기준으로 하면 `lo` 는 0, `hi` 는 6, `mid` 는 3 입니다.

그리고 `nums[lo]` 와 `nums[mid]` 값을 비교합니다.

만약 `nums[lo]` 가 더 작다면 `lo ~ mid` 까지의 범위는 오름차순입니다. 즉, 기준점이 없습니다.

만약 `nums[lo]` 가 더크다면 `lo ~ mid` 범위는 뒤틀린 배열입니다.

따라서 `nums[lo] ~ nums[mid]` 안에 `target` 값이 포함되어 있다면 해당 범위로 이분탐색을 계속 이어나가고, 아니라면 `mid ~ hi` 의 범위에서 이분탐색을 진행하면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        
        int lo = 0;
        int hi = nums.length - 1;
        
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            
            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {
                // lo ~ mid : increase
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                // mid ~ hi : increase
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        
        return nums[lo] == target ? lo : -1;
    }
}
```