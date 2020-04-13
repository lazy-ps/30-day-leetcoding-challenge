class Solution {
public:
    int lastStoneWeight(vector<int>& stones) {
        vector<int> stone_cnt(1005, 0);
        for(auto &v : stones)
            stone_cnt[v]++;
        
        int having = 0, diff;
        for(int i=1000; i>0; i--)
            if(stone_cnt[i]) {
                if(having == 0)
                {
                    if(stone_cnt[i] % 2)
                    {
                        stone_cnt[i] = 0;
                        having = i;
                    }
                    else
                        continue;
                }
                else
                {
                    diff = having - i;
                    stone_cnt[diff]++;
                    stone_cnt[i]--;
                    i = having;
                    having = 0;
                }
            }
        return having;
    }
};
