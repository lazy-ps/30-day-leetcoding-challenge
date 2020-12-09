class Solution:
    def numPairsDivisibleBy60(self, time: List[int]) -> int:
        d = [0] * 60
        for i in time:
            d[i % 60] += 1
        result = 0
        result += d[0] * (d[0] - 1) // 2
        result += d[30] * (d[30] - 1) // 2
        for i in range(1, 30):
            result += d[i] * d[60 - i]
        return result
