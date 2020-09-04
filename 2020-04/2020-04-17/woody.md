# Problem

- [문제 링크](https://leetcode.com/problems/number-of-islands/)

<br>

2차원 배열이 주어지면 섬의 갯수를 구하면 됩니다.

상하좌우가 1로 연결되어 있으면 한 덩어리입니다.

<br><br>

# Solution

DFS 나 BFS 를 이용해서 간단하게 구할 수 있습니다.

`grid` 를 전체 순회하면서 1 을 만날 때마다 `count++` 후 DFS 또는 BFS 를 사용하여 섬을 지워줍니다.

<br><br>

# Java Code

```java
class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    removeIsland(grid, i, j);
                }        
            }
        }
        
        return count;
    }
    
    private void removeIsland(char[][] grid, int x, int y) {
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        
        grid[x][y] = '0';
        
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (0 <= nx && nx < grid.length && 0 <= ny && ny < grid[0].length) {
                if (grid[nx][ny] == '1') {
                    removeIsland(grid, nx, ny);
                }
            }
        }
    }
}
```