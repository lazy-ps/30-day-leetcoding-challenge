# Problem

- [문제 링크](https://leetcode.com/problems/minimum-path-sum/)

<br>

_m x n_ 배열이 주어졌을 때, 배열의 왼쪽 위 (0, 0) 에서 오른쪽 아래 (m-1, n-1) 까지 이동했을 때 이동 경로의 합 중 최소값을 구하는 문제입니다.

이동은 무조건 오른쪽 혹은 아래쪽 으로만 할 수 있습니다.

<br><br>

# Solution

처음에 아무 생각 없이 재귀로 했다가 시간 초과 났습니다.

DP 로 풀면 됩니다.

(i, j) 로 이동한 경로의 최소값을 `grid[i][j]` 에 저장합니다.

(i, j) 로 이동하기 전의 위치는 위인 (i-1, j) 또는 왼쪽인 (i, j-1) 입니다.

따라서 (i, j) 로 이동할 때의 최소값은 `grid[i][j] + min(grid[i-1][j], grid([i][j-1]))` 입니다.

가장 위와 가장 왼쪽에 있을 때는 무조건 한쪽에서밖에 이동하지 못하므로 min 값을 구할 필요가 없습니다.

시간복잡도는 `O(m * n)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) continue;
                
                if (i == 0) {
                    grid[i][j] += grid[i][j-1]; 
                } else if (j == 0) {
                    grid[i][j] += grid[i-1][j]; 
                } else {
                    grid[i][j] += Math.min(grid[i-1][j], grid[i][j-1]); 
                }
            }
        }

        return grid[n-1][m-1];
    }
}
```