class Solution:
    def generateMatrix(self, n: int) -> List[List[int]]:
        d = [[0] * n for _ in range(n)]
        dx = [1, 0, -1, 0]
        dy = [0, 1, 0, -1]
        ix = 0
        iy = 0
        i = 0
        direction = 0
        while ix < n and iy < n and ix >= 0 and iy >= 0 and d[iy][ix] == 0:
            i += 1
            d[iy][ix] = i
            prev_ix = ix
            prev_iy = iy
            ix += dx[direction]
            iy += dy[direction]
            if ix >= n or iy >= n or ix < 0 or iy < 0 or d[iy][ix] != 0:
                direction = (direction + 1) % 4
                ix = prev_ix + dx[direction]
                iy = prev_iy + dy[direction]
        return d
