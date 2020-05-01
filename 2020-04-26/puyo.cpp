class Solution {
public:
    vector<vector<int>> memoi;
    int dp(string &s1, string &s2, int idx1, int idx2) {
        if(idx1 >= s1.size() || idx2 >= s2.size()) return 0;
        int &ret = memoi[idx1][idx2];
        if(ret != -1) return ret;
        
        int jump1 = dp(s1, s2, idx1 + 1, idx2);
        int jump2 = dp(s1, s2, idx1, idx2 + 1);
        int jump12 = dp(s1, s2, idx1 + 1, idx2 + 1) + (s1[idx1] == s2[idx2]);
        
        return ret = max(max(jump1, jump2), jump12);
    }
    
    int longestCommonSubsequence(string text1, string text2) {
        memoi.resize(text1.size());
        for(auto &v : memoi)
            v.assign(text2.size(), -1);
        
        return dp(text1, text2, 0, 0);
    }
};
