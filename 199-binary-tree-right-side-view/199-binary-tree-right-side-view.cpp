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
    
    int recur(vector<int>&vec, TreeNode* root, int level,int up){
    
            if(root==NULL)return level;
            if(level>up){
            vec.push_back(root->val);
            }
            int lev=level;
            if(root->right!=NULL){
                lev=recur(vec,root->right,level+1,up);
            }
            if(root->left!=NULL){
                lev=recur(vec,root->left,level+1,max(up,lev));
            }
            return max(up,lev);
    
    }
    
    vector<int> rightSideView(TreeNode* root) {
        vector<int>vec;
        int lev=recur(vec,root,0,-1);
        return vec;
    }
};