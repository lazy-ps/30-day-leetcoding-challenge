// key point is there is no POP function
class FirstUnique {
public:
    unordered_map<int, int> umap;  // save number count
    queue<int> que;  // added order for unique values
    
    FirstUnique(vector<int>& nums) {
        umap = unordered_map<int, int>();
        que = queue <int>();
        
        // this exactly same as using add function for every element
        // it means, time complexity is O(N) 
        for(auto &v: nums) {  
            que.push(v);
            auto iter = umap.find(v);
            if(iter == umap.end()) umap[v] = 1;
            else iter->second += 1;
        }
    }
    
    int showFirstUnique() {
        // this total time complexity is input numbers.
        // not for one query, all query for O(N)
        while(!que.empty())
        {
            int t = que.front();
            // if que front is not unique, pop it. 
            // it never be unique.
            if(umap[t] > 1) que.pop();
            else return t;
        }
        return -1;
    }
    
    void add(int value) {
        que.push(value);  // O(1)
        
        auto iter = umap.find(value);  // O(1) for hash map
        if(iter == umap.end()) umap[value] = 1;
        else iter->second += 1;
    }
};
