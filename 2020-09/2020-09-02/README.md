# Contains Duplicate III

- [Link](https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3446/)

Given an array of integers, find out whether there are two distinct indices `i` and `j` in the array such that the **absolute** difference between `nums[i]` and `nums[j]` is at most `t` and the **absolute** difference between `i` and `j` is at most `k`.

<br>

### Example 1:

```
Input: nums = [1,2,3,1], k = 3, t = 0
Output: true
```

### Example 2:
```
Input: nums = [1,0,1,1], k = 1, t = 2
Output: true
```

### Example 3:
```
Input: nums = [1,5,9,1,5,9], k = 2, t = 3
Output: false
```

<br>

### Constraints:

- `0 <= nums.length <= 2 * 104`
- `-231 <= nums[i] <= 231 - 1`
- `0 <= k <= 104`
- `0 <= t <= 231 - 1`
