# https://leetcode.com/explore/featured/card/september-leetcoding-challenge/554/week-1-september-1st-september-7th/3445/
from itertools import permutations


class Solution:
    def isValid(self, candi):
        hh, mm = candi[:2], candi[3:]
        return 0 <= int(hh) <= 23 and 0 <= int(mm) <= 59
    
    def largestTimeFromDigits(self, A: List[int]) -> str:
        candidates =  [f'{c[0]}{c[1]}:{c[2]}{c[3]}' 
                       for c in permutations(A, 4)]
        candidates = [c for c in candidates if self.isValid(c)]
        
        if not candidates:
            return ''
        else:
            candidates.sort()
            return candidates[-1]