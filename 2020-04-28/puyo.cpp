class FirstUnique {
public:
    unordered_map<int, int> umap;
    queue<int> que;
    
    FirstUnique(vector<int>& nums) {
        umap = unordered_map<int, int>();
        que = queue <int>();
        
        for(auto &v: nums) {
            que.push(v);
            auto iter = umap.find(v);
            if(iter == umap.end()) umap[v] = 1;
            else iter->second += 1;
        }
    }
    
    int showFirstUnique() {
        while(!que.empty())
        {
            int t = que.front();
            if(umap[t] > 1) que.pop();
            else return t;
        }
        return -1;
    }
    
    void add(int value) {
        que.push(value);
        
        auto iter = umap.find(value);
        if(iter == umap.end()) umap[value] = 1;
        else iter->second += 1;
    }
};