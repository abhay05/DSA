class Solution {
public:
    bool validPath(int n, vector<vector<int>>& edges, int source, int destination) {
        vector<int>arr[n+1];
        int edgepoints=edges.size();
        for(int i=0;i<edgepoints;i++){
            arr[edges[i][0]].push_back(edges[i][1]);
            arr[edges[i][1]].push_back(edges[i][0]);
        }
        
        queue<int>q;
        q.push(source);
        bool vis[n+1];
        for(int i=0;i<n+1;i++){
            vis[i]=false;
        }
        //vis[source]=true;
        while(!q.empty()){
            int p=q.front();
            q.pop();
            vis[p]=true;
            if(p==destination){
                return true;
            }
            int nz=arr[p].size();
            for(int i=0;i<nz;i++){
                if(!vis[arr[p][i]]){
                q.push(arr[p][i]);}
            }
        }
        return false;
    }
};