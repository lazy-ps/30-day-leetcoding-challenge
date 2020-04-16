class Solution {
public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int len = nums.size();
        vector<int> ret = vector<int>(len, 1);
        for(int i=1; i<len; i++)
            ret[i] *= ret[i-1] * nums[i-1];
        
        for(int i=len-2; i>=0; i--)
        {
            ret[i] *= nums[i+1];
            nums[i] *= nums[i+1];
        }
        
        return ret;
    }
};
