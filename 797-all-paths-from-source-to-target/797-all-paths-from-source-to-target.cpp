class Solution {
public:
    vector<vector<int>> dfs(vector<vector<int>>& graph,int node,int par,int n,vector<int>v){
        if(node==n-1){
            vector<vector<int>>ans;
            ans.push_back(v);
            return ans;
        }
        vector<vector<int>> ans;
        int m=graph[node].size();
        for(int i=0;i<m;i++){
            if(graph[node][i]!=par){
                v.push_back(graph[node][i]);
               vector<vector<int>>temp= dfs(graph,graph[node][i],node,n,v);
                int temp_size=temp.size();
                for(int i=0;i<temp_size;i++){
                    ans.push_back(temp[i]);
                }
                
                v.pop_back();
            }
        }
        return ans;
    }
    vector<vector<int>> allPathsSourceTarget(vector<vector<int>>& graph) {
        vector<int>v;
        v.push_back(0);
        int graph_size=graph.size();
       return dfs(graph,0,-1,graph_size,v);
    }
};