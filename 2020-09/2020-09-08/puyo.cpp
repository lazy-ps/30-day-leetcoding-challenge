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
    int ret;
    
    void recursive(TreeNode* root, int val) {
        if (root->left == nullptr and root->right == nullptr) ret += (val << 1) + root->val;
        
        if (root->left) recursive(root->left, (val << 1) + root->val);
        if (root->right) recursive(root->right, (val << 1) + root->val);
    }
    
    int sumRootToLeaf(TreeNode* root) {
        ret = 0;
        
        if (root) recursive(root, 0);
        
        return ret;
    }
};