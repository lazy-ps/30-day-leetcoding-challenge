class Solution {
public:
    int matching(vector<vector<int>>& A, vector<vector<int>>& B, int rshift, int cshift) {
        int size = A.size();
        int matched = 0;
        for (int shifted_r = rshift, r = 0; shifted_r < size; shifted_r++, r++)
            for (int shifted_c = cshift, c = 0; shifted_c < size; shifted_c++, c++)
                matched += A[shifted_r][shifted_c] and B[r][c];
        
        return matched;
    }
    
    int largestOverlap(vector<vector<int>>& A, vector<vector<int>>& B) {
        int size = A.size();
        int ans = 0;
        for (int rs = 0; rs < size; rs++)
            for (int cs = 0; cs < size; cs++) {
                ans = max(ans, matching(A, B, rs, cs));
                ans = max(ans, matching(B, A, rs, cs));
            }
        
        return ans;
    }
};