class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        queue<int>q;
        vector<int>graph[2001];
        int visited[2001];
        map<int,int>mp;
        for(int i=0;i<prerequisites.size();i++){
           int v=prerequisites[i][0];
           int u=prerequisites[i][1];
            mp[v]++;
            graph[u].push_back(v);
        }
        
        for(int i=0;i<numCourses;i++){
            if(mp[i]==0){
                q.push(i);
            }
            visited[i]=0;
        }
        
        vector<int>ans;
        while(q.size()>0){
            int u=q.front();
            q.pop();
           // cout<<u<<"\n";
            if(visited[u]==1)continue;
            visited[u]=1;
            ans.push_back(u);
            for(int i=0;i<graph[u].size();i++){
                int v=graph[u][i];
                mp[v]--;
                if(mp[v]==0){
                q.push(v);
                }
                
            }
        }
        vector<int>ans1;
        return ans.size()==numCourses?ans:ans1;
    }
};