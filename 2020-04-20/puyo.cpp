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
    TreeNode* recursive(vector<int>& preorder, int s, int e) {
        if(s == preorder.size()) return nullptr;
        TreeNode* root = new TreeNode(preorder[s]);
        
        int next_s;
        for(next_s = s + 1; next_s < e && preorder[next_s] < preorder[s]; next_s++);
        root->left = s + 1 == next_s ? nullptr : recursive(preorder, s + 1, next_s);
        root->right = next_s == e ? nullptr : recursive(preorder, next_s, e);
        return root;
    }
    
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        return recursive(preorder, 0, preorder.size());
    }
};
