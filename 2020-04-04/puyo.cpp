class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector<int> t;
        for(auto &a: nums)
            if(a) t.push_back(a);
        for(int i=0, len=t.size(); i<len; i++)
            nums[i] = t[i];
        for(int i=t.size(), len=nums.size(); i<len; i++)
            nums[i] = 0;
    }
};
