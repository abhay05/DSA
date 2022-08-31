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
    
    TreeNode* st=NULL;
    int res=0;
    
    pair<int,bool> recur(TreeNode* root,int level,int start){
        
        if(root==NULL)return {0,false};
        
        
       pair<int,bool>ppl=recur(root->left,level+1,start);
       pair<int,bool>ppr=recur(root->right,level+1,start);
        
       // cout<<"XXXX\n";
        //cout<<root->val<<' '<<ppl.first<<' '<<ppl.second<<'\n';
     //   if(root->right!=NULL){
        //cout<<root->val<<' '<<root->right->val<<' '<<ppr.first<<' '<<ppr.second<<'\n';
     //   }
     //   cout<<"XXXX\n";
        
        if(root->val==start){
            res=max(res,ppl.first);
            res=max(res,ppr.first);
            return {1,true};
                            }
        
        if(ppl.second || ppr.second){
            res=max(res,ppl.first+ppr.first);
        }
        
        if(ppl.second){
            return {ppl.first+1,ppl.second};
        }
        if(ppr.second){
            return {ppr.first+1,ppr.second};
        }
        //cout<<"node "<<root->val<<' '<<max(ppl.first,ppr.first)+1<<'\n';
        int valn=max(ppl.first,ppr.first)+1;
        return {valn,false};
        
    }
    
    
    int amountOfTime(TreeNode* root, int start) {
       pair<int,bool> r= recur(root,0,start);
        return res;
     
    }
};