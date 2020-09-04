class Solution {
public:
    int search(vector<int>& nums, int target) {
        // check for only one number
        if(nums.size() < 2)
        {
            int ret = -1;
            for(int i=0; i<nums.size(); i++)
                if(nums[i] == target)
                    return i;
            return ret;
        }
        
        // find rotated pivot by binary search
        int l = 0, r = nums.size() - 1, m;
        while(l + 1 < r)
        {
            m = (l + r) / 2;
            if(nums[m] < nums[r])
                r = m;
            else
                l = m;
        }
        int real_min = r;
        
        
        if(target <= nums.back())  // is target in pivot ~ last ?
            l = real_min, r = nums.size() - 1;
        else  // is target in 0 ~ pivot ?
            l = 0, r = real_min - 1;  
        
        // find target by binary search
        while (l <= r) 
        { 
            m = (l + r) / 2; 
            if (nums[m] <= target)
                l = m + 1; 
            else
                r = m - 1; 
        }
        
        if(r < 0 || nums[r] != target) return -1;
        else return r; 
    }
};
