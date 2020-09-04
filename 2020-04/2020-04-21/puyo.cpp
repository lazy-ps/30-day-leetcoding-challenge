class Solution {
public:
    int leftMostColumnWithOne(BinaryMatrix &binaryMatrix) {
        auto D = binaryMatrix.dimensions();
        int R = D[0], C = D[1];
        int ans = 987654321;
        
        for(int r=0; r<R; r++)
        {
            int left = 0, right = C - 1;
            while(left <= right)
            {
                int m = (left + right) / 2;
                if(binaryMatrix.get(r, m) == 0)
                    left = m + 1;
                else
                    right = m - 1;
            }
            if(right != C - 1)
                ans = min(right + 1, ans);
        }
        
        return ans == 987654321 ? -1 : ans;
    }
};