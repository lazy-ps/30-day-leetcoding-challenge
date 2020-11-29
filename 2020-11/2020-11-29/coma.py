# BFS
class Solution:
    def canReach(self, arr: List[int], start: int) -> bool:
        b = [False] * len(arr)
        b[start] = True
        q = deque()
        q.append(start)
        while len(q) != 0:
            idx = q.popleft()
            if arr[idx] == 0:
                return True
            minus_idx = idx - arr[idx]
            plus_idx = idx + arr[idx]
            if minus_idx >= 0 and not b[minus_idx]:
                q.append(minus_idx)
                b[minus_idx] = True
            if plus_idx < len(arr) and not b[plus_idx]:
                q.append(plus_idx)
                b[plus_idx] = True
        return False
