class MinStack {
public:
    /** initialize your data structure here. */
    vector<int> stk;
    vector<int> history;
    MinStack() {
        
    }
    
    void push(int x) {
        int cur_min = stk.size() ? min(getMin(), x) : x;
        history.push_back(cur_min);
        stk.push_back(x);
    }
    
    void pop() {
        stk.pop_back();
        history.pop_back();
    }
    
    int top() {
        return stk[stk.size() - 1];
    }
    
    int getMin() {
        return history[stk.size() - 1];
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(x);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */
