# Problem

- [문제 링크](https://leetcode.com/problems/longest-common-subsequence/)

<br>

최장 공통 부분 수열 (LCS) 을 구하는 문제입니다.

<br><br>

# Solution

흔히 알려진 LCS 알고리즘으로 풀 수 있습니다.

`i`, `j` 이중포문을 돌면서 두 문자가 같으면 대각선에서 1 증가시키고 아니라면 위와 왼쪽 중 큰 값으로 갱신해가면 됩니다.

시간복잡도는 `O(n * m)` 입니다.

<br><br>

# Java Code

```java
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1Array = text1.toCharArray();
        char[] text2Array = text2.toCharArray();
        
        int n = text1Array.length + 1;
        int m = text2Array.length + 1;
        
        int[][] dp = new int[n][m];
        
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (text1Array[i-1] == text2Array[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[n-1][m-1];
    }
}
```