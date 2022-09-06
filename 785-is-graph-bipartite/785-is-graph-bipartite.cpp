class Solution {
public:
    int visited[101];
    bool recur(vector<int> graph[],int node,int id){
        
        visited[node]=id;
        bool ans=true;
        for(int i=0;i<graph[node].size();i++){
            int v=graph[node][i];
            if(visited[v]==visited[node]){ans=(ans&false);continue;};
            if(visited[v]==-1){
                ans=(ans&recur(graph,v,1-id));
            }
            
        }
        return ans;
    }
    
    bool isBipartite(vector<vector<int>>& graphi) {
        bool ans=true;
        for(int i=0;i<101;i++){
            visited[i]=-1;
        }
        vector<int>graph[101];
        int maxn=0;
        for(int i=0;i<graphi.size();i++){
            for(int j=0;j<graphi[i].size();j++){
                graph[i].push_back(graphi[i][j]);
             //   cout<<i<<' '<<j<<'\n';
             //   maxn=max(maxn,max(graphi[i][0],graphi[i][1]));
            }
            
        }
        //cout<<"hwll\n";
        for(int i=0;i<graphi.size();i++){
           // cout<<i<<'\n';
            if(graph[i].size()>0 && visited[i]==-1){
                ans=(ans&recur(graph,i,0));
                
            }
            
        }
        return ans;
    }
};