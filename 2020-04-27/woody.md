# Problem

- [문제 링크](https://leetcode.com/problems/maximal-square/)

<br>

가장 큰 정사각형을 만드는 1 의 갯수를 구하는 문제입니다.

<br><br>

# Solution

DP 로 구할 수 있습니다.

사각형을 구해야 하므로 `dp[i][j], dp[i-1][j], d[i][j-1], d[i-1][j-1]` 이 전부 1 이어야 합니다.

각 `dp[][]` 변수의 값은 사각형 한 변의 길이가 됩니다.

이 중에서 최대 값을 구해주면 됩니다.

<br><br>

# Java Code

```java
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n+1][m+1];
        int len = 0;
        
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < m+1; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    len = Math.max(len, dp[i][j]);
                }
            }
        }
        
        return len * len;
    }
}
```