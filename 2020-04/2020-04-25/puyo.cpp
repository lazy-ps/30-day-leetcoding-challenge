class Solution {
public:
    bool canJump(vector<int>& nums) {
        if(nums.empty()) return true;
        
        int cur , rest = nums[0];
        for(cur = 0; rest; ) 
        {
            cur++; rest--;
            if(rest + cur >= nums.size() - 1) return true;
            rest = max(rest, nums[cur]);
        }
        
        return rest + cur >= nums.size() - 1;
    }
};