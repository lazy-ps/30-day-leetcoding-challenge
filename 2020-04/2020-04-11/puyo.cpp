/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    int diameter = 0;
        
    int get_depth(TreeNode* root) {
        if(root == nullptr) return 0;
        int l = get_depth(root->left), r = get_depth(root->right);
        diameter = max(diameter, l + r);
        return max(l, r) + 1;
    }
    int diameterOfBinaryTree(TreeNode* root) {
        if(root == nullptr) return 0;
        return max(get_depth(root->left) + get_depth(root->right), diameter);
    }
};
