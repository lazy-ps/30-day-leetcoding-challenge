class Solution {
public:
    bool isHappy(int n) {
        vector<bool> used(1000, false);
        
        int cur, next;
        while(n != 1)
        {
            next = 0;
            while(n)
            {
                cur = n % 10;
                next += cur * cur;
                n /= 10;
            }
            if(used[next]) return false;
            
            used[next] = true;
            n = next;
        }
        
        return true;
    }
};
