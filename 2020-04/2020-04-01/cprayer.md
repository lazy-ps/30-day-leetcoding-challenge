# Problem

- [문제 링크](https://leetcode.com/problems/single-number/)

배열이 주어집니다. 해당 배열에는 유일한 숫자가 하나 존재하고, 나머지 숫자는 모두 한쌍씩 존재합니다. 이 중 유일한 숫자를 구하여 반환합니다.

XOR의 성질(A ^ A = 0)을 이용하여 간단하게 문제를 풀 수 있습니다.

시간복잡도는 O(N)입니다.

```golang
func singleNumber(nums []int) int {
    ans := 0
    for _, v := range(nums) {
        ans ^= v
    }
    return ans
}
```