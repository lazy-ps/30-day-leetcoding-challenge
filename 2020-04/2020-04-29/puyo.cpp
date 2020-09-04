class Solution {
public:
    int max_val = -987654321;
    
    int recursive(TreeNode* root) {
        int left = root->left ? recursive(root->left) : 0;
        int right = root->right ? recursive(root->right) : 0;
        
        int cur_max = root->val;
        if(left > 0) cur_max += left;
        if(right > 0) cur_max += right;
        max_val = max(max_val, cur_max);
        return root->val + max(max(left, right), 0);
    }
    
    int maxPathSum(TreeNode* root) {
        int find = recursive(root);
        return max(find, max_val);
    }
};