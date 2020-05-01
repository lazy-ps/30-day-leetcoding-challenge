class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        if(n - m > m) return 0;
        
        int ret = m;
        for(; m <= n; m++)
        {
            ret &= m;
            if(m == 2147483647) break;
        }
        return ret;
    }
};
