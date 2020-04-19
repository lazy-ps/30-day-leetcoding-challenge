class Solution {
public:
    const int DR[4] = {-1, 1, 0, 0};
    const int DC[4] = {0, 0, 1, -1};
    
    int numIslands(vector<vector<char>>& grid) {
        int R = grid.size();
        if(R == 0) return 0;
        int C = grid[0].size(), idx = 0;
        
        queue<pair<int, int>> que;
        for(int r=0; r<R; r++)
            for(int c=0; c<C; c++)
                if(grid[r][c] == '1')
                {
                    idx++;
                    que.push(make_pair(r, c));
                    grid[r][c] = '0';
                    
                    while(!que.empty())
                    {
                        auto cur = que.front(); que.pop();
                        
                        for(int d=0; d<4; d++)
                        {
                            int tr = cur.first + DR[d], tc = cur.second + DC[d];
                            if(tr >= 0 && tr < R && tc >=0 && tc < C && grid[tr][tc] == '1')
                            {
                                que.push(make_pair(tr, tc));
                                grid[tr][tc] = '0';
                            }
                        }
                    }
                }
        
        return idx;
    }
};
