class Solution {
public:
    string stringShift(string s, vector<vector<int>>& shift) {
        int go_left = 0;
        for(auto &v: shift) 
            go_left += v[1] * (v[0] ? -1 : 1);
        
        while(go_left < 0) go_left += s.size();
        go_left %= s.size();
        
        return s.substr(go_left) + s.substr(0, go_left);
    }
};
