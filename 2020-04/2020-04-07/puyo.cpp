class Solution {
public:
    int countElements(vector<int>& arr) {
        sort(arr.begin(), arr.end());
        int ret = 0, prev = arr.front(), cnt = 0;
        for(auto &v : arr)
        {
            if(prev == v)
                cnt++;
            else
            {
                if(prev + 1 == v)
                    ret += cnt;
                
                prev = v;
                cnt = 1;
            }
        }
        
        return ret;
    }
};
