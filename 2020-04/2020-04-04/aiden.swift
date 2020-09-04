class Solution {
    func moveZeroes(_ nums: inout [Int]) {
        var front = 0
        var end = 0

        while end < nums.count {
            if nums[front] != 0 {
                if front == end {
                    front += 1
                    end += 1
                } else {
                    front += 1
                }
            } else {
                if nums[end] == 0 {
                    end += 1
                } else {
                    nums.swapAt(front, end)
                    front += 1
                    end += 1
                }
            }
        }
    }
}