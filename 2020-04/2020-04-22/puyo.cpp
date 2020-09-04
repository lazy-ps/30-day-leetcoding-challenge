class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        if(nums.size() == 0) return 0;
        
        vector<int> pre_sum = vector<int>(nums.size());
        pre_sum[0] = nums[0];
        for(int i = 1; i< nums.size(); i++)
            pre_sum[i] = pre_sum[i - 1] + nums[i];
        
        int ret = 0;
        unordered_map<int, int> v_cnt;
        v_cnt[0] = 1;
        for(auto &v : pre_sum) {
            auto iter = v_cnt.find(v - k);
            if(iter != v_cnt.end()) ret += iter->second;
            
            iter = v_cnt.find(v);
            if(iter == v_cnt.end()) v_cnt[v] = 1;
            else iter->second += 1;
        }
        
        return ret;
    }
};
