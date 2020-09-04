// dijkstra
#define PII pair<int, int>

class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        int R = grid.size(), C = grid[0].size();
        vector<vector<int>> cost(R + 1, vector<int>(C + 1, 987654321));
		vector<vector<bool>> visited(R, vector<bool>(C, false));
		for(int r = 0; r <= R; r++) cost[r][C] = -1;
		for(int c = 0; c <= C; c++) cost[R][c] = -1;
		for(int r = 0; r < R; r++) grid[r].push_back(987654321);
		grid.push_back(vector<int>(C, 987654321));

		auto comp = [&cost](PII a, PII b) { return cost[a.first][a.second] > cost[b.first][b.second]; };
		priority_queue<PII, vector<PII>, decltype(comp)> pq(comp);

		pq.push(make_pair(0, 0));
		cost[0][0] = grid[0][0];

		while(true)
		{
			int r = pq.top().first, c = pq.top().second; pq.pop();

			if(r == R - 1 && c == C - 1) break;
			if(visited[r][c]) continue;
			visited[r][c] = true;
			
			int down = cost[r][c] + grid[r + 1][c];
			if(down < cost[r + 1][c]) {
				cost[r + 1][c] = down;
				pq.push(make_pair(r + 1, c));
			}
            
			int right = cost[r][c] + grid[r][c + 1];
			if(right < cost[r][c + 1]) {
				cost[r][c + 1] = right;
				pq.push(make_pair(r, c + 1));
			}
		}

		return cost[R - 1][C - 1];
    }
};


// dp
class Solution {
public:
    vector<vector<int>> memoi;

    int dp(int r, int c, vector<vector<int>>& grid)
    {
        int &ret = memoi[r][c];
        if(ret != -1) return ret;

        int up = r == 0 ? 987654321 : dp(r - 1, c, grid);
        int left = c == 0 ? 987654321 : dp(r, c - 1, grid);

        return ret = min(up, left) + grid[r][c];
    }

    int minPathSum(vector<vector<int>>& grid) {
        int R = grid.size(), C = grid[0].size();
        memoi.assign(R, vector<int>(C, -1));
        memoi[0][0] = grid[0][0];

        return dp(R - 1, C - 1, grid);
    }
};
