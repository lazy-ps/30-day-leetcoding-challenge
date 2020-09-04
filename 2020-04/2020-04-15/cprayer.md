# Problem

- [문제 링크](https://leetcode.com/problems/product-of-array-except-self/)

```golang
func productExceptSelf(nums []int) []int {

    n := len(nums)
    output := make([]int, n)

    for i := range(output) {
        output[i] = 1
    }

    leftAcc := 1
    for i := range(nums) {
        output[i] *= leftAcc
        leftAcc *= nums[i]
    }

    rightAcc := 1
    for i := n - 1; i >= 0; i-- {
        output[i] *= rightAcc
        rightAcc *= nums[i]
    }

    return output
}

```
