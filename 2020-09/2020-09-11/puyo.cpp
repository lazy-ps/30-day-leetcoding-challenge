class Solution {
public:
    const int NEG_INF = -987654321;
    
    int local_max(int st, int ed, vector<int>& nums) {
        if (st == ed) return NEG_INF;
        else if (st + 1 == ed) return nums[st];
        
        int neg_cnt = 0, neg_first = -1, neg_last;
        for (int i = st; i < ed; i++)
            if (nums[i] < 0) {
                neg_cnt++;
                if (neg_first == -1) neg_first = i;
                neg_last = i;
            }
        
        int ret;
        if (neg_cnt % 2) {
            int left = 1, right = 1;
            
            if (neg_last == st)
                left = NEG_INF;
            else 
                for (int i = st; i < neg_last; i++)
                    left *= nums[i];
            
            if (neg_first == ed - 1)
                right = NEG_INF;
            else
                for (int i = neg_first + 1; i < ed; i++)
                    right *= nums[i];
            
            ret = max(left, right);
        }
        else {
            ret = 1;
            for (int i = st; i < ed; i++)
                ret *= nums[i];
        }
        
        return ret;
    }
    
    int maxProduct(vector<int>& nums) {
        int ret = nums.back();
        int st = 0, ed = 0;
        
        for (int len = nums.size(); ed < len; ed++) {
            ret = max(ret, nums[ed]);
            
            if (nums[ed] == 0) {
                ret = max(ret, local_max(st, ed, nums));
                st = ed + 1;
            }
        }
        ret = max(ret, local_max(st, ed, nums));
        
        return ret;
    }
};