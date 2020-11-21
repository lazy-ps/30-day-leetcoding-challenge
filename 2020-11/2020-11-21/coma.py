class Solution:
    def atMostNGivenDigitSet(self, digits: List[str], n: int) -> int:
        n = str(n)
        result = 0
        for i in range(1, len(n)):
            result += pow(len(digits), i)
        digits.sort()

        result += self.get_count(digits, 0, n)
        return result
    
    def get_count(self, digits: List[str], idx: int, n: str) -> int:
        result = 0
        if idx > len(n) - 1:
            return 1
        for digit in digits:
            if n[idx] > digit:
                result += pow(len(digits), len(n) - idx - 1)
            elif n[idx] == digit:
                result += self.get_count(digits, idx+1, n)
            else:
                break
        return result
