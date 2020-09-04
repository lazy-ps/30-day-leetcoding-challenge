class Solution {
public:
    int findMaxLength(vector<int>& nums) {
        if(nums.size() == 0) return 0;
        
        vector<pair<int, int>> count_idx = vector<pair<int, int>>(nums.size());
        count_idx[0] = make_pair(nums[0] == 0 ? 1 : -1, 0);
        for(int i = 1; i < nums.size(); i++)
        {
            count_idx[i].second = i;
            count_idx[i].first = count_idx[i - 1].first + (nums[i] == 0 ? 1 : -1);
        }
        
        count_idx.push_back(make_pair(0, -1));
        sort(count_idx.begin(), count_idx.end());
        int cur_count = -987654321, cur_idx, ret = 0;
        for(int i = 0; i < count_idx.size(); i++)
        {
            if(cur_count == count_idx[i].first)
                ret = max(ret, count_idx[i].second - cur_idx);
            else
            {
                cur_count = count_idx[i].first;
                cur_idx = count_idx[i].second;
            }
        }
        return ret;
    }
};
