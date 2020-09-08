/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    vector<int> getAllElements(TreeNode* root1, TreeNode* root2) {
        vector<int> ans;
        queue<TreeNode*> que;
        
        if (root1) que.emplace(root1);
        if (root2) que.emplace(root2);
        
        while (not que.empty()) {
            auto cur = que.front(); que.pop();
            
            ans.emplace_back(cur->val);
            if (cur->left) que.emplace(cur->left);
            if (cur->right) que.emplace(cur->right);
        }
        
        sort(ans.begin(), ans.end());
        return ans;
    }
};