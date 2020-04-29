class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0 || matrix[0].size() == 0) return 0;
        
        int ret = 0, R = matrix.size(), C = matrix[0].size();
        for(auto &row : matrix)
            for(auto &v : row)
            {
                v -= '0';
                if(v) ret = 1;
            }
        
        for(int r = 1; r < R; r++)
            for(int c = 1; c < C; c++)
                if(matrix[r][c]) 
                {
                    matrix[r][c] += min(min(matrix[r - 1][c - 1], matrix[r - 1][c]), matrix[r][c - 1]);
                    ret = ret < matrix[r][c] ? matrix[r][c] : ret;
                }
        return ret * ret;
    }
};